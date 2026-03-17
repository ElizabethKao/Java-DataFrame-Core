public class LL<T> {

    public class LLNode {
        private String index;
        private T data;
        private LLNode next;

        public LLNode() {
            index = null;
            data = null;
            next = null;
        }

        public LLNode(String _index, T _data) {
            index = _index;
            data = _data;
        }

        public String getIndex() {
            return index;
        }

        public T getData() {
            return data;
        }

        public void setData(T d) {
            data = d;
        }
    }

    private LLNode head;
    private LLNode tail;
    private int length;

    public LL () {
        head = new LLNode (null, null);
        tail = new LLNode (null, null);

        head.next = tail;
        tail.next = null;
        length = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("print the linked list ...\n");
        sb.append("==================\n");

        LLNode current = head;

        while (current != null) {
            sb.append(current.getIndex()).append("\t: ").append(current.getData()).append("\n");
            current = current.next;
        }

        return sb.toString();
    }

    public int getLength() {
        return length;
    }

    public String[] getDataArray() {
        String[] array = new String[length];
        LLNode current = head.next;
        int i = 0;

        while (current != tail) {
            array[i] = String.valueOf(current.getData());
            current = current.next;
            i++;
        }
        return array;
    }

    public String[] getIndexArray() {
        String[] array = new String[length];
        LLNode current = head.next;
        int i = 0;

        while (current != tail) {
            array[i] = current.getIndex();
            current = current.next;
            i++;
        }
        return array;
    }

    public void appendNode(String _index, T _data) {
        if (_index == null) {
            _index = String.valueOf(length);
        }

        if (_index.isEmpty()) {
            _index = String.valueOf(length);
        }

        LLNode newNode = new LLNode(_index, _data);

        LLNode current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = tail;

        length++;
    }

    public LLNode searchNode(String _index) {

        LLNode current = head.next;

        while (current != tail) {
            if (current.getIndex().equals(_index)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public void removeNode(String _index) {
        LLNode current = head;

        while (current.next != tail) {
            if (current.next.getIndex().equals(_index)) {
                current.next = current.next.next;
                length--;
                return;
            }

            current = current.next;
        }

        throw new IllegalArgumentException("removeNode(String _index): No node with an index " + _index + " in the list");
    }

    public void updateNode(String _index, T value) throws IllegalArgumentException {
        LLNode node = searchNode(_index);

        if (node != null) {
            node.setData(value);
            return;
        }

        throw new IllegalArgumentException("updateNode(String _index, T value): No node with an index " + _index + " in the list");
    }

}
