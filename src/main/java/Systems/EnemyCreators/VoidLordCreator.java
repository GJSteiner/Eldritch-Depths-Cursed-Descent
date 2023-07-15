package Systems.EnemyCreators;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor5.AbyssKnight;
import Characters.Enemies.Floor5.VoidLord;

public class VoidLordCreator extends EnemyCreator{
    @Override
    public VoidLord create(String enemyName, int enemyLevel) {
        enemyAbilities.add(voidSiphon);
        enemyAbilities.add(voidSlash);
        enemyPassives.add(callOfTheVoid);

        if(enemyLevel == 6){
            enemyInventory.add(extremelyStrongPotion);
            enemyInventory.add(extremelyStrongPotion);
            createArmor("Helmet", 5);
            createArmor("Feet", 5);
        }
        if(enemyLevel == 7){
            enemyInventory.add(extremelyStrongPotion);
            createWeapon("BalancedWeapon", 5);
            createWeapon("StrengthOffHand", 5);
            createWeapon("MagicOffHand", 5);
            createWeapon("DefenseOffHand", 5);
        }
        if(enemyLevel == 8){
            enemyInventory.add(extremelyStrongPotion);
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

        VoidLord voidLord = new VoidLord(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);

        return voidLord;
    }
}
