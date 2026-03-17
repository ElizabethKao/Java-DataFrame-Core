public interface Series<T> {

    public String toString();

    public int getLength();

    public String[] getRowNames();

    public String[] getData();

    public void append(String rn, T d);

    public T loc(String rn);

    public T[] loc(String[] rn);

    public T iloc(int ind);

    public boolean drop(String rn);

    public void fillNull(T value);

}
//    /**
//     * Row names of the series.
//     */
//    // private String[] rowNames;
//
//    /**
//     * The Integer array that contains the list of data that constitutes a Series object.
//     */
//    // private T[] data;
//
//    private LL<T> seriesData;
//
//    /**
//     * Constructs a new Series object.
//     *
//     * @param _rowNames an array of row names
//     * @param _data     an array of Integer data
//     */
//    public Series(String[] _rowNames, T[] _data) {
//        // TODO: Implement constructor
//
//        if (_data == null) {
//            throw new NullPointerException("Series(String[] _index, T[] _data): _data can't be null. Terminating the program");
//        }
//
//        seriesData = new LL<>();
//
//        try {
//            int checkLength = _rowNames.length;
//            if (_rowNames.length != _data.length) {
//                throw new IllegalArgumentException("Series(String[] _index, T[] _data): the length of _index and _data must be the same");
//            }
//
//            for (int i = 0; i < _rowNames.length; i++) {
//                if (_rowNames[i] == null) {
//                    throw new IllegalArgumentException("Series(String[] _index, T[] _data): _rowNames is not valid");
//                }
//                seriesData.appendNode(_rowNames[i], _data[i]);
//            }
//
////            rowNames = new String[_rowNames.length];
////            data = (T[]) new Object[_data.length];
////            for (int i = 0; i < _rowNames.length; i++) {
////                rowNames[i] = _rowNames[i];
////                data[i] = (T) _data[i];
////            }
//
//        } catch (NullPointerException e) {
//
////            rowNames = new String[_data.length];
////            data = (T[]) new Object[_data.length];
//
//            for (int i = 0; i < _data.length; i++) {
//                seriesData.appendNode(String.valueOf(i), _data[i]);
////                rowNames[i] = String.valueOf(i);
////                data[i] = (T) _data[i];
//            }
//        }
//    }
//
//    /**
//     * Returns a string representation of the Series object.
//     */
//    public String toString() {
//        // TODO: Implement toString method
//        return seriesData.toString();
////        String s_rep = "";
////
////        s_rep += "Printing Series...\n\n";
////
////        for (int i = 0; i < data.length; i++) {
////            s_rep += rowNames[i] + "\t" + data[i] + "\n";
////
////        }
////
////        return s_rep;
//    }
//
//    /**
//     * Returns the length of the series object.
//     */
//    public int getLength() {
//        return seriesData.getLength();
////        return data.length;
//    }
//
//    /**
//     * Returns the row names of this Series object.
//     */
//    public String[] getRowNames() {
//        return seriesData.getIndexArray();
////        String[] no_mod = new String[rowNames.length];
////
////        for (int i = 0; i < rowNames.length; i++) {
////            no_mod[i] = rowNames[i];
////        }
////        return no_mod;
//    }
//
//    /**
//     * Returns the data of this Series object as strings.
//     */
//
//    public String[] getData() {
//        return seriesData.getDataArray();
////        String[] sameData = new String[data.length];
////
////        for (int i = 0; i < data.length; i++) {
////            sameData[i] = String.valueOf(data[i]);
////        }
////        return sameData;
//    }
//
//    /**
//     * Adds a new pair of rowName and data at the end of the Series object.
//     *
//     * @param rn the row name to be added
//     * @param d  the Integer data value to be added
//     */
//    public void append(String rn, T d) {
//        // TODO: Implement append method
//        seriesData.appendNode(rn, d);
////        String[] more_rowNames = new String[rowNames.length + 1];
////        T[] more_data = (T[]) new Object[data.length + 1];
////
////        for (int i = 0; i < rowNames.length; i++) {
////            more_rowNames[i] = rowNames[i];
////            more_data[i] = data[i];
////        }
////
////        if (rn == null) {
////            rn = String.valueOf(more_rowNames.length - 1);
////        } else {
////            if (rn.isEmpty()) {
////                rn = String.valueOf(more_rowNames.length - 1);
////            }
////        }
////
////        more_rowNames[more_rowNames.length - 1] = rn;
////        more_data[more_data.length - 1] = (T) d;
////
////        rowNames = more_rowNames;
////        data = more_data;
//    }
//
//    /**
//     * Retrieves a data value given a row name.
//     *
//     * @param rn the row name to search for
//     */
//    public T loc(String rn) throws NullPointerException, IllegalArgumentException {
//        // TODO: Implement loc method
//        if (rn == null) {
//            throw new NullPointerException("loc(String rn): rn can't be null");
//        }
//
//        if (rn.isEmpty()) {
//            throw new IllegalArgumentException("loc(String rn): rn can't be an empty string");
//        }
//
//        LL<T>.LLNode node = seriesData.searchNode(rn);
//
//        if (node == null) {
//            return null;
//        }
//
//        return node.getData();
//
////        for (int i = 0; i < data.length; i++) {
////            if (rowNames[i].equals(rn)) {
////                return data[i];
////            }
////        }
////
////        return null;
//    }
//
//    /**
//     * Retrieves multiple data values given an array of row names.
//     *
//     * @param rn an array of row names to search for
//     */
//    public T[] loc(String[] rn) throws NullPointerException, IllegalArgumentException {
//        // TODO: Implement loc method for multiple row names
//        if (rn == null) {
//            throw new NullPointerException("loc(String[] rn): rn[] can't be null");
//        }
//
//        if (rn.length == 0) {
//            throw new IllegalArgumentException("loc(String[] rn): rn[] can't be an empty array");
//        }
//
//        T[] integerObjects = (T[]) new Object[rn.length];
//
//        for (int i = 0; i < rn.length; i++) {
//            integerObjects[i] = loc(rn[i]);
//        }
//
//        return integerObjects;
//    }
//
//
//    /**
//     * Retrieves a data value based on its integer index.
//     *
//     * @param ind the index of the data to retrieve
//     */
//    public T iloc(int ind) {
//        try {
//            String idx = seriesData.getIndexArray()[ind];
//            return seriesData.searchNode(idx).getData();
//
////            return data[ind];
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("the index " + ind + " is not valid.. returning null");
//            return null;
//        }
//
//    }
//
//    /**
//     * Removes a pair of rowname-data from the Series, given a row name.
//     *
//     * @param rn the row name of the pair to be removed
//     */
//    public boolean drop(String rn) throws NullPointerException, IllegalArgumentException {
//        // TODO: Implement drop method
//        if (rn == null) {
//            throw new NullPointerException("drop(String rn): rn can't be null");
//        }
//
//        if (rn.isEmpty()) {
//            throw new IllegalArgumentException("drop(String rn): rn can't be an empty String");
//        }
//
//        LL<T>.LLNode node = seriesData.searchNode(rn);
//
//        if (node == null) {
//            return false;
//        }
//
//        seriesData.removeNode(rn);
//        return true;
//
////        int dropIdx = -1;
////        for (int i = 0; i < rowNames.length; i++) {
////            if (rowNames[i].equals(rn)) {
////                dropIdx = i;
////                break;
////            }
////        }
////
////        if (dropIdx == -1) {
////            return false;
////        }
////
////        String[] droppedRn = new String[rowNames.length - 1];
////        T[] droppedData = (T[]) new Object[data.length - 1];
////
////        for (int i = 0; i < dropIdx; i++) {
////            droppedRn[i] = rowNames[i];
////            droppedData[i] = data[i];
////        }
////        for (int i = dropIdx + 1; i < rowNames.length; i++) {
////            droppedRn[i - 1] = rowNames[i];
////            droppedData[i - 1] = data[i];
////        }
////
////        rowNames = droppedRn;
////        data = droppedData;
////
////        return true;
//    }
//
//    /**
//     * Replace any data value that is null with value.
//     *
//     * @param value the new value to replace null values
//     */
//    public void fillNull(T value) throws IllegalArgumentException {
//        if (value == null) {
//            throw new IllegalArgumentException("fillNull(T value): value can't be null");
//        }
//
//        String[] idxArray = seriesData.getIndexArray();
//
//        for (int i = 0; i < idxArray.length; i++) {
//
//            LL<T>.LLNode node = seriesData.searchNode(idxArray[i]);
//
//            if (node.getData() == null) {
//                node.setData(value);
//            }
//        }
//    }
//}
//
////    /**
////     * Replace any data value that is null with the mean of the Series.
////     *
////     */
////    public void fillNullWithMean() throws IllegalArgumentException {
////        // TODO: Implement fillNullWithMean method
////        // Handle ArithmeticException that could be raised from mean()
////        Integer meanSeries;
////
////        try {
////            meanSeries = Tool.mean(this);
////        } catch (Exception e) {
////            meanSeries = null;
////        }
////
////        fillNull(meanSeries);
////    }
////}
//
//
////     public static void main(String[] args) {
////         Series s = new Series (new String[] {"A", "B", "C"}, new Integer[] {1, 2, 100});
////         Integer t = Tool.max(s);
////         System.out.print(t);
////         s.fillNullWithMean();
////     }
// }