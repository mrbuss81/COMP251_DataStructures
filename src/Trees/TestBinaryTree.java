import java.util.*;

class TestBinaryTree {
	
	public static void main( String [] args ) {
		
		BinaryTree tree = new BinaryTree(4);
		BinaryTree<Integer>.Node<Integer> node = tree.add(2, tree.getRoot());
		BinaryTree<Integer>.Node<Integer> n = tree.add(3, tree.getRoot());
		tree.add( 35, node );
		node = tree.add( 25, node );
		tree.add( 48, node );
		tree.add( 87, node );
		tree.add( 109, n );
		tree.add( 270, n );
		

        //Create a reusable list to store traversal results
        List<Integer> result = new ArrayList<>();

        // Preorder traversal
        result.clear();                             // clear result just to make sure its empty
        tree.getRoot().iterativePreOrder(result);   // fills the list with the correct order
        System.out.println("Preorder: " + result);  // we print the results and we do this sequence for all 4 iterative traversals

        // Inorder traversal
        result.clear();
        tree.getRoot().iterativeInOrder(result);
        System.out.println("Inorder: " + result);

        // Postorder traversal
        result.clear();
        tree.getRoot().iterativePostOrder(result);
        System.out.println("Postorder: " + result);

        // Level Order (Breadth-First) traversal
        result.clear();
        tree.getRoot().iterativeLevelOrder(result);
        System.out.println("Level Order (BFS): " + result);
	}
}