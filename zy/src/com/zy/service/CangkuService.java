package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.Cangku;
import com.zy.dao.mapper.CangkuMapper;

@Service
public class CangkuService {
	
	@Resource
	private CangkuMapper ckm;

	public void setCkm(CangkuMapper ckm) {
		this.ckm = ckm;
	}
	
	/**
	 * ����
	 */
	public boolean addNew(Cangku ck){
		return ckm.addNew(ck);
	}
	/**
	 * �޸�
	 */
	public boolean updateById(Cangku ck){
		return ckm.updateById(ck);
	}
	/**
	 * ɾ��
	 */
	public boolean deleteById(int id){
		return ckm.deleteById(id);
	}
	/**
	 * ��ҳ��ѯ
	 */
	public List<Cangku> findByPage(int page){
		return ckm.findByPage(page);
	}
	/**
	 * ����id��ѯ
	 */
	public Cangku findById(int id){
		return ckm.findById(id);
	}
	/**
	 * ��ѯ����
	 */
	public int findAll(){
		return ckm.findAll();
	}
	
}
