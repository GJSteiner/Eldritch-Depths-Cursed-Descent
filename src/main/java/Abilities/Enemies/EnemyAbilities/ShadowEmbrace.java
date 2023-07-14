package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;
import Systems.Debuff;

import java.util.List;

public class ShadowEmbrace extends Ability {
    private static final String NAME = "Shadow Embrace";
    private static final String DESCRIPTION = "Envelops a target in its shadowy form, draining their life force and weakening their defenses.";
    private static final int LEVEL_REQUIREMENT = 2;
    private static final double DAMAGE = 5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Shadow";

    public ShadowEmbrace() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        target.takeDamage(DAMAGE);

        double defenseDebuffIntensity = 5;
        Debuff defenseDebuff = new Debuff("Defense Debuff", "Defense", 5, defenseDebuffIntensity);
        target.applyDebuff(defenseDebuff);

        System.out.println(caster.getName() + " casts Shadow Embrace on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + DAMAGE + " damage.");
        System.out.println(target.getName() + "'s defense has been weakened by " + defenseDebuffIntensity + ".");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
