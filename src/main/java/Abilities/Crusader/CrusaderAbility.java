package Abilities.Crusader;

import Abilities.Ability;
import Abilities.Crusader.CrusaderPassives.HolyFireMastery;
import Characters.Character;

public abstract class CrusaderAbility extends Ability {
    public CrusaderAbility(String name, String description, int levelRequirement, double damage, boolean aoe, boolean dot, String abilityElement) {
        super(name, description, levelRequirement, damage, aoe, dot, abilityElement);
    }

    public void checkHFM(Character character, Character target){
        HolyFireMastery hfm = new HolyFireMastery();
        if(character.getLevel() >= hfm.getLevelRequirement()){
           hfm.applyHFM(character, target);
        }
    }

}
