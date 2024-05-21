package models;

import models.Enums.DifficultyLevel;

public class Bot extends Player
{
    private DifficultyLevel levels;

    public DifficultyLevel getLevels() {
        return levels;
    }

    public void setLevels(DifficultyLevel levels) {
        this.levels = levels;
    }
}
