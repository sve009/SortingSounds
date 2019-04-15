package edu.grinnell.sortingvisualization.events;

public interface SortEvent<T> {
    public void apply(arr);

    public List<Integer> getAffectedIndices();

    public boolean isEmphasized();
}

