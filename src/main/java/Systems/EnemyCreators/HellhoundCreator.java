package Systems.EnemyCreators;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor4.Hellhound;

public class HellhoundCreator extends EnemyCreator{
    @Override
    public Hellhound create(String enemyName, int enemyLevel) {
        enemyAbilities.add(voidFire);
        enemyAbilities.add(viciousBite);
        enemyAbilities.add(hellBlitz);

        if(enemyLevel == 6){
            enemyInventory.add(veryStrongPotion);
            enemyInventory.add(veryStrongPotion);
            createArmor("Helmet", 5);
            createArmor("Feet", 5);
        }
        if(enemyLevel == 7){
            enemyInventory.add(veryStrongPotion);
            createWeapon("BalancedWeapon", 5);
            createWeapon("StrengthOffHand", 5);
            createWeapon("MagicOffHand", 5);
            createWeapon("DefenseOffHand", 5);
        }
        if(enemyLevel == 8){
            enemyInventory.add(veryStrongPotion);
            createWeapon("StrengthWeapon", 5);
            createWeapon("MagicWeapon", 5);
            createArmor("Chest", 5);
            createArmor("Legs", 5);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 10;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1);
        boolean enemyAlive = true;

        Hellhound hellhound = new Hellhound(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);

        return hellhound;
    }
}
