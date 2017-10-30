import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
class Node{
	int key;
	Node left,right;
	
	public Node(int item){
		key=item;
		left=right=null;
	}
	
}

class Height{
	int height=0;
	
}

public class BinaryTree{
	
	Node root,root1;
	
	public BinaryTree(int key){
		
		root= new Node(key);
	}
	
	public BinaryTree(){
		
		root= null;
	}
	
	void inorderTraversal(Node node){
		
		if(node==null)
			return;
		
		inorderTraversal(node.left);
		System.out.print(node.key+" ");
		inorderTraversal(node.right);
		
	}
	
	void preorderTraversal(Node node){
		
		if(node==null)
			return;
		
		System.out.print(node.key+" ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		
	}
	
	void postorderTraversal(Node node){
		
		if(node==null)
			return;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.key+" ");
		
	}
/*	void insertNodeInBT(Node node,int key){
		
		if(node==null)
			node =new Node(key);
		
		while(node.left!=null || node.right!=null){
			
			if(node.left==null)
				
			
		}
	}
	
*/

	void printLevelOrder(Node node){
		
		int h=height(node);
		
		for(int i=1;i<=h;i++){
			printGivenLevel(node,i);
			System.out.println();
		
		}
		
		
	}
	
	void printGivenLevel(Node node,int level){

		if(node==null)
			return;
		if(level==1){
			System.out.print(node.key+" ");
		}
		else if(level>1){
			printGivenLevel(node.left,level-1);
			printGivenLevel(node.right,level-1);
		}
		
	}

	int height(Node node){
		if(node==null)
			return 0;
		
		int lheight=height(node.left);
		int rheight=height(node.right);
		
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	
	void printLevelOrderIterative(Node node){
		
		Queue<Node> q= new LinkedList<Node>();
		
		Node temp=node;
		
		while(temp!=null){
			
			System.out.print(temp.key+" ");
			q.add(temp.left);
			q.add(temp.right);
			
			temp=q.remove();
			
		}
		
		
	}
	
	void printInOrderIterative(Node node){
		if(node==null)
			return;
		
		Stack<Node> st =new Stack<Node>();
		
		Node curr=node;
		
		
		while(curr!=null){
			st.push(curr);
			curr=curr.left;
			
		}
		while(!st.isEmpty()){
			
			Node popped = st.pop();
			
			System.out.print(popped.key+" ");
			curr=popped.right;
			if(curr!=null){
				
					while(curr!=null){
						st.push(curr);
						curr=curr.left;
			
					}
				
			}
			
		}
		
		
	}
	
	
	void printInOrderWithoutStack(Node node){
		
		if(node==null)
			return;
		
		Node curr=node;
		Node pre;
		
		while(curr!=null){
			
			if(curr.left==null){
				
				System.out.print(curr.key+" << ");
				curr=curr.right;
				
			}
			else{
				
				pre=curr.left;
				while(pre.right!=null && pre.right!=curr){
					pre=pre.right;
				}
				if(pre.right==null){
					pre.right=curr;
					curr=curr.left;
				}
				else{
					
					pre.right=null;
					System.out.print(curr.key+" ");
					curr=curr.right;
					
				}
				
				
				
			}
			
		}
		
	}
	
	int sizeOfTree(Node node){
		
		if(node==null)
			return 0;
		
		return sizeOfTree(node.left)+ sizeOfTree(node.right) +1;
		
	}
	
	static boolean isIdentical(Node node1,Node node2){
		
		if(node1==null && node2==null)
			return true;
		
		if(node1!=null && node2!=null){
			
			return node1.key==node2.key && isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right);
				
		}
		
		return false;
	}
	
	static boolean isIdenticalIterative(Node node1,Node node2){
			
		Queue<Node> q1=new LinkedList<Node>();
		Queue<Node> q2=new LinkedList<Node>();
		
		if(node1==null && node2==null)
			return true;
		
		if(node1==null || node2==null)
			return false;
		
		q1.add(node1);
		q2.add(node2);
		
		while(!q1.isEmpty() && !q2.isEmpty()){
			
			Node n1=q1.peek();
			Node n2=q2.peek();
			
			if(n1.key != n2.key)
				return false;
			
			q1.remove();
			q2.remove();
			
			if(n1.left!=null && n2.left!=null){
				q1.add(n1.left);
				q2.add(n2.left);
			}
			else if(n1.left!=null || n2.left!=null)
				return false;
			
			if(n1.right!=null && n2.right!=null){
				q1.add(n1.right);
				q2.add(n2.right);
			}
			else if(n1.right!=null && n2.right!=null)
				return false;
			
		}
			
		return true;
		
	}
	
