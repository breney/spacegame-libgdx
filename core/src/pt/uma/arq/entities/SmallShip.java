package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class SmallShip extends Ship{

    public SmallShip(SpriteBatch batch,int x ,int y) {
        super(new Animator(batch,"enemy-small.png",2,1),x,y,0,false,new Rectangle());
    }

}
