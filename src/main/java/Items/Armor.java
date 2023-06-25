package Items;

public class Armor extends Item{
    private int defense;
    private int health;

    public Armor(String name, String description, int defense, int health) {
        super(name, description);

        this.defense = defense;
        this.health = health;
    }
    //inherited from super
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }
}