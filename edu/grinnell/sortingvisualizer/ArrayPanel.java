package edu.grinnell.sortingvisualizer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    private int width;
    private int height;
    private int rectWidth;
    private int rectHeight;
    private boolean initialized = false;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
    }

    private void initialize() {
        this.rectWidth = this.width / this.notes.getNotes().length;
        this.rectHeight = this.height / this.notes.getNotes().length;
        this.initialized = true;
    }


    @Override
    public void paintComponent(Graphics g) {
        if (!this.initialized) {
            this.initialize();
        }

        Integer[] currentNotes = notes.getNotes();

        for (int i = 0; i < currentNotes.length; i++) {
            int index = currentNotes[i];

            if (notes.isHighlighted(index)) {
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.blue);
            }

            g.fillRect(i * rectWidth, (currentNotes.length - index) * rectHeight, rectWidth, index * rectHeight);
        }
    }
}
