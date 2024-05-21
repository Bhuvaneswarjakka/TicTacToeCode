package service.Strategies.BotPlayingStrategy;

import Exceptions.GameOverException;
import models.Board;
import models.Cell;
import models.Enums.CellStatus;
import models.Move;
import models.Player;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy
{

    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> matrix=board.getCells();
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix.size();j++)
            {
                if(matrix.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY))
                {
                    board.getCells().get(i).get(j).setPlayer(player);
                    board.getCells().get(i).get(j).setCellStatus(CellStatus.FULL);
                    return new Move( player, board.getCells().get(i).get(j));
                }
            }
        }
        throw new GameOverException("There is no Empty Cells in the board");
    }
}
