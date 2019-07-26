package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zy.bean.Giver;
import com.zy.dao.mapper.ZGiverMapper;
 
@Service
public class ZGiverService {
 
@Resource
private ZGiverMapper zgivermapper;

public void setZgivermapper(ZGiverMapper zgivermapper) {
	this.zgivermapper = zgivermapper;
}
//��Ӧ��
public List<Giver> findAllgys(int no){
	return  zgivermapper.findAllgys(no); 
}

//��������ȡ��Ӧ�̵���Ϣ
public List<Giver> tiaojianGysInfoId(String zhi,int no){
	return  zgivermapper.tiaojianGysInfoId(zhi,no); 
}
public List<Giver> tiaojianGysInfoName(String zhiname,int no){
	return  zgivermapper.tiaojianGysInfoName(zhiname,no); 
}
//��ӳ���
public boolean addgys(Giver giverdan){
	System.out.println("1");
	  return  zgivermapper.addgys(giverdan); 
}
//ɾ�������еĳ���
public void delegysruku(int id){
    zgivermapper.delegys(id); 
}
//ɾ������
public void delegys(int id){
    zgivermapper.delegys(id); 
}
//�޸ĳ�����Ϣ
public void xiugaigys(Giver giverxiu){
  zgivermapper.xiugaigys(giverxiu); 
}
public int findAllg(){
	return zgivermapper.findAllg();
	
}
public int tiaojianGysInfoIdcount(String id){
	return zgivermapper.tiaojianGysInfoIdcount(id);
	
}
public int tiaojianGysInfoNamecount(String zhiname,int no){
	return zgivermapper.tiaojianGysInfoNamecount(zhiname, no);
	
}
public List<Giver> gongyschong(@Param("name")String zhiname){
	return zgivermapper.gongyschong(zhiname); 
}
}
