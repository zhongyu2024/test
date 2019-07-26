package com.zy.action;

 

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
 

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zy.bean.Giver;
import com.zy.bean.Unit;
import com.zy.service.ZGiverService;

@Controller
@RequestMapping("/giver")
public class ZGiverAction {
@Resource 
     private ZGiverService zgiverservice;
private Object re;

public void setZgiverservice(ZGiverService zgiverservice) {
	this.zgiverservice = zgiverservice;
}
//��ѯ���г��̵���Ϣ
@RequestMapping("/findAllGiverInfo")
public String findAllGiverInfo(Model model,@RequestParam(defaultValue="1")int page)throws Exception{
	//���й�Ӧ��
	 //System.out.println(page+"+++++++++++++++");
	 List<Giver> gys = zgiverservice.findAllgys(page);
	 int cnum=zgiverservice.findAllg()/18;
	 if(zgiverservice.findAllg()%18!=0){
			cnum=cnum+1;
		}
	 
		model.addAttribute("page", page);
		model.addAttribute("zy", cnum);
	 model.addAttribute("gysAll", gys);
	return "/pages/zj/gys.jsp";
}
//��������ѯ
@RequestMapping("/ajaxQ")
public String ajaxQ(String typed,String zhi,@RequestParam(defaultValue="1")int page,Model model)throws Exception
{
	int cnum;
	List<Giver> listgys;
	//��ѯ
	 
	 if(zhi.length()==0)
	 {
		 listgys = zgiverservice.findAllgys(page);
			 cnum=zgiverservice.findAllg()/18;
			 if(zgiverservice.findAllg()%18!=0){
					cnum=cnum+1;
		     }
	 }else{
		 
		 
		 
	 
	if(typed.equals("���")){
		 
		  listgys = zgiverservice.tiaojianGysInfoId(zhi,page);
		  cnum = zgiverservice.tiaojianGysInfoIdcount(zhi)/18;
		  
			 if(zgiverservice.tiaojianGysInfoIdcount(zhi)%18!=0){
					cnum=cnum+1;
		     }
	}
	else{
		
		  listgys = zgiverservice.tiaojianGysInfoName(zhi,page);
		  cnum=zgiverservice.tiaojianGysInfoNamecount(zhi,page)/18; 
		   
			 if(zgiverservice.tiaojianGysInfoNamecount(zhi,page)%18!=0){
					cnum=cnum+1;
		     }
	} 
	 }

	 System.out.println("+++++++++"+page);
		model.addAttribute("page", page);
		model.addAttribute("zy", cnum);
	model.addAttribute("gysAll", listgys); 
	return "/pages/zj/gysajax.jsp";
}
//��ӳ�������
@RequestMapping("/ajaxQadd")
public String ajaxQadd(String name,String content,String cell,String address,Model model,@RequestParam(defaultValue="1")int page)throws Exception
{
	System.out.println("�������");
	// System.out.println(page+"+++++++++++++++");
	Giver csy=new Giver(0, name,content,cell,address);
	       zgiverservice.addgys(csy);
	 
		 System.out.println("��ӳɹ���");
		  
		 List<Giver> gys = zgiverservice.findAllgys(page);
		 int cnum=zgiverservice.findAllg()/18;
		 if(zgiverservice.findAllg()%18!=0){
				cnum=cnum+1;
			}
		 System.out.println("__________"+zgiverservice.findAllg());
			model.addAttribute("page", page);
			model.addAttribute("zy", cnum);
		 model.addAttribute("gysAll", gys);
		 return "/pages/zj/gysajax.jsp";
  
}

//ɾ����������
@RequestMapping("/ajaxQdele")
public String ajaxQdele(int id,Model model,@RequestParam(defaultValue="1")int page)throws Exception
{
	     //zgiverservice.delegysruku(id);
	      zgiverservice.delegys(id);
		 System.out.println("ɾ���ɹ���");
		 List<Giver> gys = zgiverservice.findAllgys(page);
		 int cnum=zgiverservice.findAllg()/18;
		 if(zgiverservice.findAllg()%18!=0){
				cnum=cnum+1;
			}
		 System.out.println("__________"+zgiverservice.findAllg());
			model.addAttribute("page", page);
			model.addAttribute("zy", cnum);
		 model.addAttribute("gysAll", gys);
		 return "/pages/zj/gysajax.jsp";
  
}
//�޸ĳ���
@RequestMapping("/ajaxQXiugai")
public String ajaxQXiugai(int id,String name,String content,String cell,String address,Model model,@RequestParam(defaultValue="1")int page)throws Exception
{
	    Giver csyy=new Giver(id, name,content,cell,address);
	     zgiverservice.xiugaigys(csyy);
		 System.out.println("�޸ĳɹ���");
		 List<Giver> gys = zgiverservice.findAllgys(page);
		 int cnum=zgiverservice.findAllg()/18;
		 if(zgiverservice.findAllg()%18!=0){
				cnum=cnum+1;
			}
			model.addAttribute("page", page);
			model.addAttribute("zy", cnum);
		 model.addAttribute("gysAll", gys);
		 return "/pages/zj/gysajax.jsp";
  
}
@RequestMapping("/findAt")
public String findAt(Model model,@RequestParam(defaultValue="1")int page)throws Exception{
	//���й�Ӧ��
	 System.out.println(page+"+++++++++++++++�����鿴ȫ��");
	 List<Giver> gys = zgiverservice.findAllgys(page);
	 int cnum=zgiverservice.findAllg()/18;
	 if(zgiverservice.findAllg()%18!=0){
			cnum=cnum+1;
		}
	 System.out.println("__________"+zgiverservice.findAllg());
		model.addAttribute("page", page);
		model.addAttribute("zy", cnum);
	 model.addAttribute("gysAll", gys);
	return "/pages/zj/gysajax.jsp";
}
@RequestMapping("/gongyingsagin")
public void gongyingsagin(String name,Model model,HttpServletResponse response)throws Exception{
	int ck=1;
	    List<Giver> sek = zgiverservice.gongyschong(name);
	if(sek.size()==0)
		ck=0;
	JSONArray js = JSONArray.fromObject(ck);
	System.out.println(js.toString());
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/json");
	PrintWriter out = response.getWriter();
	out.write(js.toString());
	out.flush();
	out.close();
	
}

}
