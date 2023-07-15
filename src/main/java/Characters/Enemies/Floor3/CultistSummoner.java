package Characters.Enemies.Floor3;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Item;
import Systems.EnemyCreators.CultistSummonerCreator;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class CultistSummoner extends Enemy {
    private static final int XP_YIELD = 25;
    private static final String ENEMY_TYPE = "Cultist Summoner";
    private static final String DESCRIPTION = "A fanatical cultist adept in dark rituals and summoning forbidden creatures.";

    CultistSummonerCreator creator = new CultistSummonerCreator();

    public CultistSummoner() {
    }

    public List<String> setSummonerTags() {
        List<String> summonerTags = new ArrayList<>();
        summonerTags.add(allTags.getSummonerEnemy());
        summonerTags.add(allTags.getCultistEnemy());
        return summonerTags;
    }

    public CultistSummoner(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setSummonerTags());
    }

    public CultistSummoner level4Summoner() {
        CultistSummoner cultistSummoner = creator.create("Summoner Trainee", 4);
        cultistSummoner.addTag(allTags.getWeakEnemy());
        cultistSummoner.addTag(allTags.getNormalEnemy());

        return cultistSummoner;
    }

    public CultistSummoner level5Summoner() {
        CultistSummoner cultistSummoner = creator.create("Summoner Adept", 5);
        cultistSummoner.addTag(allTags.getMediumEnemy());
        cultistSummoner.addTag(allTags.getNormalEnemy());

        return cultistSummoner;
    }

    public CultistSummoner level6Summoner() {
        CultistSummoner cultistSummoner = creator.create("Summoner Master", 6);
        cultistSummoner.addTag(allTags.getStrongEnemy());
        cultistSummoner.addTag(allTags.getNormalEnemy());

        return cultistSummoner;
    }

}