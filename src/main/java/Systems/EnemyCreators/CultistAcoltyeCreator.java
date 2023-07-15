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
            createArmor("Helmet", 4);
            createArmor("Feet", 4);
        }
        if(enemyLevel == 7){
            enemyInventory.add(strongPotion);
            createWeapon("BalancedWeapon", 4);
            createWeapon("StrengthOffHand", 4);
            createWeapon("MagicOffHand", 4);
            createWeapon("DefenseOffHand", 4);
        }
        if(enemyLevel == 8){
            enemyInventory.add(strongPotion);
            createWeapon("StrengthWeapon", 4);
            createWeapon("MagicWeapon", 4);
            createArmor("Chest", 4);
            createArmor("Legs", 4);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 10;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1);
        boolean enemyAlive = true;

        CultistAcolyte cultistAcolyte = new CultistAcolyte(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);

        return cultistAcolyte;
    }
}
