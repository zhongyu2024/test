package com.zy.bean;
/**
 * ʳ��
 * @author Administrator
 *
 */
public class Food {

	private int id;
	private String name;
	private int cooktypeid;
	private double price;
	private int state;
	private int isguqing;//�Ƿ�����0-���ǣ�1-��
	public int getIsguqing() {
		return isguqing;
	}
	public void setIsguqing(int isguqing) {
		this.isguqing = isguqing;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCooktypeid() {
		return cooktypeid;
	}
	public void setCooktypeid(int cooktypeid) {
		this.cooktypeid = cooktypeid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
