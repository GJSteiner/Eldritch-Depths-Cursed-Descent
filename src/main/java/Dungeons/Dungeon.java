package Dungeons;

import Dungeons.Floors.FirstFloor.FirstFloorLayout;
import Dungeons.Floors.FloorLayout;
import Dungeons.Floors.SecondFloor.SecondFloorLayout;

import java.util.ArrayList;
import java.util.List;

import static Systems.GameRunner.dungeon;

public class Dungeon {
    private List<FloorLayout> floors;
    private int currentFloorIndex;
    private boolean gameCompleted;

    public Dungeon() {
        floors = new ArrayList<>();
        currentFloorIndex = 0;
        gameCompleted = false;
//        initializeFloors();
    }

    private void initializeFloors() {
//        floors.add(new FirstFloorLayout(dungeon));
//        floors.add(new SecondFloorLayout(dungeon));
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
    public void reset(){
        for (FloorLayout floor : floors){
            floor.reset();
        }
        setCurrentFloorIndex(0);
    }
}