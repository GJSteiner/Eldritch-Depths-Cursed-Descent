package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;

public class HighWaters extends Passive {
    private static final String NAME = "High Waters";
    private static final String DESCRIPTION = "This character increases its level by 1 each round.";
    private static final int LEVEL_REQUIREMENT = 10;

    public HighWaters() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyHighWaters(Character character, Character target) {
//        int currentLevel = character.getLevel();
//        character.setLevel(currentLevel + 1);
        character.levelUp();
        System.out.println(character.getName() + " has triggered " + NAME + " and leveled up to level " + character.getLevel() + "!");

    }
}
