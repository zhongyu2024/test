package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Cangku;

public interface CangkuMapper {
	/**
	 * ����
	 */
	public boolean addNew(Cangku ck);
	/**
	 * �޸�
	 */
	public boolean updateById(Cangku ck);
	/**
	 * ɾ��
	 */
	public boolean deleteById(int id);
	/**
	 * ��ҳ��ѯ
	 */
	public List<Cangku> findByPage(@Param(value="page")int page);
	/**
	 * ����id��ѯ
	 */
	public Cangku findById(int id);
	/**
	 * ��ѯ����
	 */
	public int findAll();
}
