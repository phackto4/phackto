
class Node{
	int key;
	Node left,right;
	Node nextRight;
	
	public Node(int item){
		key=item;
		left=right=nextRight=null;
	}
	
}

public class ConnectNodes{
	
	Node root;
	
	public ConnectNodes(int key){
		
		root= new Node(key);
	}
	
	public ConnectNodes(){
		
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
	static Node getNextRight(Node node){
		
		Node temp=node.nextRight;
		
		while(temp!=null){
			
			if(temp.left!=null)
				return temp.left;
			if(temp.right!=null)
				return temp.right;
			
			temp=temp.nextRight;
			
		}
		return null;
	}
	static void connectNodes(Node node){
		if(node==null)
			return;
		
		node.nextRight=null;
		
		while(node!=null){
			Node inode = node;
			
			while(inode!=null){
				
				if(inode.left!=null){
					
					if(inode.right!=null){
						inode.left.nextRight=inode.right;
					}
					else 
						inode.left.nextRight=getNextRight(inode);
					
				}
				if(inode.right!=null){
					
					inode.right.nextRight=getNextRight(inode);
					
				}
				
				inode=inode.nextRight;
			}
			
			if(node.left!=null){
				node=node.left;}
			else if(node.right!=null){
				node=node.right;}
			else{
				node=getNextRight(node);
			}
		}
		
	}
	
	
	public static void main(String[] args){
		
		isSumTree tree= new isSumTree();
		
		tree.root= new Node(26);
		
		tree.root.left= new Node(10);
		
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(8);
		
		tree.root.left.right= new Node(2);
				
		tree.root.right.right= new Node(3);
		
		connectNodes(tree.root);
		System.out.println();
		
	}

}
