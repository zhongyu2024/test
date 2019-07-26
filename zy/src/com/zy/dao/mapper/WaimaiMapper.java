package com.zy.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;



import com.zy.bean.CookBook;
import com.zy.bean.Emp;
import com.zy.bean.Food;
import com.zy.bean.Kitchenkucun;
import com.zy.bean.Listinfo;
import com.zy.bean.Mode;
import com.zy.bean.QueryTime;
import com.zy.bean.SendRecord;
import com.zy.bean.Vip;
import com.zy.bean.VipRecord;
import com.zy.bean.Waitnum;
import com.zy.bean.ZList;

public interface WaimaiMapper {

	/**
	 * ��ѯ��������˵Ĳ�Ʒ
	 * @return
	 */
	List<Food> getAllFood();
	/**
	 * ����״̬��ѯ�ƺ�
	 * @param state
	 * @return
	 */
	List<Waitnum> getByState(int state);
	/**
	 * ��ȡ���еĲ�ϵ
	 * @return
	 */
	List<Mode> getAllCookType();
	/**
	 * ��ȡ���е�����Ҫ��
	 * @return
	 */
	List<Mode> getAllYaoqiu();
	/**
	 * ���ݲ�ϵ��ȡ��Ʒ
	 * @param typeid
	 * @return
	 */
	List<Food> getByType(int typeid);
	/**
	 * ���ݲ�Ʒ��Ż�ȡ�ò˵Ĳ��϶��󼯺�
	 * @param foodid
	 * @return
	 */
	List<CookBook> getCaipuByFoodid(int foodid);
	/**
	 * ���ݲ��ϱ���ڳ�������в�ѯ�ò���
	 * @param id
	 * @return
	 */
	Kitchenkucun getByMaterialsid(int id);
	/**
	 * //���ݲ�����ȡ��Ʒ����
	 * @param name
	 * @return
	 */
	Food getByName(String name);
	/**
	 * ���³������Ͽ��
	 * @param num
	 * @param id
	 * @return
	 */
	boolean updateKucun(@Param("num") double num,@Param("id")int id);
	/**
	 * ���������嵥��ϸ��
	 * @param lists
	 * @return
	 */
	int addlistinfo(List<Listinfo> lists);
	/**
	 * ���һ���嵥��Ϣ
	 * @param zl
	 * @return
	 */
	boolean addList(ZList zl);
	/**
	 *  �����嵥��Ż�ȡ�嵥����
	 * @param listid
	 * @return
	 */
	ZList getListByid(String listid);
	/**
	 * �����ֻ��Ż�ȡ��Ա����
	 * @param tel
	 * @return
	 */
	
	Vip getvip(String tel);
	/**
	 * ��ӻ�Ա���Ѽ�¼
	 * @param vr
	 * @return
	 */
	boolean addviprecord(VipRecord vr);
	/**
	 * �޸Ļ�Ա���
	 * @param money
	 * @param id
	 * @return
	 */
	boolean editvip(@Param("money") double money,@Param("id") int id);
	/**
	 * ����ʱ�޸Ķ���
	 * @param zl
	 * @return
	 */
	boolean editlist(ZList zl);
	/**
	 * �޸Ŀ���ƺ�״̬
	 * @param tableid
	 * @param i
	 * @return
	 */
	boolean updatewaitnum(@Param("tableid")int tableid,@Param("state") int i);
	/**
	 * ����״̬�����ͻ�ȡ�嵥
	 * @param state
	 * @param type
	 * @return
	 */
	List<ZList> getlistBystateAndType(@Param("state") int state, @Param("type") int type);
	List<ZList> getlistBystateAndType1(@Param("state") int state, @Param("type") int type);
	List<ZList> getlistBystateAndType2(@Param("state") int state, @Param("type") int type);
	/**
	 * ����״̬�����ͷ�ҳ��ȡ��Ӧ���嵥
	 * @param state
	 * @param type
	 * @param pageNo
	 * @return
	 */
	List<ZList> getlistBystateAndTypeAndFenye(@Param("state") int state,@Param("type") int type,@Param("start") int start,@Param("end") int end);
	List<ZList> getlistBystateAndTypeAndFenye1(@Param("state") int state,@Param("type") int type,@Param("start") int start,@Param("end") int end);
	List<ZList> getlistBystateAndTypeAndFenye2(@Param("state") int state,@Param("type") int type,@Param("start") int start,@Param("end") int end);
	/**
	 * �����嵥�Ż�ȡ�嵥�µĲ�Ʒ��Ϣ
	 * @param listid
	 * @return
	 */
	List<Listinfo> gtebylistid(String listid);
	/**
	 * ȡ�ؽ������϶���
	 * @param listid
	 * @return
	 */
	boolean editlistzuofei(String listid);
	/**
	 * ���ƺ���������
	 * @param waitnum
	 * @return
	 */
	List<ZList> getBywaitnum(int waitnum);
	/**
	 * ����ʱ�����ʾȡ��ҳ���е��嵥��Ϣ
	 * @param qm
	 * @return
	 */
	List<ZList> getBytimeAll(QueryTime qm);
	List<ZList> getBytimeFenye(QueryTime qm);
	List<Emp> getpaisongman();
	int getmannum(String name);
	Emp getByid(int sendman);
	boolean addSendRecord(SendRecord sr);
	boolean updatelistpaisong(ZList zl);
	void editsendrecord(String listid);
	
}
