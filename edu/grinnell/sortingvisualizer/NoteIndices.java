package edu.grinnell.sortingvisualizer;

import java.util.Random;
import java.util.ArrayList;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {

    Integer[] indices;
    ArrayList<Integer> highlights;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        highlights = new ArrayList<Integer>();
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        Random rand = new Random();

        int i1;
        int i2;
        for (int i = 0; i < 10 * n; i++) {
            i1 = rand.nextInt(n);
            i2 = rand.nextInt(n);

            //Swap
            int temp = this.indices[i1];
            indices[i1] = indices[i2];
            indices[i2] = temp;
        }
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return this.indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (!this.isHighlighted(index)) {
            highlights.add(index);
        }
    }
    
    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        return highlights.contains(index);
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        highlights.clear();
    }
}
