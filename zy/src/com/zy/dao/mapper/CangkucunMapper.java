package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;

public interface CangkucunMapper {
	/**
	 * �����Ϣ����(��ҳ����)
	 */
	public List<Cangkucun> findByPage(@Param(value="page")int page);
	
	/**
	 * �����Ϣ����(��ҳ����)
	 */
	public int findPAll();
	/**
	 * ��Ҫ�����
	 */
	public int findTAll(CangkucunSearch ckcserch);
	
	/**
	 * ��Ҫ�����
	 */
	public List<Cangkucun> findByText(CangkucunSearch ckcserch);
	
	
}
