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
	public static int diameter(Node root)
	{
	    if(root==null)
	    return 0;
	    int lheight=height(root.left);
	    int rheight=height(root.right);
	    int ldia=diameter(root.left);
	    int rdia=diameter(root.right);
	    return Math.max(lheight+rheight+1,Math.max(ldia,rdia));

	}
    static int height(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		return 1+Math.max(height(root.left),height(root.right));
	}
	public static void main(String[] args) {
		root=insert(root,20);
		root=insert(root,10);
		root=insert(root,40);
		root=insert(root,5);
		root=insert(root,12);
		root=insert(root,30);
		root=insert(root,60);
		System.out.print(diameter(root));
	}
}
