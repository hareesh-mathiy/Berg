package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.TestGame;

import helpers.GameRenderer;
import helpers.InputHandler;
import helpers.AssetLoader;

/**
 * Created by Hareesh on 2016-03-20.
 */
public class GameScreen implements Screen {
    private InputHandler inputHandler;
    private GameRenderer renderer;
    private float runTime;
    private String device;
    long startTime = 0;

    public GameScreen(final TestGame game) {
        switch(Gdx.app.getType()) {
            case Android:
                renderer = new GameRenderer("android");
                device = "android";
                break;
            case Desktop:
                renderer = new GameRenderer("desktop");
                device = "desktop";
                break;
            case WebGL:
        }
        startTime = TimeUtils.nanoTime();
        inputHandler = new InputHandler(renderer);
        AssetLoader.load();
    }

    @Override
    public void render(float delta) {
        //Gdx.app.log("GS", Float.toString(1/delta));
        runTime += delta;
        renderer.render(runTime);
        if (device == "android") {
            inputHandler.updateAndroid(delta);
        }
        if (device == "desktop")
        {
            inputHandler.updateDesktop(delta);
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
        renderer.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        AssetLoader.dispose();
        renderer.getBatch().dispose();
    }

    public float getRuntime(){
        return runTime;
    }
}
