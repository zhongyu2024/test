package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
import com.zy.dao.mapper.WaimaiMapper;

/**
 * ����
 * @author Administrator
 *
 */
@Service
public class WaimaiService {

	@Resource
	private WaimaiMapper wm;
	public void setWm(WaimaiMapper wm) {
		this.wm = wm;
	}
	/**
	 * ��ѯ���еĲ�Ʒ
	 * @return
	 */
	public List<Food> getAllFood(){		
		return wm.getAllFood();
	}
	/**
	 * ���ݲ�ϵ��ȡ��Ʒ
	 * @param typeid
	 * @return
	 */
	public List<Food> getByType(int typeid){
		return wm.getByType(typeid);
	}
	/**
	 * ����״̬��ѯ�ƺ�
	 */
	public List<Waitnum> getByState(int state){
		return wm.getByState(state);
	}
	/**
	 * ��ȡ���в�ϵ
	 * @return
	 */
	public List<Mode> getAllCookType(){
		return wm.getAllCookType();
	}
	/**
	 * ��ȡ����Ҫ��
	 * @return
	 */
	public List<Mode> getAllYaoqiu(){
		return wm.getAllYaoqiu();
	}
	/**
	 * ���ݲ�Ʒ��Ż�ȡ�ò˵Ĳ��϶��󼯺�
	 * @param foodid
	 * @return
	 */
	public List<CookBook> getCaipuByFoodid(int foodid){
		return wm.getCaipuByFoodid(foodid);
	}
	/**
	 * ���ݲ��ϱ���ڳ�������в�ѯ�ò���
	 * @param id
	 * @return
	 */
	public Kitchenkucun getByMaterialsid(int id){
		return wm.getByMaterialsid(id);
	}
	/**
	 * ���ݲ�����ȡ��Ʒ����
	 * @param name
	 * @return
	 */
	public Food getByName(String name){
		return wm.getByName(name);
	}
	/**
	 * �޸ĳ��������
	 * @param num
	 * @param id
	 * @return
	 */
	public boolean updateKucun(double num,int id){
		return wm.updateKucun(num, id);
	}
	/**
	 * ���һ���嵥��Ϣ
	 * @param zl
	 * @return
	 *//*
	public boolean addList(ZList zl){
		return km.addList(zl);
	}
	*//**
	 * ������Ӷ�����ϸ��Ϣ
	 * @param lists
	 * @return
	 *//*
	public int addlistinfo(List<Listinfo> lists){
		return km.addlistinfo(lists);
	}
	*//**
	 * 
	 * �����嵥��Ż�ȡ�嵥����
	 * @param listid
	 * @return
	 */
	public ZList getListByid(String listid){
		return wm.getListByid(listid);
	}
	/**
	 * �����ֻ��Ż�ȡ��Ա����
	 * @param tel
	 * @return
	 *//*
	public Vip getvip(String tel){
		return km.getvip(tel);
	}
	*//**
	 * ��ӻ�Ա���Ѽ�¼
	 * @param vr
	 * @return
	 *//*
	public boolean addviprecord(VipRecord vr){
		return km.addviprecord(vr);
	}
	*//**
	 * �޸Ļ�Ա���
	 * @param id
	 * @param money
	 * @return
	 *//*
	public boolean editvip(int id,double money){
		return km.editvip(money,id);
	}
	*//**
	 * ����ʱ�޸Ķ���
	 * @param zl
	 * @return
	 *//*
	public boolean editlist(ZList zl) {
		// TODO Auto-generated method stub
		return km.editlist(zl);
	}
	*//**
	 * �޸Ŀ���ƺ�״̬
	 * @param tableid
	 * @param i
	 *//*
	public boolean updatewaitnum(int tableid, int i) {
		// TODO Auto-generated method stub
		return km.updatewaitnum(tableid,i);
	}
	*//**
	 * ���涩����Ϣ
	 * @param zl
	 * @param lists
	 */
	public void subjiezhang(ZList zl, List<Listinfo> lists) {
		// TODO Auto-generated method stub
		wm.addList(zl);
		wm.addlistinfo(lists);		
		/*wm.updatewaitnum(zl.getTableid(),i);*/
		
	}
	/**
	 * ��Ա֧��
	 * @param vr
	 * @param zl 
	 */
	public void subvippay(VipRecord vr, ZList zl) {
		// TODO Auto-generated method stub
		wm.addviprecord(vr);
		wm.editvip(vr.getMoney(),vr.getVipid());
		wm.editlist(zl);
		wm.editsendrecord(zl.getId());
	}
	/**
	 * ��֧ͨ��
	 * @param zl
	 */
	public void subputongpay(ZList zl) {
		// TODO Auto-generated method stub
		wm.editlist(zl);
		wm.editsendrecord(zl.getId());
	}
	/**
	 * ����״̬�����ͻ�ȡ��Ӧ�������嵥
	 * @param i
	 * @param j
	 * @return
	 */
	public List<ZList> getlistBystateAndType(int state, int type) {
		// TODO Auto-generated method stub
		return wm.getlistBystateAndType(state,type);
	}
	public List<ZList> getlistBystateAndType1(int state, int type) {
		// TODO Auto-generated method stub
		return wm.getlistBystateAndType1(state,type);
	}
	public List<ZList> getlistBystateAndType2(int state, int type) {
		// TODO Auto-generated method stub
		return wm.getlistBystateAndType2(state,type);
	}
	/**
	 * ����״̬�����ͷ�ҳ��ȡ��Ӧ���嵥
	 * @param state
	 * @param type
	 * @param pageNo
	 * @return
	 */
	public List<ZList> getlistBystateAndTypeAndFenye(int state, int type,int start,int end){
		return wm.getlistBystateAndTypeAndFenye(state,type,start,end);
	}
	public List<ZList> getlistBystateAndTypeAndFenye1(int state, int type,int start,int end){
		return wm.getlistBystateAndTypeAndFenye1(state,type,start,end);
	}
	public List<ZList> getlistBystateAndTypeAndFenye2(int state, int type,int start,int end){
		return wm.getlistBystateAndTypeAndFenye2(state,type,start,end);
	}
	/**
	 * �����嵥�Ż�ȡ�嵥�µĲ�Ʒ��Ϣ
	 * @param listid
	 * @return
	 */
	public List<Listinfo> getbylistid(String listid){
		return wm.gtebylistid(listid);
	}
	/**
	 * ȡ�ؽ������϶���
	 * @param listid
	 * @return
	 */
	public void edilistzuofei(String listid) {
		// TODO Auto-generated method stub
		wm.editlistzuofei(listid);
		
		
	}
	/**
	 * ���ƺ���������
	 * @param waitnum
	 * @return
	 *//*
	public List<ZList> getBywaitnum(int waitnum) {
		// TODO Auto-generated method stub
		
		return km.getBywaitnum(waitnum);
	}
	*//**
	 * ����ʱ�����ʾȡ��ҳ���е��嵥��Ϣ
	 * @param qm
	 * @return
	 */
	public List<ZList> getBytimeAll(QueryTime qm) {
		// TODO Auto-generated method stub
		return wm.getBytimeAll(qm);
	}
	public List<ZList> getBytimeFenye(QueryTime qm) {
		// TODO Auto-generated method stub
		return wm.getBytimeFenye(qm);
	}
	public List<Emp> getpaisongman() {
		// TODO Auto-generated method stub
		return wm.getpaisongman();
	}
	public int getmannum(String name) {
		// TODO Auto-generated method stub
		return wm.getmannum(name);
	}
	public Emp getByid(int sendman) {
		// TODO Auto-generated method stub
		return wm.getByid(sendman);
	}
	public boolean addSenRecord(SendRecord sr) {
		// TODO Auto-generated method stub
		return wm.addSendRecord(sr);
	}
	public boolean updatelistpaisong(ZList zl) {
		// TODO Auto-generated method stub
		return wm.updatelistpaisong(zl);
	}
	
	
	
}
