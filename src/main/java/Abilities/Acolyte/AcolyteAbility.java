package Abilities.Acolyte;

import Abilities.Ability;
import Abilities.Acolyte.AcolytePassives.Reserves;
import Characters.Character;

public abstract class AcolyteAbility extends Ability {

    public AcolyteAbility(String name, String description, int levelRequirement, double damage, boolean aoe) {
        super(name, description, levelRequirement, damage, aoe);
    }

    public double checkReserves(Character character, double selfDamage){
        Reserves reserves = new Reserves();
        if(character.getLevel() >= reserves.getLevelRequirement()){
            selfDamage = reserves.applyReserves(selfDamage);
        }
        return selfDamage;
    }

}
