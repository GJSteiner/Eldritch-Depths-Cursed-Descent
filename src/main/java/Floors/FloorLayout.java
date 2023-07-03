package Floors;

import Rooms.Room;

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
}
