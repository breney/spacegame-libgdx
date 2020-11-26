package pt.uma.arq.entities;

import pt.uma.arq.game.Animator;

import java.awt.*;

public abstract class Ship {

    private Animator animator;
    private int x;
    private int y;
    private int attackValue;
    private boolean collided;
    private Rectangle boundingBox;

    public Ship(){
        animator = new Animator();
        x = 0;
        y = 0;
        attackValue = 0;
        collided = false;
        boundingBox = new Rectangle();
    }

    public Ship(Animator animator, int x, int y, int attackValue, boolean collided, Rectangle boundingBox) {
        this.animator = animator;
        this.x = x;
        this.y = y;
        this.attackValue = attackValue;
        this.collided = collided;
        this.boundingBox = boundingBox;
    }

    public int getX() {return x;}

    public int getY() {return y;}
}
