package com.cyuxuan.myconllection;

/**
 * @author Cyuxuan
 * 
 * ��˵�� : 
 * 		�����������еĽڵ���
 */

public class Node {
	
	private Node previous;//��һ���ڵ�
	
	private Node next;//��һ���ڵ�
	
	private Object element;//��ǰ�ڵ��е�����Ԫ��

	
	
	public Node(Node previous, Node next, Object element) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = element;
	}



	public Node(Object element) {
		super();
		this.element = element;
	}
	
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
	
	
	
	
}
