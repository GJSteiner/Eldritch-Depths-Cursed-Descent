package Dungeons.Rooms;

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
    private boolean visited;
    private boolean isFinalRoom;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.enemies = new ArrayList<>();
        this.isEndRoom = false;
        this.visited = false;
        this.isFinalRoom = false;
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
    public boolean isVisited() {
        return visited;
    }

    public boolean isFinalRoom() {
        return isFinalRoom;
    }

    public void setFinalRoom(boolean finalRoom) {
        isFinalRoom = finalRoom;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public abstract void enterRoom(Player player);
//    public abstract void reset();
}