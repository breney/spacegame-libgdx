package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class MediumShip extends Ship {

    public MediumShip(SpriteBatch batch ,int x, int y) {
        super(new Animator(batch,"enemy-medium.png",2,1),x,y,0,false,new Rectangle());
    }
}
