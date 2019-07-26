package com.zy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.bean.Caipin;
import com.zy.bean.Food;
import com.zy.bean.Mode;
import com.zy.dao.mapper.caiPinMapple;
@Service
public class caiPinService {

	@Resource
	private caiPinMapple cpm;
	public void setCpm(caiPinMapple cpm) {
		this.cpm = cpm;
	}
	public List<Caipin> findAllFood(){
		System.out.println("����caipinMapple");
		return cpm.findAllFood();
	}
	public List<Caipin> showOthers(String name){
		System.out.println("����showothers");
		return cpm.showOthers(name);
	}
	public boolean addFood(String name,int id,Double price){
		System.out.println("����addFood");
		return cpm.addFood(name,id,price);
	}
	public boolean deleteFood(int id){
		System.out.println("����deleteFood");
		return cpm.deleteFood(id);
	}
	public boolean editFood(String name,String name1,Double price){
		System.out.println("����editFood");
		return cpm.editFood(name1, name1, price);
	}
	public int searchFoodByName(int id){
		System.out.println("����searchFoodByName");
		return cpm.searchFoodByName(id);
	}
	public int searchthis(String name){
		System.out.println("����searchthis");
		return cpm.searchthis(name);
	}
	public List<Mode> findAllCookType(){
		System.out.println("����caipinMapple");
		return cpm.findAllCookType();
	}
	
	////����
	public List<Caipin> searchType(String name){
		System.out.println("����addCook");
		return cpm.searchCai(name);
	}
	
	
	public boolean addCookType(Mode mode){
		System.out.println("����addCook");
		return cpm.addCookType(mode);
	}
	public boolean deleteCookType(String name){
		System.out.println("����deleteCook");
		return cpm.deleteCookType(name);
	}
	public boolean deleteAllFood(int typeid){
		System.out.println("����deleteFood");
		return cpm.deleteAllFood(typeid);
	}
	public boolean editCoolType(String name,String name1){
		System.out.println("����editCook");
		return cpm.editCookType(name,name1);
	}
}
