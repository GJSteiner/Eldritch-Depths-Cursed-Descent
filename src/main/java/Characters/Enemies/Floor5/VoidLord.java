package Characters.Enemies.Floor5;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Item;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyCreators.VoidLordCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class VoidLord extends Enemy {
    private static final int XP_YIELD = 35;
    private static final String ENEMY_TYPE = "Void Lord";
    private static final String DESCRIPTION = "A powerful demonic entity that harnesses the void's energy.";

    VoidLordCreator creator = new VoidLordCreator();

    public VoidLord() {
    }

    public List<String> setLordTags() {
        List<String> lordTags = new ArrayList<>();
        lordTags.add(allTags.getVoidEnemy());
        lordTags.add(allTags.getChampionEnemy());
        return lordTags;
    }

    public VoidLord(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setLordTags());
    }

    public VoidLord level8Lord() {
        VoidLord voidLord = creator.create("Void Lord", 8);
        voidLord.addTag(allTags.getWeakEnemy());
        voidLord.addTag(allTags.getNormalEnemy());

        return voidLord;
    }

    public VoidLord level9Lord() {
        VoidLord voidLord = creator.create("Void Viscount", 9);
        voidLord.addTag(allTags.getMediumEnemy());
        voidLord.addTag(allTags.getNormalEnemy());

        return voidLord;
    }

    public VoidLord level10Lord() {
        VoidLord voidLord = creator.create("Void King", 10);
        voidLord.addTag(allTags.getStrongEnemy());
        voidLord.addTag(allTags.getNormalEnemy());

        return voidLord;
    }

}