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
	public static void zigzag(Node root)
	{
	    if(root==null)
	    return;
	    Stack<Node> current=new Stack<>();
	    Stack<Node> next=new Stack<>();
	    current.push(root);
	    boolean flag=true;
	    while(!current.isEmpty()){
	        Node temp=current.pop();
	        if(temp!=null){
	            System.out.print(temp.data+" ");
	            if(flag){
	                if(temp.left!=null)
	                next.push(temp.left);
	                if(temp.right!=null)
	                next.push(temp.right);
	            }else{
	                if(temp.right!=null)
	                next.push(temp.right);
	                if(temp.left!=null)
	                next.push(temp.left);
	            }
	        }
	        if(current.isEmpty()){
	            flag=!flag;
	            Stack<Node> t=current;
	            current=next;
	            next=t;
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
		zigzag(root);
	}
}
