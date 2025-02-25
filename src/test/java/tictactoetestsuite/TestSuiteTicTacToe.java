package tictactoetestsuite;

import com.tictactoe.game.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuiteTicTacToe {
    @Test
    public void testWinnerIsXInRows() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'X');
        board.setFigure(0, 1, 'X');
        board.setFigure(0, 2, 'X');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(xResult);
        assertFalse(oResult);
        assertFalse(tResult);
    }

    @Test
    public void testWinnerIsXInCols() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'X');
        board.setFigure(1, 0, 'X');
        board.setFigure(2, 0, 'X');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(xResult);
        assertFalse(oResult);
        assertFalse(tResult);
    }

    @Test
    public void testWinnerIsXInDiags() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'X');
        board.setFigure(1, 1, 'X');
        board.setFigure(2, 2, 'X');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(xResult);
        assertFalse(oResult);
        assertFalse(tResult);
    }

    @Test
    public void testWinnerIsOInRows() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'O');
        board.setFigure(0, 1, 'O');
        board.setFigure(0, 2, 'O');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(oResult);
        assertFalse(xResult);
        assertFalse(tResult);
    }

    @Test
    public void testWinnerIsOInCols() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'O');
        board.setFigure(1, 0, 'O');
        board.setFigure(2, 0, 'O');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(oResult);
        assertFalse(xResult);
        assertFalse(tResult);
    }

    @Test
    public void testWinnerIsOInDiags() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'O');
        board.setFigure(1, 1, 'O');
        board.setFigure(2, 2, 'O');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertTrue(oResult);
        assertFalse(xResult);
        assertFalse(tResult);
    }

    @Test
    public void testTie() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'X');
        board.setFigure(0, 1, 'X');
        board.setFigure(0, 2, 'O');
        board.setFigure(1, 0, 'O');
        board.setFigure(1, 1, 'O');
        board.setFigure(1, 2, 'X');
        board.setFigure(2, 0, 'X');
        board.setFigure(2, 1, 'O');
        board.setFigure(2, 2, 'X');
        //When
        final boolean xResult = board.checkWinner('X');
        final boolean oResult = board.checkWinner('O');
        final boolean tResult = board.checkWinner('T');
        //Then
        assertFalse(board.checkWinner('O'));
        assertFalse(board.checkWinner('X'));
        assertTrue(board.checkWinner('T'));
    }

    @Test
    public void testWrongMove() {
        //Given
        Board board = new Board(3);
        board.setFigure(0, 0, 'X');
        board.setFigure(0, 1, 'X');
        board.setFigure(0, 2, 'O');
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //When
        boolean result = board.setFigure(0, 2, 'X');

        //Then
        assertEquals("0,2 is already occupied.\n", out.toString());
        assertFalse(result);
    }
}
