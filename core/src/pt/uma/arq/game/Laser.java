package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;

import java.awt.*;

public class Laser {

    private Animator animator;
    private int x;
    private int y;
    private int laserSpeed;
    private int laserTimer;
    private boolean removable;

    public Laser(SpriteBatch batch, int x, int y) {
        this.animator = new Animator(batch, "laser-bolts.png", 2, 2);
        this.x = x;
        this.y = y;
        this.laserSpeed = 20;
        this.laserTimer = 1;
        this.removable = false;
        this.animator.create();
    }

    public void render() {
        y += laserSpeed;
        animator.render(x,y);
    }

    public boolean isRemovable(){
        if(y >= 800){
            removable = true;
        }
        return  removable;
    }




}
