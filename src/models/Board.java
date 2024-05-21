package models;

import java.util.List;

public class Board
{
    private int id;
    private int size;
    private List<List<Cell>> cells;

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }
}
