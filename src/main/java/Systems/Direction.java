package Systems;

// Used to provide a list of options - directions that a player can move from each room
public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public static Direction fromString(String directionString) {
        try {
            return Direction.valueOf(directionString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}