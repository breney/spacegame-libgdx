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
    private int score;
    private boolean isFired;

    //construtor da classe
    public PlayerShip(SpriteBatch batch) {
        super(new Animator(batch, "ship.png", 5, 2), 200, 0, 0, false, "playership");
        this.batch = batch;
        this.playerLaserTime = 0.3f;
        this.laserTimer = 0;
        this.score = 0;
        this.life = 100;
        this.isFired = false;
    }

    //Função para movimentar e disparar o playership
    public void handleInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x >= 0) {
            if(x == 0){
                x = Gdx.graphics.getWidth() - 30;
            }
            x = x - 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x + 20 <= Gdx.graphics.getWidth()) {
            if(x == Gdx.graphics.getWidth() - 20){
                x = 0;
            }
            x = x + 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && laserTimer >= playerLaserTime) {
            fire();
            laserTimer = 0;
        }
    }

    //função fire que adiciona ao array de laser
    public void fire() {
        LaserManagement.add(new Laser(batch, getX(), getY(), true, 100));
    }

    //função para contar o tempo de espera entre o disparo
    public void update() {
        laserTimer += Gdx.graphics.getDeltaTime();
    }


    //getters and setters
    public int getLife() {
        return life;
    }

    //getters and setters
    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
