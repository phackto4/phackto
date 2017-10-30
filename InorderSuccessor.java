import java.util.HashMap;
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

public class InorderSuccessor{
	
	Node root;
	Node[] nextNode =new Node[1];

	
	public InorderSuccessor(int key){
		
		root= new Node(key);
	}
	
	public InorderSuccessor(){
		
		root= null;
	}
	
	
	static void populateNext(Node node,Node nextNode[]){
		
		if(node!=null){
			
			populateNext(node.right,nextNode);
			
			node.next=nextNode[0];
			
			if(node.next!=null)
				System.out.println(node.key+" "+node.next.key);
			else
				System.out.println(node.key+" "+"-1");
			
			nextNode[0]=node;
			
			populateNext(node.left,nextNode);
			
		}
		
	}
	
	static void inorderTraversal(Node node){
		
		if(node==null)
			return;
		
		inorderTraversal(node.left);
		System.out.print(node.key+" ");
		inorderTraversal(node.right);
		
	}
	static int treeSum(Node node){
		
		if(node==null)
			return 0;
		
		int oldSum=node.key;
		
		node.key=treeSum(node.left)+treeSum(node.right);
		
		return node.key+oldSum;
	}
	static void verticalSum(Node node){
		
		if(node==null)
			return;
		
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		verticalSumUtil(node,0,hm);
		
		if(hm!=null)
			System.out.println(hm.entrySet());
		
	}
	static void verticalSumUtil(Node node,int horiDist,HashMap<Integer,Integer> hm){
		if(node==null)
			return;
		
		verticalSumUtil(node.left,horiDist-1,hm);
		
		int prevSum= hm.get(horiDist)==null ? 0 : hm.get(horiDist);
		hm.put(horiDist,prevSum+node.key);
		
		verticalSumUtil(node.right,horiDist+1,hm);
		
	}
	public static void main(String[] args){
		
		InorderSuccessor tree= new InorderSuccessor();
		
		tree.root= new Node(26);
		
		tree.root.left= new Node(10);
		
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(8);
		
		tree.root.left.right= new Node(2);
				
		tree.root.right.right= new Node(3);
		
		populateNext(tree.root,tree.nextNode);
		
		System.out.println();
		
//		int sum=treeSum(tree.root);
		
//		inorderTraversal(tree.root);
		
		verticalSum(tree.root);
		
	}

}