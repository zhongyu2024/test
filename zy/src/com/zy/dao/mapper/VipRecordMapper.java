package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.VipRecord;

public interface VipRecordMapper {
	public double findAllPayMoneyById(int id);//���ݻ�Աid�����������ѽ��
	public List<VipRecord> findRecordById(int id);//���ݻ�Աid���ҳ�ֵ��¼
	public List<VipRecord> findPayRecordById(int id);//���ݻ�Աid�������Ѽ�¼
}
