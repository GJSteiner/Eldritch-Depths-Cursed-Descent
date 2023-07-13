package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.EnemyAbilities.DarkBlast;
import Abilities.Enemies.EnemyAbilities.ImpFire;
import Abilities.Enemies.EnemyAbilities.ShadowStep;
import Characters.Enemies.Floor1.VoidImp;


public class VoidImpCreator extends EnemyCreator {

    public VoidImp create(String enemyName, int enemyLevel){
        enemyTags.add(tags.getVoidEnemy());
        enemyTags.add(tags.getImpEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);
        enemyAbilities.add(impFire);

        if(enemyLevel == 0){
            enemyInventory.add(weakPotion);
            enemyInventory.add(weakPotion);
            createArmor("Helmet", 1);
            createArmor("Feet", 1);
        }
        if(enemyLevel == 1){
            enemyInventory.add(weakPotion);
            createWeapon("BalancedWeapon", 1);
            createWeapon("StrengthOffHand", 1);
            createWeapon("MagicOffHand", 1);
            createWeapon("DefenseOffHand", 1);
        }
        if(enemyLevel == 2){
            enemyInventory.add(weakPotion);
            createWeapon("StrengthWeapon", 1);
            createWeapon("MagicWeapon", 1);
            createArmor("Chest", 1);
            createArmor("Legs", 1);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 10;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1);
        boolean enemyAlive = true;

        VoidImp voidImp = new VoidImp(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives, enemyTags);
        return voidImp;
    }

}
