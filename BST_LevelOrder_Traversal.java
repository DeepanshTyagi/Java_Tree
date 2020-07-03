import java.io.*;
import java.util.*;
public class BST_LevelOrder_Traversal
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
	public void LevelOrder()
	{
		 LevelOrder_Traversal(root);
	}
    private void LevelOrder_Traversal(Node node)
    {
    	if(node==null)
        {
        	System.out.println("Tree is Empty :");
        	return;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty())
        {
           Node current=queue.poll();
           System.out.print(current.data+" ");
           if(current.left!=null) queue.add(current.left);
           if(current.right!=null) queue.add(current.right);
        }

      }
	public static void main(String[] args) throws Exception
	{
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        BST_LevelOrder_Traversal tree=new BST_LevelOrder_Traversal();
        System.out.println("Enter the Number of Nodes in the BST :");
        int n=Integer.parseInt(inp.readLine());
        System.out.println("Enter the Node Data");
        String []str=inp.readLine().trim().split(" ");
        for(int i=0;i<n;i++)
        {
        	tree.Insert(Integer.parseInt(str[i]));
        }
        tree.Display();
        System.out.println("Level Order Traversal Of BST is :");
        tree.LevelOrder();
	}
}