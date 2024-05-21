package models;

import Exceptions.InvalidBotCountException;
import Exceptions.InvalidPlayerSizeException;
import Exceptions.InvalidSymbolSetupException;
import models.Enums.GameState;
import models.Enums.PlayerType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game
{
    private Board currentBoard;
    private List<Player> players;
    private List<Move> moves;
    private Player currentPlayer;
    private GameState status_Of_Game;
    private List<Board> boards;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;

    private Game(Board currentBoard, List<Player> players, List<Move> moves, Player currentPlayer, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.moves = moves;
        this.currentPlayer = currentPlayer;
        this.status_Of_Game = GameState.IN_PROGRESS;
        this.boards = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }

    public Builder builder()
    {
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameState getStatus_Of_Game() {
        return status_Of_Game;
    }

    public void setStatus_Of_Game(GameState status_Of_Game) {
        this.status_Of_Game = status_Of_Game;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static class Builder
    {
        private Board currentBoard;
        private List<Player> players;
        private List<Move> moves;
        private Player currentPlayer;
        private GameState status_Of_Game;
        private List<Board> boards;
        private WinningStrategy winningStrategy;
        private int numberOfSymbols;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Builder setStatus_Of_Game(GameState status_Of_Game) {
            this.status_Of_Game = status_Of_Game;
            return this;
        }

        public Builder setBoards(List<Board> boards) {
            this.boards = boards;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setNumberOfSymbols(int numberOfSymbols) {
            this.numberOfSymbols = numberOfSymbols;
            return this;
        }

        private void validateNumberOfPlayers()
        {
            if(players.size()<currentBoard.getSize()-2 || players.size()>=currentBoard.getSize()-1)
            {
                throw new InvalidPlayerSizeException("Player size should be N-2 or N-1 as per board Size");
            }
        }
        private void validatePlayerSymbols()
        {
            HashSet<Character> set=new HashSet<>();
            for(Player player:players)
            {
                set.add(player.getSymbol());
            }
            if(set.size()!=players.size())
            {
                throw new InvalidSymbolSetupException("There should be unique symbold for all the players");
            }
        }

        private void validateBotCount()
        {
            int botCount=0;
            for(Player player: players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
            }

            if(botCount>1 || botCount<0)
            {
                throw new InvalidBotCountException("we can have max 1 bot");
            }
        }

        private void validate()
        {
            validateBotCount();
            validatePlayerSymbols();
            validateNumberOfPlayers();
        }

        public Game build()
        {
            validate();
//            return new Game();
            return null;

        }



    }
}
