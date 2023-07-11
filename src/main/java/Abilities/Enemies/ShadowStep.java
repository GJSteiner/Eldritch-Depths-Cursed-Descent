package Abilities.Enemies;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

public class ShadowStep extends Ability {
    private static final String NAME = "Shadow Step";
    private static final String DESCRIPTION = "Teleports behind the target and launches a surprise attack.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final double DAMAGE = 15;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Void";


    public ShadowStep() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = DAMAGE;
        // if the enemy is a Shadow enemy, target takes double damage
        if(caster instanceof Enemy){
           if (((Enemy) caster).getEnemyTags().contains("Shadow")){
                adjustedDamage *=2;
            }
        }

        target.takeDamage(adjustedDamage);

        System.out.println(caster.getName() + " casts Shadow Step on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + adjustedDamage + " damage.");
    }
}
