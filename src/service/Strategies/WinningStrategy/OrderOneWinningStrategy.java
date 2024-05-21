package service.Strategies.WinningStrategy;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy
{
    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMapList;
    private List<HashMap<Character, Integer>> colHashMapList;
    private HashMap<Character, Integer> leftDiagonalHashMap;
    private HashMap<Character, Integer> rightDiagonalHashMap;

    public OrderOneWinningStrategy(int dimension)
    {
        this.dimension=dimension;
        rowHashMapList=new ArrayList<>();
        colHashMapList=new ArrayList<>();
        leftDiagonalHashMap=new HashMap<>();
        rightDiagonalHashMap=new HashMap<>();
        for(int i=0;i<dimension;i++)
        {
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }

    }
    @Override
    public Player checkWinner(Board board, Move lastMove)
    {
        Player player=lastMove.getPlayer();
        char symbol=player.getSymbol();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();

        boolean Winner=winnerCheckForCorners(board.getCells(), symbol)
                || checkAndUpdateForRowHashMap(row, symbol)
                || checkAndUpdateForColHashMap(col, symbol)
                || (checkAndUpdateForLeftDiagonalHashMap(symbol) && checkLeftDiaqonal(row, col))
                || (checkAndUpdateForRightDiagonalHashMap(symbol) && checkRightDiagonal(row, col));
        if(Winner)
        {
            return player;
        }
        else {
            return null;
        }

    }

    private boolean checkLeftDiaqonal(int row, int col)
    {
        return row==col;
    }

    private boolean checkRightDiagonal(int row, int col)
    {
        return row+col==dimension-1;
    }
    private boolean checkAndUpdateForRowHashMap(int row, char symbol)
    {
        HashMap<Character, Integer> map=rowHashMapList.get(row);
        if(map.containsKey(symbol))
        {
            map.put(symbol, map.get(symbol)+1);
        }
        else {
            map.put(symbol, 1);
        }
        return map.get(symbol)==dimension;
    }

    private boolean checkAndUpdateForColHashMap(int col, char symbol)
    {
        HashMap<Character, Integer> map=colHashMapList.get(col);
        if(map.containsKey(symbol))
        {
            map.put(symbol, map.get(symbol)+1);
        }
        else {
            map.put(symbol, 1);
        }
        return map.get(symbol)==dimension;
    }

    private boolean checkAndUpdateForLeftDiagonalHashMap(char symbol)
    {
        if(leftDiagonalHashMap.containsKey(symbol))
        {
            leftDiagonalHashMap.put(symbol, leftDiagonalHashMap.get(symbol)+1);
        }
        else {
            leftDiagonalHashMap.put(symbol, 1);
        }
        return leftDiagonalHashMap.get(symbol)==dimension;
    }

    private boolean checkAndUpdateForRightDiagonalHashMap(char symbol)
    {
        if(rightDiagonalHashMap.containsKey(symbol))
        {
            rightDiagonalHashMap.put(symbol, rightDiagonalHashMap.get(symbol)+1);
        }
        else {
            rightDiagonalHashMap.put(symbol, 1);
        }
        return rightDiagonalHashMap.get(symbol)==dimension;
    }

    private boolean winnerCheckForCorners(List<List<Cell>> matrix, char symbol)
    {
        return (matrix.get(0).get(0).getPlayer().getSymbol()==symbol)
                || (matrix.get(0).get(dimension-1).getPlayer().getSymbol()==symbol)
                || (matrix.get(dimension-1).get(0).getPlayer().getSymbol()==symbol)
                || (matrix.get(dimension-1).get(dimension-1).getPlayer().getSymbol()==symbol);
    }


}
