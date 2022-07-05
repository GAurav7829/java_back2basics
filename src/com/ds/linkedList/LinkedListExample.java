package com.ds.linkedList;

public class LinkedListExample {
	Node head = null;
	public static void main(String[] args) {
		LinkedListExample example = new LinkedListExample();
		example.insertNode(new Node(10));
		example.insertNode(new Node(20));
		example.insertNode(new Node(30));
		example.insertNode(new Node(40));
		
		System.out.println("Print All nodes: ");
		example.printNodes();
		System.out.println("\nDelete a node: ");
		example.deleteNode(20);
		example.printNodes();
		System.out.println("\nInsert node Before: ");
		example.insertNodeBefore(30, 5);
		example.printNodes();
		System.out.println("\nInsert node After: ");
		example.insertNodeAfter(30, 45);
		example.printNodes();
		System.out.println("\nData to Update: ");
		example.updateNode(30, 41);
		example.printNodes();
		
	}
	
	public void insertNode(Node node) {
		if(head==null) {
			head = node;
			return;
		}
		Node tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		tmp.next = node;
	}
	
	public void insertNodeBefore(int currentData, int data) {
		if(head==null) {
			head = new Node(data);
			return;
		}
		if(head.data==currentData) {
			Node tmp = new Node(data);
			tmp.next = head;
			head = tmp;
			return;
		}
		for(Node n=head; n.next!=null; n=n.next) {
			if(n.next.data==currentData) {
				Node tmp = n.next;
				n.next = new Node(data);
				n.next.next = tmp;
				break;
			}
		}
	}
	
	public void insertNodeAfter(int currentData, int data) {
		if(head==null) {
			head = new Node(data);
			return;
		}
		if(head.data==currentData) {
			Node tmp = head.next;
			head.next = new Node(data);
			head.next.next = tmp;	
			return;
		}
		for(Node n=head; n.next!=null; n=n.next) {
			if(n.next.data==currentData) {
				Node tmp = n.next.next;
				n.next.next = new Node(data);
				n.next.next.next = tmp;
				break;
			}
		}
	}
	
	public void printNodes() {
		checkHeadNull();
		for(Node n=head; n!=null; n=n.next) {
			System.out.print(n.data + ", ");
		}
	}
	
	public void deleteNode(int data) {
		checkHeadNull();
		
		if(head.data==data) {
			head = head.next;
			return;
		}
				
		for(Node n=head; n.next!=null; n=n.next) {
			if(n.next.data==data) {
				n.next = n.next.next;
				break;
			}
		}
	}
	
	public void updateNode(int currentData, int dataToUpdate) {
		checkHeadNull();
		if(head.data==currentData) {
			head.data = dataToUpdate;
		}
		for(Node n=head; n!=null; n=n.next) {
			if(n.next.data==currentData) {
				n.next.data = dataToUpdate;
				break;
			}
		}
	}

	private void checkHeadNull() {
		if(head==null) {
			System.out.println("No Data Available");
			return;
		}
	}
}

class Node{
	public Node next;
	public int data;
	
	public Node() {}
	public Node(int data) {
		this.data = data;
	}
}
