package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;
import com.zy.dao.mapper.CangkucunMapper;

@Service
public class CangkucunService {
	
	@Resource
	private CangkucunMapper ckcm;

	public void setCkcm(CangkucunMapper ckcm) {
		this.ckcm = ckcm;
	}
	
	
	/**
	 * �����Ϣ����(��ҳ����)
	 */
	public List<Cangkucun> findByPage(int page){
		return ckcm.findByPage(page);
	}
	
	/**
	 * ��Ҫ�����
	 */
	public List<Cangkucun> findByText(CangkucunSearch ckcserch){
		return ckcm.findByText(ckcserch);
	}
	/**
	 * �����Ϣ����(��ҳ����)
	 */
	public int findPAll(){
		return ckcm.findPAll();
	}
	/**
	 * ��Ҫ�����
	 */
	public int findTAll(CangkucunSearch ckcserch){
		return ckcm.findTAll(ckcserch);
	}
}
