package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Items.Item;

import java.util.ArrayList;
import java.util.List;


public class VoidImpCreator {

    List<Item> enemyInventory = new ArrayList<>();  // Assuming you have an inventory of items for the enemy
    List<Ability> enemyAbilities = new ArrayList<>();  // Assuming you have a list of abilities for the enemy
    List<Passive> enemyPassives = new ArrayList<>();  // Assuming you have a list of passives for the enemy


    public Enemy create(String enemyName, int enemyLevel){

        int enemyMaxHealth = enemyLevel + 50;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 2;
        boolean enemyAlive = true;

        Enemy voidImp = new VoidImp(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);
        return voidImp;
    }

}
