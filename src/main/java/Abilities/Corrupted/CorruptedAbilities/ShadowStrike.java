package Abilities.Corrupted.CorruptedAbilities;

import Abilities.Corrupted.CorruptedAbility;
import Characters.Character;
import Characters.Enemies.Enemy;
import Systems.DamageOverTime;

import java.util.List;

public class ShadowStrike extends CorruptedAbility {

    private static final String NAME = "Shadow Strike";
    private static final String DESCRIPTION = "Deals .2 strength each round, stacking";
    private static final int LEVEL_REQUIREMENT = 0;
    private static final double DAMAGE = 0;
    private static final double strengthMultiplier = 0.2;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    private static final int DOT_ROUNDS = 3;
    private static final boolean STACKING = true;
    private static final String ABILITY_ELEMENT = "Shadow";
    private static final String DOT_ELEMENT = "Curse";

    // don't need DOT in the constructor because all Corrupted abilities are Dot abilities, so that was set in the parent class
    public ShadowStrike() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {

        checkEmpoweredCurses(caster, target);
        checkSiphoningCurses(caster, target);

        double totalDamage = Math.round(caster.getStrength() * strengthMultiplier);

        DamageOverTime shadowStrikeCurse = new DamageOverTime("Shadow Strike Curse", totalDamage, DOT_ROUNDS, DOT_ELEMENT, STACKING);
        shadowStrikeCurse.setStacking(STACKING);


        DamageOverTime existingDot = target.getExistingDamageOverTimeEffect(shadowStrikeCurse.getDotName());
        if (existingDot != null && existingDot.isStacking()) {
            System.out.println(target.getName() + " already has " + shadowStrikeCurse.getDotName() +
                    " active. Current intensity: " + existingDot.getDamagePerRound());
        }
        // guaranteed damage
        target.takeDamage(totalDamage);
        // dot application
        target.applyDamageOverTime(shadowStrikeCurse.getDotName(), shadowStrikeCurse.getDamagePerRound(), shadowStrikeCurse.getRemainingRounds(), shadowStrikeCurse.getElement(), STACKING);

        System.out.println(caster.getName() + " strikes with " + NAME + "!");
        System.out.println(caster.getName() + " deals " + totalDamage + " damage.");
        System.out.println(caster.getName() + " curses " + target.getName() +".");


        DamageOverTime updatedDot = target.getExistingDamageOverTimeEffect(shadowStrikeCurse.getDotName());
        if(existingDot != null && existingDot.isStacking()) {
            System.out.println(shadowStrikeCurse.getDotName() + " is now doing " + updatedDot.getDamagePerRound() + " damage per round.");
        }
        else if (existingDot != null){
            System.out.println(shadowStrikeCurse.getDotName() + " has " + updatedDot.getRemainingRounds() + " rounds remaining");
        }
        else {
            System.out.println("The target is taking " + shadowStrikeCurse.getDamagePerRound() +
                    " damage each round for " + DOT_ROUNDS + " rounds.");
        }

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
