package Dungeons.Floors.SecondFloor;

import Dungeons.Floors.FloorLayout;
import Dungeons.Rooms.Room;

public class SecondFloorLayout extends FloorLayout {
    @Override
    protected void generateLayout() {
        layout.clear();
    }

    @Override
    public Room getStartingRoom() {
        return null;
    }
}
