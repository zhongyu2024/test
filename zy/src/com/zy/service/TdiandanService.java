package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.CookBook;
import com.zy.bean.Food;
import com.zy.bean.Foodtable;
import com.zy.bean.Hetable;
import com.zy.bean.Kitchenkucun;
import com.zy.bean.Listinfo;
import com.zy.bean.ListinfoModel;
import com.zy.bean.Mode;
import com.zy.bean.QueryTime;
import com.zy.bean.Vip;
import com.zy.bean.VipRecord;
import com.zy.bean.Waitnum;
import com.zy.bean.ZList;
import com.zy.dao.mapper.TdiandanMapper;

/**
 * ���
 * @author Administrator
 *
 */
@Service
public class TdiandanService {

	@Resource
	private TdiandanMapper tm;
	public void setTm(TdiandanMapper tm) {
		this.tm = tm;
	}
	/**
	 * ��ѯ���еĲ�Ʒ
	 * @return
	 */
	public List<Food> getAllFood(){		
		return tm.getAllFood();
	}
	/**
	 * ���ݲ�ϵ��ȡ��Ʒ
	 * @param typeid
	 * @return
	 */
	public List<Food> getByType(int typeid){
		return tm.getByType(typeid);
	}
	/**
	 * ����״̬��ѯ�ƺ�
	 */
	public List<Waitnum> getByState(int state){
		return tm.getByState(state);
	}
	/**
	 * ��ȡ���в�ϵ
	 * @return
	 */
	public List<Mode> getAllCookType(){
		return tm.getAllCookType();
	}
	/**
	 * ��ȡ����Ҫ��
	 * @return
	 */
	public List<Mode> getAllYaoqiu(){
		return tm.getAllYaoqiu();
	}
	/**
	 * ���ݲ�Ʒ��Ż�ȡ�ò˵Ĳ��϶��󼯺�
	 * @param foodid
	 * @return
	 */
	public List<CookBook> getCaipuByFoodid(int foodid){
		return tm.getCaipuByFoodid(foodid);
	}
	/**
	 * ���ݲ��ϱ���ڳ�������в�ѯ�ò���
	 * @param id
	 * @return
	 */
	public Kitchenkucun getByMaterialsid(int id){
		return tm.getByMaterialsid(id);
	}
	/**
	 * ���ݲ�����ȡ��Ʒ����
	 * @param name
	 * @return
	 */
	public Food getByName(String name){
		return tm.getByName(name);
	}
	/**
	 * �޸ĳ��������
	 * @param num
	 * @param id
	 * @return
	 */
	public boolean updateKucun(double num,int id){
		return tm.updateKucun(num, id);
	}
	/**
	 * ���һ���嵥��Ϣ
	 * @param zl
	 * @return
	 */
	/*public boolean addList(ZList zl){
		return tm.addList(zl);
	}*/
	/**
	 * ������Ӷ�����ϸ��Ϣ
	 * @param lists
	 * @return
	 */
	/*public int addlistinfo(List<Listinfo> lists){
		return tm.addlistinfo(lists);
	}*/
	/**
	 * 
	 * �����嵥��Ż�ȡ�嵥����
	 * @param listid
	 * @return
	 */
	public ZList getListByid(String listid){
		return tm.getListByid(listid);
	}
	/**
	 * �����ֻ��Ż�ȡ��Ա����
	 * @param tel
	 * @return
	 */
	public Vip getvip(String tel){
		return tm.getvip(tel);
	}
	/**
	 * ��ӻ�Ա���Ѽ�¼
	 * @param vr
	 * @return
	 */
	public boolean addviprecord(VipRecord vr){
		return tm.addviprecord(vr);
	}
	/**
	 * �޸Ļ�Ա���
	 * @param id
	 * @param money
	 * @return
	 */
	public boolean editvip(int id,double money){
		return tm.editvip(money,id);
	}
	/**
	 * ����ʱ�޸Ķ���
	 * @param zl
	 * @return
	 */
	public boolean editlist(ZList zl) {
		// TODO Auto-generated method stub
		return tm.editlist(zl);
	}
	/**
	 * �޸Ŀ���ƺ�״̬
	 * @param tableid
	 * @param i
	 */
	/*public boolean updatewaitnum(int tableid, int i) {
		// TODO Auto-generated method stub
		return tm.updatewaitnum(tableid,i);
	}*/
	/**
	 * ���涩����Ϣ
	 * @param zl
	 * @param lists
	 */
	public void subjiezhang(List<Listinfo> lists) {
		// TODO Auto-generated method stub
		/*tm.addList(zl);*/
		tm.addlistinfo(lists);		
		/*tm.updatewaitnum(zl.getTableid(),i);*/
		
	}
	/**
	 * ��Ա֧��
	 * @param vr
	 * @param zl 
	 */
	public void subvippay(VipRecord vr, ZList zl) {
		// TODO Auto-generated method stub
		tm.addviprecord(vr);
		tm.editvip(vr.getMoney(),vr.getVipid());
		tm.editlist(zl);
		tm.edittablestate(zl.getTableid());
	}
	/**
	 * ��֧ͨ��
	 * @param zl
	 */
	public void subputongpay(ZList zl) {
		// TODO Auto-generated method stub
		tm.editlist(zl);
		tm.edittablestate(zl.getTableid());
	}
	/**
	 * ����״̬�����ͻ�ȡ��Ӧ�������嵥
	 * @param i
	 * @param j
	 * @return
	 */
	public List<ZList> getlistBystateAndType(int state, int type) {
		// TODO Auto-generated method stub
		return tm.getlistBystateAndType(state,type);
	}
	/**
	 * ����״̬�����ͷ�ҳ��ȡ��Ӧ���嵥
	 * @param state
	 * @param type
	 * @param pageNo
	 * @return
	 */
	public List<ZList> getlistBystateAndTypeAndFenye(int state, int type,int start,int end){
		return tm.getlistBystateAndTypeAndFenye(state,type,start,end);
	}
	/**
	 * �����嵥�Ż�ȡ�嵥�µĲ�Ʒ��Ϣ
	 * @param listid
	 * @return
	 */
	public List<Listinfo> getbylistid(String listid){
		return tm.gtebylistid(listid);
	}
	/**
	 * ȡ�ؽ������϶���
	 * @param listid
	 * @return
	 */
	public void edilistzuofei(String listid,int waitnum) {
		// TODO Auto-generated method stub
		tm.editlistzuofei(listid);
		tm.updatewaitnum(waitnum, 0);
	}
	/**
	 * ���ƺ���������
	 * @param waitnum
	 * @return
	 */
	public List<ZList> getBywaitnum(int waitnum) {
		// TODO Auto-generated method stub
		
		return tm.getBywaitnum(waitnum);
	}
	/**
	 * ����ʱ�����ʾȡ��ҳ���е��嵥��Ϣ
	 * @param qm
	 * @return
	 */
	public List<ZList> getBytimeAll(QueryTime qm) {
		// TODO Auto-generated method stub
		return tm.getBytimeAll(qm);
	}
	public List<ZList> getBytimeFenye(QueryTime qm) {
		// TODO Auto-generated method stub
		return tm.getBytimeFenye(qm);
	}
	public List<Mode> getALLliyou() {
		// TODO Auto-generated method stub
		return tm.getALLliyou();
	}
	public Foodtable getFtByid(int tableid) {
		// TODO Auto-generated method stub
		return tm.Foodtable(tableid);
	}
	/**
	 * ��ʳ�㵥�����µ�
	 * @param zl
	 * @param list
	 */
	public void subTjiezhang(ZList zl, List<Listinfo> list) {
		// TODO Auto-generated method stub
		tm.editlistT(zl);
		tm.addlistinfo(list);
	}
	public void editlistinfo(int id, String liyou) {
		// TODO Auto-generated method stub
		tm.editlistinfo(id,liyou);
	}
	public Listinfo getlistinfoByid(int id) {
		// TODO Auto-generated method stub
		return tm.getlistinfoByid(id);
	}
	public void editlistxiaofei(Listinfo listinfo) {
		// TODO Auto-generated method stub
		tm.editlistxiaofei(listinfo);
	}
	public List<Hetable> gethtByAid(String id) {
		// TODO Auto-generated method stub
		return tm.gethtByAid(id);
	}
	public List<Hetable> gethtByBid(String id) {
		// TODO Auto-generated method stub
		return tm.gethtByBid(id);
	}
	public void edithetable(String id) {
		// TODO Auto-generated method stub
		tm.edithetable(id);
	}
	public void edittablestate(int tableid) {
		// TODO Auto-generated method stub
		tm.edittablestate(tableid);
	}
	
	
}
