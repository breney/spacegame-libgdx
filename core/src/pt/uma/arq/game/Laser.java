package pt.uma.arq.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Laser {

    private Animator laserAnimator;
    private int x;
    private int y;
    private int laserSpeed;
    private boolean removable;
    private boolean colided;
    private Animator explosionAnimator;
    private boolean isPlayerLaser;
    private Rectangle boundingbox;
    private Texture walkSheet;
    private int damage;

    //construtor laser
    public Laser(SpriteBatch batch, int x, int y, boolean isPlayerLaser, int damage) {
        this.laserAnimator = new Animator(batch, "laser-bolts.png", 2, 2);
        this.explosionAnimator = new Animator(batch, "explosion.png", 4, 1);
        this.walkSheet = new Texture(Gdx.files.internal("laser-bolts.png"));
        this.boundingbox = new Rectangle(x, y, walkSheet.getWidth() / 2, walkSheet.getHeight());
        this.laserAnimator.create();
        this.x = x;
        this.y = y;
        this.laserSpeed = 10;
        this.removable = false;
        this.colided = false;
        this.isPlayerLaser = isPlayerLaser;
        this.damage = damage;
    }

    //função para renderizar laser verificando se o laser é disparado pelo player ou nao
    public void render() {

        if (isPlayerLaser) {
            y += laserSpeed;
        } else {
            y -= laserSpeed;
        }

        laserAnimator.render(x, y);
        boundingbox.setLocation(x, y);
    }

    //função para verificar se o laser chegar a um determinado ponto retorna true
    public boolean isRemovable() {
        if (y >= 800) {
            removable = true;
        } else if (y <= 0) {
            removable = true;
        }
        return removable;
    }

    //função para verficar a colidez do laser do player para as naves
    public boolean isColidedEnemyShip(ArrayList<Ship> ships, PlayerShip player) {

        Iterator<Ship> it = ships.iterator();

        while (it.hasNext()) {
            Ship ship = it.next();
            if (boundingbox.intersects(ship.getBoundingBox())) {
                it.remove();
                player.setScore(player.getScore() + ship.getAttackValue());
                explosionAnimator.create();
                explosionAnimator.render(ship.getX(), ship.getY());
                colided = true;
            }
        }
        return colided;
    }

    //função para verficar a colidez do laser do naves para o player
    public boolean isColidedPlayerShip(PlayerShip player) {
        if (boundingbox.intersects(player.getBoundingBox())) {
            player.setLife(player.getLife() - damage);
        }
        return colided;
    }

    //função para fazer update
    public boolean isPlayerLaser() {
        return isPlayerLaser;
    }


}
