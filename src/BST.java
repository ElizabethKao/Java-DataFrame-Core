public class BST<I extends Comparable<I>, T>{

    class BSTNode {
        private I index;
        private T data;
        private BSTNode left;
        private BSTNode right;

        /**
         * Default constructor. Sets all instance variables to be null.
         */
        public BSTNode() {
            // TODO
            index = null;
            data = null;
            left = null;
            right = null;
        }

        /**
         * Constructor. Sets data and index to be _data and _index respectively.
         */
        public BSTNode(I _index, T _data) {
            // TODO
            index = _index;
            data = _data;
        }

        /**
         * Returns the index stored in this node.
         */
        public I getIndex() {
            // TODO
            return index;
        }

        /**
         * Returns the data stored in this node.
         */
        public T getData() {
            // TODO
            return data;
        }

        /**
         * Updates the data in this node to the specified value.
         */
        public void setData(T d) {
            // TODO
            data = d;
        }

        /**
         * Returns a string representation of the node, indicating its index and data.
         */
        public String toString() {
            // TODO
            return "index:\t" + index + ",\tdata:\t" + data + "\n";
        }
    }


    private BSTNode root;
    private int size;

    /**
     * Constructor. Initializes an empty BST with root set to null and size set to 0.
     */
    public BST() {
        // TODO
        root = null;
        size = 0;
    }


    /**
     * Performs an in-order traversal of the BST and records indices and data values.
     */
    private String inOrderTraversal(BSTNode node) {
        // TODO
        if (node == null) {
            return "";
        }

        String leftChild = inOrderTraversal(node.left);
        String currentNode = node.toString();
        String rightChild = inOrderTraversal(node.right);

        return leftChild + currentNode + rightChild;
    }

    /**
     * Returns a string representation of the entire BST using in-order traversal.
     */
    public String toString() {
        // TODO
        StringBuilder sb = new StringBuilder();

        sb.append("In-order Traversal of the BST ...\n");
        sb.append("==================\n");

        sb.append(inOrderTraversal(root));

        return sb.toString();
    }

    /**
     * Returns the size of the BST, i.e., the number of valid nodes.
     */
    public int getSize() {
        // TODO
        return size;
    }

    /**
     * Adds a new node with the specified index and data to the BST.
     */

    private void addNodeHelper(BSTNode current, I _index, T _data) {
        int compare = _index.compareTo(current.getIndex());

        if (compare < 0) {
            if (current.left == null) {
                current.left = new BSTNode(_index, _data);
                size++;
            }
            else {
                addNodeHelper(current.left, _index, _data);
            }
        }

        else if (compare > 0) {
            if (current.right == null) {
                current.right = new BSTNode(_index, _data);
                size++;
            }
            else {
                addNodeHelper(current.right, _index, _data);
            }
        }
    }

    public void addNode(I _index, T _data) {
        // TODO
        if (root == null) {
            root = new BSTNode(_index, _data);
            size++;
        }

        else {
            addNodeHelper(root, _index, _data);
        }
    }

    /**
     * Searches for a node with the specified index in the BST.
     */
    public BSTNode searchNode(I _index) {
        // TODO
        BSTNode current = root;

        while (current != null) {
            int compare = _index.compareTo(current.getIndex());

            if (compare == 0) {
                return current;
            }

            else if (compare > 0) {
                current = current.right;
            }

            else {
                current = current.left;
            }
        }

        return null;
    }

    /**
     * Removes a node with the specified index from the BST.
     */
    public void removeNode(I _index) {
        // TODO

        if (searchNode(_index) == null) {
            throw new IllegalArgumentException("removeNode(I _index): No node with an index " + _index + " in the BST");

        }

        root = removeNodeHelper(root, _index);
        size--;
    }

    private BSTNode removeNodeHelper(BSTNode current, I _index) {
        if (current == null) {
            return null;
        }

        int compare = _index.compareTo(current.getIndex());

        if (compare < 0) {
            current.left = removeNodeHelper(current.left, _index);
        }
        else if (compare > 0) {
            current.right = removeNodeHelper(current.right, _index);
        }
        else {
            if (current.left == null) {
                return current.right;
            }
            else if (current.right == null) {
                return current.left;
            }

            BSTNode successor = searchMin(current.right);
            current.index = successor.index;
            current.data = successor.data;

            current.right = removeNodeHelper(current.right, successor.index);

        }
        return current;
    }

    private BSTNode searchMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    /**
     * Updates a node's data with a new value, given its index.
     */
    public void updateNode(I _index, T _newData) {
        // TODO

        BSTNode updateNode = searchNode(_index);

        if (updateNode == null) {
            throw new IllegalArgumentException("updateNode(I _index, T _newData): No node with an index " + _index + " in the BST");
        }
        updateNode.setData(_newData);
    }

    
/************************************ GRADING CODE (DO NOT MODIFY) ************************************ */
    /**
     * Performs a pre-order traversal of the BST.
     */
    private void preOrderTraversal(BSTNode node, int[] idx, String[] arr, boolean dataFlag) {
        // DO NOT CHANGE THIS. THIS FOR TESTING PURPOSES
        if(node == null)
            return;

        if(dataFlag)
            arr[idx[0]] = String.valueOf(node.getData());
        else
            arr[idx[0]] = String.valueOf(node.getIndex());
        idx[0]++;
        
        preOrderTraversal(node.left, idx, arr, dataFlag);
        preOrderTraversal(node.right, idx, arr, dataFlag);
    }

    /**
     * Returns an array of data values in pre-order traversal order.
     * @return A String array containing the data values of all nodes in pre-order order
     */
    public String[] getDataArray() {
        /// DO NOT CHANGE THIS. THIS FOR TESTING PURPOSES
        String[] dataArr = new String[size];
        preOrderTraversal(this.root, new int[1], dataArr, true);
        return dataArr;
    }

    /**
     * Returns an array of index values in pre-order traversal order.
     * @return A String array containing the index values of all nodes in pre-order order
     */
    public String[] getIndexArray() {
        // DO NOT CHANGE THIS. THIS FOR TESTING PURPOSES
        String[] indexArr = new String[size];
        preOrderTraversal(this.root, new int[1], indexArr, false);
        return indexArr;
    }

/****************************************************************************************************** */

}
