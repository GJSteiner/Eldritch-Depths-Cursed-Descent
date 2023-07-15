package Characters.Enemies.Floor3;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Item;
import Systems.EnemyCreators.CultistAcoltyeCreator;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class CultistAcolyte extends Enemy {
    private static final int XP_YIELD = 25;
    private static final String ENEMY_TYPE = "Cultist Acolyte";
    private static final String DESCRIPTION = "A fanatical cultist adept in the dark magics of the void.";



    CultistAcoltyeCreator creator = new CultistAcoltyeCreator();

    public CultistAcolyte() {
    }

    public List<String> setAcolyteTags() {
        List<String> acolyteTags = new ArrayList<>();
        acolyteTags.add(allTags.getCultistEnemy());
        acolyteTags.add(allTags.getCasterEnemy());
        return acolyteTags;
    }

    public CultistAcolyte(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setAcolyteTags());
    }

    public CultistAcolyte level4Acolyte() {
        CultistAcolyte cultistAcolyte = creator.create("Acolyte Initiate", 4);
        cultistAcolyte.addTag(allTags.getWeakEnemy());
        cultistAcolyte.addTag(allTags.getNormalEnemy());

        return cultistAcolyte;
    }

    public CultistAcolyte level5Acolyte() {
        CultistAcolyte cultistAcolyte = creator.create("Acolyte Adept", 5);
        cultistAcolyte.addTag(allTags.getMediumEnemy());
        cultistAcolyte.addTag(allTags.getNormalEnemy());

        return cultistAcolyte;
    }

    public CultistAcolyte level6Acolyte() {
        CultistAcolyte cultistAcolyte = creator.create("Acolyte Ascendant", 6);
        cultistAcolyte.addTag(allTags.getStrongEnemy());
        cultistAcolyte.addTag(allTags.getNormalEnemy());

        return cultistAcolyte;
    }

}