public class SeriesV2<T> implements Series<T> {
    private LL<T> seriesData;
    private BST<String,T> seriesDataBST;

    public SeriesV2(String[] _rowNames, T[] _data) {
        if (_data == null) {
            throw new NullPointerException("Series(String[] _index, T[] _data): _data can't be null. Terminating the program");
        }

        seriesData = new LL<>();
        seriesDataBST = new BST<>();

        try {
            if (_rowNames.length != _data.length) {
                throw new IllegalArgumentException("Series(String[] _index, T[] _data): the length of _index and _data must be the same");
            }

            for (int i = 0; i < _rowNames.length; i++) {
                if (_rowNames[i] == null) {
                    throw new IllegalArgumentException("Series(String[] _index, T[] _data): _rowNames is not valid");
                }
                seriesData.appendNode(_rowNames[i], _data[i]);
                seriesDataBST.addNode(_rowNames[i], _data[i]);
            }

        }
        catch (NullPointerException e) {

            for (int i = 0; i < _data.length; i++) {
                seriesData.appendNode(String.valueOf(i), _data[i]);
                seriesDataBST.addNode(String.valueOf(i), _data[i]);
            }
        }
    }

    /**
     * Returns a string representation of the Series object.
     */
    public String toString() {
        String origLLString = seriesData.toString();
        return origLLString.replace("linked list", "series");
    }

    /**
     * Returns the length of the series object.
     */
    public int getLength() {
        return seriesData.getLength();
    }

    /**
     * Returns the row names of this Series object.
     */
    public String[] getRowNames() {
        return seriesData.getIndexArray();
    }

    /**
     * Returns the data of this Series object as strings.
     */

    public String[] getData() {
        return seriesData.getDataArray();
    }

    /**
     * Adds a new pair of rowName and data at the end of the Series object.
     *
     * @param rn the row name to be added
     * @param d  the Integer data value to be added
     */
    public void append(String rn, T d) {
        // TODO: Implement append method
        if (rn == null) {
            rn = String.valueOf(seriesData.getLength());
        }
        if (rn.isEmpty()) {
            rn = String.valueOf(seriesData.getLength());
        }

        seriesData.appendNode(rn, d);
        seriesDataBST.addNode(rn, d);
    }

    /**
     * Retrieves a data value given a row name.
     *
     * @param rn the row name to search for
     */
    public T loc(String rn) throws NullPointerException, IllegalArgumentException {
        // TODO: Implement loc method
        if (rn == null) {
            throw new NullPointerException("loc(String rn): rn can't be null");
        }

        if (rn.isEmpty()) {
            throw new IllegalArgumentException("loc(String rn): rn can't be an empty string");
        }

        BST<String, T>.BSTNode node = seriesDataBST.searchNode(rn);

        if (node == null) {
            return null;
        }

        return node.getData();

    }

    /**
     * Retrieves multiple data values given an array of row names.
     *
     * @param rn an array of row names to search for
     */
    public T[] loc(String[] rn) throws NullPointerException, IllegalArgumentException {
        // TODO: Implement loc method for multiple row names
        if (rn == null) {
            throw new NullPointerException("loc(String[] rn): rn[] can't be null");
        }

        if (rn.length == 0) {
            throw new IllegalArgumentException("loc(String[] rn): rn[] can't be an empty array");
        }

        T[] integerObjects = (T[]) new Object[rn.length];

        for (int i = 0; i < rn.length; i++) {
            integerObjects[i] = loc(rn[i]);
        }

        return integerObjects;
    }


    /**
     * Retrieves a data value based on its integer index.
     *
     * @param ind the index of the data to retrieve
     */
    public T iloc(int ind) {
        try {
            String idx = seriesData.getIndexArray()[ind];
            return seriesDataBST.searchNode(idx).getData();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("the index " + ind + " is not valid.. returning null");
            return null;
        }

    }

    /**
     * Removes a pair of rowname-data from the Series, given a row name.
     *
     * @param rn the row name of the pair to be removed
     */
    public boolean drop(String rn) throws NullPointerException, IllegalArgumentException {
        // TODO: Implement drop method
        if (rn == null) {
            throw new NullPointerException("drop(String rn): rn can't be null");
        }

        if (rn.isEmpty()) {
            throw new IllegalArgumentException("drop(String rn): rn can't be an empty String");
        }

        BST<String, T>.BSTNode node = seriesDataBST.searchNode(rn);

        if (node == null) {
            return false;
        }

        seriesData.removeNode(rn);
        seriesDataBST.removeNode(rn);
        return true;

    }

    /**
     * Replace any data value that is null with value.
     *
     * @param value the new value to replace null values
     */
    public void fillNull(T value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("fillNull(T value): value can't be null");
        }

        String[] idxArray = seriesData.getIndexArray();

        for (int i = 0; i < idxArray.length; i++) {

            BST<String, T>.BSTNode bstNode = seriesDataBST.searchNode(idxArray[i]);

            if (bstNode.getData() == null) {
                bstNode.setData(value);
                seriesData.searchNode(idxArray[i]).setData(value);
            }
        }
    }
}

