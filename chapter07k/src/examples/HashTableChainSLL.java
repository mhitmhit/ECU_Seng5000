/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @param <K> The key type
 * @param <V> The value type
 */
public class HashTableChainSLL<K, V> extends AbstractMap<K, V> {

    /**
     * The table
     */
    private Entry<K, V>[] table;
    /**
     * The number of keys
     */
    private int numKeys;
    /**
     * The capacity
     */
    private static final int CAPACITY = 101;
    /**
     * The maximum load factor
     */
    private static final double LOAD_THRESHOLD = 0.75;

    private static class Entry<K, V> implements Map.Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        private Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    // Constructor
    @SuppressWarnings({"unchecked", "rawtypes"})
    public HashTableChainSLL() {
        table = new Entry[CAPACITY];
    }
    
    public HashTableChainSLL(Map<K, V> otherMap) {
        this(otherMap.size() * 2);
        otherMap.forEach((k, v) -> put(k, v));
    }

    // Constructor for test purposes
    @SuppressWarnings({"unchecked", "rawtypes"})
    HashTableChainSLL(int capacity) {
        table = new Entry[capacity];
    }

// Insert solution to programming project 4, chapter 07 here

// Insert solution to programming project 5, chapter 07 here

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean containsKey(Object k) {
        K key = (K) k;
        int index = getIndex(key);
        Entry<K, V> entry = find(table[index], key);
        return entry != null;
    }

// Insert solution to programming project 6, chapter 07 here

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        for (Entry<K, V> entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

// Insert solution to programming project 7, chapter 07 here
}
