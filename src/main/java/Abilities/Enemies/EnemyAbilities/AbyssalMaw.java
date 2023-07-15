package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.ShadowImpaler;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor2.VoidLeech;

import java.util.ArrayList;
import java.util.List;

public class AbyssalMaw extends Ability {
    private static final String NAME = "Abyssal Maw";
    private static final String DESCRIPTION = "Opens a portal to the depths of the void, summoning forth an eldritch creature to aid it in battle";
    private static final int LEVEL_REQUIREMENT = 4;
    private static final double DAMAGE = 0;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Summoning";



    public AbyssalMaw() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        VoidImp voidImp = new VoidImp();
        ShadowImpaler shadowImpaler = new ShadowImpaler();
        VoidLeech voidLeech = new VoidLeech();

        VoidImp imp = voidImp.level1Imp();
        ShadowImpaler impaler = shadowImpaler.level1Shadow();
        VoidLeech leech = voidLeech.level2Leech();

        List<Enemy> summons = getSummons();
        summons.add(imp);
        summons.add(impaler);
        summons.add(leech);

        System.out.println(caster.getName() + " casts " + NAME + " and summons an eldritch creature to join the fight");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }

}
