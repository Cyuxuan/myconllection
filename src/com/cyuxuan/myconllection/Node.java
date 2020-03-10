package com.cyuxuan.myconllection;

/**
 * @author Cyuxuan
 * 
 * 类说明 : 
 * 		此类是链表中的节点类
 */

public class Node {
	
	private Node previous;//上一个节点
	
	private Node next;//下一个节点
	
	private Object element;//当前节点中的数据元素

	
	
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
