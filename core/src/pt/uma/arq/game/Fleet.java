package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import pt.uma.arq.entities.Ship;

import java.util.ArrayList;

public class Fleet {


    private ArrayList<Ship> ships;

    public Fleet(SpriteBatch batch) {
        this.ships = new ArrayList<>();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(Ship ship) {
        this.ships.add(ship);
    }

    public void createFleet(int order, int quantity) {

        for (int j = 0; j < quantity; j++) {
            int p = ships.get(order).getX();
            ships.get(order).create();
            ships.get(order).setX(p +(50 * j));
            ships.get(order).render();

        }
    }
}
