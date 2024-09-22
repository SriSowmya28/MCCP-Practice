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
	public static Node removehalf(Node root)
	{
	if(root == null) return root;
        
        Node leftNode = RemoveHalfNodes(root.left);
        Node rightNode = RemoveHalfNodes(root.right);
        
        if(leftNode == null && rightNode == null) {
            return root;
        } else if(leftNode == null) {
            root.right = rightNode;
            return rightNode;
        } else if(rightNode == null) {
            root.left = leftNode;
            return leftNode;
        } else {
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
	}
		static void traversal(Node root)
	{
		if(root!=null)
		{
			traversal(root.left);
			System.out.print(root.data+" ");
			traversal(root.right);
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
		removehalf(root);
		traversal(root);
	}
}
