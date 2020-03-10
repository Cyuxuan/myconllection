package com.cyuxuan.myconllection;



/**
 * @author Cyuxuan
 * ��˵��:
 * 		������LinkedList������
 */
public class MyLinkedList<E> {
	
	private Node first;//��һ��Ԫ��
	
	private Node last;//���һ��Ԫ��
	
	private int size;//����ǰ����
	
	
	
	public  void  add(int index, E  element) {   //alt+shift+R
		
		checkRange(index);//��֤λ���Ƿ�Ϸ�
		
		Node  newNode = new Node(element);
		
		//
		Node  temp  =  getNode(index);
		
		
		//�ڵ�˳��Ϊup newNode temp
		if(temp!=null){
			Node up = temp.getPrevious();
			
			up.setNext(newNode);//
			newNode.setPrevious(up);
			
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			
		}
		
	}
	
	
	
	//�Ƴ�ָ��λ�õ�Ԫ��
	public   void  remove(int index){
		
		checkRange(index);//���С���Ƿ�Ϸ�
		
		Node  temp  =  getNode(index);//��ȡָ���±��Ԫ��
		
		if(temp!=null){
			Node  up = temp.getPrevious();
			Node down = temp.getNext();
			
			if(up!=null){
				up.setNext(down);
			}
			
			if(down!=null){
				down.setPrevious(up);
			}
			
			//��ɾ����Ԫ���ǵ�һ��Ԫ��ʱ
			if(index==0){
				first = down;
			}
			
			//��ɾ����Ԫ�������һ��Ԫ��ʱ
			if(index == size-1){
				last = up;
			}
			
			size--;
		}
		
	}
	
	
	//��ȡָ���±��Ԫ��
	public  E  get(int index) {  
	
		checkRange(index);//����±��Ƿ�Ϸ�
		
		Node temp = getNode(index);
		
		return temp!=null?(E)temp.getElement():null;//��Ŀ�����
	}
	
	
	//����±��Ƿ�Ϸ�
	//���Ϸ�ֱ���׳�����ʱ�쳣
	private  void  checkRange(int index){
		if(index<0||index>size-1){
			throw  new RuntimeException("�������ֲ��Ϸ�:"+index);
		}
	}
	
	
	
	private   Node  getNode(int index){
		
		checkRange(index);//����±��Ƿ�Ϸ�
		
		Node  temp = null;//��ʼ��һ���սڵ����
		
		/*
		 * �˴���ѭ����Ҫ�ǽ��һ��Ч������
		 * 		����һ��Ӻ���ѭ��
		 * 		С��һ���ǰ��ѭ����ȡ
		 * 		��Ϊ����ֻ��ͨ��next��������ʻ���provious�����ǰ����
		 */
		if(index<=(size>>1)){   //size>>1�൱�ڳ���2
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
	
	
	
	//�����������Ԫ��
	public  void  add(E  element) {
		Node  node  = new Node(element);
		
		if(first==null){//��������л�û��Ԫ�أ�ֱ�ӷ��뼴��
//			node.setPrevious(null);
//			node.setNext(null);
			first = node;
			last = node;
		}else{//�������Ԫ�أ�����Ҫ����������е����һ��Ԫ��֮��
			
			node.setPrevious(last);
			node.setNext(null);
			
			last.setNext(node);
			last = node;
			
		}
		
		size++;//����Ԫ������+1
		
		
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
	 * ���������ڲ���
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
