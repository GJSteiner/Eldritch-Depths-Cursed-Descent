package Systems.EnemyCreators;

import Characters.Enemies.Floor2.AbyssElemental;
import Characters.Enemies.Floor2.VoidLeech;

public class AbyssElementalCreator extends EnemyCreator {
    public AbyssElemental create(String enemyName, int enemyLevel){
        enemyTags.add(tags.getWaterEnemy());
        enemyTags.add(tags.getElementalEnemy());
        enemyTags.add(tags.getAbyssEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(abyssalMaw);
        enemyAbilities.add(shadowEmbrace);

        if(enemyLevel == 2){
            enemyInventory.add(averagePotion);
            createArmor("Feet", 2);
            createArmor("Helmet", 2);
        }
        if(enemyLevel == 3){
            enemyInventory.add(averagePotion);
            createWeapon("BalancedWeapon", 2);
            createWeapon("StrengthOffHand", 2);
            createWeapon("MagicOffHand", 2);
            createWeapon("DefenseOffHand", 2);
        }
        if(enemyLevel == 4){
            enemyInventory.add(averagePotion);
            createWeapon("StrengthWeapon", 2);
            createWeapon("MagicWeapon", 2);
            createArmor("Chest", 2);
            createArmor("Legs", 2);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 10;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 5;
        boolean enemyAlive = true;

        AbyssElemental abyssElemental = new AbyssElemental(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives, enemyTags);
        return abyssElemental;
    }
}
