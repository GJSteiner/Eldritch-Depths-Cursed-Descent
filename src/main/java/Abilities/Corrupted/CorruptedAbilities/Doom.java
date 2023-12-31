package Abilities.Corrupted.CorruptedAbilities;

import Abilities.Corrupted.CorruptedAbility;
import Characters.Character;
import Characters.Enemies.Enemy;
import Systems.DamageOverTime;

import java.util.List;

public class Doom extends CorruptedAbility {
    private static final String NAME = "Doom";
    private static final String DESCRIPTION = "Deals .5 strength each round.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 0;
    private static final double strengthMultiplier = 0.5;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    private static final int DOT_ROUNDS = 5;
    private static final boolean STACKING = false;
    private static final String ABILITY_ELEMENT = "Void";
    private static final String DOT_ELEMENT = "Curse";

    // don't need DOT in the constructor because all Corrupted abilities are Dot abilities, so that was set in the parent class
    public Doom() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        checkEmpoweredCurses(caster, target);
        checkSiphoningCurses(caster, target);

        double totalDamage = Math.round(caster.getStrength() * strengthMultiplier);

        DamageOverTime doomCurse = new DamageOverTime("Shadow Strike Curse", totalDamage, DOT_ROUNDS, DOT_ELEMENT, STACKING);
        doomCurse.setStacking(STACKING);


        DamageOverTime existingDot = target.getExistingDamageOverTimeEffect(doomCurse.getDotName());
        if (existingDot != null && existingDot.isStacking()) {
            System.out.println(target.getName() + " already has " + doomCurse.getDotName() +
                    " active. Current intensity: " + existingDot.getDamagePerRound());
        }
        // guaranteed damage
//        target.takeDamage(totalDamage);
        // dot application
        target.applyDamageOverTime(doomCurse.getDotName(), doomCurse.getDamagePerRound(), doomCurse.getRemainingRounds(), doomCurse.getElement(), STACKING);

        System.out.println(caster.getName() + " strikes with " + NAME + "!");
//        System.out.println(caster.getName() + " deals " + totalDamage + " damage.");
        System.out.println(caster.getName() + " curses " + target.getName() +".");


        DamageOverTime updatedDot = target.getExistingDamageOverTimeEffect(doomCurse.getDotName());
        if(existingDot != null && existingDot.isStacking()) {
            System.out.println(doomCurse.getDotName() + " is now doing " + updatedDot.getDamagePerRound() + " damage per round.");
        }
        else if (existingDot != null){
            System.out.println(doomCurse.getDotName() + " has " + updatedDot.getRemainingRounds() + " rounds remaining");
        }
        else {
            System.out.println("The target is taking " + doomCurse.getDamagePerRound() +
                    " damage each round for " + DOT_ROUNDS + " rounds.");
        }

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
