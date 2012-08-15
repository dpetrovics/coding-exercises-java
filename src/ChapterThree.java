
//Stacks and Queues
public class ChapterThree {
	public static void main(String[] args) {
		ChapterThree chThree = new ChapterThree();
		ChapterThree.Stack myStack = chThree.new Stack();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		myStack.push("four");
		System.out.println(myStack.toString());
		System.out.println("Popped: " + (String)myStack.pop());
		System.out.println(myStack.toString());
	}
	
	class Node {
		Object data;
		Node next;
		public Node (Object n) {
			data = n;
		}
		public String toString () {
			return (String)(data);
		}
	}
	class Stack {
		Node top;
		public Object pop() {
			if (top==null)
				return null;
			else {
				Object topData = top.data;
				top = top.next;
				return topData;
			}
		}
		public void push(Object b) {
			Node aNode = new Node(b);
			aNode.next = top;
			top = aNode;
		}
		public String toString() {
			//start from top and go until next == null
			Node a = top;
			String ret = a.toString();
			while (a.next != null) {
				ret = ret + " " + a.next.toString();
				a = a.next;
			}
			return ret;
		}
	}
	
	class Queue {
		
	}
}
