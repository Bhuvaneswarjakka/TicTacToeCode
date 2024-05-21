package service.Strategies.WinningStrategy;

import models.Enums.WinningStrategies;

public class WinningStrategyFactory
{
    public static WinningStrategy getWinningStrategy(WinningStrategies winningStrategies, int dimension)
    {
        return new OrderOneWinningStrategy(dimension);
    }
}
