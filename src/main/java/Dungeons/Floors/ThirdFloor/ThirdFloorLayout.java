package Dungeons.Floors.ThirdFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.AbyssElemental;
import Characters.Enemies.Floor2.VoidLeech;
import Characters.Enemies.Floor3.CultistAcolyte;
import Characters.Enemies.Floor3.CultistSummoner;
import Characters.Enemies.Floor4.Hellhound;
import Dungeons.Dungeon;
import Dungeons.Floors.FloorLayout;
import Dungeons.Rooms.*;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.XlHealthPotion;
import Items.Equipment.EquipableItem;
import Items.Item;
import Systems.Direction;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class ThirdFloorLayout extends FloorLayout{
    public ThirdFloorLayout() {
    }

    @Override
    protected void generateLayout() {
        EnemyTags enemyTags = new EnemyTags();

        layout.clear();

        // Creating enemies for the floor
        /// enemyRoom1 enemies:
        CultistAcolyte enemy1 =  cultistAcolyte.level4Acolyte();

        List<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(enemy1);

        /// enemyRoom2 enemies:
        CultistAcolyte enemy2 =  cultistAcolyte.level4Acolyte();

        List<Enemy> room2Enemies = new ArrayList<>();

        room2Enemies.add(enemy2);

        /// enemyRoom3 enemies:
        CultistAcolyte enemy3 = cultistAcolyte.level5Acolyte();
        CultistAcolyte enemy4 = cultistAcolyte.level5Acolyte();
        CultistAcolyte enemy5 = cultistAcolyte.level5Acolyte();
        CultistAcolyte enemy6 = cultistAcolyte.level5Acolyte();
        CultistAcolyte enemy7 = cultistAcolyte.level5Acolyte();

        List<Enemy> room3Enemies = new ArrayList<>();

        room3Enemies.add(enemy3);
        room3Enemies.add(enemy4);
        room3Enemies.add(enemy5);
        room3Enemies.add(enemy6);
        room3Enemies.add(enemy7);

        setNamesForMultipleEnemies(room3Enemies);

        /// enemyRoom4 enemies:
        CultistAcolyte enemy8 = cultistAcolyte.level5Acolyte();
        CultistAcolyte enemy9 = cultistAcolyte.level5Acolyte();

        List<Enemy> room4Enemies = new ArrayList<>();

        room4Enemies.add(enemy8);
        room4Enemies.add(enemy9);

        setNamesForMultipleEnemies(room4Enemies);

        /// enemyRoom5 enemies:
        CultistAcolyte enemy10 = cultistAcolyte.level6Acolyte();
        CultistAcolyte enemy11 = cultistAcolyte.level6Acolyte();

        List<Enemy> room5Enemies = new ArrayList<>();

        room4Enemies.add(enemy10);
        room4Enemies.add(enemy11);

        setNamesForMultipleEnemies(room5Enemies);

        /// bossRoom enemies:
        CultistSummoner bossEnemy = cultistSummoner.level6Summoner();

        bossEnemy.removeTag(enemyTags.getNormalEnemy());
        bossEnemy.addTag(enemyTags.getBossEnemy());

        List<Enemy> bossRoomEnemies = new ArrayList<>();

        Hellhound bossRoomAdd1 = hellhound.level6Hellhound();
        Hellhound bossRoomAdd2 = hellhound.level6Hellhound();

        bossRoomEnemies.add(bossRoomAdd1);
        bossRoomEnemies.add(bossRoomAdd2);

        setNamesForMultipleEnemies(bossRoomEnemies);

        // Treasure(items available for pickup, rather than defeating enemies)
        LargeHealthPotion largePotion1 = new LargeHealthPotion();
        LargeHealthPotion largePotion2 = new LargeHealthPotion();
        LargeHealthPotion largePotion3 = new LargeHealthPotion();
        XlHealthPotion xlHealthPotion = new XlHealthPotion();
        EquipableItem balancedStarterWeapon = weaponList.getByTypeAndTier("Balance Weapon", 3);


        List<Item> treasure = new ArrayList<>();
        treasure.add(largePotion1);
        treasure.add(largePotion2);
        treasure.add(largePotion3);
        treasure.add(xlHealthPotion);
        treasure.add(balancedStarterWeapon);


        // Creating the rooms for the floor
        Room startingRoom = new StartingRoom("Third Floor Starting Room", "The first room of the third floor.");
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
        bossRoom.addExit(nextFloorStartingRoom, Direction.WEST);
        nextFloorStartingRoom.addExit(bossRoom, Direction.EAST);

    }

}
