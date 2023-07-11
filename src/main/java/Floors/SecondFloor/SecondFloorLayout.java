package Floors.SecondFloor;

import Floors.FloorLayout;
import Rooms.Room;

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
