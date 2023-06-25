package Abilities.Acolyte.AcolytePassives;
import Abilities.Ability;
import Abilities.Passive;
import Characters.Character;

public class Reserves extends Passive {
    private static final String NAME = "Reserves";
    private static final String DESCRIPTION = "The health cost of your blood spells is halved.";
    private static final int LEVEL_REQUIREMENT = 4;

    public Reserves() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public double applyReserves(double selfDamage){
        double newSelfDamage;

        if (selfDamage % 2 == 1){
            newSelfDamage = (selfDamage+1)/2;
        }
        else{
            newSelfDamage = (selfDamage)/2;
        }

        return newSelfDamage;
    }

}

