package pt.uma.arq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.icu.util.CodePointTrie;
import org.w3c.dom.Text;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.entities.SmallShip;

import java.lang.Math;

import java.awt.*;
import java.util.ArrayList;

public class Fleet {


    private ArrayList<Ship> ships;

    private float laserTimer = 0;

    private float shipsLaserTime = 0;

    private SpriteBatch batch;

    public Fleet(SpriteBatch batch) {
        this.ships = new ArrayList<>();
        this.batch = batch;
        this.laserTimer = 0;
        this.shipsLaserTime = 2f;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void fillShips(SpriteBatch batch) {

        for (int i = 0; i < 3; i++) {
            ships.add(new SmallShip(batch, (200 + 70 * i), 500));
        }
        for (int j = 0; j < 4; j++) {
            ships.add(new MediumShip(batch, (150 + 70 * j), 550));
        }
        for (int k = 0; k < 6; k++) {
            ships.add(new LargeShip(batch, (100 + 70 * k), 600));
        }
    }

    public void createFleet() {
        for (int i = 0; i < ships.size(); i++) {
            ships.get(i).create();
        }
    }

    public void render() {
        for (int j = 0; j < ships.size(); j++) {
            ships.get(j).render();
        }
    }

    public void shipsFire() {

        double random = Math.random() * ships.size();
        int damage = 0;

        if(ships.get((int) random).getName() == "largeship"){
            damage = 20;
        }else if (ships.get((int) random).getName() == "mediumship"){
            damage = 10;
        }else{
            damage = 5;
        }

        if (laserTimer >= shipsLaserTime && ships.size() != 0) {
            LaserManagement.add(new Laser(batch, ships.get((int) random).getX(), ships.get((int) random).getY(), false, damage));
            laserTimer = 0;
        }

    }

    public void update() {
        laserTimer += Gdx.graphics.getDeltaTime();
    }


}
