package org.practice.javaFundas.designPatterns.MarketPlace;

/**
 * @author kumari.singh
 */
public class User {
	private int id;
	private String name;
	private Boolean isBlackListed;

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

	public void setBlackListed(Boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}

	public Boolean getIsBlackListed() {
		return isBlackListed;
	}

}
