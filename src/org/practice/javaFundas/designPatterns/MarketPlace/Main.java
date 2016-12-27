package org.practice.javaFundas.designPatterns.MarketPlace;

/*You need to create a simple marketplace which should support below functionalities.
		(a) You can add a product of given category -> addProduct(“p1″, c1)
		(b) A user can purchase a product -> purchase(“u1″,”p1″)
		(c) A user can return a product -> returnProduct(“u1″,”p1″)
		(d) A user can be blocked and all of his purchases will be marked null -> blackListUser(“u1″)
		(e) Display the best selling product for each category -> bestSelling()
		Best selling product will be the one which have been bought by most number of unique users.
		Note: Store data in memory
*/

import java.util.*;

public class Main {

	private Map<Category, List<Product>> categoryToProductMapping ;

	Main() {
		categoryToProductMapping = new HashMap<>();
	}

	public void addProduct(Product p, Category category) {
		List<Product> products = categoryToProductMapping.get(category);

		if(products == null) {
			products = new ArrayList<>();
		}
		products.add(p);
		categoryToProductMapping.put(category, products);
	}

	public void purchaseProduct(User u, Product p) throws Exception {
		boolean productFound = false;

		if(u.getIsBlackListed()) {
			throw new Exception("user: "+u+"is blacklisted");
		}

		for(Map.Entry<Category, List<Product>> entrySet: categoryToProductMapping.entrySet()) {
			List<Product> productList = entrySet.getValue();
			if(productList.contains(p)) {
				productFound = true;
				break;
			}

		}

		if(!productFound) {
			throw new Exception("product p does not exists");
		}

		Map<User, Integer> users = p.getUsers();
		if(users == null || users.size() == 0) {
			users = new HashMap<>();
			users.put(u,1);
			p.setUsers(users);
		} else {
			int count = (users.get(u) == null)?0:users.get(u) ;

			users.put(u, count + 1);
		}


	}

	public void returnProduct(User u, Product p) throws Exception {
		Map<User, Integer> users = p.getUsers();
		Integer count = users.get(u);
		if(count == 0) {
			throw new Exception("User : "+u +" did not buy the product");
		}

		if(--count == 0) {
			users.remove(u);
		} else {
			users.put(u, --count);
		}

	}

	public void bestSelling() {
		System.out.println("**********************");

		for(Map.Entry<Category, List<Product>> entry: categoryToProductMapping.entrySet()) {
			List<Product> products = entry.getValue();
			Product bestSeller = products.get(0);
			Map<User, Integer> map = bestSeller.getUsers();
			int count = map.size();

			for(Product p: products) {
				if(p.getUsers() != null) {
					if (count < p.getUsers().size()) {
						bestSeller = p;
						count = p.getUsers().size();
					}
				}
			}
			if(bestSeller != null && count > 0) {
				System.out.println("Best selling product in category " + entry.getKey().getName() + " is " + bestSeller.getName());
			}
		}
	}



	public static void main(String args[]) throws Exception {
		User u1 = new User();
		u1.setId(1);
		u1.setName("u1");
		u1.setBlackListed(false);

		User u2 = new User();
		u2.setId(2);
		u2.setName("u2");
		u2.setBlackListed(false);

		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Levis shirt");

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("Van Huesun shirt");

		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Shirt");

		Product p3 = new Product();
		p3.setId(3);
		p3.setName("Levis pant");

		Product p4 = new Product();
		p4.setId(4);
		p4.setName("Van Huesun pant");

		Category c2 = new Category();
		c2.setId(2);
		c2.setName("Pant");

		Main main = new Main();
		main.addProduct(p1,c1);
		main.addProduct(p2,c1);

		main.addProduct(p3,c2);
		main.addProduct(p4,c2);

		main.purchaseProduct(u1, p1);
		main.purchaseProduct(u1,p3);

		//main.bestSelling();

		main.returnProduct(u1, p1);


		main.purchaseProduct(u2, p3);
		main.purchaseProduct(u2, p4);


		main.bestSelling();


	}

}
