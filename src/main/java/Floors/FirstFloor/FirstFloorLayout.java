package Floors.FirstFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Floors.FloorLayout;
import Rooms.Room;
import Systems.Direction;

import java.util.ArrayList;
import java.util.List;

public class FirstFloorLayout extends FloorLayout {
    VoidImp voidImp = new VoidImp();

    List<Room> firstFloorLayout = new ArrayList<>();


    @Override
    protected void generateLayout() {

        // Define the rooms for the floor
        Room startingRoom = new Room("Starting Room", "A small room with a dimly lit torch.");
        Room enemyRoom1 = new Room("Enemy Room 1", "A room filled with eerie silence.");
        Room treasureRoom = new Room("Treasure Room", "A small room with a locked chest in the middle.");
        Room bossRoom = new Room("Boss Room", "A large chamber with an intimidating presence.");

        // Connect the rooms

            startingRoom.addExit(enemyRoom1, Direction.EAST);
            enemyRoom1.addExit(startingRoom, Direction.WEST);
            enemyRoom1.addExit(treasureRoom, Direction.NORTH);
            treasureRoom.addExit(enemyRoom1, Direction.SOUTH);
            treasureRoom.addExit(bossRoom, Direction.EAST);
            bossRoom.addExit(treasureRoom, Direction.WEST);

        // Add the rooms to the first floor layout
        addRoom(startingRoom);
        addRoom(enemyRoom1);
        addRoom(treasureRoom);
        addRoom(bossRoom);
        // Create enemies and add them to their rooms
        /// enemyRoom1 enemies:
        VoidImp enemy1 = voidImp.level0Imp();
        /// treasureRoom enemies:
        VoidImp enemy2 = voidImp.level1Imp();
        /// bossRoom enemies:
        VoidImp bossEnemy = voidImp.level2Imp();

    }
}
