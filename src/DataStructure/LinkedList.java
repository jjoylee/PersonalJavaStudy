package DataStructure;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public static void main(String args[]){
		LinkedList numbers = new LinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		System.out.println(numbers);
	}
	
	class Node{
		Node next;
		Object data;
		
		Node(Object data){
			this.next = null;
			this.data = data;
		}
	}
	
	public void addFirst(Object data){
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
		if(head.next == null)
			tail = head;
	}
	
	public void addLast(Object data){
		Node node = new Node(data);
		if(size == 0){ 
			addFirst(data);
		}else{
			tail.next = node;
			tail = node;
			size++;
		}
	}
	
	
	public Object get(int index){
		return getNode(index).data;
	}

	public Node getNode(int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : "+ size);
		
		Node node = head;
		for(int i = 0 ; i < index; i++){
			node = node.next;
		}
		return node;
	}
	
	public void add(int index, Object data){
		if(index == 0){
			addFirst(data);
		}else{
			Node beforeIndex = getNode(index-1);
			Node afterIndex = beforeIndex.next;
			Node node = new Node(data);
			beforeIndex.next = node;
			node.next = afterIndex;
			size++;
			if(node.next == null)
				tail = node;
		}
	}
	
	public String toString(){
		if(head==null) return "[]";
		
		Node node = head;
		String str = "[";
		while(node.next != null){
			str += node.data + ",";
			node = node.next;
		}
		
		str += node.data;
		return str + "]";
	}
	
	public Object removeFirst(){
		return new Object();
	}
}
