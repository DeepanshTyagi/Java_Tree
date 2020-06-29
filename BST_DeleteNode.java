// This Program will find the Minimum and Maximum element from the BST 

import java.io.*;
import java.util.*;
public class BST_DeleteNode
{
	class Node
	{
		int data;
		Node left;
		Node right;
		Node(int n)
		{
			this.data=n;
		}
	}
	public Node root=null;
	public void Insert(int key)
	{
		root=InsertNode(root,key);
	}
	private Node InsertNode(Node node,int key)
	{
		if(node==null)
		{
			Node newNode=new Node(key);
			return newNode;
		} 
		else if(node.data>key) // If our key is less than root node data 
		{
			node.left=InsertNode(node.left,key); 
		}
		else if(node.data<key) // If our key is greater than root node data
		{
		   node.right=InsertNode(node.right,key);
	    }
	    return node;
	}
	public void Display()
	{
		DisplayTree(root);
	}

	private void DisplayTree(Node node) // for print the tree 
	{
		if(node==null)
	    {
			return;
		}
		if(node.left==null)
		{
			 System.out.print(".");
		} 
		else 
			{
				System.out.print(node.left.data);
			}
	    System.out.print(" <= "+node.data+" => ");
	    	if(node.right==null)
		{
			 System.out.print(".");
		} 
		else 
			{
				System.out.print(node.right.data);
			}
		System.out.println();
		DisplayTree(node.left);
		DisplayTree(node.right);
			
	}
	private int Mini(Node node)
	{
		if(node==null)
			return -1;
		Node curr_node=node;
		while(curr_node.left!=null)
		{
			curr_node=curr_node.left;
		}
		return curr_node.data;
	}
	public void Delete(int val)
	{
		root=DeleteNode(root,val);
	}
	private Node DeleteNode(Node node,int val)
	{
		if(node==null)
		{
			return null;
		}
		else if(node.data>val)
		{
			node.left=DeleteNode(node.left,val);
		}
		else if(node.data<val)
		{
			node.right=DeleteNode(node.right,val);
		}
		else
		{
			// Now we find the node which we want to delete lets Delete this node
			// Case 1:- If Node have only one or zero child(leaf Node)
			if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;
			// Case 1:- If node have both right and left child 
			else
			{
				node.data=Mini(node.right);
				node.right=DeleteNode(node.right,node.data);
			}
		}
		return node;
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
		BST_DeleteNode tree=new BST_DeleteNode();
		System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.Insert(Integer.parseInt(inp.readLine()));
		}
		tree.Display();
        System.out.println("Enter the node You want to Delete");
        int val=Integer.parseInt(inp.readLine());
        tree.Delete(val);
        System.out.println("After Delete "+val+" Node Tree is :");
        tree.Display();
	}
}