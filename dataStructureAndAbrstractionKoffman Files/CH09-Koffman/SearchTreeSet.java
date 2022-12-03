/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KW.CH09;

import KW.CH06.SearchTree;
import java.util.AbstractSet;
import java.util.Iterator;

/**
 *
 * @author Paul
 * @param <E> The element type
 */
public class SearchTreeSet<E extends Comparable<E>> extends AbstractSet<E> {
    
    private final SearchTree<E> searchTree;
    
    @Override
    public Iterator<E> iterator() {
        return searchTree.iterator();
    }

    @Override
    public int size() {
        return searchTree.size();
    }
    
    public SearchTreeSet(SearchTree<E> tree) {
        this.searchTree = tree;
    }
    
}
