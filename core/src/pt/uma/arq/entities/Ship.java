package pt.uma.arq.entities;

import pt.uma.arq.game.Animator;

import java.awt.*;

public abstract class Ship {

    protected Animator animator;
    protected int attackValue;
    protected boolean collided;
    protected Rectangle boundingBox;
    protected int x;
    protected int y;

    public Ship() {
        animator = new Animator();
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

    public void create() {
        animator.create();
    }

    public void render() {
        animator.render(x, y);
    }

    public Animator getAnimator() {
        return animator;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
