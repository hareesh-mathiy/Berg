package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Hareesh on 5/17/2016.
 */
public class Score {
    BitmapFont BMF;
    private String scoreText;
    private int score;

    public Score(){
        BMF = new BitmapFont(Gdx.files.internal("data/GoldenSun/others/font.fnt"));
    }

    public void drawScore(SpriteBatch batch, float time, float height){
        scoreText = "Score: " + (int) time;
        batch.begin();
        BMF.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        BMF.getData().setScale(1f);
        BMF.draw(batch, scoreText, 10f, height-10f);
        batch.end();
        score = (int) time;
    }

    public int getScore(){
        return score;
    }
}
