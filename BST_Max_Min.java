// This Program will find the Minimum and Maximum element from the BST 

import java.io.*;
import java.util.*;
public class BST_Max_Min
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
	private void Display()
	{
		DisplayTree(root);
	}

	public void DisplayTree(Node node) // for print the tree 
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

	public void Min_Element()
	{
		int result=Mini(root);
		if(result<0)
		{
			System.out.println("Tree is Empty");
			return;
		}
		else
		{
			System.out.println("The Minimum Element in the Given BST is :"+result);
		}
	}
	private int Mini(Node node)
	{
		if(node==null)
			return -1;
		Node curr_node=node.left;
		while(curr_node.left!=null)
		{
			curr_node=curr_node.left;
		}
		return curr_node.data;
	}
    public void Max_Element()
    {
    	int result=Maxi(root);
    	if(result<0)
		{
			System.out.println("Tree is Empty");
			return;
		}
		else
		{
			System.out.println("The Maximum Element in the Given BST is :"+result);
		}
    }
    private int Maxi(Node node)
    {
    	if(node==null)
    	{
    		return -1;
    	}
    	Node curr_node=node.right;
    	while(curr_node.right!=null)
    	{
          curr_node=curr_node.right;
    	}
    	return curr_node.data;
    }
	public static void main(String[] args) throws Exception
	{
		BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
		BST_Max_Min tree=new BST_Max_Min();
		System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.Insert(Integer.parseInt(inp.readLine()));
		}
		tree.Display();
        tree.Min_Element();
        tree.Max_Element();
	}
}