package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Cailiao;
import com.zy.bean.Cangku;
import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;
import com.zy.bean.Emp;
import com.zy.bean.Giver;
import com.zy.bean.InCailiao;
import com.zy.bean.InCangku;

public interface InCangkuMapper {
	/**
	 * ����ȫ��Ա��
	 */
	public List<Emp> findAllEmp();
	
	/**
	 * ����ȫ����Ӧ��
	 */
	public List<Giver> findAllGiver();
	
	/**
	 * ����ȫ���ֿ�
	 */
	public List<Cangku> findAllCangku();
	
	/**
	 * ��ѯ��ˮ���Ƿ����
	 */
	public InCangku findById(String id);
	
	public InCangku findById2(String id);
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List<Cailiao> findCailiao(@Param(value="page")int page);
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List<Cailiao> findCailiaoByType(CangkucunSearch ckcs);
	
	/**
	 * ����ȫ����ⵥ(��ҳ)
	 */
	public List<InCangku> findByPage(@Param(value="page")int page);
	
	/**
	 * ���������Ʒ��ϸ
	 */
	public boolean addNewCailia(InCailiao incl);
	
	/**
	 * ɾ��һ�������Ʒ��ϸ
	 */
	public boolean deleteById(int id);
	
	/**
	 * ���������Ʒ��ϸ��
	 */
	public List<InCailiao> findByMid(String mid);
	
	
	/**
	 * ɾ�������Ʒ��ϸ
	 */
	public boolean deleteByMid(String id);
	
	/**
	 * �������
	 */
	public boolean addNewInck(InCangku ck);
	
	/**
	 * ��ѯ�����Ƿ��������
	 */
	public Cangkucun findCangkucnByType(Cangkucun c);
	
	/**
	 * ����һ�������Ĳֿ�������
	 */
	public boolean addNewCangkucun(Cangkucun c);
	
	/**
	 * ����һ�������Ĳֿ�������
	 */
	public boolean updateNewCangkucun(Cangkucun c);
	
	
	/**
	 * ���������ѯ
	 */
	public List<InCangku> selectTime(CangkucunSearch ckcs);
	
	public List<InCangku> selectType(CangkucunSearch ckcs);
	
	public List<InCangku> selectAll(CangkucunSearch ckcs);
	
	
	/**
	 * ����ȫ����ⵥ
	 */
	public int findP();
	/**
	 * ���������ѯ
	 */
	public int selectT1(CangkucunSearch ckcs);
	
	public int selectT2(CangkucunSearch ckcs);
	
	public int selectT3(CangkucunSearch ckcs);
	
	
	/**
	 * ��ѯ������Ϣ
	 */
	public int findAll();
	
	/**
	 * ��ѯ������Ϣ
	 */
	public int findType(CangkucunSearch ckcs);
	
}
