/*Complete the function below */

class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}

class PrintRootToLeaf
{
	public void printPaths(Node root)
       {
           int index = 0;
         ArrayList<Integer> pathArr = new ArrayList<Integer>();
         printTreeUtil(root,pathArr,index);
       }
       
    public static void printTreeUtil(Node root,ArrayList<Integer> pathArr, int index){
        
        if(root.left == null && root.right == null){
            pathArr.add(index,root.data);
            printList(pathArr,index);
        } else {
            pathArr.add(index++,root.data);
            printTreeUtil(root.left,pathArr,index);
            printTreeUtil(root.right,pathArr,index);
        }
    }
    
    public static void printList(ArrayList<Integer> list, int index){
        
        for(int i=0;i<=index;i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print("#");
    }
}
