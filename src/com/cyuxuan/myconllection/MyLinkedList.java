package com.cyuxuan.myconllection;



/**
 * @author Cyuxuan
 * 类说明:
 * 		此类是LinkedList主体类
 */
public class MyLinkedList<E> {
	
	private Node first;//第一个元素
	
	private Node last;//最后一个元素
	
	private int size;//链表当前长度
	
	
	
	public  void  add(int index, E  element) {   //alt+shift+R
		
		checkRange(index);//验证位置是否合法
		
		Node  newNode = new Node(element);
		
		//
		Node  temp  =  getNode(index);
		
		
		//节点顺序为up newNode temp
		if(temp!=null){
			Node up = temp.getPrevious();
			
			up.setNext(newNode);//
			newNode.setPrevious(up);
			
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			
		}
		
	}
	
	
	
	//移除指定位置的元素
	public   void  remove(int index){
		
		checkRange(index);//检查小标是否合法
		
		Node  temp  =  getNode(index);//获取指定下标的元素
		
		if(temp!=null){
			Node  up = temp.getPrevious();
			Node down = temp.getNext();
			
			if(up!=null){
				up.setNext(down);
			}
			
			if(down!=null){
				down.setPrevious(up);
			}
			
			//被删除的元素是第一个元素时
			if(index==0){
				first = down;
			}
			
			//被删除的元素是最后一个元素时
			if(index == size-1){
				last = up;
			}
			
			size--;
		}
		
	}
	
	
	//获取指定下标的元素
	public  E  get(int index) {  
	
		checkRange(index);//检查下标是否合法
		
		Node temp = getNode(index);
		
		return temp!=null?(E)temp.getElement():null;//三目运算符
	}
	
	
	//检查下标是否合法
	//不合法直接抛出运行时异常
	private  void  checkRange(int index){
		if(index<0||index>size-1){
			throw  new RuntimeException("索引数字不合法:"+index);
		}
	}
	
	
	
	private   Node  getNode(int index){
		
		checkRange(index);//检查下标是否合法
		
		Node  temp = null;//初始化一个空节点对象
		
		/*
		 * 此处的循环主要是解决一下效率问题
		 * 		大于一半从后面循环
		 * 		小于一半从前面循环获取
		 * 		因为链表只能通过next逐个向后访问或者provious逐个向前访问
		 */
		if(index<=(size>>1)){   //size>>1相当于除以2
			temp = first;
			for(int i=0 ; i<index ; i++){
				temp = temp.getNext();
			}
		}else{
			temp = last;
			for(int i=size-1; i>index;i--){
				temp = temp.getPrevious();
			}
		}
		
		return temp;
	}
	
	
	
	//向链表中添加元素
	public  void  add(E  element) {
		Node  node  = new Node(element);
		
		if(first==null){//如果链表中还没有元素，直接放入即可
//			node.setPrevious(null);
//			node.setNext(null);
			first = node;
			last = node;
		}else{//如果已有元素，则需要插入最后已有的组后一个元素之后
			
			node.setPrevious(last);
			node.setNext(null);
			
			last.setNext(node);
			last = node;
			
		}
		
		size++;//链表元素数量+1
		
		
	}
	
	@Override
	public String toString() {
		//[a,b,c]     first=a,    last=c
		//a,b,c
		StringBuilder   sb = new StringBuilder("[");
		Node  temp = first;
		while(temp!=null){
			sb.append(temp.getElement()+",");
			temp = temp.getNext();
		}
		sb.setCharAt(sb.length()-1, ']'); 
		
		return sb.toString();
	}	
	
	
	/*
	 * 主函数用于测试
	 */
	public static void main(String[] args) {
		MyLinkedList<String>  list = new MyLinkedList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		System.out.println(list);
		
		System.out.println(list.get(3));
		
		
	}
}
