package Abilities.Corrupted;

import Abilities.Ability;
import Abilities.Corrupted.CorruptedPassives.EmpoweredCurses;
import Abilities.Corrupted.CorruptedPassives.SiphoningCurses;
import Characters.Character;

public abstract class CorruptedAbility extends Ability {
//    private double strengthMultiplier;

    public CorruptedAbility(String name, String description, int levelRequirement, double damage, boolean aoe, String abilityElement) {
        super(name, description, levelRequirement, damage, aoe, true, abilityElement);
    }

//    public double getStrengthMultiplier() {
//        return strengthMultiplier;
//    }
public void checkEmpoweredCurses(Character character, Character target){
    EmpoweredCurses ec = new EmpoweredCurses();
    if(character.getLevel() >= ec.getLevelRequirement()){
        ec.applyEmpoweredCurses(character, target);
    }
}  public void checkSiphoningCurses(Character character, Character target){
        SiphoningCurses sc = new SiphoningCurses();
        if(character.getLevel() >= sc.getLevelRequirement()){
            sc.applySiphoningCurses(character, target);
        }
    }
}
