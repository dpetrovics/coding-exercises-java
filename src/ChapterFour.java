
//Binary Trees
public class ChapterFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChapterFour chFour = new ChapterFour();
		ChapterFour.Node myNode = chFour.new Node(5);
		System.out.println(myNode.data);
	}
	
	class Node {
		Node left;
		Node right;
		int data;
		public Node (int d) {
			data = d;
		}
	}
	
	 public void insert(Node node, int value) {
		if (value < node.data) {
			if (node.left != null) {
				  insert(node.left, value);
			} 
			else {
				System.out.println("  Inserted " + value + 
						  				" to left of node " + node.data);
				node.left = new Node(value);
			}
		}
		else if (value > node.data) {
			if (node.right != null) {
				insert(node.right, value);
			} 
			else {
				System.out.println("  Inserted " + value + 
						" to right of node " + node.data);
				node.right = new Node(value);
			}
		}
	 }
	  
	  public void printInOrder(Node node) {
		  if (node != null) {
			  printInOrder(node.left);
			  System.out.println("  Traversed " + node.data);
			  printInOrder(node.right);
		  }
	  }

}
