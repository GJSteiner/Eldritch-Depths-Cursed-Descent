package Dungeons.Floors.FirstFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.ShadowImpaler;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor5.AbyssKnight;
import Characters.Enemies.Floor5.VoidLord;
import Dungeons.Floors.FloorLayout;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.SmallHealthPotion;
import Items.Equipment.EquipableItem;
import Items.Item;
import Dungeons.Rooms.*;
import Systems.Direction;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;


public class FirstFloorLayout extends FloorLayout {

    public FirstFloorLayout() {
    }

    @Override
    protected void generateLayout() {
        setFloorIndex(1);
        EnemyTags enemyTags = new EnemyTags();

        layout.clear();

        // Creating enemies for the floor
        /// enemyRoom1 enemies:
        VoidImp enemy1 = voidImp.level0Imp();

        List<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(enemy1);

        /// enemyRoom2 enemies:
        VoidImp enemy2 = voidImp.level1Imp();

        List<Enemy> room2Enemies = new ArrayList<>();

        room2Enemies.add(enemy2);

        /// enemyRoom3 enemies:

        VoidImp enemy3 = voidImp.level1Imp();
        VoidImp enemy4 = voidImp.level1Imp();
        ShadowImpaler enemy5 = shadowImpaler.level1Shadow();

        List<Enemy> room3Enemies = new ArrayList<>();

        room3Enemies.add(enemy3);
        room3Enemies.add(enemy4);
        room3Enemies.add(enemy5);

        setNamesForMultipleEnemies(room3Enemies);

        /// bossRoom enemies:
        VoidImp bossEnemy = voidImp.level2Imp();


        bossEnemy.addTag(enemyTags.getBossEnemy());
        bossEnemy.removeTag(enemyTags.getNormalEnemy());

        List<Enemy> bossRoomEnemies = new ArrayList<>();






        // Treasure(items available for pickup, rather than defeating enemies)
        SmallHealthPotion smallPotion1 = new SmallHealthPotion();
        SmallHealthPotion smallPotion2 = new SmallHealthPotion();
        MediumHealthPotion mediumPotion1 = new MediumHealthPotion();
        EquipableItem balancedStarterWeapon = weaponList.getByTypeAndTier("Balance Weapon", 1);

//        MediumHealthPotion mediumPotion2 = new MediumHealthPotion();
//        LargeHealthPotion largePotion1 = new LargeHealthPotion();

        List<Item> treasure = new ArrayList<>();
        treasure.add(smallPotion1);
        treasure.add(smallPotion2);
        treasure.add(mediumPotion1);

        treasure.add(balancedStarterWeapon);
//        treasure.add(mediumPotion2);
//        treasure.add(largePotion1);


        // Creating the rooms for the floor
        Room startingRoom = new StartingRoom("Starting Room", "A small room with a dimly lit torch.");
        Room enemyRoom1 = new EnemyRoom("Enemy Room 1", "A room filled with eerie silence.", room1Enemies);
        Room enemyRoom2 = new EnemyRoom("Enemy Room 2", "A small room with an ominous air.", room2Enemies);
        Room treasureRoom = new TreasureRoom("Treasure Room", "A small room with a locked chest in the middle.", treasure);
        Room enemyRoom3 = new EnemyRoom("Enemy Room 3", "A room with three enemies dancing about.", room3Enemies);
        Room bossRoom = new BossRoom("Boss Room", "A large chamber with an intimidating presence.", bossEnemy, bossRoomEnemies);

        // Connecting the rooms

            startingRoom.addExit(enemyRoom1, Direction.EAST);
            enemyRoom1.addExit(startingRoom, Direction.WEST);
            enemyRoom1.addExit(enemyRoom2, Direction.NORTH);
            enemyRoom2.addExit(enemyRoom1, Direction.SOUTH);
            enemyRoom2.addExit(bossRoom, Direction.EAST);
            enemyRoom2.addExit(treasureRoom, Direction.NORTH);
            treasureRoom.addExit(enemyRoom2, Direction.SOUTH);
            treasureRoom.addExit(enemyRoom3, Direction.EAST);
            enemyRoom3.addExit(treasureRoom, Direction.WEST);
            enemyRoom3.addExit(bossRoom, Direction.SOUTH);
            bossRoom.addExit(enemyRoom3, Direction.NORTH);
            bossRoom.addExit(enemyRoom2, Direction.WEST);

        // Adding the rooms to the layout list
        addRoom(startingRoom);
        addRoom(enemyRoom1);
        addRoom(enemyRoom2);
        addRoom(treasureRoom);
        addRoom(enemyRoom3);
        addRoom(bossRoom);

        bossRoom.setEndRoom(true);


//        // testRoom
//        AbyssKnight abyssKnight1 = abyssKnight.level9Knight();
//        VoidLord voidLord1 = voidLord.level9Lord();
//        VoidLord voidLord2 = voidLord.level10Lord();
//        AbyssKnight abyssKnight2 = abyssKnight.level10Knight();
//
//        List<Enemy> testRoomEnemies = new ArrayList<>();
//        testRoomEnemies.add(abyssKnight1);
//        testRoomEnemies.add(abyssKnight2);
//        testRoomEnemies.add(voidLord1);
//        testRoomEnemies.add(voidLord2);
//
//        Room testRoom = new EnemyRoom("Test Room", "Test", testRoomEnemies);
//        startingRoom.addExit(testRoom, Direction.SOUTH);
//        testRoom.addExit(startingRoom, Direction.NORTH);
//        addRoom(testRoom);

    }
    public void addNextFloorExit(){
        int lastIndex = getLayout().size()-1;

            Room nextFloorStartingRoom = getNextFloorLayout().getStartingRoom();
            Room bossRoom = this.getLayout().get(lastIndex);
            bossRoom.addExit(nextFloorStartingRoom, Direction.SOUTH);
            nextFloorStartingRoom.addExit(bossRoom, Direction.NORTH);

    }
}
