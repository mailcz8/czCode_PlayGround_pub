package basicJavaDemo;

class Node {
	int data;
	Node next;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}	
}

public class LinkListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int[] iarr = {10, 20, 30};		
		Node head = creatLinkedList(iarr);
		Node walker = head;
		while (walker != null) {
			System.out.println(walker.data);
			walker = walker.next;
		}
		
		boolean isLoop = traverseLinkList(head);
		
	}
	
	public static Node creatLinkedList(int[] iarr) {		
		Node head = null;
		Node tail = null;		
		if (iarr.length >= 1) {
			head = new Node(iarr[0], null);
			tail = head;	
		}					
		for (int i = 1; i < iarr.length; i++) {
			Node temp = new Node(iarr[i], null);		
			tail.next = temp;
			tail = temp;
		}	
		return head;
	}

	public static boolean traverseLinkList(Node head) {		
		Node pointerOne = head;
		Node pointerTwo = head.next.next;
			
		while (pointerOne != null) {
			if (pointerOne == pointerTwo) {
				return true;
			}
			pointerOne = pointerOne.next;
			
			if (pointerTwo != null && pointerTwo.next != null) {
				pointerTwo = pointerTwo.next.next;
			}
		}
		
		return false;
	}
}

