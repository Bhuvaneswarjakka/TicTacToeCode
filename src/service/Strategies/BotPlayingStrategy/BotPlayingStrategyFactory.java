package service.Strategies.BotPlayingStrategy;

public class BotPlayingStrategyFactory
{
    public static BotPlayingStrategy getBotPlayingStrategy()
    {
        return new RandomBotPlayingStrategy();
    }
}
