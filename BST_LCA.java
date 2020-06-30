// This Program Find Lowest Common Ancestor between two Nodes in BST 
import java.io.*;
import java.util.*;
public class BST_LCA
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
	public void insert(int val)
	{
		root=InsertNode(root,val);
	}
	private Node InsertNode(Node node,int key)
	{
		if(node==null)
		{
			Node newNode=new Node(key);
			return newNode;
		}
		else if(node.data>key)
			node.left=InsertNode(node.left,key);
		else if(node.data<key)
			node.right=InsertNode(node.right,key);

		return node;
	}
	public void Lowest_Common_Ancestor(int n1,int n2)
	{
		int result=LCA(root,n1,n2);
		if(result>0)
		{
			System.out.println("Lowest Common ancestor of "+n1+" and "+n2+" is : "+result);
		}

	}
	private int LCA(Node node,int n1,int n2)
	{
		if(node==null)
		{
			return -1;
		}
		else if(node.data>n1 && node.data>n2) // Our Lowest commom Ancestor Present in Left-Subtree 
		{
			return LCA(node.left,n1,n2);
		}
		else if(node.data<n1 && node.data<n2) // Our Lowest Commom Ancestor Present in Right-Subtree 
		{
			return LCA(node.right,n1,n2);
		}
		return node.data; // If from the above condition no one is true means our current node is ancestor (If one present in Left Subtree and another present in right subtree)

	}
   
	public static void main(String[] args) throws Exception
	{
         BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
         BST_LCA tree=new BST_LCA();
        System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.insert(Integer.parseInt(inp.readLine()));
		}
		System.out.println("Enter Two Node ");
		String str[]=inp.readLine().trim().split(" ");
       tree.Lowest_Common_Ancestor(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
	}
}