package com.zy.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.zy.bean.CookBook;
import com.zy.bean.Emp;
import com.zy.bean.Food;
import com.zy.bean.Kitchenkucun;
import com.zy.bean.Listinfo;
import com.zy.bean.ListinfoModel;
import com.zy.bean.Mode;
import com.zy.bean.PageBean;
import com.zy.bean.QueryTime;
import com.zy.bean.SendRecord;
import com.zy.bean.Vip;
import com.zy.bean.VipRecord;
import com.zy.bean.Waitnum;
import com.zy.bean.ZList;
import com.zy.service.WaimaiService;

/**
 * �������Ʋ�
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/Waimai")
public class WaimaiAction {

	@Resource
	private WaimaiService ws;
	public void setWs(WaimaiService ws) {
		this.ws = ws;
	}
	/**
	 * ���η���չ��ҳ��
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showWaimai")
	public String showKuaican(Model model)throws Exception{		
		return show(model);
	}
	/**
	 * ajax���ݲ�ϵ��ѯ��Ʒ��Ϣ
	 * @param typeid
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showByType")
	public String showByType(int typeid,Model model)throws Exception{
		List<Food> lists;
		if(typeid==0){
			//��ѯȫ����Ʒ
			lists=ws.getAllFood();
		}else{
			//���ݲ�ϵ��ѯ��Ʒ
			lists=ws.getByType(typeid);
		}
		yanzheng(lists);		
		model.addAttribute("foods", lists);
		return "/pages/xfr/foodinfo.jsp";
	}
	/**
	 * ajax�ж�ĳһ����Ƿ��㹻�û��������
	 * @param cainame
	 * @param num
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/jisuan")
	public String jisuan(String cainame,int num,int typeid,Model model)throws Exception{
		//System.out.println(cainame+"--"+num+"--"+typeid);
		//�������ֲ�ѯ��Ʒ����
		Food food=ws.getByName(cainame);
		
		//��ȡ�ò�Ʒ����Ĳ��ϼ���
		List<CookBook> ms=ws.getCaipuByFoodid(food.getId());
		for(CookBook ck:ms){
			//ȥ��������и��²�������
			boolean b=ws.updateKucun(num*ck.getNum(), ck.getMaterialsid());
		}	
		List<Food> lists;
		if(typeid==0){
			//��ѯȫ����Ʒ
			lists=ws.getAllFood();
		}else{
			//���ݲ�ϵ��ѯ��Ʒ
			lists=ws.getByType(typeid);
		}
		yanzheng(lists);		
		model.addAttribute("foods", lists);
		return "/pages/xfr/foodinfo.jsp";		
	}
	/**
	 * ��ѯĳ����Ʒ��ʣ������
	 * @param cainame
	 * @throws Exception
	 */
	@RequestMapping("/checkNum")
	public void checkNum(String cainame,HttpServletResponse response)throws Exception{
		//System.out.println(cainame);
		int maxnum=1000000;//�������ķ���
		//���ݲ�����ȡ��Ʒ����
		Food food=ws.getByName(cainame);		
		//���ݲ�Ʒ��ȡ�䷽
		List<CookBook> ms=ws.getCaipuByFoodid(food.getId());
		//�����䷽����������в�ѯ�����
		for(CookBook cb:ms){				
			//����ò�Ʒ��ʣ�����
			Kitchenkucun kk=ws.getByMaterialsid(cb.getMaterialsid());
			int x=(int)(kk.getNum()/cb.getNum());
			maxnum=maxnum<=x?maxnum:x;
		}
		//ajax����
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(maxnum);
		out.flush();
		out.close();
	}
	/**
	 *����,��������϶���
	 * @param model
	 * @param listinfo
	 * @param zl���ƺ�״̬�� 0-���У�1-ռ��
	 * @param paisong �ж��ǲ������ͼ�¼ 0-���ǣ�1-��
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zuofei")
	public String zuofei(Model model,ListinfoModel listinfo,ZList zl,String tel,String manname,String address,int paisong) throws Exception{	
		//System.out.println("sssssssssssss");
		zl.setSendmsg(manname+" "+tel+" "+address);
		String id=listinfo.getLists().get(0).getListid();//��ȡ�������
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ordertime=sf.format(new Date());
		double money=0;
		zl.setId(id);
		zl.setOrdertime(ordertime);
		if(paisong!=0){
			//���µ�����������Ҫ�����ͼ�¼�����������
			zl.setSendtime(ordertime);
		}
		for(Listinfo l:listinfo.getLists()){
			l.setPrice(l.getMoney()/l.getNum());
			money+=l.getMoney();
		}
		zl.setPaymoney(money);
		if(zl.getState()==2){
			//�ָ�֮ǰ���ݿ�ɾ���Ĳ�Ʒ������Ϣ
			for(Listinfo ll:listinfo.getLists()){
				//���ݲ�����ȡ��Ʒ����
				Food food=ws.getByName(ll.getCainame());				
				//��ȡ�ò�Ʒ����Ĳ��ϼ���
				List<CookBook> ms=ws.getCaipuByFoodid(food.getId());
				for(CookBook ck:ms){
					//ȥ��������и��²�������
					boolean b=ws.updateKucun(-ll.getNum()*ck.getNum(), ck.getMaterialsid());
				}
				
			}
			ws.subjiezhang(zl,listinfo.getLists());			
		}else {
			//����һ������
			ws.subjiezhang(zl,listinfo.getLists());
		}
		if(paisong!=0){
			//���µ�����������Ҫ�����ͼ�¼�����������
			//����Ա����Ż�ȡԱ������
			Emp sendman=ws.getByid(zl.getSendman());
			SendRecord sr=new SendRecord(zl.getId(), sendman.getName(), 0);
			//������ͼ�¼
			ws.addSenRecord(sr);
			//�����޸Ķ�����Ϣ�������������Լ�����ʱ�䣩
			ws.updatelistpaisong(zl);
		}
		//���·���ҳ��
		return show(model);
		
	}
	/**
	 * ȡ�ؽ������ϲ���
	 * @param listid
	 * @param model
	 * @return
	 */
	@RequestMapping("/quhuizuofei")
	public String quhuizuofei(String listid,Model model){
		ZList z=ws.getListByid(listid);
		//�޸Ķ���״̬
		ws.edilistzuofei(listid);
		return fasongquhui(model,1,1);
	}
	/**
	 * ����ȡ�ؽ�����������
	 * @param listid
	 * @param sendman
	 * @return
	 */
	@RequestMapping("/waimaiquhuipaisong")
	public String waimaiquhuipaisong(String listid,int sendman,Model model){
		ZList z=new ZList();
		z.setId(listid);
		z.setSendman(sendman);
		Emp e=ws.getByid(sendman);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sendtime=sf.format(new Date());
		z.setSendtime(sendtime);
		ws.updatelistpaisong(z);
		SendRecord sr=new SendRecord(listid, e.getName(), 0);
		ws.addSenRecord(sr);
		return fasongquhui(model,1,2);
	}
	/**
	 * ȡ�ؽ��水ʱ������
	 * @param time
	 * @param model
	 * @return
	 */
	@RequestMapping("/getBytime")
	public String getBytime(int time,Model model,int pageNum){
		int pageSize=1;
		int start=0;
		int end =0;
		if(time==0){
			//��ѯȫ��
			
		}else if(time==10){
			end=10*60;
		}else if(time==20){
			start=10*60;
			end=20*60;
		}else if(time==40){
			start=20*60;
			end=40*60;
		}else if(time==60){
			start=40*60;
			end=60*60;
		}else {
			start=60*60;
			end=120*60;
		}
		int start1=(pageNum-1)*pageSize+1;
		int end1=pageNum*pageSize;
		QueryTime qm=new QueryTime(start,end,start1,end1);
		List<ZList> zls=ws.getBytimeAll(qm);
		PageBean<ZList> pb=new PageBean<ZList>(pageNum, zls.size(), pageSize);			
		pb.setList(ws.getBytimeFenye(qm));
		for(ZList zz:pb.getList()){
 			if(zz.getSendman()!=0){
 				Emp s=ws.getByid(zz.getSendman());
 				zz.setSendname(s.getName());
 			}else{
 				zz.setSendname("");
 			}	
 		}
		model.addAttribute("zls", pb);
		model.addAttribute("url","Waimai/getBytime.do");
		return "/pages/xfr/waimaiquhuilist.jsp";
	}
	/**
	 * ȡ�ؽ��水״̬����
	 * @param state
	 * @param model
	 * @param pageNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBystate")
	public String getBystate(int state,Model model,int pageNum)throws Exception{
		List<ZList> zls;
		if(state==0){
			//��ѯ����δ���˵���������
			zls=ws.getlistBystateAndType(4,2);
		}else if(state==1){
			//δ����
			zls=ws.getlistBystateAndType1(4,2);
		}else{
			//������
			zls=ws.getlistBystateAndType2(4,2);
		}
 		int pagesize=1;
 		int totalRecord=zls.size();//�ܼ�¼
 		int start=(pageNum-1)*pagesize+1;
 		int end=pageNum*pagesize;
 		PageBean<ZList> pb=new PageBean<ZList>(pageNum, totalRecord, pagesize); 		
 		if(state==0){
			//��ѯ����δ���˵���������
 			pb.setList(ws.getlistBystateAndTypeAndFenye(4, 2, start, end));
		}else if(state==1){
			//δ����
			pb.setList(ws.getlistBystateAndTypeAndFenye1(4, 2, start, end));
		}else{
			//������
			pb.setList(ws.getlistBystateAndTypeAndFenye2(4, 2, start, end));
		}
 		for(ZList zz:pb.getList()){
 			if(zz.getSendman()!=0){
 				Emp s=ws.getByid(zz.getSendman());
 				zz.setSendname(s.getName());
 			}else{
 				zz.setSendname("");
 			}	
 		}
 		model.addAttribute("zls", pb);
		model.addAttribute("url","Waimai/getBystate.do");
		return "/pages/xfr/waimaiquhuilist.jsp";
	}
	/**
	 * ��������չʾ����ҳ��
	 * @param danhao
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/jiezhang")
	public String jiezhang(Model model,ListinfoModel listinfo,ZList zl,String tel,String manname,String address)throws Exception{
		zl.setSendmsg(manname+" "+tel+" "+address);
		String id=listinfo.getLists().get(0).getListid();//��ȡ�������
		ZList zl1=ws.getListByid(id);		
		if(zl1==null){			
			//δ�ύ������
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ordertime=sf.format(new Date());
			double money=0;
			zl.setId(id);
			zl.setOrdertime(ordertime);
			for(Listinfo l:listinfo.getLists()){
				l.setPrice(l.getMoney()/l.getNum());
				money+=l.getMoney();
			}
			zl.setPaymoney(money);
			ws.subjiezhang(zl,listinfo.getLists());		
		}
		model.addAttribute("zlist",zl);
		model.addAttribute("cailist", listinfo.getLists());	
		model.addAttribute("types", "waimai");	
		return "/pages/xfr/jiezhang.jsp";
	}
	/**
	 * ������Ϣʱ��������Ա
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getpaisongman")
	public void getpaisongman(HttpServletResponse response)throws Exception{
		List<Emp> emps=ws.getpaisongman();
		List<Emp> eee=new ArrayList<Emp>();
		for(Emp e:emps){
			int m=ws.getmannum(e.getName());
			if(m>=5){
				//ÿ������Ա���ͬʱ�����������
				eee.add(e);
			}
		}
		for(Emp e:eee){
			emps.remove(e);
		}
		JSONArray js=new JSONArray().fromObject(emps);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter();
		out.print(js);
		out.flush();
		out.close();
		
	}
	/**
	 * ȡ�ؽ�����ת����
	 * @param model
	 * @param listid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/quhuijiezhang")
	public String quhuijiezhang(Model model,String listid)throws Exception{
		//System.out.println(listid);
		ZList zl=ws.getListByid(listid);		
		List<Listinfo> lists=ws.getbylistid(listid);
		model.addAttribute("zlist", zl);
		model.addAttribute("cailist", lists);
		model.addAttribute("types", "waimaiquhui");	
		return "/pages/xfr/jiezhang.jsp";
	}
	/**
	 * ȡ�ؽ�������չʾ
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getcailist")
	public String getcailist(String id,Model model)throws Exception{
		List<Listinfo> lists=ws.getbylistid(id);
		model.addAttribute("foods",lists);
		return "/pages/xfr/quhuicailist.jsp";
	}
	/**
	 * �������
	 * @param zl
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/subjiezhang")
	public String subjiezhang(ZList zl,Model model,String tts)throws Exception {
		System.out.println("������ˣ�");
		System.out.println(zl.getVip()+"--"+zl.getId()+"--"+zl.getDazhemoney()+"--"+zl.getRealpay());
		zl.setCashierid(1);////////////////////
		if(zl.getDazhemoney()!=0&&zl.getVip()!=0){
			//�ǻ�Ա֧��,���һ����Ա���Ѽ�¼,�����޸Ļ�Ա�˻����
			VipRecord vr=new VipRecord();
			vr.setVipid(zl.getVip());
			vr.setDoman(1);/////////////////////////
			vr.setListid(zl.getId());
			vr.setType(1);
			vr.setMoney(zl.getRealpay());
			ws.subvippay(vr,zl);			
		}else{
			ws.subputongpay(zl);
		}
		
		//���·���ҳ��
		if(tts.equals("waimai")){
			return show(model);	
		}else {//if(tts.equals("waimaiquhui"))
			return fasongquhui(model,1,1);
		}
	}
	/**
	 * �����ֻ��Ż�ȡ��Ա����
	 * @param tel
	 *//*
	@RequestMapping("/getvip")
	public void  getvip(String tel,HttpServletResponse response)throws Exception{
		Vip vip=ks.getvip(tel);
		JSONArray js=new JSONArray().fromObject(vip);		
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(js.toString());
		out.flush();
		out.close(); 
	}
	*//**
	 * չʾȡ��ҳ��
	 * @param model
	 * @param t 1-�״�չʾ��2-��ҳչʾ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showquhui")
	public String showquhui(Model model,int pageNum ,int t)throws Exception{		
 		return fasongquhui(model,pageNum,t);
	}
	private String fasongquhui(Model model,int pageNum,int t){
		List<ZList> zls=ws.getlistBystateAndType(4,2);
 		int pagesize=1;
 		int totalRecord=zls.size();//�ܼ�¼
 		int start=(pageNum-1)*pagesize+1;
 		int end=pageNum*pagesize;
 		PageBean<ZList> pb=new PageBean<ZList>(pageNum, totalRecord, pagesize);
 		pb.setList(ws.getlistBystateAndTypeAndFenye(4, 2, start, end));
 		for(ZList zz:pb.getList()){
 			if(zz.getSendman()!=0){
 				Emp s=ws.getByid(zz.getSendman());
 				zz.setSendname(s.getName());
 			}else{
 				zz.setSendname("");
 			}	
 		}
		model.addAttribute("zls", pb);
		model.addAttribute("url", "Waimai/showquhui.do");
		if(t==1){
			return "/pages/xfr/waimaiquhui.jsp";
		}else{
			return "/pages/xfr/waimaiquhuilist.jsp";
		}
	}
	/**
	 * ����
	 * @param fs
	 * @return
	 */
	private void yanzheng(List<Food> fs){		
		//HashMap<Food, Integer> map=new HashMap<Food, Integer>();
		//������Ʒ�б�
		for(Food f:fs){
			//��ȡ�ò�Ʒ����Ĳ��ϼ���
			List<CookBook> ms=ws.getCaipuByFoodid(f.getId());
			if(ms.size()>0){
				int n=ms.size();//��¼�ò˵Ĳ������������
				for(CookBook cb:ms){				
					//��ѯÿ�ֲ��ϵĿ����
					Kitchenkucun kk=ws.getByMaterialsid(cb.getMaterialsid());
					if(kk!=null){
						if(kk.getNum()>=cb.getNum()){
							//����㹻
							n--;					
						}
					}
				}
				if(n==0){
					//�ò���������в��Ͼ�����㹻
					f.setIsguqing(0);					
				}else{
					f.setIsguqing(1);	
				}
			}else{
				f.setIsguqing(1);	
			}
		}
		
	}
	/**
	 * չʾ��ʼ��������
	 * @param model
	 * @return
	 */
	private String show(Model model){
		List<Food> foods=ws.getAllFood();		
		List<Mode> cooktypes=ws.getAllCookType();
		List<Mode> yaoqius=ws.getAllYaoqiu();
		yanzheng(foods);		
		model.addAttribute("foods", foods);	
		model.addAttribute("cks", cooktypes);
		model.addAttribute("yqs", yaoqius);
		return "/pages/xfr/Waimai.jsp";
	}
}
