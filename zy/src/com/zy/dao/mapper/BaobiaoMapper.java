package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Cooktype;
import com.zy.bean.Listinfo;

public interface BaobiaoMapper {
	//��ѯ�ſ���Ӫҵ����
	public int findTotal(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	//��ѯ�ſ����ܵ���
	public int findSum(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	//��ѯ�ſ�������������
	public int findHum(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	//��ѯ���۵Ĳ��������ܶ�
	public int findCaiMoney(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("cooktypename") String cooktypename);
	public List<Listinfo> findCaiMoneyId(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("cooktypename") String cooktypename);	
	public int findSumMoney(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	public List<Cooktype> findCaiType(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
}
