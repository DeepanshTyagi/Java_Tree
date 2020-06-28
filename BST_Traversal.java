import java.io.*;
import java.util.*;
public class BST_Traversal
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
		else if(node.data>key)
		{
			node.left=InsertNode(node.left,key);
		}
		else if(node.data<key)
		{
			node.right=InsertNode(node.right,key);
		}
		return node;
	}
	public void Inorder()
	{
		InorderTraversal(root);
	}
	private void InorderTraversal(Node node)
	{
		if(node==null)
		{
			return;
		}
		InorderTraversal(node.left);
		System.out.print(node.data+" ");
		InorderTraversal(node.right);
	}
	public void Preorder()
	{
		PreorderTraversal(root);
	}
	private void PreorderTraversal(Node node)
	{
		if(node==null)
		{
			return;
		}
		System.out.print(node.data+" ");
		PreorderTraversal(node.left);
		PreorderTraversal(node.right);
	}
	public void Postorder()
	{
		PostOrderTraversal(root);
	}
	private void PostOrderTraversal(Node node)
	{
		if(node==null) return;
		PostOrderTraversal(node.left);
		PostOrderTraversal(node.right);
		System.out.print(node.data+" ");
	}
    public static void main(String[] args) throws Exception
     {
		BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
		BST_Traversal tree=new BST_Traversal();
		System.out.println("Enter the Number of Nodes in the tree :");
		int n=Integer.parseInt(inp.readLine());
		System.out.println("Enter the Node data");
		for(int i=0;i<n;i++)
		{
          tree.Insert(Integer.parseInt(inp.readLine()));
		}
		System.out.println("\nInorder Traversal   :");
		tree.Inorder();
		System.out.println("\nPreorder Traversal  :");
		tree.Preorder();
		System.out.println("\nPostorder Traversal :");
		tree.Postorder();
	 }
}