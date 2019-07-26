package com.zy.bean;
import java.util.List;
/**
 * ��ҳ��Ϣ��
 * @author Administrator
 *
 */
public class PageBean<T> {

	private int pageNum;    //��ǰҳ,�������Ǳߴ�������
	private int pageSize;    //ÿҳ��ʾ������������
	private int totalRecord;    //�ܵļ�¼��������ѯ���ݿ�õ�������
	      
	     //��Ҫ�������
	      private int totalPage;    //��ҳ����ͨ��totalRecord��pageSize������Ե���
	      //��ʼ������Ҳ�������������ݿ���Ҫ�ӵڼ������ݿ�ʼ�ã�����startIndex��pageSize��
	    //��֪����limit�����������ݣ����ܻ��ÿҳ��Ҫ��ʾ��������
	     private int startIndex;        
	          
	      
	      //��ÿҳҪ��ʾ�����ݷ���list������
	     private List<T> list;
	      
	      //��ҳ��ʾ��ҳ��,������ҳ������ʾ1��2��3��4��5ҳ��start��Ϊ1��end��Ϊ5�����Ҳ���������
	    private int start;
	    private int end;
	     
	     //ͨ��pageNum��pageSize��totalRecord�������tatalPage��startIndex
	      //���췽���н�pageNum��pageSize��totalRecord���
	      public PageBean(int pageNum,int totalRecord,int pagesize) {
	        this.pageNum = pageNum;
	        this.totalRecord = totalRecord;
	        this.pageSize=pagesize;	         
	          //totalPage ��ҳ��
	          if(totalRecord%pageSize==0){
	              //˵������������ÿҳ��ʾpageSize�����ݣ�û�ж���һҳҪ��ʾ����pageSize�����ݵ�
	             this.totalPage = totalRecord / pageSize;
	          }else{
	             //����������Ҫ�ڼ�һҳ������ʾ��������ݡ�
	              this.totalPage = totalRecord / pageSize +1;
	          }
	         //��ʼ����
	         this.startIndex = (pageNum-1)*pageSize ;
	          //��ʾ5ҳ�������Լ��������ã�����ʾ��ҳ���Լ�ͨ�������㷨�޸�
	         this.start = 1;
	         this.end = 5;
	         //��ʾҳ�����㷨
	 
	         if(totalPage <=5){
	            //��ҳ����С��5����ôend��Ϊ��ҳ����ֵ�ˡ�
	             this.end = this.totalPage;
	        }else{
	            //��ҳ������5����ô��Ҫ���ݵ�ǰ�ǵڼ�ҳ�����ж�start��endΪ�����ˣ�
	             this.start = pageNum - 2;
	              this.end = pageNum + 2;
	             
	              if(start < 0){
	                //���統ǰҳ�ǵ�1ҳ�����ߵ�2ҳ����ô�Ͳ�����������
	                  this.start = 1;
	                 this.end = 5;
	             }
	             if(end > this.totalPage){
	                  //���統ǰҳ�ǵ�����2ҳ�������һҳ��Ҳͬ�������������������
	                 this.end = totalPage;
	                 this.start = end - 5;
	             }
	         }
	      }
	  //get��set������
	      public int getPageNum() {
	          return pageNum;
	     }
 
	     public void setPageNum(int pageNum) {
	         this.pageNum = pageNum;
	     }
	  
	    public int getPageSize() {
	         return pageSize;
	     }
	  
	      public void setPageSize(int pageSize) {
	          this.pageSize = pageSize;
	     }
	  
	      public int getTotalRecord() {
	         return totalRecord;
	     }
	
	      public void setTotalRecord(int totalRecord) {
	          this.totalRecord = totalRecord;
	      }
	
	     public int getTotalPage() {
	         return totalPage;
	      }
	 
	      public void setTotalPage(int totalPage) {
	         this.totalPage = totalPage;
	      }
	  
	    public int getStartIndex() {
	       return startIndex;
	    }
	 
	     public void setStartIndex(int startIndex) {
	         this.startIndex = startIndex;
	    }
	
	     public List<T> getList() {
	         return list;
	     }
	 
	     public void setList(List<T> list) {
	         this.list = list;
	    }
	
	     public int getStart() {
	         return start;
	     }
	
	     public void setStart(int start) {
	         this.start = start;
	     }
	
	     public int getEnd() {
	        return end;
	     }
	
	    public void setEnd(int end) {
	         this.end = end;
	    }
}
