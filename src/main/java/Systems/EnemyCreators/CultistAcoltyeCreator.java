package Systems.EnemyCreators;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor3.CultistAcolyte;
import Characters.Enemies.Floor3.CultistSummoner;

public class CultistAcoltyeCreator extends EnemyCreator{
    @Override
    public CultistAcolyte create(String enemyName, int enemyLevel) {
        enemyAbilities.add(darkBlast);
        enemyAbilities.add(voidFire);
        enemyAbilities.add(voidDrain);

        if(enemyLevel == 6){
            enemyInventory.add(strongPotion);
            enemyInventory.add(strongPotion);
            createArmor("Helmet", 3);
            createArmor("Feet", 3);
        }
        if(enemyLevel == 7){
            enemyInventory.add(strongPotion);
            createWeapon("BalancedWeapon", 3);
            createWeapon("StrengthOffHand", 3);
            createWeapon("MagicOffHand", 3);
            createWeapon("DefenseOffHand", 3);
        }
        if(enemyLevel == 8){
            enemyInventory.add(strongPotion);
            createWeapon("StrengthWeapon", 3);
            createWeapon("MagicWeapon", 3);
            createArmor("Chest", 3);
            createArmor("Legs", 3);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 20;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 4;
        boolean enemyAlive = true;

        CultistAcolyte cultistAcolyte = new CultistAcolyte(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);

        return cultistAcolyte;
    }
}
