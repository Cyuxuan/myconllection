package com.cyuxuan.myconllection;

public class MyArrayList<E> {
	
	//�洢����
	private Object[] elementData;
	
	
	//��ǰ�������Ѵ�������Ԫ�س���
	private int size;
	
	
	//Ĭ�����鳤��
	private static int DEFALT_CAPACITY = 10;
	
	//���ǲ�������
	private int a;
	
	//�޲ι��캯������ʼ������
	public MyArrayList() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	

	//�������Ĺ��캯��
	public MyArrayList(int  capacity) {
		
		if(capacity<0){
			throw  new  RuntimeException("��������������Ϊ����");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
		
		
	}
	
	//��дtoString����
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i=0;i< size;i++) {
			sb.append(elementData+",");
		}
		
		sb.setCharAt(sb.length()-1, ']');//�����һ�������滻Ϊ]
		return sb.toString();
	}
	
	/*
	 * �Ƴ�ָ���±��Ԫ��
	 */
	public  void  remove(int index){
		
		//a,b,c,d,e,f,g,h
		//a,b,c,e,f,g,h,h
		int numMoved = elementData.length-index-1;//���Ƴ�λ�õ������±�
		if(numMoved>0){//�����±겻��Ϊɶ����
			System.arraycopy(elementData, index+1, elementData, index, numMoved);//
		}
		
		elementData[--size] = null;//�����һ��λ��ֵΪnull
		
	}
	
	
	/*
	 * �Ƴ���һ����ָ��Ԫ��ƥ���Ԫ��
	 */
	public void  remove(E  element){
		//element������������Ԫ�ذ����Ƚϣ���õ�һ���Ƚ�Ϊtrue�ģ����ء�
		for(int i=0;i<size;i++){
			if(element.equals(get(i))){   //���������еıȽϲ����������õ�equals������==
				
				//����Ԫ�شӴ˴��Ƴ�
				remove(i);
			}
		}
	}
	
	
	/*
	 * ���Ŀ��λ���Ƿ�Ϸ�
	 */
	public  void  checkRange(int index){
		/*
		 * //�����Ϸ��ж� [0,size) 10 0-9 if(index<0||index>size-1){ //���Ϸ� //throw new
		 * RuntimeException("�������Ϸ�:"+index);//�׳��쳣
		 * 
		 * System.out.println("�������Ϸ�:"+index); return false; }
		 * 
		 * return true;
		 */
		
		
		if(index < 0 || index > size -1) {
			throw new RuntimeException("�������Ϸ�:" + index);
		}
	}
	
	
	/*
	 * ����ָ���±�Ķ���
	 */
	public  E  get(int index) {
		
		/*
		 * if(checkRange(index)) { return (E)elementData[index]; }else{ throw new
		 * RuntimeException("�±겻����"); }
		 */
		
		checkRange(index);
		
		return (E)elementData[index];

	}
	
	
	/*
	 * ����ָ���±�Ķ���
	 */
	public void set(E element, int  index) {
		
		checkRange(index);
		
		elementData[index] = element;
		
	}
	
	
	/*
	 * �������鵱ǰ���鳤��
	 */
	public int size(){
		return size;
	}
	
	
	/*
	 * ��֤��ǰ�����Ƿ�Ϊ��
	 */
	public  boolean isEmpty(){
		return  size==0?true:false;
	}
	
	
	/*
	 * �����������ָ��Ԫ��
	 * ������鳤�Ȳ�����Ҫ�������ݲ���
	 */
	public  void  add(E  element){
		
		//ʲôʱ�����ݣ���
		if(size == elementData.length){
			//���ݲ���
			Object[]  newArray  =  new Object[elementData.length+(elementData.length>>1)];  //���ӳ�����ԭ���ȼ���ԭ���ȵ�һ���
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //��ʼ���и���
			elementData = newArray;//�µõ����鸳ֵ������elementData
		}
		
		elementData[size++] = element;//����ӵ�Ԫ�ؼ���ĩβ
	}

	
	//����ArrayList��
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
		
		//����һ��
	}

}
