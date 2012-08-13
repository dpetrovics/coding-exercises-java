/**
 * @author David Petrovics
 * Coding exercises from Chapter 2 of "Cracking the Coding Interview"
 */
import java.util.Hashtable;

public class ChapterTwo {
	public static void main(String[] args) {
		ChapterTwo chTwo = new ChapterTwo();
		ChapterTwo.Node aNode = chTwo.new Node(23);
//		aNode.appendToTail(23);
//		aNode.appendToTail(34);
//		aNode.appendToTail(19);
//		aNode.printAllData(aNode);
//		
//		System.out.println("Deleting 34: ");
//		aNode = aNode.delete(aNode, 34);
//		aNode.printAllData(aNode);
		
//		System.out.println("Adding 23, 14, 23, 11, 19, 32, 32");
		aNode.appendToTail(23);
		aNode.appendToTail(14);
		aNode.appendToTail(23);
		aNode.appendToTail(11);
		aNode.appendToTail(19);
		aNode.appendToTail(32);
		aNode.appendToTail(32);
		aNode.printAllData(aNode);
		
		ChapterTwo.Node insert = chTwo.new Node(54);
		ChapterTwo.Node head = aNode.insertNode(aNode, insert, 6);
		head.printAllData(head);
		
		
//		System.out.println("Deleting Duplicates");
//		aNode.deleteDuplicatesBuffer(aNode);
//		aNode.printAllData(aNode);
		
//		aNode.findNthToLastRecursive(aNode, 5);
	}
	
   class Node {
	   Node next = null;
	   int data;
	   public Node (int d) {
		   data = d;
	   }
	   //remember parameters in Java are pass-by-value
	   //the method gets its own copy of the parameters
	   //you cant change what they refer to (local copy gets discarded after the method call), 
	   //but for an object, you could change its contents by calling head.dosomething();
	   //cant change strings, since they are immutable (no method provided like s.change() );
	   public void printAllData(Node head) {
		   while (head!=null) {
			   System.out.println(head.data);
			   head = head.next; 
		   }
	   }
	   //wouldn't use appendToTail if you use a linked list class
	   public void appendToTail(int d) {
		   Node appended = new Node(d);
		   Node a = this;
		   while (a.next!=null) {
			   a = a.next;
		   }
		   a.next = appended;
	   }
	   //returns the new head
	   public Node delete(Node head, int d) {
		   //find Node with data == d and delete it
		   if (head.data == d) {
			    return head.next; //moved head
		   }
		   Node n = head;
		   while (n.next!=null) {
			   if (n.next.data == d) {     //found the node, now delete it;
				   n.next=n.next.next;
				   return head; //head is the same, but deleted a node in the list
			   }
			   n = n.next;
		   }
		   return head; //nothing changed
	   }
	   
	   public void deleteDuplicatesBuffer (Node n) {
		   Hashtable table = new Hashtable();
		   Node prev = null;
		   while (n != null) {
			   if (table.containsKey(n.data)) {
				   prev.next = n.next;
			   }
			   else {
			      table.put(n.data, true);
			      prev = n;
			   }
			   n=n.next;
		   }
	   }
	   //O(n^2) - no temp buffer.
	   //use hash map or some other buffer (int?) if a temp buffer is allowed
	   public Node deleteDuplicates(Node head) {
		   Node a = head; 
           Node b;        
           
		   while (a.next != null) {
			   b = a.next;
			   if (a.data==b.data) {
				   a.next=b.next;
				   if (a.next==null)
					   break;
			   }
			   else {
				   while (b.next != null) {
					   if (a.data == b.next.data) {
						   b.next = b.next.next; //remove duplicate
					   }
					   b=b.next;
				   }
			   }
			   a = a.next;
		   }
		   return head;
	   }
	
	   //Implement an algorithm to find the nth to last element of a singly linked list
	   //can also try doing this with two nodes p1 and p2 spaced n apart
	   //recursive solution?
	   public Node findNthToLast (Node head, int n) {
		   Node a=head;
		   int numNodes=0;

		   while (a!=null) {
			   numNodes++;
			   a = a.next;
		   }
		   
		   if (n>numNodes || n<1) {
			   return null;
		   }
		   
		   for (int i=0; i<(numNodes-n); i++) {
			   head = head.next;
		   }
		   System.out.println("Nth node data: " + head.data);
		   return head;
	   }
	   
	   //this does not work because the incremented count (local var) is discarded after 
	   //the call is popped off the stack
	   public Node findNthToLastRecursive (Node a, int n) {
		   int count = 1;
		   if (a.next == null) {
			   return a;
		   }
		   findNthToLastRecursive(a.next, n);
		   System.out.println("count: " + count);
		   if (count == n) {
			   count++;
			   return a;
		   }
		   return null;
	   }
	   
	   //insert a node at the nth spot, returns head
	   public Node insertNode(Node head, Node insert, int n) {
		System.out.println("Inserting: " + insert.data + " at n = " + n);

		   if (n==1) {
			   insert.next = head;
			   return insert;
		   }
		   //iterate so that prev is the node before insert location.
		   Node prev=head;
		   for (int i=1; i<n-1; i++) {
			   if (prev.next!=null) {
				   prev = prev.next;
			   }
			   else {
				   System.out.println("n is bigger than the length of the linked list");
				   return null;
			   }
		   }
		   //now insert node
		   insert.next = prev.next;
		   prev.next = insert;
		   return head;
	   }
	   
	   //reverse a linked list. And a doubly linked list.
	   
	   //Implement an algorithm to delete a node in the middle of a single linked list, 
	   //given only access to that node
	   
   }
   
}
