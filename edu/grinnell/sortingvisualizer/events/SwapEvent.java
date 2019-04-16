package edu.grinnell.sortingvisualizer.events;

import java.util.List;
import java.util.Iterator;

public class SwapEvent<T> implements SortEvent<T> {
    public List<Integer> affectedIndices;

    public SwapEvent(List<Integer> affectedIndices) {
       this.affectedIndices = affectedIndices;
    } 

    public void apply(T[] arr) {
        Iterator<Integer> iter = affectedIndices.iterator();

        int first = iter.next();
        int second = iter.next();
        
        T temp = arr[first];

        arr[first] = arr[second];
        arr[second] = temp;
    }

    public List<Integer> getAffectedIndices() {
        return this.affectedIndices;
    }

    public boolean isEmphasized() {
        return true;
    }

}
