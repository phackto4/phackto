import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
class Node{
	char key;
	Node left,right;
	
	public Node(char item){
		key=item;
		left=right=null;
	}
	
}



public class BuildTreeFromInOrderAndPreOrder{
	
	Node root,root1;
	static int preIndex=0;
	
	public BuildTreeFromInOrderAndPreOrder(char key){
		
		root= new Node(key);
	}
	
	public BuildTreeFromInOrderAndPreOrder(){
		
		root= null;
	}
	
	void inorderTraversal(Node node){
		
		if(node==null){
			return;
		}
		inorderTraversal(node.left);
		System.out.print(node.key+" ");
		inorderTraversal(node.right);
		
	}
	
	void preorderTraversal(Node node){
		
		if(node==null){
			return;
		}
		System.out.print(node.key+" ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		
	}
	
	void postorderTraversal(Node node){
		
		if(node==null){
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.key+" ");
		
	}

	
	Node buildTree(char in[],char pre[],int inStart,int inEnd){
		
		if(inStart>inEnd){
			return null;
		}
		Node tNode = new Node(pre[preIndex++]);
		
		if(inStart==inEnd)
			return tNode;
		
		int inIndex=search(in,inStart,inEnd,tNode.key);
		
		tNode.left=buildTree(in,pre,inStart,inIndex-1);
		tNode.right=buildTree(in,pre,inIndex+1,inEnd);
		
		return tNode;
	}
	
	int search(char arr[],int start,int end,char value){
		System.out.println(value);
		int i;
		for(i=start;i<=end;i++){
			
			if(arr[i]==value)
				return i;
			
		}
		return i;
	}

	public static void main(String[] args){
		
		BuildTreeFromInOrderAndPreOrder tree= new BuildTreeFromInOrderAndPreOrder();
	
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inorderTraversal(root);
		
	}

}
