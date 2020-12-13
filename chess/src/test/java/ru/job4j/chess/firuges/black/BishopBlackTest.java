package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack test = new BishopBlack(Cell.A1);
        Assert.assertThat(test.position(),is(Cell.A1));
    }

    @Test
    public void testCopy() {
        BishopBlack original = new BishopBlack(Cell.A1);
        BishopBlack copy = (BishopBlack) original.copy(Cell.D2);
        Assert.assertThat(copy.position(), is(Cell.D2));
    }

    @Test
    public void testWay() {
        BishopBlack original = new BishopBlack(Cell.C1);
        Assert.assertThat(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}, is(original.way(Cell.G5)));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenWrongWay() {
        BishopBlack original = new BishopBlack(Cell.G6);
        original.way(Cell.A2);
        Assert.assertThat(Cell.A2, is(original.position()));
    }

}