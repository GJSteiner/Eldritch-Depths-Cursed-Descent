package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.EnemyAbilities.DarkBlast;
import Abilities.Enemies.EnemyAbilities.ShadowStep;
import Characters.Enemies.Floor1.ShadowImpaler;

public class ShadowImpalerCreator extends EnemyCreator {



    public ShadowImpaler create(String enemyName, int enemyLevel){
        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);

        if (enemyLevel == 1){
            enemyInventory.add(weakPotion);
            enemyInventory.add(averagePotion);
            createArmor("Helmet", 1);
            createArmor("Feet", 1);
        }
        if (enemyLevel == 2){
            enemyInventory.add(averagePotion);
            createWeapon("BalancedWeapon", 1);
            createWeapon("StrengthOffHand", 1);
            createWeapon("MagicOffHand", 1);
            createWeapon("DefenseOffHand", 1);
        }
        if (enemyLevel == 3){

            enemyInventory.add(averagePotion);
            createWeapon("StrengthWeapon", 1);
            createWeapon("MagicWeapon", 1);
            createArmor("Chest", 1);
            createArmor("Legs", 1);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 7;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 2;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 2;
        boolean enemyAlive = true;

        ShadowImpaler shadowImpaler = new ShadowImpaler(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);
        return shadowImpaler;
    }

}
