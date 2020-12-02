package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.entities.SmallShip;

import java.util.ArrayList;

public class Fleet {


    private ArrayList<Ship> ships;

    public Fleet() {
        this.ships = new ArrayList<>();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void fillShips() {
        for (int i = 0; i < 3; i++) {
            ships.add(new SmallShip(new SpriteBatch(), 200, 500));
        }
        for (int j = 0; j < 5; j++) {
            ships.add(new MediumShip(new SpriteBatch(), 150, 550));
        }
        for (int k = 0; k < 7; k++) {
            ships.add(new LargeShip(new SpriteBatch(),100,600));
        }
    }

    public void createFleet() {
        int distance = 0;
        for (int i = 0; i < ships.size(); i++) {
               ships.get(i).setX(ships.get(i).getX() + distance);
               ships.get(i).create();
               distance += 50;
        }
    }

    public void render(){
        for (int j = 0; j < ships.size(); j++) {
            ships.get(j).render();
        }
    }
}
