package pt.uma.arq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.icu.util.CodePointTrie;
import org.w3c.dom.Text;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.entities.SmallShip;

import java.awt.*;
import java.util.ArrayList;

public class Fleet {


    private ArrayList<Ship> ships;

    public Fleet() {
        this.ships = new ArrayList<>();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void fillShips(SpriteBatch batch) {

        for (int i = 0; i < 3; i++) {
            ships.add(new SmallShip(batch, (200 + 50 * i), 500));
        }
        for (int j = 0; j < 5; j++) {
            ships.add(new MediumShip(batch,(150 + 50 * j),550));
        }
        for (int k = 0; k < 7; k++) {
            ships.add(new LargeShip(batch,(100 + 50 * k),600));
        }
    }

    public void createFleet() {
        for (int i = 0; i < ships.size(); i++) {
                ships.get(i).create();
        }
    }

    public void render(){
        for (int j = 0; j < ships.size(); j++) {
            ships.get(j).render();
        }
    }


}
