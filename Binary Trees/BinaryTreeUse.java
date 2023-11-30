// package Trees.Binary Trees;
import java.util.*;

public class BinaryTreeUse{

     public static  void printAtDepthK(BinaryTreeNode<Integer> root , int k)
     {
        if(root == null){
            return ;
        }
        if(k==0){
            System.out.println(root.data);
            return ;
        }

        printAtDepthK(root.left, k-1);
         printAtDepthK(root.right, k-1);
     }

    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root == null)
        {
            return 0;
        }

        if(root.left == null && root.right == null)
        {
            return 1;
        }

        return numLeaves(root.left) + numLeaves(root.right);



    }
    public static BinaryTreeNode<Integer> removeleafnodes(BinaryTreeNode<Integer> root){
        if(root == null)
        {
            return null;
        }

        if(root.left == null && root.right == null)
        {
            return null;
        }

        root.left =  removeleafnodes(root.left);
        root.right = removeleafnodes(root.right);
        return root;



    }

    // public static int height(BinaryTreeNode<Integer> root) {
	// 	//Your code goes here

	// 	if(root == null)
	// 	{
	// 		return 0 ;
	// 	}

	// 	int lefth = height(root.left);
	// 	int righth = height(root.right);
	// 	return 1 + Math.max(lefth , righth);

	// }
        
    public static int numNodes(BinaryTreeNode<Integer> root)
    {
       if(root == null){
        return 0 ;
       }

       int leftNodeCount = numNodes(root.left); 
       int rightNodeCount = numNodes(root.right);
       return 1+leftNodeCount+rightNodeCount;
    }

    public static int largest(BinaryTreeNode<Integer>root)
    {
        if(root == null)
        {
            return -1;
        }

        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(root.data , Math.max(largestLeft , largestRight) );
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here

        if(root==null)
        {
            return 0;
        }

        ///////////////////case 1 --> h of L + h of R////////////\

        int option1=height(root.left)+height(root.right);


        ///////////////////case 2--> dia of left side only////////////

        int leftdiameter=diameterOfBinaryTree(root.left);



        //////////////////case 3--> dia of right side only////////////

        int rightdiameter=diameterOfBinaryTree(root.right);



        //////////return the max from all these three//////////////////


        return Math.max(option1+1,(Math.max(leftdiameter, rightdiameter)));
    }
    public static int height(BinaryTreeNode<Integer> root) {
        if(root==null)
        {
            return 0;
        }

        int leftcount=height(root.left);
        int rightcount=height(root.right);


        if(leftcount>rightcount)
        {
            return leftcount+1;

        }
        else
            return rightcount+1;

    }

        

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root)
    {

        if(root == null)
        {
            int height = 0 ;
            boolean isBal = true;
            BalancedTreeReturn  ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;

        }
        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;  //as default
        int  height = 1 + Math.max(leftOutput.height , rightOutput.height);

        if(Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        
        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height ;
        ans.isBalanced = isBal;
        return ans ; 
        
    }
        
        public static boolean isBalanced(BinaryTreeNode<Integer> root){
            if(root == null){
                return true;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if(Math.abs(leftHeight - rightHeight)>=1)
            return false;

            boolean isLeftBalanced = isBalanced(root.left);
            boolean isRightBalanced = isBalanced(root.right);

            return isLeftBalanced && isRightBalanced;

    }
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot , int parentData , boolean isLeft) {
        if(isRoot){
            System.out.println("Enter Tree's root data");
        }    
        else
        {
            if(isLeft){
            System.out.println("Enter left child of "+ parentData);
            }    
            else
            {
                 System.out.println("Enter right child of "+ parentData);
            }

        }
       
            Scanner scn = new Scanner(System.in);
            int rootData = scn.nextInt();

            if(rootData == -1){
                return null;
            }

            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
            BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false , rootData , true);
             BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false , rootData , false);
             root.left = leftChild;
             root.right = rightChild;
             return root;

        }    
    
    public static BinaryTreeNode<Integer> takeTreeInput() {
            System.out.println("Enter Tree's root data");
            Scanner scn = new Scanner(System.in);
            int rootData = scn.nextInt();

            if(rootData == -1){
                return null;
            }

            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
            BinaryTreeNode<Integer> leftChild = takeTreeInput();
             BinaryTreeNode<Integer> rightChild = takeTreeInput();
             root.left = leftChild;
             root.right = rightChild;
             return root;

        }

        public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
            if(root== null){
                return ;
            }
            System.out.print(root.data + ":");

            if(root.left != null){
                System.out.print("L"+root.left.data + ", ");
            }
           if(root.right != null){
                System.out.print("R"+root.right.data );
            }
            System.out.println();
            printTreeDetailed(root.left);
            printTreeDetailed(root.right);
        }

        public static void printTree(BinaryTreeNode<Integer> root) {
            
            
            if(root==null)
            {
                return ;
            }


            System.out.println(root.data);
            // if(root.left!= null){
                  printTree(root.left);
            // }
            

            // if(root.right!= null){
            printTree(root.right);
            // }


        }

        public static BinaryTreeNode<Integer> takeInputLevelWise(){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter root data");
            int rootData = s.nextInt();

            if(rootData == -1)
            {
                return null;
            }

            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
            Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>(); 
            pendingChildren.add(root);

            while(!pendingChildren.isEmpty()){
                BinaryTreeNode<Integer> front = pendingChildren.poll();
                System.out.println();
            }

            pendingChildren.add(root);

            while(!pendingChildren.isEmpty())
            {
                BinaryTreeNode<Integer> front = pendingChildren.poll(); 
                 System.out.println("Enter left child of " + front.data);
                 int left = s.nextInt();
                 if(left!=-1)
                 {
                     BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
                     front.left = leftChild;
                     pendingChildren.add(leftChild);
                 }

                  System.out.println("Enter right child of " + front.data);
                 int right = s.nextInt();
                 if(right!=-1)
                 {
                     BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
                     front.right = rightChild;
                     pendingChildren.add(rightChild);
                 }



            
        }
            return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();

			System.out.print(curr.data + ":");
			if (curr.left != null)
			 {
				System.out.print("L:" + curr.left.data + ",");
				q.add(curr.left);
			} 
			else 
			{
				System.out.print("L:-1,");
			}

			if (curr.right != null)
			 {
				System.out.print("R:" + curr.right.data);
				q.add(curr.right);
			} 
			else
			 {
				System.out.print("R:-1");
			}

			System.out.println();
		}
	}




        public static void main(String[] args){
            // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
    
            // BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
            // BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
            // root.left = rootLeft;
            // root.right= rootRight;

            // // printTree(root);
            
    
            // BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
            // BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
    
            // rootLeft.right= twoRight;
            // rootRight.left= threeLeft;

            // printTreeDetailed(root);
            

            // BinaryTreeNode<Integer> root =takeTreeInput();
             BinaryTreeNode<Integer> root =takeTreeInputBetter(true , 0 , true);
            printTreeDetailed(root);
    
        }
    }
    

