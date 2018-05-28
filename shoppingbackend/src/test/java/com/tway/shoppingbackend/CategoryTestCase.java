package com.tway.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.tway.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	/*
	 * 
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop2");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_105.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(33);
	 * 
	 * assertEquals("Successfully fetched a single Category from the table!",
	 * "Laptop2", category.getName());
	 * 
	 * }
	 * 
	 */
/*
	@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(2);

		category.setName("Television");
		assertEquals("Successfully updated a single Category from the table!", true, categoryDAO.update(category));

	}*/

	/*
	 * isActive boolean (true == > false, fasel ==> true
	 * 
	 */
	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(33);
	 * 
	 * 
	 * assertEquals("Successfully updated a single Category from the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 * 
	 */ /*
		 * isAcitve true ==> false
		 * 
		 */
	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(33);
	 * 
	 * 
	 * assertEquals("Successfully deleted a single Category from the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 * 
	 */
	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched  a single Category from the table!", 4,
	 * categoryDAO.list().size());
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testCRUDCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Television");
	 * category.setDescription("This is some description for Television!");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * //fetching category = categoryDAO.get(2);
	 * 
	 * category.setName("TV");
	 * assertEquals("Successfully updated a single Category from the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * //delete
	 * assertEquals("Successfully deleted a single Category from the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * //list
	 * assertEquals("Successfully fetched  a single Category from the table!",
	 * 1,categoryDAO.list().size());
	 * 
	 * }
	 * 
	 */

}
