package com.cyuxuan.myconllection;

public class MyArrayList<E> {
	
	//存储数组
	private Object[] elementData;
	
	
	//当前数组内已存入数据元素长度
	private int size;
	
	
	//默认数组长度
	private static int DEFALT_CAPACITY = 10;
	
	//这是测试数据
	private int a;
	
	//无参构造函数，初始化数组
	public MyArrayList() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	

	//带参数的构造函数
	public MyArrayList(int  capacity) {
		
		if(capacity<0){
			throw  new  RuntimeException("容器的容量不能为负数");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
		
		
	}
	
	//重写toString方法
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i=0;i< size;i++) {
			sb.append(elementData+",");
		}
		
		sb.setCharAt(sb.length()-1, ']');//将最后一个逗号替换为]
		return sb.toString();
	}
	
	/*
	 * 移除指定下标的元素
	 */
	public  void  remove(int index){
		
		//a,b,c,d,e,f,g,h
		//a,b,c,e,f,g,h,h
		int numMoved = elementData.length-index-1;//被移除位置的数组下标
		if(numMoved>0){//数组下标不能为啥负数
			System.arraycopy(elementData, index+1, elementData, index, numMoved);//
		}
		
		elementData[--size] = null;//将最后一个位置值为null
		
	}
	
	
	/*
	 * 移除第一个和指定元素匹配的元素
	 */
	public void  remove(E  element){
		//element，将它和所有元素挨个比较，获得第一个比较为true的，返回。
		for(int i=0;i<size;i++){
			if(element.equals(get(i))){   //容器中所有的比较操作，都是用的equals而不是==
				
				//将该元素从此处移除
				remove(i);
			}
		}
	}
	
	
	/*
	 * 检查目标位置是否合法
	 */
	public  void  checkRange(int index){
		/*
		 * //索引合法判断 [0,size) 10 0-9 if(index<0||index>size-1){ //不合法 //throw new
		 * RuntimeException("索引不合法:"+index);//抛出异常
		 * 
		 * System.out.println("索引不合法:"+index); return false; }
		 * 
		 * return true;
		 */
		
		
		if(index < 0 || index > size -1) {
			throw new RuntimeException("索引不合法:" + index);
		}
	}
	
	
	/*
	 * 返回指定下标的对象
	 */
	public  E  get(int index) {
		
		/*
		 * if(checkRange(index)) { return (E)elementData[index]; }else{ throw new
		 * RuntimeException("下标不存在"); }
		 */
		
		checkRange(index);
		
		return (E)elementData[index];

	}
	
	
	/*
	 * 设置指定下标的对象
	 */
	public void set(E element, int  index) {
		
		checkRange(index);
		
		elementData[index] = element;
		
	}
	
	
	/*
	 * 返回数组当前数组长度
	 */
	public int size(){
		return size;
	}
	
	
	/*
	 * 验证当前数组是否为空
	 */
	public  boolean isEmpty(){
		return  size==0?true:false;
	}
	
	
	/*
	 * 向数组中添加指定元素
	 * 如果数组长度不足需要进行扩容操作
	 */
	public  void  add(E  element){
		
		//什么时候扩容？？
		if(size == elementData.length){
			//扩容操作
			Object[]  newArray  =  new Object[elementData.length+(elementData.length>>1)];  //增加长度是原长度加上原长度的一般半
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //开始进行复制
			elementData = newArray;//新得的数组赋值给变量elementData
		}
		
		elementData[size++] = element;//将添加的元素加入末尾
	}

	
	//测试ArrayList类
	public static void main(String[] args) {
		MyArrayList<String>  s1 = new MyArrayList<String>(5);
		
		for(int i=0;i<40;i++){
			s1.add("gao"+i);
		}
		
		s1.set("dddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(39));

		s1.remove(3);
		s1.remove("gao11");
		System.out.println(s1);
		System.out.println(s1.size);
		System.out.println(s1.isEmpty()); 
		
		//测试一下
	}

}
