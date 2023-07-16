package Dungeons.Floors.FourthFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Characters.Enemies.Floor3.CultistAcolyte;
import Characters.Enemies.Floor3.CultistSummoner;
import Characters.Enemies.Floor4.Hellhound;
import Characters.Enemies.Floor4.VoidScuttler;
import Dungeons.Floors.FloorLayout;
import Dungeons.Rooms.*;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.XlHealthPotion;
import Items.Consumables.Potions.XxlHealthPotion;
import Items.Equipment.EquipableItem;
import Items.Item;
import Systems.Direction;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class FourthFloorLayout extends FloorLayout {
    public FourthFloorLayout() {
    }

    @Override
    protected void generateLayout() {
        EnemyTags enemyTags = new EnemyTags();

        layout.clear();

        // Creating enemies for the floor
        /// enemyRoom1 enemies:
        Hellhound enemy1 =  hellhound.level6Hellhound();
        Hellhound enemy2 =  hellhound.level6Hellhound();

        List<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(enemy1);
        room1Enemies.add(enemy2);

        setNamesForMultipleEnemies(room1Enemies);

        /// enemyRoom2 enemies:
        Hellhound enemy3 =  hellhound.level6Hellhound();
        Hellhound enemy4 =  hellhound.level6Hellhound();

        List<Enemy> room2Enemies = new ArrayList<>();

        room2Enemies.add(enemy3);
        room2Enemies.add(enemy4);

        setNamesForMultipleEnemies(room2Enemies);

        /// enemyRoom3 enemies:
        VoidScuttler enemy5 = voidScuttler.level6Spider();
        VoidScuttler enemy6 = voidScuttler.level6Spider();
        VoidScuttler enemy7 = voidScuttler.level6Spider();
        VoidScuttler enemy8 = voidScuttler.level6Spider();
        VoidScuttler enemy9 = voidScuttler.level7Spider();


        List<Enemy> room3Enemies = new ArrayList<>();

        room3Enemies.add(enemy5);
        room3Enemies.add(enemy6);
        room3Enemies.add(enemy7);
        room3Enemies.add(enemy8);
        room3Enemies.add(enemy9);

        setNamesForMultipleEnemies(room3Enemies);

        /// enemyRoom4 enemies:
        Hellhound enemy10 =  hellhound.level7Hellhound();
        Hellhound enemy11 =  hellhound.level8Hellhound();

        List<Enemy> room4Enemies = new ArrayList<>();

        room4Enemies.add(enemy10);
        room4Enemies.add(enemy11);

        setNamesForMultipleEnemies(room4Enemies);

        /// enemyRoom5 enemies:
//        CultistAcolyte enemy10 = cultistAcolyte.level6Acolyte();
//        CultistAcolyte enemy11 = cultistAcolyte.level6Acolyte();
//
//        List<Enemy> room5Enemies = new ArrayList<>();
//
//        room4Enemies.add(enemy10);
//        room4Enemies.add(enemy11);
//
//        setNamesForMultipleEnemies(room5Enemies);

        /// bossRoom enemies:
        VoidScuttler bossEnemy = voidScuttler.level8Spider();

        bossEnemy.removeTag(enemyTags.getNormalEnemy());
        bossEnemy.addTag(enemyTags.getBossEnemy());

        List<Enemy> bossRoomEnemies = new ArrayList<>();

        VoidScuttler bossRoomAdd1 = voidScuttler.level6Spider();
        VoidScuttler bossRoomAdd2 = voidScuttler.level6Spider();
        VoidScuttler bossRoomAdd3 = voidScuttler.level6Spider();

        bossRoomEnemies.add(bossRoomAdd1);
        bossRoomEnemies.add(bossRoomAdd2);
        bossRoomEnemies.add(bossRoomAdd3);

        setNamesForMultipleEnemies(bossRoomEnemies);

        // Treasure(items available for pickup, rather than defeating enemies)

        XlHealthPotion xlHealthPotion1 = new XlHealthPotion();
        XlHealthPotion xlHealthPotion2 = new XlHealthPotion();
        XlHealthPotion xlHealthPotion3 = new XlHealthPotion();
        XxlHealthPotion xxlHealthPotion = new XxlHealthPotion();
        EquipableItem balancedStarterWeapon = weaponList.getByTypeAndTier("Balance Weapon", 4);


        List<Item> treasure = new ArrayList<>();
        treasure.add(xlHealthPotion1);
        treasure.add(xlHealthPotion2);
        treasure.add(xlHealthPotion3);
        treasure.add(xxlHealthPotion);


        // Creating the rooms for the floor
        Room startingRoom = new StartingRoom("Fourth Floor Starting Room", "The first room of the fourth floor.");
        Room enemyRoom1 = new EnemyRoom("Enemy Room 1", "A room with a cultist altar at its center.", room1Enemies);
        Room enemyRoom2 = new EnemyRoom("Enemy Room 2", "A small room with a shrine to an eldritch horror against the side wall.", room2Enemies);
        Room enemyRoom3 = new EnemyRoom("Enemy Room 3", "A large room that seems to be the main congregation of the Abyssal Cult.", room3Enemies);
        Room treasureRoom = new TreasureRoom("Treasure Room", "A small room with a shining chest in the middle.", treasure);
        Room enemyRoom4 = new EnemyRoom("Enemy Room 4", "A spacious room that seems to have been the site of a failed, profane ritual.", room4Enemies);
        Room enemyRoom5 = new EnemyRoom("Enemy Room 5", "A narrow hallway with large, ornate double doors at one end.", room5Enemies);
        Room bossRoom = new BossRoom("Boss Room", "A large chamber housing the cult's elite and recently summoned denizens of the Abyss.", bossEnemy, bossRoomEnemies);

        // Connecting the rooms

        startingRoom.addExit(enemyRoom1, Direction.WEST);
        enemyRoom1.addExit(startingRoom, Direction.EAST);
        enemyRoom1.addExit(enemyRoom2, Direction.SOUTH);
        enemyRoom2.addExit(enemyRoom1, Direction.NORTH);
        enemyRoom2.addExit(enemyRoom3, Direction.SOUTH);
        enemyRoom3.addExit(enemyRoom2, Direction.NORTH);
        enemyRoom3.addExit(enemyRoom4, Direction.WEST);
        enemyRoom3.addExit(treasureRoom, Direction.EAST);
        treasureRoom.addExit(enemyRoom3, Direction.WEST);
        enemyRoom4.addExit(enemyRoom3, Direction.EAST);
        enemyRoom4.addExit(enemyRoom5, Direction.WEST);
        enemyRoom5.addExit(enemyRoom4, Direction.EAST);
        enemyRoom5.addExit(bossRoom, Direction.WEST);
        bossRoom.addExit(enemyRoom5, Direction.EAST);

        // Adding the rooms to the layout list
        addRoom(startingRoom);
        addRoom(enemyRoom1);
        addRoom(enemyRoom2);
        addRoom(enemyRoom3);
        addRoom(treasureRoom);
        addRoom(enemyRoom4);
        addRoom(enemyRoom5);
        addRoom(bossRoom);

        bossRoom.setEndRoom(true);

    }
    @Override
    public void addNextFloorExit() {
        int lastIndex = getLayout().size()-1;

        Room nextFloorStartingRoom = getNextFloorLayout().getStartingRoom();
        Room bossRoom = this.getLayout().get(lastIndex);
        bossRoom.addExit(nextFloorStartingRoom, Direction.EAST);
        nextFloorStartingRoom.addExit(bossRoom, Direction.WEST);

    }
}
