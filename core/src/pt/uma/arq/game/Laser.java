package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;

import java.awt.*;

public class Laser {

    private Animator laser;
    private int x;
    private int y;
    private Animator player;

    public Laser(SpriteBatch batch, int x, int y) {
        this.laser = new Animator(batch, "laser-bolts.png", 2, 2);
        this.x = x;
        this.y = y;
    }

    public void create() {
        laser.create();
    }

    public void render(int x) {
        laser.render(x, y);
        this.x = x;
    }

    public void walk() {
        int p = y;
        while (p < 800) {
            p += 1;
            laser.render(x, p);
        }
    }


}
