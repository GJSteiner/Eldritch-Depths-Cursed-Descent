package Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Room {
    private String name;
    private String description;
    private Map<Direction, Room> exits;
    private List<Enemy> enemies;
    private boolean isEndRoom;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.enemies = new ArrayList<>();
        this.isEndRoom = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(Room room, Direction direction) {
        exits.put(direction, room);
    }

    public Room getExit(Direction direction) {
        return exits.get(direction);
    }


    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public List<Direction> getAvailableExits() {
        List<Direction> availableExits = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (exits.containsKey(direction)) {
                availableExits.add(direction);
            }
        }
        return availableExits;
    }

    public boolean isEndRoom() {
        return isEndRoom;
    }

    public void setEndRoom(boolean endRoom) {
        isEndRoom = endRoom;
    }
    public abstract void enterRoom(Player player);
//    public abstract void reset();
}