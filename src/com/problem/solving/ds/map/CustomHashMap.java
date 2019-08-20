package com.problem.solving.ds.map;

/**
 * https://www.javamadesoeasy.com/2015/02/hashmap-custom-implementation.html
 * http://codecramp.com/how-to-implement-your-own-hashmap/
 * https://codereview.stackexchange.com/questions/171650/hashmap-implementation
 */
public class CustomHashMap<K, V> {

    protected int capacity = 8;
    private int size = 0;
    private final double LOAD_FACTOR = 0.75;

    private Entry<K, V> table[];

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    public CustomHashMap() {
        this.table = new Entry[capacity];
    }


    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced
     *
     * @param key
     * @param value
     */
    public boolean put(K key, V value) {

        ensureCapacity();

        Entry<K, V> entryToAdd = new Entry<>(key, value);

        int targetBucketIndex = getBucketHashIndex(key);

        Entry<K, V> existingEntry = table[targetBucketIndex];


        if (existingEntry == null) {
            // bucket is empty
            table[targetBucketIndex] = entryToAdd;
            size++;
            return true;
        } else {
            //linked list found
            //check for same/matching key

            while (!entryToAdd.key.equals(existingEntry.key) && existingEntry.next != null) {
                existingEntry = existingEntry.next;
            }

            //either last element or matches key
            if (entryToAdd.key.equals(existingEntry.key)) {
                //duplicate key found - override value
                existingEntry.value = entryToAdd.value;
                //no need to increase size as we have replaced value
                return true;
            }

            // no duplicate found add at the end
            existingEntry.next = entryToAdd;
            size++;
            return true;
        }


    }

    /**
     * Returns the entry associated with the specified key in the HashMap.
     * Returns null if the HashMap contains no mapping for the key.
     */
    public V get(K key) {

        int targetBucketIndex = getBucketHashIndex(key);

        //entry = null if itemnot found
        Entry<K, V> entry = table[targetBucketIndex];

        if (entry == null) {
            return null;
        } else {
            //linked list found
            while (entry != null) {
                //found matching entry key
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            //not found key
            return null;
        }

    }

    public Entry<K, V> remove(K key) {
        int targetBucketIndex = getBucketHashIndex(key);
        Entry<K, V> currentEntry = table[targetBucketIndex];

        if (currentEntry == null) {
            return null;
        }
        //entry exists
        Entry<K, V> previous = null;
        while (currentEntry != null) {
            //linked list
            if (currentEntry.key.equals(key)) {
                //found & delete
                Entry<K, V> entryToRemove = new Entry<>(currentEntry.key, currentEntry.value);

                if (previous == null) {
                    //first element matching
                    // Entry is the very first node. So, just overwrite it with the second Entry.
                    table[targetBucketIndex] = currentEntry.next;
                    size--;
                    return entryToRemove;

                } else {
                    //found at a middle node
                    previous.next = currentEntry.next;
                    size--;
                    return entryToRemove;
                }
            }
            previous = currentEntry;
            currentEntry = currentEntry.next;
        }

        return null;
    }

    /**
     * can insert your own hash methods
     * Applies a supplemental hash function to a given hashCode, which defends
     * against poor quality hash functions.
     * null should always map to index 0
     *
     * @param key- the key for which bucket index needs to be found.
     */
    protected int getBucketHashIndex(K key) {
// this method cannot have any variable that changes -like capacity as we resize
 //iff we use this we need to recalculate  hashkey when increasing size and copying table
       return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);

        //simple table copy will work but not efficent , will cause long and slow chains
//          return (key == null) ? 0 : Math.abs(key.hashCode() % 2);
    }


    private void ensureCapacity() {
        if (shouldResize()) {
            resize();
        }
    }

    private boolean shouldResize() {
        return this.size > Math.ceil((double) this.capacity * this.LOAD_FACTOR);
    }

    private void resize() {

        this.capacity = this.size * 2;
        System.out.println("INCREADED CAPACITY TO :" + capacity);
        //instantiate new table
        Entry<K, V>[] newEntries = new Entry[this.capacity];
        Entry<K, V>[] temp = table;
        table = new Entry[this.capacity];
        //copy all elements from old table to new table and return it
        for (int i = 0; i < temp.length; i++) {

            Entry<K,V> entry = temp[i];

            while(entry!=null){
                //check for linked list
                put(entry.key,entry.value);//will recalculate hash based on new capacity
                entry= entry.next;
            }

        }

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void printMap() {
        if (isEmpty()) {
            System.out.println("UNDERFLOW");
        }
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                System.out.print(current);
                current = current.next;
            }
            System.out.println();
        }
    }
}

class Entry<K, V> {

    K key;
    V value;
    //linked list - chaining & collision handling
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}



