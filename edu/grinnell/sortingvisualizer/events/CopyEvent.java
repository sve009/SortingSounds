package edu.grinnell.sortingvisualizer.events;
import java.util.ArrayList;

import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {
  T value;
  boolean emphasis;
  int affectIndex;
  
  public CopyEvent(T value, int destination){
  this.value=value;
  this.emphasis=true;
  this.affectIndex=destination;
} //constructor

  @Override
  public void apply(T[] arr) {
    arr[this.affectIndex]=value;
  }

  @Override
  public List<Integer> getAffectedIndices() {
    ArrayList<Integer> index= new ArrayList<Integer>();
    index.add(affectIndex);
    return null;
  }

  @Override
  public boolean isEmphasized() {
  
    return this.emphasis;
  }
}//class CopyEvent