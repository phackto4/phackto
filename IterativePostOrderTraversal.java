import java.util.ArrayList;
import java.util.Stack;
class Node{
	int key;
	Node left,right;
	Node next;
	
	public Node(int item){
		key=item;
		left=right=next=null;
	}
	
	public Node(){
		
		left=right=next=null;
	}
	
}

public class IterativePostOrderTraversal{
	
	Node root;
	static ArrayList<Integer> list;
	
	public IterativePostOrderTraversal(int key){
		
		root= new Node(key);
	}
	
	public IterativePostOrderTraversal(){
		
		root= null;
	}
	
	static ArrayList<Integer> iterativePostOrder(Node node){
		list =new ArrayList<Integer>();
	
		if(node==null)
			return list;
		
		Stack<Node> s= new Stack<Node>();
		
		s.push(node);
		
		Node prev=null;
		
		while(!s.isEmpty()){
				
				Node current = s.peek();
				
				if(prev==null || prev.left==current || prev.right==current){
					
					if(current.left!=null)
						s.push(current.left);
					else if(current.right!=null)
						s.push(current.right);
					else{
						s.pop();
						list.add(current.key);
						
					}
					
				}
			else if(current.left==prev){
				if(current.right!=null){
					s.push(current.right);
				}
				else{
					
					s.pop();
					list.add(current.key);
				}
				
			}
			else if(current.right==prev){
				
				s.pop();
				list.add(current.key);
				
			}
				prev=current;
				
		}
		
		return list;
	}
	
	public static void main(String[] args){
		
		IterativePostOrderTraversal tree= new IterativePostOrderTraversal();
		
		tree.root= new Node(1);
		
		tree.root.left= new Node(2);
		
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(4);
		
		tree.root.left.right= new Node(5);
				
		tree.root.right.right= new Node(6);
		
		ArrayList<Integer> al = iterativePostOrder(tree.root);
		
		System.out.println(al);
		
	}

}