import java.util.*;
public class MyClass{
	public static class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	static Node root=null;
	public static Node insert(Node root,int key)
	{
		if(root==null)
		{
			Node t=new Node(key);
			return t;
		}
		else if(root.data<key)
		{
			root.right=insert(root.right,key);
		}
		else if(root.data>key)
		{
			root.left=insert(root.left,key);
		}
		return root;
	}
	public static int nodes(Node root)
	{
	    Queue<Node> q=new Queue<>();
	    q.add(root);
	    int l=1;
	    while(!q.isEmpty()){
	        int size=q.size();
	        for(int i=1;i<=size;i++){
	            root=q.poll();
	            if(root.left!=null)
	            q.add(root.left);
	            if(root.right!=null)
	            q.add(root.right);
	            if(l>=start && r<=end)
	            System.out.print(root.data);
	        }
	    }
	}
	public static void main(String[] args) {
		root=insert(root,20);
		root=insert(root,10);
		root=insert(root,40);
		root=insert(root,5);
		root=insert(root,12);
		root=insert(root,30);
		root=insert(root,60);
		nodes(root,2,3);
	}
}