	static void deleteTree(Node node){
		
		if(node == null)
			return;
		
		deleteTree(node.left);
		deleteTree(node.right);
		
		System.out.print(node.key+" ");
		node=null;
		
	}
	static Node mirror(Node node){
		if(node==null)
			return node;
		
		Node left=mirror(node.left);
		Node right=mirror(node.right);
		
		node.left=right;
		node.right=left;
		
		return node;
		
	}
	
	
	static void printPath(Node node){
		
		int path[]=new int[1000];
		printPathRec(node,path,0);
		
	}
	static void printPathRec(Node node, int path[],int pathLen){
		if(node==null)
			return;
		
		path[pathLen]=node.key;
		pathLen++;
		
		if(node.left==null && node.right==null)
			printArray(path,pathLen);
		else{
			
			printPathRec(node.left,path,pathLen);
			printPathRec(node.right,path,pathLen);
			
		}
		
		
	}
	
	static void printArray(int path[],int pathLen){
		
		int i;
		for(i=0;i<pathLen;i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
		
	}
	
	
	static Node BTToCList(Node node){
		
		if(node==null)
			return node;
		
		Node left =BTToCList(node.left);
		Node right = BTToCList(node.right);
		
		node.left=node.right=node;
		
		return concate(concate(left,node),right);
		
	}
	
	static Node concate(Node leftList,Node rightList){
		if(leftList==null)
			return rightList;
		if(rightList==null)
			return leftList;
		
		Node leftLast=leftList.left;
		Node rightLast=rightList.left;
		
		leftLast.right=rightList;
		
		rightList.left=leftLast;
		
		leftList.left=rightLast;
		
		rightLast.right=leftList;
		
		
		return leftList;
	}
	
	static void displayCLL(Node head){
			if(head==null)
				return;
			
			Node temp=head;
			
			do{
				System.out.print(temp.key+" ");
				temp=temp.right;
			}
			while(temp!=head);
			System.out.println();
		
	}
	
	static int getLeafCount(Node node){
		
		if(node==null)
			return 0;
		
		if(node.left==null && node.right==null)
			return 1;
		else
			return getLeafCount(node.left)+getLeafCount(node.right);
		
	}
	
	
	static boolean isBalanced(Node node,Height heigh){
		
			if(node==null){
				heigh.height=0;
				return true;
			}
			
			Height lheight=new Height();
			Height rheight=new Height();
			
			boolean l = isBalanced(node.left,lheight);
			boolean r = isBalanced(node.right,rheight);
			
			int lh=lheight.height;
			int rh=rheight.height;
			
			heigh.height=(lh> rh ? lh :rh)+1;
			
			if((lh-rh >=2) || (rh-lh>=2))
				return false;
			return l && r;
		
	}
	public static void main(String[] args){
		
		BinaryTree tree= new BinaryTree();
		
		tree.root= new Node(1);
		
		tree.root.left= new Node(2);
		
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(4);
		
		tree.root.left.right= new Node(5);
				
		tree.root.right.left= new Node(6);
		
		
		tree.root1= new Node(1);
		
		tree.root1.left= new Node(2);
		
		tree.root1.right= new Node(3);
		
		tree.root1.left.left= new Node(4);
		
		tree.root1.left.right= new Node(5);
				
		tree.root1.right.left= new Node(6);
		tree.root1.left.left.left= new Node(7);
		tree.root1.left.left.left.left= new Node(8);
		tree.root1.left.left.left.right= new Node(9);
		tree.inorderTraversal(tree.root);
		System.out.println();
		tree.preorderTraversal(tree.root);
		System.out.println();
		tree.postorderTraversal(tree.root);
		System.out.println();
		
		System.out.println(tree.height(tree.root));
		
		tree.printLevelOrder(tree.root);
		System.out.println();
		
		tree.printGivenLevel(tree.root,3);
		System.out.println();
		
		tree.printLevelOrderIterative(tree.root);
		
		System.out.println();
		tree.printInOrderIterative(tree.root);
		
		System.out.println();
		tree.printInOrderWithoutStack(tree.root);
		
		System.out.println();
		int size=tree.sizeOfTree(tree.root);
		System.out.println(size);
		
		System.out.println(isIdentical(tree.root,tree.root1));
		
		System.out.println(isIdenticalIterative(tree.root,tree.root1));
		
	/*	deleteTree(tree.root);
		tree.root=null;
		System.out.println("Tree Deleted");
		*/
	//	Node mirrorNode=mirror(tree.root);
	//	tree.printInOrderWithoutStack(mirrorNode);
		
		printPath(tree.root);
		
		System.out.println();
		
		Node head=BTToCList(tree.root);
		
		displayCLL(head);
		
		System.out.println(getLeafCount(tree.root1));
		
		
		Height heigh=new Height();
		
		System.out.println(isBalanced(tree.root1,heigh));
		
	}

}