package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;

public class Game extends ApplicationAdapter {

    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;

    private PlayerShip player;
    private Fleet fleet;

    private Animator score;
    private Animator life;

    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(600, 800);

        batch = new SpriteBatch();

        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        fleet = new Fleet(batch);
        player = new PlayerShip(batch);
        score = new Animator(batch,"score.png",1,1);
        life = new Animator(batch,"hearth.png",1,1);

        player.create();

        fleet.fillShips(batch);
        fleet.createFleet();

        score.create();
        life.create();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        backgroundManagement.render();

        score.render(20,760);
        font.draw(batch, "" + player.getScore(), 90, 780);
        life.render(490, 760);
        font.draw(batch, "" + player.getLife(), 530, 780);

        if(player.getLife() > 0){
            player.render();
            player.handleInput();
            player.update();
            fleet.shipsFire();
        }

        fleet.render();
        fleet.update();

        LaserManagement.render();
        LaserManagement.remove();
        LaserManagement.updateEnemyShipPosition(fleet.getShips());
        LaserManagement.updatePlayerShipPosition(player);

        if(fleet.getShips().size() == 0){
            font.draw(batch, "Player Wins", 220, 420);
        }
        if(player.getLife() <= 0){
            font.draw(batch, "Enemy Crew Wins", 180, 420);
            player.setLife(0);
        }

        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}