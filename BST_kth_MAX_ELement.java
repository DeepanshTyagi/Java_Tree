import java.io.*;
import java.util.*;
public class BST_kth_MAX_ELement
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
	public void Insert(int n)
	{
		root=InsertNode(root,n);

	}
	private Node InsertNode(Node node,int n)
	{
       if(node==null)
       {
       	Node newNode=new Node(n);
       	return newNode;
       }
       else if(node.data>n)
       	   {
       	   	node.left=InsertNode(node.left,n);
       	   }
       else 
       {
       	node.right=InsertNode(node.right,n);
       }
       return node;
	}
	public void Display()
	{
		DisplayTree(root);
	}
	private void DisplayTree(Node node)
	{
         if(node==null)
         {
         	return ;
         }
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
         DisplayTree(node.left);
         DisplayTree(node.right);
	}
	public class Count
	{
		int c=0;
	}
	public void kth_MAX(int pos)
	{
		Count c=new Count();
		FindKthMAX(root,pos,c);
	}
	private void FindKthMAX(Node node,int pos,Count C)
	{
		if(node==null || C.c>=pos)
		{
			return ;
		} 
		FindKthMAX(node.right,pos,C);
		C.c++;
		if(C.c==pos)
		{
			System.out.println(pos+"th Max Element is "+node.data);
			return ;
		}
		FindKthMAX(node.left,pos,C);
	}
	public static void main(String[] args) throws Exception 
	{
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        BST_kth_MAX_ELement tree=new BST_kth_MAX_ELement();
        System.out.println("Enter the Number of Nodes in the BST :");
        int n=Integer.parseInt(inp.readLine());
        System.out.println("Enter the Node Data");
        String []str=inp.readLine().trim().split(" ");
        for(int i=0;i<n;i++)
        {
        	tree.Insert(Integer.parseInt(str[i]));
        }
        System.out.println("Enter the kth Element");
        int pos=Integer.parseInt(inp.readLine());
        tree.Display();
        tree.kth_MAX(pos);
	}
}