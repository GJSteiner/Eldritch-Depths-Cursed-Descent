package Dungeons.Floors.FifthFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Characters.Enemies.Floor3.CultistAcolyte;
import Characters.Enemies.Floor3.CultistSummoner;
import Characters.Enemies.Floor4.Hellhound;
import Characters.Enemies.Floor4.VoidScuttler;
import Characters.Enemies.Floor5.AbyssKnight;
import Characters.Enemies.Floor5.VoidLord;
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

public class FifthFloorLayout extends FloorLayout {

         public FifthFloorLayout() {

        }

        @Override
        protected void generateLayout() {
            setFloorIndex(5);

            EnemyTags enemyTags = new EnemyTags();

            layout.clear();

            // Creating enemies for the floor
            /// enemyRoom1 enemies:
            AbyssKnight enemy1 =  abyssKnight.level8Knight();

            List<Enemy> room1Enemies = new ArrayList<>();

            room1Enemies.add(enemy1);

            setNamesForMultipleEnemies(room1Enemies);


            /// enemyRoom2 enemies:
            VoidLord enemy2 = voidLord.level8Lord();

            List<Enemy> room2Enemies = new ArrayList<>();

            room2Enemies.add(enemy2);

            setNamesForMultipleEnemies(room2Enemies);

            /// enemyRoom3 enemies:
            VoidLord enemy3 = voidLord.level8Lord();
            AbyssKnight enemy4 =  abyssKnight.level8Knight();


            List<Enemy> room3Enemies = new ArrayList<>();

            room3Enemies.add(enemy3);
            room3Enemies.add(enemy4);

            setNamesForMultipleEnemies(room3Enemies);

            /// enemyRoom4 enemies:
            AbyssKnight enemy5 =  abyssKnight.level9Knight();

            List<Enemy> room4Enemies = new ArrayList<>();

            room4Enemies.add(enemy5);

            setNamesForMultipleEnemies(room4Enemies);

            /// enemyRoom5 enemies:
            VoidLord enemy6 = voidLord.level9Lord();

            List<Enemy> room5Enemies = new ArrayList<>();

            room5Enemies.add(enemy6);

            setNamesForMultipleEnemies(room5Enemies);

            /// uniqueRoom enemies:
            AbyssKnight uniqueEnemy1 = abyssKnight.level9Knight();
            VoidLord uniqueEnemy2 = voidLord.level9Lord();

            List<Enemy> uniqueEnemies = new ArrayList<>();
//
            uniqueEnemies.add(uniqueEnemy2);

            /// bossRoom enemies:
            VoidLord bossEnemy = voidLord.level10Lord();

            bossEnemy.removeTag(enemyTags.getNormalEnemy());
            bossEnemy.addTag(enemyTags.getBossEnemy());

            List<Enemy> bossRoomEnemies = new ArrayList<>();

            VoidScuttler bossRoomAdd1 = voidScuttler.level8Spider();
            VoidScuttler bossRoomAdd2 = voidScuttler.level8Spider();
            VoidScuttler bossRoomAdd3 = voidScuttler.level8Spider();

            bossRoomEnemies.add(bossRoomAdd1);
            bossRoomEnemies.add(bossRoomAdd2);
            bossRoomEnemies.add(bossRoomAdd3);

            setNamesForMultipleEnemies(bossRoomEnemies);

            // Treasure(items available for pickup, rather than defeating enemies)

            XxlHealthPotion xxlHealthPotion1 = new XxlHealthPotion();
            XxlHealthPotion xxlHealthPotion2 = new XxlHealthPotion();
            XxlHealthPotion xxlHealthPotion3 = new XxlHealthPotion();
            XxlHealthPotion xxlHealthPotion4 = new XxlHealthPotion();
            EquipableItem balancedStarterWeapon = weaponList.getByTypeAndTier("Balance Weapon", 5);


            List<Item> treasure = new ArrayList<>();
            treasure.add(xxlHealthPotion1);
            treasure.add(xxlHealthPotion2);
            treasure.add(xxlHealthPotion3);
            treasure.add(xxlHealthPotion4);
            treasure.add(balancedStarterWeapon);


            // Creating the rooms for the floor
            Room startingRoom = new StartingRoom("Fifth Floor Starting Room", "The first room of the fifth floor.");
            Room enemyRoom1 = new EnemyRoom("Enemy Room 1", "A room filled with darkness and echoes of distant footsteps.", room1Enemies);
            Room enemyRoom2 = new EnemyRoom("Enemy Room 2", "A room filled with mysterious symbols and wicked laughter.", room2Enemies);
            Room enemyRoom3 = new EnemyRoom("Enemy Room 3", "A cold, dark chamber with a menacing aura emanating from it.", room3Enemies);
            Room treasureRoom = new TreasureRoom("Treasure Room", "A dimly lit room with treasure glinting in the shadows.", treasure);
            Room enemyRoom4 = new EnemyRoom("Enemy Room 4", "A spacious room with ancient runes etched into the stone walls.", room4Enemies);
            Room enemyRoom5 = new EnemyRoom("Enemy Room 5", "A narrow hallway with chilling drafts and unsettling whispers.", room5Enemies);
            Room uniqueRoom = new UniqueRoom("Unique Room", "A room with strange artifacts and enigmatic symbols covering every surface.", uniqueEnemy1, uniqueEnemies);
            Room bossRoom = new BossRoom("Boss Room", "A grand chamber with a sinister aura and the smell of sulfur.", bossEnemy, bossRoomEnemies);

            // Connecting the rooms

            startingRoom.addExit(enemyRoom1, Direction.EAST);
            enemyRoom1.addExit(startingRoom, Direction.WEST);
            enemyRoom1.addExit(enemyRoom2, Direction.NORTH);
            enemyRoom2.addExit(enemyRoom1, Direction.SOUTH);
            enemyRoom2.addExit(enemyRoom3, Direction.NORTH);
            enemyRoom2.addExit(enemyRoom4, Direction.EAST);
            enemyRoom3.addExit(enemyRoom2, Direction.SOUTH);
            enemyRoom3.addExit(enemyRoom5, Direction.EAST);
            treasureRoom.addExit(uniqueRoom, Direction.NORTH);
            enemyRoom4.addExit(enemyRoom2, Direction.WEST);
            enemyRoom4.addExit(uniqueRoom, Direction.EAST);
            enemyRoom4.addExit(enemyRoom5, Direction.NORTH);
            enemyRoom5.addExit(enemyRoom3, Direction.WEST);
            enemyRoom5.addExit(enemyRoom4, Direction.SOUTH);
            enemyRoom5.addExit(bossRoom, Direction.EAST);
            uniqueRoom.addExit(treasureRoom, Direction.SOUTH);
            uniqueRoom.addExit(bossRoom, Direction.NORTH);
            bossRoom.addExit(enemyRoom5, Direction.WEST);
            bossRoom.addExit(uniqueRoom, Direction.SOUTH);

            // Adding the rooms to the layout list
            addRoom(startingRoom);
            addRoom(enemyRoom1);
            addRoom(enemyRoom2);
            addRoom(enemyRoom3);
            addRoom(treasureRoom);
            addRoom(enemyRoom4);
            addRoom(enemyRoom5);
            addRoom(uniqueRoom);
            addRoom(bossRoom);

            bossRoom.setEndRoom(true);
            bossRoom.setFinalRoom(true);

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
