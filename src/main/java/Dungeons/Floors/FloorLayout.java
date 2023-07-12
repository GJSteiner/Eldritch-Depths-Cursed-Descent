package Dungeons.Floors;

import Characters.Enemies.Enemy;
import Dungeons.Rooms.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class FloorLayout {
    protected List<Room> layout;

    public FloorLayout() {
        layout = new ArrayList<>();
        generateLayout();
    }

    protected abstract void generateLayout();

    protected void addRoom(Room room) {
        layout.add(room);
    }

    public List<Room> getLayout() {
        return layout;
    }
    public abstract Room getStartingRoom();
    public void setNamesForMultipleEnemies(List<Enemy> enemies){
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.setName(enemy.getName() + " " + (i+1));
        }
    }
    public void reset() {
        generateLayout();
//        for (Room room : layout) {
//            room.reset();
//        }
    }
}
