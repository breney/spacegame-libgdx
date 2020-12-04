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
import java.util.Timer;
import java.util.TimerTask;

public class Fleet {

    private ArrayList<Ship> ships;

    private SpriteBatch batch;

    private float laserTimer;

    private float shipsLaserTime;

    //construtor
    public Fleet(SpriteBatch batch) {
        this.ships = new ArrayList<>();
        this.batch = batch;
        this.laserTimer = 0;
        this.shipsLaserTime = 2f;
    }

    //funções para adicionar naves ao array
    public void fillShips(SpriteBatch batch) {

        for (int i = 0; i < 8; i++) {
            ships.add(new SmallShip(batch, (30 + 70 * i), 500));
        }
        for (int j = 0; j < 8; j++) {
            ships.add(new MediumShip(batch, (20 + 70 * j), 550));
        }
        for (int k = 0; k < 8; k++) {
            ships.add(new LargeShip(batch, (20 + 70 * k), 600));
        }
    }

    //função para criar naves
    public void createFleet() {
        for (int i = 0; i < ships.size(); i++) {
            ships.get(i).create();
        }
    }

    //função para renderizar naves
    public void render() {
        for (int j = 0; j < ships.size(); j++) {
            ships.get(j).render();
        }
    }

    //função para adicionar lasers ao arrayLasers de forma aleatoria
    public void shipsFire() {

        double random = Math.random() * ships.size();

        if (laserTimer >= shipsLaserTime && ships.size() != 0) {
            LaserManagement.add(new Laser(batch, ships.get((int) random).getX(), ships.get((int) random).getY(), false, ships.get((int) random).getAttackValue()));
            laserTimer = 0;
        }
    }

    //update timer
    public void update() {
        laserTimer += Gdx.graphics.getDeltaTime();
    }

    //getter
    public ArrayList<Ship> getShips() {
        return ships;
    }
}
