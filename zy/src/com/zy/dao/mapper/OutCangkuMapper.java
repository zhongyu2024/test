package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Cailiao;
import com.zy.bean.Cangku;
import com.zy.bean.Cangkucun;
import com.zy.bean.CangkucunSearch;
import com.zy.bean.Emp;
import com.zy.bean.OutCailiao;
import com.zy.bean.OutCangku;

public interface OutCangkuMapper {
	/**
	 * �������У�(��ҳ)
	 */
	public List<OutCangku> findAllByPage(@Param(value="page")int page);
	
	/**
	 * ��������
	 */
	public int findAllOC();
	/**
	 * ����������
	 */
	public int selectAllOC(CangkucunSearch cs);
	
	public int selectTimeOC(CangkucunSearch cs);

	public int selectTypOC(CangkucunSearch cs);
	
	
	/**
	 * ���³������
	 */
	public int searchKkucun(int mid);
	
	public boolean updateKkucun(@Param(value="mid")int mid,@Param(value="num")float num);
	
	public boolean addKkucun(@Param(value="mid")int mid,@Param(value="num")float num);
	
	
	
	
	
	
	
	
	
	/**
	 * �жϱ����Ƿ����
	 */
	public OutCangku findById(String id);
	
	public OutCangku findById1(String id);
	
	/**
	 * ����ȫ��Ա��
	 */
	public List<Emp> findAllEmp();
	

	/**
	 * ����ȫ���ֿ�
	 */
	public List<Cangku> findAllCangku();
	
	/**
	 * ����ѡ��Ĳֿ���Ҳֿ��ڲ���
	 */
	public List<Cailiao> findcailiao(@Param(value="page")int page,@Param(value="ckid")int ckid);
	
	/**
	 * ��������
	 */
	public List<Cailiao> findByType(CangkucunSearch cks);
	
	/**
	 * ����һ����Ʒ��ϸ
	 */
	public boolean addNewCl(OutCailiao cl);
	/**
	 * ɾ��һ����Ʒ��ϸ
	 */
	public boolean deleteNewCl(int cl);
	
	/**
	 * ���ݳ�����ˮ�Ų��Ҷ�Ӧ��ϸ��Ϣ
	 */
	public List<OutCailiao> findByCkid(String cid);
	
	/**
	 * ���²�������
	 */
	public boolean updateCangkucun(Cangkucun ck);
	
	/**
	 * ����һ��������Ϣ
	 */
	public boolean addNewCk(OutCangku oc);
	
	/**
	 * ������ˮ��ɾ��������ϸ
	 */
	public boolean deleteByCkid(String ckid);
	
	/**
	 * ����������
	 */
	public List<OutCangku> selectAll(CangkucunSearch cs);
	
	public List<OutCangku> selectTime(CangkucunSearch cs);

	public List<OutCangku> selectType(CangkucunSearch cs);
	
	
	/**
	 * ����ѡ��Ĳֿ���Ҳֿ��ڲ���
	 */
	public int findCL(@Param(value="ckid")int ckid);
	
	/**
	 * ��������
	 */
	public int findCLT(CangkucunSearch cks);
	
}

