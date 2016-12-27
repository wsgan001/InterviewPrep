package org.practice.javaFundas.designPatterns.MarketPlace;

import java.util.Map;

/**
 * @author kumari.singh
 */
public class Product {

	private int id;
	private String name;
	private Map<User, Integer> users;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<User, Integer> getUsers() {
		return this.users;
	}

	public void setUsers(Map<User, Integer> users) {
		this.users = users;
	}
}
