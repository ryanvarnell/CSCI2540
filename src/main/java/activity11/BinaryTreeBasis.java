package activity11;

class TreeNode<T> {
    T item;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T newItem) {
        // Initializes tree node with item and no children.
        item = newItem;
        leftChild  = null;
        rightChild = null;
    }  // end constructor

    public TreeNode(T newItem,
                    TreeNode<T> left, TreeNode<T> right) {
        // Initializes tree node with item and
        // the left and right children references.
        item = newItem;
        leftChild  = left;
        rightChild = right;
    }  // end constructor

}  // end TreeNode

class TreeException extends RuntimeException {
    public TreeException(String s) {
        super(s);
    }  // end constructor
} // end TreeException

public abstract class BinaryTreeBasis<T> {
    protected TreeNode<T> root;

    public BinaryTreeBasis() {
        root = null;
    }  // end default constructor

    public BinaryTreeBasis(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    }  // end constructor

    public boolean isEmpty() {
        // Returns true if the tree is empty, else returns false.
        return root == null;
    }  // end isEmpty

    public void makeEmpty() {
        // Removes all nodes from the tree.
        root = null;
    }  // end makeEmpty

    public T getRootItem() throws TreeException {
        // Returns the item in the tree's root.
        if (root == null) {
            throw new TreeException("TreeException: Empty tree");
        }
        else {
            return root.item;
        }  // end if
    }  // end getRootItem

    public abstract void setRootItem(T newItem);
    // Throws UnsupportedOperationException if operation
    // is not supported.

}  // end BinaryTreeBasis

