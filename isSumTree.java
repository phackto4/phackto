
class Node{
	int key;
	Node left,right;
	
	public Node(int item){
		key=item;
		left=right=null;
	}
	
}

public class isSumTree{
	
	Node root;
	
	public isSumTree(int key){
		
		root= new Node(key);
	}
	
	public isSumTree(){
		
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
	static int treeSum(Node node){
		if(node== null){
			return 0;
		}
		return treeSum(node.left)+node.key+treeSum(node.right);
		
	}
	static int isSumTree(Node node){
		
		int ls,rs;

				if(node==null || (node.left==null && node.right==null)){
					return 1;
				}
				
				ls=treeSum(node.left);
				rs=treeSum(node.right);
				
				if(node.key==ls+rs && isSumTree(node.left)!=0 && isSumTree(node.right) !=0)
					return 1;
				
		return 0;
		
	}
	
	static int isLeaf(Node node){
		if(node==null){
			return 0;
		}
		if(node.left==null && node.right==null){
			return 1;
		}
		return 0;
	}
	static int isSumTreeTricky(Node node){
		
		int ls,rs;
		
		if(node==null || isLeaf(node)!=0){
			return 1;
		}
			
		if(isSumTreeTricky(node.left)!=0 && isSumTreeTricky(node.right)!=0){
			
			if(node.left==null){
				ls=0;}
			else if(isLeaf(node.left)!=0){
				ls=node.left.key;}
			else{
				ls=2*node.left.key;
			}
			if(node.right==null){
				rs=0;}
			else if(isLeaf(node.right)!=0){
				rs=node.right.key;}
			else{
				rs=2*node.right.key;
			}
			
			if(node.key==ls+rs){
				return 1;}
			else{
				return 0;
			}
		}
		
		return 0;
		
	}
	public static void main(String[] args){
		
		isSumTree tree= new isSumTree();
		
		tree.root= new Node(26);
		
		tree.root.left= new Node(10);
		
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(8);
		
		tree.root.left.right= new Node(2);
				
		tree.root.right.right= new Node(3);
		
		
		System.out.println(isSumTreeTricky(tree.root));
		
	}

}
