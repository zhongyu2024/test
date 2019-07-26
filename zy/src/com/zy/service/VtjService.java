package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.VTJSearch;
import com.zy.bean.VTJtable;
import com.zy.bean.vipShuChu;
import com.zy.bean.vipShuRu;
import com.zy.dao.mapper.VtjMapper;

@Service
public class VtjService {
	
	@Resource
	private VtjMapper vm;
	public void setVm(VtjMapper vm) {
		this.vm = vm;
	}
	
	
	/*--1��������ѯ*/
	public List<VTJtable> search1(VTJSearch vs){
		return vm.search1(vs);
	}
	/*--2ֻ��ѯʱ��*/
	public List<VTJtable> search2(VTJSearch vs){
		return vm.search2(vs);
	}
	/*--3ֻ��ѯ��Ա��������*/
	public List<VTJtable> search3(VTJSearch vs){
		return vm.search3(vs);
	}
	/*--4ֻ��ѯ��Ա����*/
	public List<VTJtable> search4(VTJSearch vs){
		return vm.search4(vs);
	}
	/*--5ֻ��ѯ�м�¼��*/
	public List<VTJtable> search5(VTJSearch vs){
		return vm.search5(vs);
	}
	/*--6��ѯʱ��ͻ�Ա��*/
	public List<VTJtable> search6(VTJSearch vs){
		return vm.search6(vs);
	}
	/*--7��ѯʱ��ͻ�Ա������*/
	public List<VTJtable> search7(VTJSearch vs){
		return vm.search7(vs);
	}
	/*--8��ѯʱ����м�¼*/
	public List<VTJtable> search8(VTJSearch vs){
		return vm.search8(vs);
	}
	/*--9��ѯ��Ա���ͻ�Ա��*/
	public List<VTJtable> search9(VTJSearch vs){
		return vm.search9(vs);
	}
	/*--10��ѯ��Ա�����м�¼*/
	public List<VTJtable> search10(VTJSearch vs){
		return vm.search10(vs);
	}
	/*--11��ѯ��Ա�����ͺ��м�¼*/
	public List<VTJtable> search11(VTJSearch vs){
		return vm.search11(vs);
	}
	/*--12��ѯʱ��ͻ�Ա���ͻ�Ա��*/
	public List<VTJtable> search12(VTJSearch vs){
		return vm.search12(vs);
	}
	/*--13��ѯʱ��ͻ�Ա�����м�¼*/
	public List<VTJtable> search13(VTJSearch vs){
		return vm.search13(vs);
	}
	/*--14��ѯʱ��ͻ�Ա�����м�¼*/
	public List<VTJtable> search14(VTJSearch vs){
		return vm.search14(vs);
	}
	/*--15��ѯ��Ա���ͻ�Ա�����м�¼*/
	public List<VTJtable> search15(VTJSearch vs){
		return vm.search15(vs);
	}
	/*--16��ѯʱ�䣬��Ա������Ա�����м�¼*/
	public List<VTJtable> search16(VTJSearch vs){
		return vm.search16(vs);
	}
	
	
	public List<vipShuChu> findByvip(vipShuRu sr){
		return vm.findByvip(sr);
	}
	
	
	
}
