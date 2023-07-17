package Abilities.Corrupted.CorruptedPassives;

import Abilities.Ability;
import Abilities.Corrupted.CorruptedAbility;
import Abilities.Passive;
import Characters.Character;
import Systems.DamageOverTime;

public class EmpoweredCurses extends Passive {
    private static final String NAME = "Empowered Curses";
    private static final String DESCRIPTION = "Doubles the potency of all curses.";
    private static final int LEVEL_REQUIREMENT = 4;

    public EmpoweredCurses() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyEmpoweredCurses(Character character, Character target){
        for(DamageOverTime dot : target.getDamageOverTimeEffects()){
            if(dot.getElement().equals("Curse")){
                dot.setDamagePerRound(dot.getDamagePerRound()*2);
            }
        }

    }

}
