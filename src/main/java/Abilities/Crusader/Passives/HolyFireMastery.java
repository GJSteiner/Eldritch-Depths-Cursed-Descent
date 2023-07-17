package Abilities.Crusader.Passives;

import Abilities.Passive;
import Characters.Character;

public class HolyFireMastery extends Passive {
    private static final String NAME = "Holy Fire Mastery";
    private static final String DESCRIPTION = "Your holy and fire spells leave your target burning for 0.1 magic each round – this stacks with Holy Ignition";
    private static final int LEVEL_REQUIREMENT = 4;
    private static final String DOT_ELEMENT = "Fire";


    public HolyFireMastery() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyHFM(Character character, Character target){
        double hfmDot = character.getMagic()*0.1;

        target.applyDamageOverTime("Holy Fire Mastery", hfmDot, 2, DOT_ELEMENT);
    }

}
