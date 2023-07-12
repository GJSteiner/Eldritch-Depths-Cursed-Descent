package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.EnemyAbilities.DarkBlast;
import Abilities.Enemies.EnemyAbilities.VoidDrain;
import Abilities.Enemies.EnemyAbilities.VoidSiphon;
import Abilities.Enemies.EnemyAbilities.VoidSiphon;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Equipment.Armors.*;
import Items.Equipment.Weapons.*;

public class VoidLeechCreator extends EnemyCreator {

    public VoidLeech create(String enemyName, int enemyLevel){
        enemyTags.add(tags.getVoidEnemy());
        enemyTags.add(tags.getLeechEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(voidSiphon);
        enemyAbilities.add(voidDrain);

        enemyPassives.add(expunge);

        if(enemyLevel == 0){
            enemyInventory.add(averagePotion);
            createArmor("Feet", 2);
            createArmor("Helmet", 2);
        }
        if(enemyLevel == 1){
            enemyInventory.add(averagePotion);
            createWeapon("BalancedWeapon", 2);
            createWeapon("StrengthOffHand", 2);
            createWeapon("MagicOffHand", 2);
            createWeapon("DefenseOffHand", 2);
        }
        if(enemyLevel == 2){
            enemyInventory.add(averagePotion);
            createWeapon("StrengthWeapon", 2);
            createWeapon("MagicWeapon", 2);
            createArmor("Chest", 2);
            createArmor("Legs", 2);
        }

        int enemyMaxHealth = (enemyLevel + 1) * 8;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 4;
        int enemyStrength = (enemyLevel + 1) * 3;
        int enemyDefense = (enemyLevel + 1) * 3;
        boolean enemyAlive = true;

        VoidLeech voidLeech = new VoidLeech(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives, enemyTags);
        return voidLeech;
    }

}