package pt.uma.arq.game;

import pt.uma.arq.entities.Ship;

import java.util.ArrayList;
import java.util.Iterator;

public class LaserManagement {

    private static ArrayList<Ship> ship = new ArrayList<>();

    private static ArrayList<Laser> laserArrayList = new ArrayList<>();

    public static void add(Laser laser) {
        laserArrayList.add(laser);
    }

    public static void remove() {

        Iterator<Laser> it = laserArrayList.iterator();

        while (it.hasNext()) {
            Laser laser = it.next();
            if (laser.isRemovable()) {
                it.remove();
            }
            if(laser.isColided(ship)){
                it.remove();
            }
        }

    }

    public static void render() {
        for (Laser laser : laserArrayList) {
            laser.render();
        }
    }

    public static void updateShipPosition(ArrayList<Ship> ships) {
        ship = ships;
    }

}
