package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;

public class Expunge extends Passive {
    private static final String NAME = "Expunge";
    private static final String DESCRIPTION = "If at 100% health at the end of the round, deals 50% of its health to its target.";
    private static final int LEVEL_REQUIREMENT = 3;

    public Expunge() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyExpunge(Character character, Character target){
        double expungeDmg = character.getHealth()*.5;
        if(character.getHealth() >= character.getMaxHealth()){
            target.takeDamage(expungeDmg);
        }
    }
}
