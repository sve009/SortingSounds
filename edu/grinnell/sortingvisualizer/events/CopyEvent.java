package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {

  T value;
  int index;

  public CopyEvent(T value, int destination) {
    this.value = value;
    this.index = destination;
  } // constructor

  @Override
  public void apply(T[] arr) {
    arr[this.index] = this.value;
  }

  @Override
  public List<Integer> getAffectedIndices() {
    ArrayList<Integer> index = new ArrayList<Integer>();
    index.add(this.index);
    return index;
  }

  @Override
  public boolean isEmphasized() {
    return true;
  }
}// class CopyEvent
