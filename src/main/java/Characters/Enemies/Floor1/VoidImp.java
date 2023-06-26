package Characters.Enemies.Floor1;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Character;
import Characters.Enemies.Enemy;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class VoidImp extends Enemy {
    private static final int XP_YIELD = 50;
    private static final String ENEMY_TYPE = "Void Imp";
    private static final String DESCRIPTION = "A small imp from the void realm.";
    private static final List<Ability> VOID_IMP_ABILITIES = new ArrayList<>();

    public VoidImp(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, VOID_IMP_ABILITIES, passives);
    }

    private void addAbilities(){

    }

}
