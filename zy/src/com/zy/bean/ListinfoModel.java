package com.zy.bean;

import java.util.List;
/**
 * �嵥��ϸ���ݹ���ʵ����
 * @author Administrator
 *
 */
public class ListinfoModel {

	private List<Listinfo> lists;

	public List<Listinfo> getLists() {
		return lists;
	}

	public void setLists(List<Listinfo> lists) {
		this.lists = lists;
	}

	public ListinfoModel(List<Listinfo> lists) {
		super();
		this.lists = lists;
	}

	public ListinfoModel() {
		super();
	}
	
}
