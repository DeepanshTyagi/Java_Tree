// This Program Find path between two Nodes in BST 
import java.io.*;
import java.util.*;
public class BST_FindPath
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
	public void FindPath(int n1,int n2)
	{
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		hasPath(root,arr1,n1);
		hasPath(root,arr2,n2);
		int i=0,j=0,ind=-1;
	     while(i<arr1.size() || j<arr2.size())
		{
			if(i==j && (arr1.get(i)==arr2.get(j)))
			{
				i++;
				j++;
			}
			else
			{
            ind=j-1;
           break;
			}
		}
	  // System.out.println(ind);
	  // System.out.println(arr1.size()+" "+arr2.size());
	  // for(i=0;i<arr1.size();i++) System.out.print(arr1.get(i)+ " ");
	  // 	System.out.println();
   //    for( i=0;i<arr2.size();i++) System.out.print(arr2.get(i)+ " ");

		for(int x=arr1.size()-1;x>ind;x--)
		{
			System.out.print(arr1.get(x)+" --> ");
		}
		for(int x=ind;x<arr2.size()-1;x++)
		{
            System.out.print(arr2.get(x)+" --> ");
		}
		System.out.print(arr2.get(arr2.size()-1));
	}
	private boolean hasPath(Node node,ArrayList<Integer>arr,int val)
	{
		if(node==null) return false;
		arr.add(node.data);
		if(node.data==val) return true;
		if(node.data>val)
			return hasPath(node.left,arr,val);
		else if(node.data<val)
			return hasPath(node.right,arr,val);

		arr.remove(arr.size()-1);
		return false; 
	}
   
	public static void main(String[] args) throws Exception
	{
         BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
         BST_FindPath tree=new BST_FindPath();
        System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.insert(Integer.parseInt(inp.readLine()));
		}
		System.out.println("Enter Two Node ");
		String str[]=inp.readLine().trim().split(" ");
		System.out.println("The path between "+str[0]+ " and "+str[1]);
       tree.FindPath(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
	}
}