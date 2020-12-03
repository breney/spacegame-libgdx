package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.SmallShip;
import pt.uma.arq.game.Fleet;

import java.awt.*;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;

    private PlayerShip player;
    private Fleet fleet;


    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);


        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        fleet = new Fleet(batch);
        player = new PlayerShip(batch);
        player.create();

        fleet.fillShips(batch);
        fleet.createFleet();

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        backgroundManagement.render();
        font.draw(batch, "Score : " + player.getScore(), 20, 780);
        font.draw(batch, "HP : " + player.getLife(), 480, 780);

        if(player.getLife() >= 0){
            player.render();
            player.handleInput();
            player.update();
        }

        if(fleet.getShips().size() != 0){
            fleet.render();
            fleet.shipsFire();
            fleet.update();
        }


        LaserManagement.render();
        LaserManagement.remove();
        LaserManagement.updateEnemyShipPosition(fleet.getShips());
        LaserManagement.updatePlayerShipPosition(player);

        if(fleet.getShips().size() == 0){
            font.draw(batch, "Player Wins", 220, 420);
        }
        if(player.getLife() <= 0){
            font.draw(batch, "Enemy Crew Wins", 220, 420);
        }

        batch.end();


    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}