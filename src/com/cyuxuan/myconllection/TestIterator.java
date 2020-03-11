package com.cyuxuan.myconllection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author Cyuxuan
 * 类说明:
 * 		测试迭代器遍历List、Set、Map
 */
public class TestIterator {
	public static void main(String[] args) {
//		testIteratorList();
//		testIteratorSet();
//		testIteratorMap();
		
		testRemove();
	}
	
	public static void testIteratorList(){
		List<String>  list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		//使用iterator遍历List
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String  temp = iter.next();//返回遍历到的值并且将游标向下位移一个
			System.out.println(temp);
		}
		
	}
	
	public static void testIteratorSet(){
		Set<String>  set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		//使用iterator遍历Set
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
		
	}
	
	public static void testIteratorMap(){
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(100, "aa");
		map1.put(200, "bb");
		map1.put(300, "cc");
		

		//第一种遍历Map的方式，遍历出键值对
		Set<Entry<Integer,String>>  ss =  map1.entrySet();
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp = iter.next();
			
			System.out.println(temp.getKey()+"--"+temp.getValue());
			
		}
		System.out.println("++++++++++++++++++++++++");
		
		
		
		//第二种遍历Map的方式，便利出键然后再由键获取值
		Set<Integer>  keySet = map1.keySet();
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext(); ){
			Integer key = iter.next();
			System.out.println(key+"----"+map1.get(key));
		}
		
		
	}
	
	//测试边遍历，边删除
	public static void testRemove(){
		List<String> list = new ArrayList<>();
		
		//初始化List
		for(int i=0;i<20;i++){
			list.add("test_"+i);
		}
		
		
		//循环遍历list
		for(int i=0;i<list.size();i++){
			
			String temp = list.get(i);
			
			if(temp.endsWith("2")){//endsWith测试字符串是否已指定的字符结尾
				list.remove(i);
			}
			System.out.println(list.size()); 
			System.out.println(list.get(i));  
		}
		
		
	}
	
}
