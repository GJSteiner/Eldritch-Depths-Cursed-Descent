package Dungeons.Floors;

import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.ShadowImpaler;
import Characters.Enemies.Floor1.VoidImp;
import Characters.Enemies.Floor2.AbyssElemental;
import Characters.Enemies.Floor2.VoidLeech;
import Dungeons.Rooms.Room;
import Items.Equipment.Armors.ArmorList;
import Items.Equipment.Weapons.Weapon;
import Items.Equipment.Weapons.WeaponList;

import java.util.ArrayList;
import java.util.List;

public abstract class FloorLayout {
    protected VoidImp voidImp = new VoidImp();
    protected ShadowImpaler shadowImpaler = new ShadowImpaler();
    protected AbyssElemental abyssElemental = new AbyssElemental();
    protected VoidLeech voidLeech = new VoidLeech();
    protected WeaponList weaponList = new WeaponList();
    protected ArmorList armorList = new ArmorList();

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
