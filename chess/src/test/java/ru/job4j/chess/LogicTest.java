package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;


public class LogicTest {

    @Test (expected = OccupiedCellException.class)
    public void whenMoveThrough() throws RuntimeException{
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.C1, Cell.H6);

    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveNotDiagonal() throws RuntimeException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);

    }

    @Test (expected = FigureNotFoundException.class)
    public void whenMoveNotFound() throws RuntimeException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.H6);

    }

}