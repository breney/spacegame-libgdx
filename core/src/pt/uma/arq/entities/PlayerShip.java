package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class PlayerShip extends Ship {

    private int life;

    public PlayerShip(SpriteBatch batch) {
        super(new Animator(batch, "ship.png", 5, 2), 200, 0, 0, false, new Rectangle());
    }

    public void handleInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (x > 0) {
                x = x - 10;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (x + 20 < Gdx.graphics.getWidth()) {
                x = x + 10;
            }
        }


    }

}
