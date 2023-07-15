package Characters.Enemies.Floor4;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.VoidScuttlerCreator;

import java.util.ArrayList;
import java.util.List;

public class VoidScuttler extends Enemy {
    private static final int XP_YIELD = 30;
    private static final String ENEMY_TYPE = "Abyss Scuttler";
    private static final String DESCRIPTION = "A monstrous arachnid with razor-sharp fangs and venomous stingers.";


    VoidScuttlerCreator creator = new VoidScuttlerCreator();

    public VoidScuttler() {
    }

    public List<String> setSpiderTags() {
        List<String> spiderTags = new ArrayList<>();
        spiderTags.add(allTags.getBeastEnemy());
        spiderTags.add(allTags.getSpiderEnemy());
        return spiderTags;
    }

    public VoidScuttler(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setSpiderTags());
    }

    public VoidScuttler level6Spider() {
        VoidScuttler voidScuttler = creator.create("Scuttler Hatchling", 6);
        voidScuttler.addTag(allTags.getWeakEnemy());
        voidScuttler.addTag(allTags.getNormalEnemy());

        return voidScuttler;
    }

    public VoidScuttler level7Spider() {
        VoidScuttler voidScuttler = creator.create("Mature Scuttler", 7);
        voidScuttler.addTag(allTags.getMediumEnemy());
        voidScuttler.addTag(allTags.getNormalEnemy());

        return voidScuttler;
    }

    public VoidScuttler level8Spider() {
        VoidScuttler voidScuttler = creator.create("Scuttler Broodmother", 8);
        voidScuttler.addTag(allTags.getStrongEnemy());
        voidScuttler.addTag(allTags.getNormalEnemy());

        return voidScuttler;
    }

}