package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Foodtable;

public interface canTaiMapper {
	//���в�̨
	public List<Foodtable> findAll();
	public List<Foodtable> findDaTing();
	public List<Foodtable> findBaoXiang();
	//��������AJAX��ѯ
	public int findByName(String name);
	
	//������̨
	public boolean addCanTai(@Param("name")String name,@Param("area")int area,@Param("seatsize")int seatsize,@Param("minpay")double minpay);
	//�༭��̨
	public boolean editCanTai(@Param("id")int id,@Param("name")String name,@Param("area")int area,@Param("seatsize")int seatsize,@Param("minpay")double minpay);

	//ɾ��
	public boolean deleteCanTai(int id);

}
