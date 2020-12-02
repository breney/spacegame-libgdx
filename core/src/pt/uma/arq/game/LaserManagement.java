package pt.uma.arq.game;

import java.util.ArrayList;
import java.util.Iterator;

public class LaserManagement {

    private static ArrayList<Laser> laserArrayList = new ArrayList<>();

    public static ArrayList<Laser> getLaserArrayList() {
        return laserArrayList;
    }

    public static void add(Laser laser) {
        laserArrayList.add(laser);
    }

    public static void remove() {

        Iterator<Laser> it = laserArrayList.iterator();

        while (it.hasNext()) {
            Laser laser = it.next();
            if (laser.isRemovable()) {
                System.out.println("Remove");
                it.remove();
            }
        }

    }

    public static void render(){
        for (Laser laser : laserArrayList ) {
            laser.render();
        }
    }
}
