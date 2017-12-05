//--------------------Driver Program-----------------------//

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}

class Height_Balanced_Tree
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();

            Node root = null;

            while (n > 0)
            {	
			
		int n1 = sc.nextInt();
                int n2 = sc.nextInt();
		char lr= sc.next().charAt(0);
				
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
			
            CheckBalanced g = new CheckBalanced();
			
			//boolean res = g.isHeap(root);
			if(g.isBalanced(root) == true)
			System.out.println(1);
			else 
			System.out.println(0);
			//CLN.inorder(root);
			 t--;
			// System.out.println();
        }
    }
}
//--------------------Driver Program-----------------------//

class CheckBalanced
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false.  Time complexity should
     be O(n) where n is number of nodes in tree */
    boolean isBalanced(Node root)
    {
	    if(root == null || (root.left == null && root.right == null))
	        return true;
	    
	    return (isBalanced(root.left) && isBalanced(root.right) && 
	            Math.abs(height(root.left) - height(root.right)) <= 1);
    }
    
    int height(Node root){
        if(root == null)
            return 0;
        
        return Math.max(height(root.left),height(root.right)) + 1;
    }
}
