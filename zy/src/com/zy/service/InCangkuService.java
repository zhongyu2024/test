package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.Cailiao;
import com.zy.bean.Cangku;
import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;
import com.zy.bean.Emp;
import com.zy.bean.Giver;
import com.zy.bean.InCailiao;
import com.zy.bean.InCangku;
import com.zy.dao.mapper.InCangkuMapper;

@Service
public class InCangkuService {
	@Resource
	private InCangkuMapper inckm;

	public void setInckm(InCangkuMapper inckm) {
		this.inckm = inckm;
	}
	
	/**
	 * ����ȫ��Ա��
	 */
	public List<Emp> findAllEmp(){
		return inckm.findAllEmp();
	}
	/**
	 * ����ȫ����Ӧ��
	 */
	public List<Giver> findAllGiver(){
		return inckm.findAllGiver();
	}
	/**
	 * ����ȫ���ֿ�
	 */
	public List<Cangku> findAllCangku(){
		return inckm.findAllCangku();
	}
	
	
	/**
	 * ��ѯ��ˮ���Ƿ����
	 */
	public InCangku findById(String id){
		return inckm.findById(id);
	}
	public InCangku findById2(String id){
		return inckm.findById2(id);
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List<Cailiao> findCailiao(int page){
		return inckm.findCailiao(page);
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List<Cailiao> findCailiaoByType(CangkucunSearch ckcs){
		return inckm.findCailiaoByType(ckcs);
	}
	
	/**
	 * ����ȫ����ⵥ
	 */
	public List<InCangku> findByPage(int page){
		return inckm.findByPage(page);
	}
	
	/**
	 * ���������Ʒ��ϸ��
	 */
	public boolean addNewCailia(InCailiao incl){
		return inckm.addNewCailia(incl);
	}
	
	/**
	 * ɾ��һ�������Ʒ��ϸ
	 */
	public boolean deleteById(int id){
		return inckm.deleteById(id);
	}
	
	/**
	 * ɾ�������Ʒ��ϸ
	 */
	public boolean deleteByMid(String id){
		return inckm.deleteByMid(id);
	}
	
	/**
	 * ���������Ʒ��ϸ��
	 */
	public List<InCailiao> findByMid(String mid){
		return inckm.findByMid(mid);
	}
	
	/**
	 * �������
	 */
	public boolean addNewInck(InCangku ck){
		return inckm.addNewInck(ck);
	}
	
	/**
	 * ��ѯ�����Ƿ��������
	 */
	public Cangkucun findCangkucnByType(Cangkucun c){
		return inckm.findCangkucnByType(c);
	}
	
	/**
	 * ����һ�������Ĳֿ�������
	 */
	public boolean addNewCangkucun(Cangkucun c){
		return inckm.addNewCangkucun(c);
	}
	
	/**
	 * ����һ�������Ĳֿ�������
	 */
	public boolean  updateNewCangkucun(Cangkucun c){
		return inckm.updateNewCangkucun(c);
	}
	
	/**
	 * ���������ѯ
	 */
	public List<InCangku> selectTime(CangkucunSearch ckcs){
		return inckm.selectTime(ckcs);
	}
	
	public List<InCangku> selectType(CangkucunSearch ckcs){
		return inckm.selectType(ckcs);
	}
	
	public List<InCangku> selectAll(CangkucunSearch ckcs){
		return inckm.selectAll(ckcs);
	}
	
	/**
	 * ����ȫ����ⵥ
	 */
	public int findP(){
		return inckm.findP();
	}
	/**
	 * ���������ѯ
	 */
	public int selectT1(CangkucunSearch ckcs){
		return inckm.selectT1(ckcs);
	}
	
	public int selectT2(CangkucunSearch ckcs){
		return inckm.selectT2(ckcs);
	}
	
	public int selectT3(CangkucunSearch ckcs){
		return inckm.selectT3(ckcs);
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	public int findAll(){
		return inckm.findAll();
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	public int findType(CangkucunSearch ckcs){
		return inckm.findType(ckcs);
	}
	
	
}
