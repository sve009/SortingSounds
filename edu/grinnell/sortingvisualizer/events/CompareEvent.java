package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {
  boolean emphasis;
  public List<Integer> affectedIndices;

  public CompareEvent(List<Integer> affectedIndices) {
    this.affectedIndices = affectedIndices;
    this.emphasis = false;
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
