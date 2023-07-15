package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;
import Systems.StatusEffects.Stun;

import java.util.Random;

public class VoidVenom extends Passive {
    private static final String NAME = "Void Venom";
    private static final String DESCRIPTION = "Has a chance to stun the target for 1 round.";
    private static final int LEVEL_REQUIREMENT = 0;

    public VoidVenom() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyVoidVenom(Character character, Character target) {
        Random rng = new Random();
        double stunChance = 0.10; // 10% chance of stunning

        if (rng.nextDouble() <= stunChance) {
            Stun stunEffect = new Stun(1);
            target.applyStatusEffect(stunEffect);
            System.out.println(target.getName() + " has been paralyzed by " + NAME + " and will skip their turn.");
        }
    }
}
