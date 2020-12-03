package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import pt.uma.arq.game.Animator;

import java.awt.*;

public abstract class Ship {

    protected Animator animator;
    protected int attackValue;
    protected boolean collided;
    protected Rectangle boundingBox;
    protected int x;
    protected int y;
    protected Texture walkSheet;
    protected String name;

    public Ship() {
        animator = new Animator();
        attackValue = 0;
        collided = false;
        boundingBox = new Rectangle();
        walkSheet = new Texture("");
    }

    public Ship(Animator animator, int x, int y, int attackValue, boolean collided, String name) {
        this.animator = animator;
        this.x = x;
        this.y = y;
        this.attackValue = attackValue;
        this.collided = collided;
        this.walkSheet = new Texture(Gdx.files.internal(animator.getPath()));
        this.boundingBox = new Rectangle(x,y,walkSheet.getWidth() / 2,walkSheet.getHeight());
        this.name = name;
    }

    public void create() {
        animator.create();
    }

    public void render() {
        animator.render(x, y);
        boundingBox.setLocation(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {return y;}

    public Rectangle getBoundingBox(){
        return boundingBox;
    }

    public String getName(){
        return name;
    }

}
