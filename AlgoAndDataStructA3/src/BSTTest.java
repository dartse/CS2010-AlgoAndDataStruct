import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree", "-null", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(1, 1);
         bst.delete(1);
         System.out.println(bst.printKeysInOrder());
         assertEquals("Deleting from a tree with 1 node.", "()", bst.printKeysInOrder());
         
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5

		assertEquals("Checking order of constructed tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",
				bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child", "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children", "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
		
		bst.delete(1);
		assertEquals("Deleting node with single child", "((()2(()4(()5())))7())", bst.printKeysInOrder());
		
		bst.delete(2);
		assertEquals("Deleting node with single child", "((()4(()5()))7())", bst.printKeysInOrder());
		
		bst.put(6, 6);
		bst.put(8, 8);
		bst.delete(7);
		assertEquals("Deleting root with two children", "((()4(()5()))6(()8()))", bst.printKeysInOrder());
	 }
     
     
     @Test
     public void testMedian() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("Testing getting median with empty bst", null,bst.median());
    	 
    	 bst.put(10, 10);
    	 bst.put(5, 5);
    	 bst.put(15,15);
    	 assertEquals("Testing getting median on root","10",Integer.toString(bst.median()));
    	 
    	 bst.put(9, 9);
    	 assertEquals("Testing getting median on odd number N", "9", Integer.toString(bst.median()));
    	 
    	 bst.put(4, 4);
    	 assertEquals("Testing getting median on odd number N", "9", Integer.toString(bst.median()));
     
    	 bst.put(8, 8);
    	 bst.put(6, 6);
    	 bst.put(7, 7);
    	 assertEquals("Testing getting median on odd number N", "7", Integer.toString(bst.median()));
     }
     
     @Test 
     public void testHeight() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("Testing height with empty bst.", -1, bst.height());
    	 
    	 bst.put(10, 10);
    	 assertEquals("Testing height with one item.", 0, bst.height());
    	 
    	 bst.put(5, 5);
    	 assertEquals("Testing height with left subtree being tallest.", 1, bst.height());
    	 
    	 bst.put(12, 12);
    	 bst.put(15, 15);
    	 assertEquals("Testing height with right subtree being tallest.", 2, bst.height());
     }
     
     @Test
     public void testGet() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("Testing get null with empty bst", null, bst.get(null));
    	 assertEquals("Testing get with empty bst", null, bst.get(10));
    	
    	 bst.put(10, 10);
    	 assertEquals("Testing get with one node", "10", Integer.toString(bst.get(10)));
    	 
    	 bst.put(10, null);
    	 bst.put(10,10);
    	 bst.put(15, 15);
    	 assertEquals("Testing get with multiple nodes.", "15", Integer.toString(bst.get(15)));
    	 
    	 bst.put(5,5);
    	 assertEquals("Testing get with multiple nodes.", "5", Integer.toString(bst.get(5)));
    	 
    	 bst.put(5, 6);
    	 assertEquals("Testing get with multiple nodes.", "6", Integer.toString(bst.get(5)));
     }
     
     @Test
     public void testContains() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("Testing contains null with empty bst", false, bst.contains(null));
    	 assertEquals("Testing contains with empty bst", false, bst.contains(10));
    	 
    	 bst.put(10, 10);
    	 assertEquals("Testing contains with valid search.", true, bst.contains(10));
     }
}

