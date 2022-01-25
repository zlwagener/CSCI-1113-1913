//Zach Wagener, wagen118
import java.util.Random;


 class HBST<Key, Value> {

	 Random generator;

	 	
	 	private TreeNode root;  //head node
	 	
	 private class PairNode {
		 private Key key; 
		 private Value value;
		 private PairNode next;
		 private PairNode(Key key, Value value, PairNode next) { //pairnode represents the nodes of an assoc. list (handles collisions)
			 this.key = key;
			 this.value = value;
		 }
	 }
	 private class TreeNode {  //rep. nodes of the binary tree
		 private int hash;
		 private PairNode pairs;
		 private TreeNode left;
		 private TreeNode right;
		 
		 private TreeNode(int hash, Key key, Value value) {
			 this.hash = hash;
			 this.pairs = new PairNode(key, value, null);
			 this.left = null;
			 this.right = null;
			 
			
		 }
	 }
	 
	 public HBST() {  				
		 generator = new Random();   	 
		 root = new TreeNode(-1, null, null); 
		 
	 }
	 
	 public Value get(Key key) 
	 {
		 TreeNode subtree = root.right;
		    while (subtree != null)
		    {
		
		    	
		      if (hash(key) < subtree.hash)
		      {
		        subtree = subtree.left;
		      }
		      else if (hash(key) > subtree.hash)
		      {
		        subtree = subtree.right;
		      }
		      else //found right hash
		      { 
		         PairNode temp = subtree.pairs;
		    	  while(temp!=null) {
		    	  if(isEqual(temp.key, key)) {  //iterate over pairs
		    	  return temp.value;
		         }
		      else {
		        	 temp = temp.next;
		         }
		        }
		        break;
		      }
		    }
		    throw new IllegalArgumentException("No such key.");

	 }
	 
	 public int height() {
		 return heighting(root.right);
	 }
	 private int heighting(TreeNode root)
	  {
	    if (root==null)
	    {
	      return 0;
	    }
	    else
	    {
	      int left  = heighting(root.left);
	      int right = heighting(root.right);
	      if (left > right)
	      {
	        return left + 1;
	      }
	      else
	      {
	        return right + 1;
	      }
	    }
	  }

	 private int hash(Key key) {
		 if(key == null) {
			 return 0;
		 }
		 generator.setSeed(key.hashCode());
		 return Math.abs(generator.nextInt());
	 }
	 public boolean isEmpty() {
		 return (root.right == null);
	 }
	 
	 private boolean isEqual(Key leftKey, Key rightKey) {
		 if(leftKey != null && leftKey != null) {
				return leftKey.equals(rightKey);
			}
			else {
				return leftKey == rightKey;
			}
		 
	 }
	 
	 public void put (Key key, Value value) {
		 TreeNode below = root;

		 	int x = hash(key);
		 	
		 while(true) {
			 
			 int y = below.hash;
			 
			 if (x > y) {
				  
				 if (below.right==null) {
					 below.right = new TreeNode(x, key, value);
					 return;
				 }
				 below = below.right; //in each case, check if null first, if it is. add treenode
			 }
			 else if (x < y) {  
				 if (below.left==null) {
					 below.left = new TreeNode(x, key, value);
					 return;
				 }
				 below = below.left;
				
			 }
			 else { //hash keys equal case
				 PairNode temp = below.pairs;
		    	  while(temp!=null) {
		    	  if(isEqual(temp.key, key)) {  //iterate over pairs
		    	  temp.value = value;
		        }
		      else {
		        	 temp = temp.next;
		        }
		        }
		        
				below.pairs = new PairNode(key, value, null);  
			 }
		 }
			
	 }
	 
	 /* Output from driver class:
	  
	  8
-10 100
 -9  81
 -8  64
 -7  49
 -6  36
 -5  25
 -4  16
 -3   9
 -2   4
 -1   1
  0   0
  1   1
  2   4
  3   9
  4  16
  5  25
  6  36
  7  49
  8  64
  9  81
 10 100

11
00 abstract
01 assert
02 boolean
03 break
04 byte
05 case
06 catch
07 char
08 class
09 const
10 continue
11 default
12 do
13 double
14 else
15 extends
16 false
17 final
18 finally
19 float
20 for
21 goto
22 if
23 implements
24 import
25 instanceof
26 int
27 interface
28 long
29 native
30 new
31 null
32 package
33 private
34 protected
35 public
36 return
37 short
38 static
39 super
40 switch
41 synchronized
42 this
43 throw
44 throws
45 transient
46 true
47 try
48 var
49 void
50 volatile
51 while

	  
	  
	  */
}

 