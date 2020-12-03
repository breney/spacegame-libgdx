package pt.uma.arq.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.Ship;

import java.awt.*;
import java.util.ArrayList;

public class Laser {

    private Animator animator;
    private int x;
    private int y;
    private int laserSpeed;
    private boolean removable;
    private boolean colided;
    private SpriteBatch batch;

    public Laser(SpriteBatch batch, int x, int y) {
        this.animator = new Animator(batch, "laser-bolts.png", 2, 2);
        this.x = x;
        this.y = y;
        this.laserSpeed = 20;
        this.removable = false;
        this.colided = false;
        this.animator.create();
        this.batch = batch;
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

    public boolean isColided(ArrayList<Ship> ships){

        Animator explosionAnimator = new Animator(batch, "explosion.png",1,1);

        for (int i = 0; i < ships.size(); i++) {
                if(x == ships.get(i).getX() && y == ships.get(i).getY()){
                    ships.remove(i);
                    explosionAnimator.create();
                    explosionAnimator.render(ships.get(i).getX() , ships.get(i).getY());
                    colided = true;
                }
        }
        return colided;
    }

}
