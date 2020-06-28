import java.io.*;
import java.util.*;
public class BST_Insertion
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
	public static void main(String[] args) throws Exception
	{
		BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
		BST_Insertion tree=new BST_Insertion();
		System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.Insert(Integer.parseInt(inp.readLine()));
		}
		tree.Display();
	}
}