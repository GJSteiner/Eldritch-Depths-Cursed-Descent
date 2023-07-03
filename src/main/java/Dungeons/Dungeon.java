package Dungeons;

import Floors.FirstFloor.FirstFloorLayout;
import Floors.FloorLayout;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<FloorLayout> floors;
    private int currentFloorIndex;
    private boolean gameCompleted;

    public Dungeon() {
        floors = new ArrayList<>();
        currentFloorIndex = 0;
        gameCompleted = false;
        initializeFloors();
    }

    private void initializeFloors() {
        floors.add(new FirstFloorLayout());
    }

    public FloorLayout getCurrentFloorLayout() {
        return floors.get(currentFloorIndex);
    }

    public void moveToNextFloor() {
        if (currentFloorIndex < floors.size() - 1) {
            currentFloorIndex++;
        } else {
            gameCompleted = true;
        }
    }

    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public List<FloorLayout> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorLayout> floors) {
        this.floors = floors;
    }

    public int getCurrentFloorIndex() {
        return currentFloorIndex;
    }

    public void setCurrentFloorIndex(int currentFloorIndex) {
        this.currentFloorIndex = currentFloorIndex;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }
}