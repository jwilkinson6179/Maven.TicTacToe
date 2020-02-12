package rocks.zipcodewilmington.tictactoe;

import com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl;

/**
 * @author leon on 6/22/18.
 */
public class Board
{
    Character boardState[][];

    public Board(Character[][] matrix)
    {
        boardState = matrix;
    }

    public Boolean isInFavorOfX()
    {
        if(boardState[0][0] == 'X' &&
                boardState[1][1] == 'X' &&
                boardState[2][2] == 'X')
        {
            return true;
        }
        else if(boardState[0][2] == 'X' &&
            boardState[1][1] == 'X' &&
            boardState[2][0] == 'X')
        {
            return true;
        }
        else if(hasWinningRow('X', boardState))
        {
            return true;
        }
        else if(hasWinningColumn('X', boardState))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean isInFavorOfO() {
        if(boardState[0][0] == 'O' &&
                boardState[1][1] == 'O' &&
                boardState[2][2] == 'O')
        {
            return true;
        }
        else if(boardState[0][2] == 'O' &&
                boardState[1][1] == 'O' &&
                boardState[2][0] == 'O')
        {
            return true;
        }
        else if(hasWinningRow('O', boardState))
        {
            return true;
        }
        else if(hasWinningColumn('O', boardState))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean isTie()
    {
        return !(isInFavorOfO() || isInFavorOfX());
    }

    public String getWinner()
    {
        if(isTie())
        {
            return "";
        }
        else
        {
            return isInFavorOfO() ? "O" : "X";
        }
    }

    public Boolean hasWinningRow(Character player, Character[][] boardState)
    {
        for(int row = 0; row < 3; row++)
        {
            if(     boardState[0][row] == player &&
                    boardState[1][row] == player &&
                    boardState[2][row] == player)
            {
                return true;
            }
        }

        return false;
    }

    public Boolean hasWinningColumn(Character player, Character[][] boardState)
    {
        for(int column = 0; column < 3; column++)
        {
            if(     boardState[column][0] == player &&
                    boardState[column][1] == player &&
                    boardState[column][2] == player)
            {
                return true;
            }
        }

        return false;
    }
}
