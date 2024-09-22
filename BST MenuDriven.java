import java.util.*;
public class HelloWorld {
	public static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	public static Node root=null;
	private static Node insert(Node root,int key)
	{
		Node curr=root;
		Node parent=null;
		Node t=new Node(key);
		if(root==null)
		{
			return t;
		}
		else
		{
			while(curr!=null)
			{
				parent=curr;
				if(key<curr.data)
				{
					curr=curr.left;
				}
				else
				{
					curr=curr.right;
				}
			}
		}
		if(parent.data>key)
		{
			parent.left=t;
		}
		else
		{
			parent.right=t;
		}
		return root;
	}
	private static Node minNode(Node temp)
	{
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
	}
	private static Node delete(Node root,int key)
	{
        if(root == null){
            return null;
        }
        
        if(root.data < key){
            root.right = delete(root.right,key);
        }
        else if(root.data > key){
            root.left = delete(root.left,key);
        }
        else{
            Node curr = root;
            
            if(curr.left == null && curr.right == null){ 
                return null;
            }
            else if(curr.left == null){
                Node newNode = curr.right; 
                return newNode;
            }
            else if(curr.right == null){
                Node newNode = curr.left; 
                return newNode;
            }
            else{
                Node temp = minNode(root.right);
                root.data = temp.data; 
                root.right = delete(root.right,temp.data); 
            }
        }
        
        return root;
	}
	public static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		
	}
	public static void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void postorder(Node root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch;
		do
		{
			System.out.println("1.insert\n2.delete\n3.traverse\n4.exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("Enter element to insert");
				   int ele=sc.nextInt();
				   root=insert(root,ele);
				   break;
			case 2:System.out.print("Enter element to delete");
				   int x=sc.nextInt();
				   root=delete(root,x);
				   break;
			case 3:System.out.println("choose traversal\n1.inorder\n2.preorder\n3.postorder");
				   int c=sc.nextInt();
				   switch(c)
				   {
				   case 1: inorder(root);
				   System.out.println();
				   		   break;
				   case 2: preorder(root);
				   System.out.println();
				   		   break;
				   case 3: postorder(root);
				   System.out.println();
				   		   break;
				   }
				   break;
			case 4: break;
			}
			
		}while(ch!=4);
		System.out.print("Thank You");
	}

}
