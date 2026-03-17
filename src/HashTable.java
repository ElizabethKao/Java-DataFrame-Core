public class HashTable<V> {
    private static final Object BRIDGE = new String("[BRIDGE]").toCharArray();
    private int size;
    private int capacity;
    private String[] keys;
    private V[] values;

    public HashTable() {
        size = 0;
        capacity = 4;
        keys = new String[capacity];
        values = (V[]) new Object[capacity];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("printing the hash table ...\n");
        sb.append("==================\n");

        for (int i = 0; i < capacity; i++) {
            sb.append("index:\t").append(i).append(",\t");
            sb.append("key:\t").append(keys[i]).append(",\t");
            sb.append("data:\t").append(values[i]).append("\n");
        }

        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public String[] getKeyArray() {
        String[] keyArray = new String[keys.length];

        for (int i = 0; i < keys.length; i++) {
            keyArray[i] = keys[i];
        }

        return keyArray;
    }

    public V[] getDataArray() {
        V[] dataArray = (V[]) new Object[values.length];

        for (int i = 0; i < values.length; i++) {
            dataArray[i] = values[i];
        }
        return dataArray;
    }

    public String[] getValidKeys() {
        int validCount = 0;
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null && keys[i] != BRIDGE) {
                validCount++;
            }
        }

        String[] validKeys = new String[validCount];

        int idx = 0;
        for (int j = 0; j < capacity; j++) {
            if (keys[j] != null && keys[j] != BRIDGE) {
                validKeys[idx] = keys[j];
                idx++;
            }
        }
        return validKeys;
    }

// STUDY THIS METHOD IT'S PROBS ON FINAL
    public int getHashIndex(String k) {
        int hashValue = 0;
        for (int i = 0; i < k.length(); i++) {
            int letter = k.charAt(i) - 96;
            hashValue += (hashValue * 27 + letter);
        }
        return hashValue % this.getCapacity();
    }

    public V lookup(String k) throws NullPointerException {
        if (k == null) {
            throw new NullPointerException("lookup(String key): key is null");
        }

        int index = getHashIndex(k);
        int count = 0;

        while (count < capacity) {
            if (keys[index] == null) {
                return null;
            }

            if (keys[index] != BRIDGE && keys[index].equals(k)) {
                return values[index];
            }

            index = (index + 1) % capacity;
            count++;
        }
        return null;
    }

    public int insert(String k, V v) throws NullPointerException {
        if (k == null){
            throw new NullPointerException("insert(String k, V v): k is null");
        }

        if (v == null) {
            throw new NullPointerException("insert(String k, V v): v is null");
        }

        int index = getHashIndex(k);
        int firstAvailIndex = -1;
        int count = 0;

        while (count < capacity) {
            if (keys[index] == null) {

                if (firstAvailIndex == -1) {
                    firstAvailIndex = index;
                }
                break;
            }
            else if (keys[index] == BRIDGE) {
                if (firstAvailIndex == -1) {
                    firstAvailIndex = index;
                }
            }

            else if (keys[index].equals(k)) {
                values[index] = v;
                return index;
            }
            index = (index + 1) % capacity;
            count++;
        }

        keys[firstAvailIndex] = k;
        values[firstAvailIndex] = v;
        size++;

        if ((double) size / capacity > 0.55) {
            sizeUp();
            return helperLookupIndex(k);
        }
        return firstAvailIndex;

    }

    private int helperLookupIndex(String k) {
        int index = getHashIndex(k);

        while (keys[index] != null) {
            if (keys[index] != BRIDGE && keys[index].equals(k)) {
                return index;
            }
            index = (index + 1) % capacity;
        }

        return -1;
    }

    private void sizeUp() {
        int oldCapacity = capacity;
        int newCapacity = 2 * oldCapacity;

        String[] oldKeys = keys;
        V[] oldValues = values;

        capacity = newCapacity;
        keys = new String[capacity];
        values = (V[]) new Object[capacity];

        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            if (oldKeys[i] != null && !oldKeys[i].equals("[BRIDGE]")) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }

    private void sizeDown() {
        int oldCapacity = capacity;
        int newCapacity = capacity / 2;

        if (newCapacity < 4) {
            newCapacity = 4;
        }

        if (newCapacity == capacity) {
            return;
        }


        String[] oldKeys = keys;
        V[] oldValues = values;

        capacity = newCapacity;
        keys = new String[capacity];
        values = (V[]) new Object[capacity];

        size = 0;

        for (int i = 0; i < oldCapacity; i++ ) {
            if (oldKeys[i] != null && !oldKeys[i].equals("[BRIDGE]")) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }

    public int delete(String k) {
        int hashedIdx = getHashIndex(k);
        int index = hashedIdx;
        int count = 0;

        while (count < capacity) {
            if (keys[index] == null) {
                return hashedIdx;
            }

            if (keys[index] != BRIDGE && keys[index].equals(k)) {
                keys[index] = "[BRIDGE]";
                values[index] = null;
                size--;

                int removedIdx = index;

                if ((double) size / capacity < 0.3) {
                    sizeDown();
                }
                return removedIdx;
            }
            index = (index + 1) % capacity;
            count++;
        }
        return hashedIdx;
    }
}
