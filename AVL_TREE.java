import java.io.*;
import java.util.*;
public class AVL_TREE
{
	class Node
	{
		int data;
		int height;
		Node left;
		Node right;

		Node(int n)
		{
			this.data=n;
			this.height=1;
		}
	}
	public Node root=null;
	public int Height(Node node)
	{
		if(node==null) return 0;
		return node.height;
	}
	private int balance_factor(Node node)
	{
		if(node==null) return 0;
		return (Height(node.left)-Height(node.right));
	}
	public void insert(int val)
	{
       root=insertNode(root,val);
	}
	private Node insertNode(Node node,int val)
	{
        if(node==null)
        {
        	Node newNode=new Node(val);
        	return newNode;
        }
        else if(node.data>val)
        	node.left=insertNode(node.left,val);
        else if(node.data<val)
        	node.right=insertNode(node.right,val);

        node.height=Math.max(Height(node.left),Height(node.right))+1;
        int bf=balance_factor(node);

        // case 1: When we insert node at node--> node.left --> node.left then we perform RR Rotation 
        if(bf>1 && val<node.left.data) // condition for RR rotation 
        {
           return RightRotate(node);
        }

        // case 2: When we insert node at node --> node.right--> node.right then we perform LL Rotation
        if(bf<-1 && val>node.right.data)// condition for LL rotation 
        {
        	return LeftRotate(node);
        }

        // case 3: When we insert node at node-->node.left-->node.right then we preform LR Rotation 
        if(bf>1 && val>node.left.data) // condition for LR 
        {
        	Node a=LeftRotate(node.left);
        	node.left=a;
        	return RightRotate(node);
        }

        // case 3: When we insert node at node-->node.right-->node.left then we preform RL Rotation 
        if(bf<-1 && val<node.right.data)
        {
        	node.right=RightRotate(node.right);
        	return LeftRotate(node);
        }
        return node;
	}
	private Node RightRotate(Node c)
	{
		Node b=c.left;
		Node t3=b.right;

		b.right=c;
		c.left=t3;

		c.height=Math.max(Height(c.left),Height(c.right))+1;
		b.height=Math.max(Height(b.left),Height(b.right))+1;
		return b;
	}
	private Node LeftRotate(Node c)
	{
        Node b=c.right;
        Node t2=b.left;

        b.left=c;
        c.right=t2;

        c.height=Math.max(Height(c.left),Height(c.right))+1;
		b.height=Math.max(Height(b.left),Height(b.right))+1;  

		return b;      
	}
	public void Display()
	{
		DisplayTree(root);
	}
	private void DisplayTree(Node node)
	{
       if(node==null)
       {
          return;
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
	public static void main(String[] args) throws Exception 
	{
         BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
         AVL_TREE tree=new AVL_TREE();
         System.out.println("Enter the Number of Nodes int the tree :");
         int n=Integer.parseInt(inp.readLine());
         System.out.println("Enter the Nodes data");
         String []str=inp.readLine().trim().split(" ");
         for(int i=0;i<n;i++)
         {
         	tree.insert(Integer.parseInt(str[i]));
         }
         tree.Display();
	}
}