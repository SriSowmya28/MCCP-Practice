import java.util.*;

public class MyClass {
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
	static int width(Node root)
	{
		int res=0;
		if(root==null)
		{
			return 0;
		}
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int l=1;
		while(!q.isEmpty())
		{
			int c=q.size();
			if(res<c){
			    res=c;
			    int k=l;
			}
			while(c!=0)
			{
				Node t=q.poll();
				if(t.left!=null)
				{
					q.add(t.left);
				}
				if(t.right!=null)
				{
					q.add(t.right);
				}
				c--;
			}
			l++;
		}
		return res;
	}
	public static void main(String[] args) {
		root=insert(root,20);
		root=insert(root,10);
		root=insert(root,40);
		root=insert(root,5);
		root=insert(root,12);
		root=insert(root,30);
		root=insert(root,60);
		System.out.print(width(root));
		
	}
}
