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
            createArmor("Helmet", 4);
            createArmor("Feet", 4);
        }
        if(enemyLevel == 7){
            enemyInventory.add(veryStrongPotion);
            createWeapon("BalancedWeapon", 4);
            createWeapon("StrengthOffHand", 4);
            createWeapon("MagicOffHand", 4);
            createWeapon("DefenseOffHand", 4);
        }
        if(enemyLevel == 8){
            enemyInventory.add(veryStrongPotion);
            createWeapon("StrengthWeapon", 4);
            createWeapon("MagicWeapon", 4);
            createArmor("Chest", 4);
            createArmor("Legs", 4);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 20;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 3;
        boolean enemyAlive = true;

        Hellhound hellhound = new Hellhound(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);

        return hellhound;
    }
}
