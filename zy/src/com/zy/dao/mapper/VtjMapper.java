package com.zy.dao.mapper;

import java.util.List;

import com.zy.bean.VTJSearch;
import com.zy.bean.VTJtable;
import com.zy.bean.vipShuChu;
import com.zy.bean.vipShuRu;

public interface VtjMapper {
	/*--1��������ѯ*/
	public List<VTJtable> search1(VTJSearch vs);
	/*--2ֻ��ѯʱ��*/
	public List<VTJtable> search2(VTJSearch vs);
	/*--3ֻ��ѯ��Ա��������*/
	public List<VTJtable> search3(VTJSearch vs);
	/*--4ֻ��ѯ��Ա����*/
	public List<VTJtable> search4(VTJSearch vs);
	/*--5ֻ��ѯ�м�¼��*/
	public List<VTJtable> search5(VTJSearch vs);
	/*--6��ѯʱ��ͻ�Ա��*/
	public List<VTJtable> search6(VTJSearch vs);
	/*--7��ѯʱ��ͻ�Ա������*/
	public List<VTJtable> search7(VTJSearch vs);
	/*--8��ѯʱ����м�¼*/
	public List<VTJtable> search8(VTJSearch vs);
	/*--9��ѯ��Ա���ͻ�Ա��*/
	public List<VTJtable> search9(VTJSearch vs);
	/*--10��ѯ��Ա�����м�¼*/
	public List<VTJtable> search10(VTJSearch vs);
	/*--11��ѯ��Ա�����ͺ��м�¼*/
	public List<VTJtable> search11(VTJSearch vs);
	/*--12��ѯʱ��ͻ�Ա���ͻ�Ա��*/
	public List<VTJtable> search12(VTJSearch vs);
	/*--13��ѯʱ��ͻ�Ա�����м�¼*/
	public List<VTJtable> search13(VTJSearch vs);
	/*--14��ѯʱ��ͻ�Ա�����м�¼*/
	public List<VTJtable> search14(VTJSearch vs);
	/*--15��ѯ��Ա���ͻ�Ա�����м�¼*/
	public List<VTJtable> search15(VTJSearch vs);
	/*--16��ѯʱ�䣬��Ա������Ա�����м�¼*/
	public List<VTJtable> search16(VTJSearch vs);
	
	
	
	
	public List<vipShuChu> findByvip(vipShuRu sr);
}
