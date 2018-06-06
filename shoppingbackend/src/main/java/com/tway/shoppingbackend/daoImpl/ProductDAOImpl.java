package com.tway.shoppingbackend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tway.shoppingbackend.dao.ProductDAO;
import com.tway.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.tway.shoppingbackend.dao.ProductDAO#get(int)
	 */

	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * List (non-Javadoc)
	 * 
	 * @see com.tway.shoppingbackend.dao.ProductDAO#list()
	 */
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	/*
	 * INSRT (non-Javadoc)
	 * 
	 * @see
	 * com.tway.shoppingbackend.dao.ProductDAO#add(com.tway.shoppingbackend.dto.
	 * Product)
	 */
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * UPDATE (non-Javadoc)
	 * 
	 * @see
	 * com.tway.shoppingbackend.dao.ProductDAO#update(com.tway.shoppingbackend.dto.
	 * Product)
	 */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * 
	 * DELETE (non-Javadoc)
	 * 
	 * @see
	 * com.tway.shoppingbackend.dao.ProductDAO#delete(com.tway.shoppingbackend.dto.
	 * Product)
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
					.setParameter("active", true)
						.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
