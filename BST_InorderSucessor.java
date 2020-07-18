import java.io.*;
import java.util.*;
public class BST_InorderSucessor
{
    	class BST_Node
	{
		int data;
		BST_Node left;
		BST_Node right;
		BST_Node(int data)
		{
			this.data=data;
		}
	}
	public BST_Node root=null;
	public void Insert(int n)
	{
		root=insert_node(root,n);
	}
	private BST_Node insert_node(BST_Node node,int n)
	{
           if(node==null)
           {
           	BST_Node newNode=new BST_Node(n);
           	return newNode;
           }
           else if(node.data>n)
           {
           	node.left=insert_node(node.left,n);
           }
           else if(node.data<n)
           {
           	node.right=insert_node(node.right,n);
           }
           return node;
	}
	public void Display()
	{
		Display_Tree(root);
	}
	private void Display_Tree(BST_Node node)
	{
            if(node==null)
            	return ;

            if(node.left==null)
            	System.out.print(".");
            else 
            	System.out.print(node.left.data);

            System.out.print(" <= "+node.data+" => ");

            if(node.right==null)
            	System.out.print(".");
            else 
            	System.out.print(node.right.data);

            System.out.println();
            Display_Tree(node.left);
            Display_Tree(node.right);
	}
	public void Inorder_Sucessor(int n)
	{
		  int ans=findInorderSucessor(root,n);
		  System.out.println("\nInorder Sucessor of "+n+" is :"+ans);
	}
	private int findInorderSucessor(BST_Node node,int n)  // O(h)
	{
		  BST_Node current=FindNode(node,n);
		  if(current==null)
		  {
		  	System.out.println("Tree Does Not contain "+n+" node");
		  	return -1;
		  }
          
          // Case 1: when node have right Subtree
		  if(current.right!=null)
		  {
		  	  return FindMin(current.right);
		  }

		  // Case 2: when node does not have right Subtree
		  else 
		{
		  	 BST_Node sucessor=null;
		  	 BST_Node ancestor=node;
		  	 while(ancestor!=current)
		  	 {
		  	 	if(current.data<ancestor.data)
		  	 	{
		  	 		sucessor=ancestor;
		  	 		ancestor=ancestor.left;
		  	 	}
		  	 	else
		  	 	{
		  	 		ancestor=ancestor.right;
		  	 	}
		  	 }
		  	 return sucessor.data;
		  } 
	}
	private BST_Node FindNode(BST_Node node,int data) // O(h)
	{
		if(node==null)
			return null;

		if(node.data==data)
			return node;

		else if(node.data>data)
			return FindNode(node.left,data);

		else
			return FindNode(node.right,data);
	}
	private int FindMin(BST_Node node) // O(h)
	{
		if(node==null)
			 return -1;

		if(node.left==null)
			return node.data;

		return FindMin(node.left);
	}
	public static void main(String[] args) throws Exception
	{
		BST_InorderSucessor tree=new BST_InorderSucessor();
		BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Number of Nodes the Binary Search Tree");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node Data");
		String str[]=inp.readLine().trim().split(" ");
		System.out.println("Enter the Node you want to find Inorder Sucessor");
		int val=Integer.parseInt(inp.readLine());
		for(int i=0;i<n;i++)
		{
			tree.Insert(Integer.parseInt(str[i]));
		}
		System.out.println("\nTree :");
		tree.Display();
        tree.Inorder_Sucessor(val);
	}
}