package DataStructure;

public class LinkedList {
	private Node header;
	private int size;
	
	class Node{
		Node nextNode;
		Object data;
		
		Node(Object data, Node pointer){
			this.nextNode = pointer;
			this.data = data;
		}
	}
	
	public void addFirst(Object data){
		Node node = new Node(data, header.nextNode);
		header.nextNode = node;
		size++;
	}
	
	public Object get(int index){
		return getNode(index).data;
	}

	public Node getNode(int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : "+ size);
		
		Node node = header.nextNode;
		for(int i = 0 ; i < index; i++){
			node = node.nextNode;
		}
		return node;
	}
}
