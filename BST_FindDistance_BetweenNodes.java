import java.io.*;
import java.util.*;
public class BST_FindDistance_BetweenNodes
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
	public void Distance_Between(int n1,int n2)
	{
		int lca=LCA(root,n1,n2);
		int dist_n1=Distance(n1);
		int dist_n2=Distance(n2);
		int dist_lca=Distance(lca);

		int result=dist_n1+dist_n2-2*dist_lca;
		System.out.println("Distance between "+n1+" and "+n2+" is "+result);
	}
	private int Distance(int val)
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
        DistanceNode(root,arr,val);
        return arr.size();
	}
	private boolean DistanceNode(Node node,ArrayList<Integer>arr,int val)
	{
		if(node==null)
		{
			return false;
		}
		arr.add(node.data);
		if(node.data==val)
		{
			return true;
		}
		if(node.data>val)
			 return DistanceNode(node.left,arr,val);
		else if(node.data<val)
	         return DistanceNode(node.right,arr,val);

	     arr.remove(arr.size()-1);
	     return false;
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

	public static void main(String[] args)  throws Exception 
	{
	   	BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
	   	BST_FindDistance_BetweenNodes tree=new BST_FindDistance_BetweenNodes();
	   	System.out.println("Enter the Number of Nodes :");
	   	int n=Integer.parseInt(inp.readLine());
	   	System.out.println("Enter the Nodes data");
	   	String str[]=inp.readLine().trim().split(" ");
	   	for(int i=0;i<n;i++)
	   	{
	   		tree.insert(Integer.parseInt(str[i]));
	   	}
       System.out.println("Enter the two Node in between you want to find the distance");
       int n1=Integer.parseInt(inp.readLine());
       int n2=Integer.parseInt(inp.readLine());
       tree.Distance_Between(n1,n2);
	}
}