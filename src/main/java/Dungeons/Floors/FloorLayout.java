package Dungeons.Floors;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.ShadowImpaler;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor2.AbyssElemental;
import Characters.Enemies.Floor2.VoidLeech;
import Dungeons.Dungeon;
import Dungeons.Rooms.Room;
import Items.Equipment.Armors.ArmorList;
import Items.Equipment.Weapons.WeaponList;
import Systems.GameRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FloorLayout {
    protected VoidImp voidImp = new VoidImp();
    protected ShadowImpaler shadowImpaler = new ShadowImpaler();
    protected AbyssElemental abyssElemental = new AbyssElemental();
    protected VoidLeech voidLeech = new VoidLeech();
    protected WeaponList weaponList = new WeaponList();
    protected ArmorList armorList = new ArmorList();
    private Dungeon dungeon = new Dungeon();

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
    public Room getStartingRoom(){
        return layout.get(0);
    }
    public void setNamesForMultipleEnemies(List<Enemy> enemies) {
        Map<String, Integer> enemyNameCounts = new HashMap<>();

        for (Enemy enemy : enemies) {
            String enemyName = enemy.getName();

            if (enemyNameCounts.containsKey(enemyName)) {
                int count = enemyNameCounts.get(enemyName) + 1;
                enemyNameCounts.put(enemyName, count);
                enemy.setName(enemy.getName() + " " + count);
            } else {
                enemyNameCounts.put(enemyName, 1);
            }
        }
    }
    public void reset() {
        generateLayout();
//        for (Room room : layout) {
//            room.reset();
//        }
    }

//    protected abstract FloorLayout getNextFloorLayout(Dungeon dungeon);
    protected FloorLayout getNextFloorLayout() {
        dungeon = GameRunner.dungeon;
        List<FloorLayout> floors = dungeon.getFloors();
        int currentFloorIndex = dungeon.getCurrentFloorIndex();

        if (currentFloorIndex + 1 < floors.size()) {
            return floors.get(currentFloorIndex + 1);
        } else {
            return null;
        }
    }
    public abstract void addNextFloorExit();

    public Dungeon getDungeon() {
        return dungeon;
    }
}
