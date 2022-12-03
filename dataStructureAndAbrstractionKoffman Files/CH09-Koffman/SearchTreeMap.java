package KW.CH09;

import KW.CH06.SearchTree;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Paul
 * @param <K> The Key type
 * @param <V> The Value type
 */
public class SearchTreeMap<K, V> extends AbstractMap<K, V> {
    
    private Comparator<K> comp;
    private SearchTree<ComparableEntry> searchTree;
    private Set<Entry<K, V>> entrySet;
   
    private class ComparableEntry implements Map.Entry<K, V>, Comparable<ComparableEntry> {
        
        private final K key;
        private V value;
        
        public ComparableEntry(K key, V value) {
            this.key = key;
            this.value = value;
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

        @Override
        public int compareTo(ComparableEntry o) {
            return comp.compare(this.key, o.key);
        }
        
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public SearchTreeMap(Comparator<K> comp, Class<? extends SearchTree> clazz) {
        this.comp = comp;
        try {
            var constructor = clazz.getConstructor();
            searchTree = constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        entrySet = new SearchTreeSet(searchTree);
    }
    
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public SearchTreeMap(Class<? extends SearchTree> clazz) {
        this ((K k1, K k2) -> ((Comparable<K>)k1).compareTo(k2), clazz);
    }
    
    @Override
    public V put(K key, V value) {
        var newEntry = new ComparableEntry(key, value);
        if (searchTree.add(newEntry)) {
            return null;
        } else {
            var oldEntry = searchTree.find(newEntry);
            var oldValue = oldEntry.value;
            oldEntry.value = value;
            return oldValue;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsKey(Object key) {
        var entry = new ComparableEntry((K)key, null);
        var oldEntry = searchTree.find(entry);
        return oldEntry != null;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public V get(Object key) {
        var entry = new ComparableEntry((K)key, null);
        var oldEntry = searchTree.find(entry);
        if (oldEntry != null) {
            return oldEntry.value;
        } else {
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public V remove(Object key) {
        var entry = new ComparableEntry((K)key, null);
        var oldEntry = searchTree.delete(entry);
        if (oldEntry != null){
            return oldEntry.value;
        } else {
            return null;
        }
    }
    
}
