/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.PrimitiveIterator;

/**
 *
 * @author Paul
 */
public interface IteratorOfBoolean extends PrimitiveIterator<Boolean, BooleanConsumer> {
    
    boolean nextBoolean();
    
    @Override
    default void forEachRemaining(BooleanConsumer action) {
        while (hasNext())
            action.accept(nextBoolean());
    }
     
}
