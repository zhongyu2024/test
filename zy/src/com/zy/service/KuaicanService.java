package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.CookBook;
import com.zy.bean.Food;
import com.zy.bean.Kitchenkucun;
import com.zy.bean.Listinfo;
import com.zy.bean.Mode;
import com.zy.bean.QueryTime;
import com.zy.bean.Vip;
import com.zy.bean.VipRecord;
import com.zy.bean.Waitnum;
import com.zy.bean.ZList;
import com.zy.dao.mapper.KuaicanMapper;

/**
 * ���
 * @author Administrator
 *
 */
@Service
public class KuaicanService {

	@Resource
	private KuaicanMapper km;
	public void setKm(KuaicanMapper km) {
		this.km = km;
	}
	/**
	 * ��ѯ���еĲ�Ʒ
	 * @return
	 */
	public List<Food> getAllFood(){		
		return km.getAllFood();
	}
	/**
	 * ���ݲ�ϵ��ȡ��Ʒ
	 * @param typeid
	 * @return
	 */
	public List<Food> getByType(int typeid){
		return km.getByType(typeid);
	}
	/**
	 * ����״̬��ѯ�ƺ�
	 */
	public List<Waitnum> getByState(int state){
		return km.getByState(state);
	}
	/**
	 * ��ȡ���в�ϵ
	 * @return
	 */
	public List<Mode> getAllCookType(){
		return km.getAllCookType();
	}
	/**
	 * ��ȡ����Ҫ��
	 * @return
	 */
	public List<Mode> getAllYaoqiu(){
		return km.getAllYaoqiu();
	}
	/**
	 * ���ݲ�Ʒ��Ż�ȡ�ò˵Ĳ��϶��󼯺�
	 * @param foodid
	 * @return
	 */
	public List<CookBook> getCaipuByFoodid(int foodid){
		return km.getCaipuByFoodid(foodid);
	}
	/**
	 * ���ݲ��ϱ���ڳ�������в�ѯ�ò���
	 * @param id
	 * @return
	 */
	public Kitchenkucun getByMaterialsid(int id){
		return km.getByMaterialsid(id);
	}
	/**
	 * ���ݲ�����ȡ��Ʒ����
	 * @param name
	 * @return
	 */
	public Food getByName(String name){
		return km.getByName(name);
	}
	/**
	 * �޸ĳ��������
	 * @param num
	 * @param id
	 * @return
	 */
	public boolean updateKucun(double num,int id){
		return km.updateKucun(num, id);
	}
	/**
	 * ���һ���嵥��Ϣ
	 * @param zl
	 * @return
	 */
	/*public boolean addList(ZList zl){
		return km.addList(zl);
	}*/
	/**
	 * ������Ӷ�����ϸ��Ϣ
	 * @param lists
	 * @return
	 */
	/*public int addlistinfo(List<Listinfo> lists){
		return km.addlistinfo(lists);
	}*/
	/**
	 * 
	 * �����嵥��Ż�ȡ�嵥����
	 * @param listid
	 * @return
	 */
	public ZList getListByid(String listid){
		return km.getListByid(listid);
	}
	/**
	 * �����ֻ��Ż�ȡ��Ա����
	 * @param tel
	 * @return
	 */
	public Vip getvip(String tel){
		return km.getvip(tel);
	}
	/**
	 * ��ӻ�Ա���Ѽ�¼
	 * @param vr
	 * @return
	 */
	public boolean addviprecord(VipRecord vr){
		return km.addviprecord(vr);
	}
	/**
	 * �޸Ļ�Ա���
	 * @param id
	 * @param money
	 * @return
	 */
	public boolean editvip(int id,double money){
		return km.editvip(money,id);
	}
	/**
	 * ����ʱ�޸Ķ���
	 * @param zl
	 * @return
	 */
	public boolean editlist(ZList zl) {
		// TODO Auto-generated method stub
		return km.editlist(zl);
	}
	/**
	 * �޸Ŀ���ƺ�״̬
	 * @param tableid
	 * @param i
	 */
	/*public boolean updatewaitnum(int tableid, int i) {
		// TODO Auto-generated method stub
		return km.updatewaitnum(tableid,i);
	}*/
	/**
	 * ���涩����Ϣ
	 * @param zl
	 * @param lists
	 */
	public void subjiezhang(ZList zl, List<Listinfo> lists,int i) {
		// TODO Auto-generated method stub
		km.addList(zl);
		km.addlistinfo(lists);		
		km.updatewaitnum(zl.getTableid(),i);
		
	}
	/**
	 * ��Ա֧��
	 * @param vr
	 * @param zl 
	 */
	public void subvippay(VipRecord vr, ZList zl) {
		// TODO Auto-generated method stub
		km.addviprecord(vr);
		km.editvip(vr.getMoney(),vr.getVipid());
		km.editlist(zl);
		km.updatewaitnum(zl.getTableid(), 0);
	}
	/**
	 * ��֧ͨ��
	 * @param zl
	 */
	public void subputongpay(ZList zl) {
		// TODO Auto-generated method stub
		km.editlist(zl);
		km.updatewaitnum(zl.getTableid(), 0);
	}
	/**
	 * ����״̬�����ͻ�ȡ��Ӧ�������嵥
	 * @param i
	 * @param j
	 * @return
	 */
	public List<ZList> getlistBystateAndType(int state, int type) {
		// TODO Auto-generated method stub
		return km.getlistBystateAndType(state,type);
	}
	/**
	 * ����״̬�����ͷ�ҳ��ȡ��Ӧ���嵥
	 * @param state
	 * @param type
	 * @param pageNo
	 * @return
	 */
	public List<ZList> getlistBystateAndTypeAndFenye(int state, int type,int start,int end){
		return km.getlistBystateAndTypeAndFenye(state,type,start,end);
	}
	/**
	 * �����嵥�Ż�ȡ�嵥�µĲ�Ʒ��Ϣ
	 * @param listid
	 * @return
	 */
	public List<Listinfo> getbylistid(String listid){
		return km.gtebylistid(listid);
	}
	/**
	 * ȡ�ؽ������϶���
	 * @param listid
	 * @return
	 */
	public void edilistzuofei(String listid,int waitnum) {
		// TODO Auto-generated method stub
		km.editlistzuofei(listid);
		km.updatewaitnum(waitnum, 0);
	}
	/**
	 * ���ƺ���������
	 * @param waitnum
	 * @return
	 */
	public List<ZList> getBywaitnum(int waitnum) {
		// TODO Auto-generated method stub
		
		return km.getBywaitnum(waitnum);
	}
	/**
	 * ����ʱ�����ʾȡ��ҳ���е��嵥��Ϣ
	 * @param qm
	 * @return
	 */
	public List<ZList> getBytimeAll(QueryTime qm) {
		// TODO Auto-generated method stub
		return km.getBytimeAll(qm);
	}
	public List<ZList> getBytimeFenye(QueryTime qm) {
		// TODO Auto-generated method stub
		return km.getBytimeFenye(qm);
	}
	
	
}
