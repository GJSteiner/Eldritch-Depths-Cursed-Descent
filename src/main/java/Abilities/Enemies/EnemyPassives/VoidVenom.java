package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;
import Systems.StatusEffects.Stun;

public class VoidVenom extends Passive {
    private static final String NAME = "Expunge";
    private static final String DESCRIPTION = "If at 100% health at the end of the round, deals 50% of its health to its target.";
    private static final int LEVEL_REQUIREMENT = 3;

    public VoidVenom() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyVoidVenom(Character character, Character target){
        Stun stunEffect = new Stun(1);
        target.applyStatusEffect(stunEffect);
        System.out.println(target.getName() + " has been paralyzed by" + NAME + " and will skip their turn.");
    }
}
