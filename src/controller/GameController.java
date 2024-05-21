package controller;

import models.Board;
import models.Enums.GameState;
import models.Game;
import models.Move;
import models.Player;

import java.util.List;

public class GameController
{
    public Game createGame(int dimension, List<Player> players, WinningStrategy winningStrategy)
    {
        return null;
    }

    public void displayBoard(Game game)
    {

    }

    public GameState getGameStatus(Game game)
    {
        return null;
    }

    public Player getWinner(Game game)
    {
        return null;
    }

    public Move executeMove(Game game, Player player)
    {
        return null;
    }

    public Player checkWinner(Game game, Move lastMovePlayed)
    {
        return null;
    }
    public Board undoMove(Game game, Move lastPlayedMove)
    {
        return null;
    }

    public void replayGame(Game game)
    {

    }


}
