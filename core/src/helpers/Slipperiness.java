package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Hareesh on 5/31/2016.
 */
public class Slipperiness {
    BitmapFont BMF;
    private String scoreText;
    private int score;

    public Slipperiness(){
        BMF = new BitmapFont(Gdx.files.internal("data/GoldenSun/others/font.fnt"));
    }

    public void drawSlipperiness(SpriteBatch batch, float sliplevel, float height){
        scoreText = "Slip: " + (int) sliplevel;
        batch.begin();
        BMF.setColor(0f, 0.8f, 1.0f, 1.0f);
        BMF.getData().setScale(1f);
        BMF.draw(batch, scoreText, 10f, height-50f);
        batch.end();
        score = (int) sliplevel;
    }

    public int getSlipperiness(){
        return score;
    }
}
