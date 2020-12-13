package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if(!isDiagonal(this.position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - this.position.getX());
        int deltaX = (dest.getX() - this.position.getX())/size;
        int deltaY = (dest.getY() - this.position.getY())/size;
        Cell[] cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            cells[i] = Cell.findBy(this.position.getX() + deltaX * (1 + i), this.position.getY() + deltaY * (1 + i));
        }
        return cells;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
