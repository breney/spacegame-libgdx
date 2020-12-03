package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Laser;
import pt.uma.arq.game.LaserManagement;

import java.awt.*;

public class PlayerShip extends Ship {

    private int life;

    private SpriteBatch batch;
    private float playerLaserTime;
    private float laserTimer;

    public PlayerShip(SpriteBatch batch) {
        super(new Animator(batch, "ship.png", 5, 2), 200, 0, 0, false, new Rectangle());
        this.batch = batch;
        this.playerLaserTime = 0.3f;
        this.laserTimer = 0;
    }

    public void handleInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
            x = x - 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x + 20 < Gdx.graphics.getWidth()) {
            x = x + 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && laserTimer >= playerLaserTime) {
            fire();
            laserTimer = 0;
        }
    }

    public void fire() {
        LaserManagement.add(new Laser(batch, getX(), getY())
        );
    }

    public void update(){
        laserTimer += Gdx.graphics.getDeltaTime();
    }

}
