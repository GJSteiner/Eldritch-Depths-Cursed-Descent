package Floors.FirstFloor;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Floors.FloorLayout;
import Rooms.BossRoom;
import Rooms.EnemyRoom;
import Rooms.Room;
import Rooms.StartingRoom;
import Systems.Direction;

import java.util.ArrayList;
import java.util.List;

public class FirstFloorLayout extends FloorLayout {

    @Override
    protected void generateLayout() {
        VoidImp voidImp = new VoidImp();


        // Creating enemies for the floor
        /// enemyRoom1 enemies:
        VoidImp enemy1 = voidImp.level0Imp();
        /// treasureRoom enemies:
        VoidImp enemy2 = voidImp.level1Imp();
        /// bossRoom enemies:
        VoidImp bossEnemy = voidImp.level2Imp();


        // Creating the rooms for the floor
        Room startingRoom = new StartingRoom("Starting Room", "A small room with a dimly lit torch.");
        Room enemyRoom1 = new EnemyRoom("Enemy Room 1", "A room filled with eerie silence.", enemy1);
        Room enemyRoom2 = new EnemyRoom("Treasure Room", "A small room with a locked chest in the middle.", enemy2);
        Room bossRoom = new BossRoom("Boss Room", "A large chamber with an intimidating presence.", bossEnemy);

        // Connecting the rooms

            startingRoom.addExit(enemyRoom1, Direction.EAST);
            enemyRoom1.addExit(startingRoom, Direction.WEST);
            enemyRoom1.addExit(enemyRoom2, Direction.NORTH);
            enemyRoom2.addExit(enemyRoom1, Direction.SOUTH);
            enemyRoom2.addExit(bossRoom, Direction.EAST);
            bossRoom.addExit(enemyRoom2, Direction.WEST);

        // Adding the rooms to the layout list
        addRoom(startingRoom);
        addRoom(enemyRoom1);
        addRoom(enemyRoom2);
        addRoom(bossRoom);

        bossRoom.setEndRoom(true);

    }
    public Room getStartingRoom(){
     return layout.get(0);
    }
}
