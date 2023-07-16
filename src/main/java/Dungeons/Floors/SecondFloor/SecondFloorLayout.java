package Dungeons.Floors.SecondFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor2.AbyssElemental;
import Characters.Enemies.Floor2.VoidLeech;
import Dungeons.Dungeon;
import Dungeons.Floors.FloorLayout;
import Dungeons.Rooms.*;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.SmallHealthPotion;
import Items.Equipment.EquipableItem;
import Items.Item;
import Systems.Direction;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class SecondFloorLayout extends FloorLayout {

    public SecondFloorLayout() {
    }

    @Override
    protected void generateLayout() {
        EnemyTags enemyTags = new EnemyTags();

        layout.clear();

        // Creating enemies for the floor
        /// enemyRoom1 enemies:
        VoidLeech enemy1 = voidLeech.level2Leech();

        List<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(enemy1);

        /// enemyRoom2 enemies:
        VoidLeech enemy2 = voidLeech.level2Leech();

        List<Enemy> room2Enemies = new ArrayList<>();

        room2Enemies.add(enemy2);

        /// enemyRoom3 enemies:
        VoidLeech enemy3 = voidLeech.level3Leech();
        VoidLeech enemy4 = voidLeech.level3Leech();
        VoidLeech enemy5 = voidLeech.level3Leech();
        VoidLeech enemy6 = voidLeech.level3Leech();

        List<Enemy> room3Enemies = new ArrayList<>();

        room3Enemies.add(enemy3);
        room3Enemies.add(enemy4);
        room3Enemies.add(enemy5);
        room3Enemies.add(enemy6);

        setNamesForMultipleEnemies(room3Enemies);

        /// enemyRoom4 enemies:
        AbyssElemental enemy7 = abyssElemental.level3Abyss();
        AbyssElemental enemy8 = abyssElemental.level3Abyss();

        List<Enemy> room4Enemies = new ArrayList<>();

        room4Enemies.add(enemy7);
        room4Enemies.add(enemy8);

        setNamesForMultipleEnemies(room4Enemies);

        /// bossRoom enemies:
        AbyssElemental bossEnemy = abyssElemental.level4Abyss();

        bossEnemy.removeTag(enemyTags.getNormalEnemy());
        bossEnemy.addTag(enemyTags.getBossEnemy());

        List<Enemy> bossRoomEnemies = new ArrayList<>();

        VoidLeech bossRoomAdd1 = voidLeech.level4Leech();

        bossRoomEnemies.add(bossRoomAdd1);


        // Treasure(items available for pickup, rather than defeating enemies)
        MediumHealthPotion mediumPotion1 = new MediumHealthPotion();
        MediumHealthPotion mediumPotion2 = new MediumHealthPotion();
        MediumHealthPotion mediumPotion3 = new MediumHealthPotion();
        LargeHealthPotion largePotion1 = new LargeHealthPotion();
        EquipableItem balancedStarterWeapon = weaponList.getByTypeAndTier("Balance Weapon", 2);



        List<Item> treasure = new ArrayList<>();
        treasure.add(mediumPotion1);
        treasure.add(mediumPotion2);
        treasure.add(mediumPotion3);
        treasure.add(largePotion1);
//        treasure.add(largePotion1);


        // Creating the rooms for the floor
        Room startingRoom = new StartingRoom("Second Floor Starting Room", "The first room of the second floor.");
        Room enemyRoom1 = new EnemyRoom("Enemy Room 1", "A room filled with an unknown sense of unease.", room1Enemies);
        Room enemyRoom2 = new EnemyRoom("Enemy Room 2", "A small room with various benign void critters scurrying about.", room2Enemies);
        Room enemyRoom3 = new EnemyRoom("Enemy Room 3", "A large room that seems to be a void leech hatchery.", room3Enemies);
        Room treasureRoom = new TreasureRoom("Treasure Room", "A small room with a chest in the corner, covered in void tendrils.", treasure);
        Room enemyRoom4 = new EnemyRoom("Enemy Room 4", "The room reeks of the abyss' miasma.", room4Enemies);
        Room bossRoom = new BossRoom("Boss Room", "A large chamber exuding a strong and intimidating presence.", bossEnemy, bossRoomEnemies);

        // Connecting the rooms

        startingRoom.addExit(enemyRoom1, Direction.SOUTH);
        enemyRoom1.addExit(startingRoom, Direction.NORTH);
        enemyRoom1.addExit(enemyRoom2, Direction.WEST);
        enemyRoom2.addExit(enemyRoom1, Direction.EAST);
        enemyRoom2.addExit(enemyRoom3, Direction.WEST);
        enemyRoom3.addExit(enemyRoom2, Direction.EAST);
        enemyRoom3.addExit(treasureRoom, Direction.SOUTH);
        treasureRoom.addExit(enemyRoom3, Direction.NORTH);
        treasureRoom.addExit(enemyRoom4, Direction.WEST);
        treasureRoom.addExit(bossRoom, Direction.SOUTH);
        bossRoom.addExit(treasureRoom, Direction.NORTH);

        // Adding the rooms to the layout list
        addRoom(startingRoom);
        addRoom(enemyRoom1);
        addRoom(enemyRoom2);
        addRoom(enemyRoom3);
        addRoom(treasureRoom);
        addRoom(enemyRoom4);
        addRoom(bossRoom);

        bossRoom.setEndRoom(true);

    }

    @Override
    public void addNextFloorExit() {
        int lastIndex = getLayout().size()-1;

        Room nextFloorStartingRoom = getNextFloorLayout().getStartingRoom();
        Room bossRoom = this.getLayout().get(lastIndex);
        bossRoom.addExit(nextFloorStartingRoom, Direction.SOUTH);
        nextFloorStartingRoom.addExit(bossRoom, Direction.NORTH);

    }


}
