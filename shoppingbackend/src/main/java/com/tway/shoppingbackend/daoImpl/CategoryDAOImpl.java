package com.tway.shoppingbackend.daoImpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * Category category = new Category();
	 * 
	 * category.setId(1); category.setName("Television");
	 * category.setDescription("This is some description for television!");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * category.setId(2); category.setName("Mobile");
	 * category.setDescription("This is some description for mobile!");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * category.setId(3); category.setName("Laptop");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * categories.add(category);
	 * 
	 * }
	 * 
	 */

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);

		return query.getResultList();
	}

	/**
	 * Getting single category
	 * 
	 * 
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

	}

	
	/**
	 * UPdating
	 */
	@Override
	public boolean update(Category category) {
		
		category.setActive(true);
		
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

}
