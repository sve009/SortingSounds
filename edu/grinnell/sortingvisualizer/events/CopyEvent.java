package edu.grinnell.sortingvisualizer.events;

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
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Integer> getAffectedIndices() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isEmphasized() {
    // TODO Auto-generated method stub
    return false;
  }
}//class CopyEvent