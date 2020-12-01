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
    private SmallShip smallEnemy;
    private MediumShip mediumEnemy;
    private LargeShip largeEnemy;
    private Fleet fleet;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);


        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        smallEnemy = new SmallShip(batch,100,700);
        mediumEnemy = new MediumShip(batch,125,675);
        largeEnemy = new LargeShip(batch,150,650);
        fleet = new Fleet(batch);

        player = new PlayerShip(batch);

        player.create();

        fleet.setShips(smallEnemy);
        fleet.setShips(mediumEnemy);
        fleet.setShips(largeEnemy);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.begin();
        backgroundManagement.render();

        player.render();
        player.handleInput();
        fleet.createFleet(0,3);
        fleet.createFleet(1,5);
        fleet.createFleet(2,7);

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}