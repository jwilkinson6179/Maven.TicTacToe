package rocks.zipcodewilmington.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest
{
    private Board board;
    private Character[][] boardXWinsRow;
    private Character[][] boardNoWins;

    @Before
    public void setup()
    {
        // Given
        this.board = new Board(new Character[][]{
                {'X', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        });
        this.boardNoWins = new Character[][]{
                {'X', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        };

        this.boardXWinsRow = new Character[][]{
                {'X', 'X', 'X'},
                {'O', 'O', 'X'},
                {'X', 'O', ' '}
        };
    }

    @Test
    public void hasNoWinningRowForX()
    {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.hasWinningColumn('X', boardNoWins);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasWinningRowForO()
    {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.hasWinningColumn('O', boardNoWins);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasWinningRowForX()
    {
        // Given
        Boolean expected = true;

        // When
        Boolean actual = board.hasWinningColumn('X', boardXWinsRow);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasWinningRowForXButNotO()
    {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.hasWinningColumn('O', boardXWinsRow);

        // Then
        Assert.assertEquals(expected, actual);
    }
}