package edu.grinnell.sortingvisualization.events;

public class CompareEvent<T> implements SortEvent<T> {

    public List<Integer> affectedIndices;

    public CompareEvent<T>(List<Integer> affectedIndices) {
       this.affectedIndices = affectedIndices;
    } 

    public void apply(T[] arr) {
        return;
    }

    public List<Integer> getAffectedIndices() {
        return this.affectedIndices;
    }

    public boolean isEmphasized() {
        return false;
    }
}
