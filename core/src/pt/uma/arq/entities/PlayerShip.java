package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Laser;

import java.awt.*;

public class PlayerShip extends Ship {

    private int life;
    private Laser laser;
    private SpriteBatch batch;


    public PlayerShip(SpriteBatch batch) {
        super(new Animator(batch, "ship.png", 5, 2), 200, 0, 0, false, new Rectangle());
        this.laser = new Laser(batch, getX(), getY());
        this.batch = batch;

    }

    public void handleInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
            x = x - 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x + 20 < Gdx.graphics.getWidth()) {
            x = x + 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fire();
        }
    }

    public void fire() {
        laser.create();
        laser.render(getX());
        laser.walk();
    }


}
