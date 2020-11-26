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
    private Fleet enemyFleet;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);



        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        smallEnemy = new SmallShip(batch, 200,650);
        mediumEnemy = new MediumShip(batch ,200,600);
        largeEnemy = new LargeShip(batch,200,700);

        player = new PlayerShip(batch);

        smallEnemy.create();
        mediumEnemy.create();
        largeEnemy.create();

        enemyFleet.enemyFleet(smallEnemy,5);

        player.create();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.handleInput();

        batch.begin();
        backgroundManagement.render();


        player.render();

        batch.end();
    }



    @Override
    public void dispose() {
        batch.dispose();
    }
}