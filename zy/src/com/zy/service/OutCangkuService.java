package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zy.bean.Cailiao;
import com.zy.bean.Cangku;
import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;
import com.zy.bean.Emp;
import com.zy.bean.OutCailiao;
import com.zy.bean.OutCangku;
import com.zy.dao.mapper.OutCangkuMapper;

@Service
public class OutCangkuService {
	@Resource
	private OutCangkuMapper ockm;

	public void setOckm(OutCangkuMapper ockm) {
		this.ockm = ockm;
	}
	
	/**
	 * �������У�(��ҳ)
	 */
	public List<OutCangku> findAllByPage(int page){
		return ockm.findAllByPage(page);
	}
	/**
	 * �жϱ����Ƿ����
	 */
	public OutCangku findById(String id){
		return ockm.findById(id);
	}
	
	public OutCangku findById1(String id){
		return ockm.findById1(id);
	}
	
	/**
	 * ����ȫ��Ա��
	 */
	public List<Emp> findAllEmp(){
		return ockm.findAllEmp();
	}
	

	/**
	 * ����ȫ���ֿ�
	 */
	public List<Cangku> findAllCangku(){
		return ockm.findAllCangku();
	}
	
	/**
	 * ����ѡ��Ĳֿ���Ҳֿ��ڲ���
	 */
	public List<Cailiao> findcailiao(int page,int ckid){
		return ockm.findcailiao(page, ckid);
	}
	
	/**
	 * ��������
	 */
	public List<Cailiao> findByType(CangkucunSearch cks){
		return ockm.findByType(cks);
	}
	
	/**
	 * ����һ����Ʒ��ϸ
	 */
	public boolean addNewCl(OutCailiao cl){
		return ockm.addNewCl(cl);
	}
	/**
	 * ɾ��һ����Ʒ��ϸ
	 */
	public boolean deleteNewCl(int cl){
		return ockm.deleteNewCl(cl);
	}
	
	/**
	 * ���ݳ�����ˮ�Ų��Ҷ�Ӧ��ϸ��Ϣ
	 */
	public List<OutCailiao> findByCkid(String cid){
		return ockm.findByCkid(cid);
	}
	/**
	 * ���²�������
	 */
	public boolean updateCangkucun(Cangkucun ck){
		return ockm.updateCangkucun(ck);
	}
	
	/**
	 * ����һ��������Ϣ
	 */
	public boolean addNewCk(OutCangku oc){
		return ockm.addNewCk(oc);
	}
	
	/**
	 * ������ˮ��ɾ��������ϸ
	 */
	public boolean deleteByCkid(String ckid){
		return ockm.deleteByCkid(ckid);
	}
	
	/**
	 * ����������
	 */
	public List<OutCangku> selectAll(CangkucunSearch cs){
		return ockm.selectAll(cs);
	}
	
	public List<OutCangku> selectTime(CangkucunSearch cs){
		return ockm.selectTime(cs);
	}

	public List<OutCangku> selectType(CangkucunSearch cs){
		return ockm.selectType(cs);
	}
	
	/**
	 * ��������
	 */
	public int findAllOC(){
		return ockm.findAllOC();
	}
	/**
	 * ����������
	 */
	public int selectAllOC(CangkucunSearch cs){
		return ockm.selectAllOC(cs);
	}
	
	public int selectTimeOC(CangkucunSearch cs){
		return ockm.selectTimeOC(cs);
	}

	public int selectTypOC(CangkucunSearch cs){
		return ockm.selectTypOC(cs);
	}
	
	/**
	 * ����ѡ��Ĳֿ���Ҳֿ��ڲ���
	 */
	public int findCL(int ckid){
		return ockm.findCL(ckid);
	}
	
	/**
	 * ��������
	 */
	public int findCLT(CangkucunSearch cks){
		return ockm.findCLT(cks);
	}
	/**
	 * ���������º��ж�
	 */
	public int searchKkucun(int mid){
		return ockm.searchKkucun(mid);
	}
	
	public boolean updateKkucun(int mid,float num){
		return ockm.updateKkucun(mid, num);
	}
	
	public boolean addKkucun(int mid,float num){
		return ockm.addKkucun(mid, num);
	}
	
	
}
