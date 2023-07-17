package Abilities.Corrupted.CorruptedPassives;

import Abilities.Passive;
import Characters.Character;
import Systems.DamageOverTime;

public class SiphoningCurses extends Passive {
    private static final String NAME = "Siphoning Curses";
    private static final String DESCRIPTION = "Heals the caster for a portion of all their curse damage.";
    private static final int LEVEL_REQUIREMENT = 3;


    public SiphoningCurses() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applySiphoningCurses(Character character, Character target){
        for(DamageOverTime dot : target.getDamageOverTimeEffects()){
            if(dot.getElement().equals("Curse")){
                character.applyHealOverTime("Siphoning Curses", (dot.getDamagePerRound()/2), 1);
            }
        }

    }

}
