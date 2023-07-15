package Characters.Enemies.Floor5;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Item;
import Systems.EnemyCreators.AbyssKnightCreator;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class AbyssKnight extends Enemy {
    private static final int XP_YIELD = 35;
    private static final String ENEMY_TYPE = "Void Leech";
    private static final String DESCRIPTION = "A heavily armored knight wielding a massive, sinister blade that channels the corrupted waters of the abyss.";



    AbyssKnightCreator creator = new AbyssKnightCreator();

    public AbyssKnight() {
    }

    public List<String> setKnightTags() {
        List<String> knightTags = new ArrayList<>();
        knightTags.add(allTags.getAbyssEnemy());
        knightTags.add(allTags.getKnightEnemy());
        return knightTags;
    }

    public AbyssKnight(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setKnightTags());
    }

    public AbyssKnight level8Knight() {
        AbyssKnight abyssKnight = creator.create("Knight of Hell", 8);
        abyssKnight.addTag(allTags.getWeakEnemy());
        abyssKnight.addTag(allTags.getNormalEnemy());

        return abyssKnight;
    }

    public AbyssKnight level9Knight() {
        AbyssKnight abyssKnight = creator.create("Knight of the Abyss", 9);
        abyssKnight.addTag(allTags.getMediumEnemy());
        abyssKnight.addTag(allTags.getNormalEnemy());

        return abyssKnight;
    }

    public AbyssKnight level10Knight() {
        AbyssKnight abyssKnight = creator.create("Knight of the Void", 10);
        abyssKnight.addTag(allTags.getStrongEnemy());
        abyssKnight.addTag(allTags.getNormalEnemy());

        return abyssKnight;
    }

}