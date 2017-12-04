// INITIAL CODE
import java.util.*;
import java.lang.Integer;
import java.util.HashMap;
import java.lang.Math;
import java.io.*;

// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


class SumTree
{
    // driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
		
		for(int i=0;i<2000;i++);
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();

            Node root=null;

            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }

                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            GfG g = new GfG();
			boolean b = g.isSumTree(root);
			if(b==true)
				System.out.println(1);
			else
				System.out.println(0);
            t--;
			
        }
    }
}


class CheckSumTree
{
	boolean isSumTree(Node node)
	{
        if(node == null)
            return true;
        
        if(node.left == null && node.right == null)
            return true;
        
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        
        if(isSumTree(node.left) && isSumTree(node.right) && node.data == leftSum + rightSum)
            return true;
        
        return false;
	}
	
	public int sum(Node node){
	    
	    if(node == null)
	        return 0;
	    else 
	        return node.data + sum(node.left) + sum(node.right);
	}
	
}
