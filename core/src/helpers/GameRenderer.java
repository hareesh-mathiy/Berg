package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.javafx.scene.control.skin.ProgressBarSkin;

import gamelocations.Location;
import gameobjects.Isaac;
import gameobjects.Penguin;

/**
 * Created by Hareesh on 2016-03-20.
 */
public class GameRenderer {
    private Isaac isaac;
    private Penguin penguin;
    private OrthographicCamera camera;
    private Stage stage;
    private SpriteBatch batch;
    private Location location;
    private Touchpad touchpad;
    private Button button1, button2;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin, button1Skin, button2Skin, progressBarSkin;
    private Drawable touchBackground;
    private Drawable touchKnob, button1k, button2k;
    private World world;
    private String changeLocation = "test";
    private float startPointX, startPointY;
    int i, j;
    float runTime = 0;
    Score score;
    Slipperiness slipperiness;
    private long time, startTime, sliplevel, slipTime;
    float height, width;

    public GameRenderer(String device) {
        score = new Score();
        slipperiness = new Slipperiness();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 267, 160);
        camera.zoom = 0.7f;
        batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(800, 480), batch);
        world = new World(new Vector2(0,0), true);
        world.setContactListener(new WorldContactListener(this));
        isaac = new Isaac(world, 105, 65, 24, 24);
        penguin = new Penguin(world, 70, 65, 16, 16);
        time = 0;
        sliplevel = 0;
        location = new Location(this);
        if(isaac.gameActive) {
            penguin.b2body.applyLinearImpulse(5, 5, 5, 5, true);
        }
        if(device.equals("android")){
            createHud();
            stage.addActor(touchpad);
            //stage.addActor(button1);
            //stage.addActor(button2);
            Gdx.input.setInputProcessor(stage);
            height = stage.getHeight();
            width = stage.getWidth();
        }
        else height = Gdx.graphics.getHeight();

        startTime = TimeUtils.millis();
        slipTime = TimeUtils.millis();
    }

    public void render(float runTime){
        //Gdx.app.log("GR", Float.toString(isaac.b2body.getPosition().x) + "|" + Float.toString(isaac.b2body.getPosition().y));
        this.runTime = runTime;
        if(!isaac.falling && isaac.gameActive){
            time = TimeUtils.timeSinceMillis(startTime)/1000;
            if(sliplevel<100) sliplevel = TimeUtils.timeSinceMillis(slipTime)/250;
        }
        else {
            isaac.gameActive = false;
            time = 0;
            startTime = TimeUtils.millis();
            sliplevel = 0;
            slipTime = TimeUtils.millis();
        }

        world.step(1 / 60f, 8, 3);

        setCameraPosition();
        batch.setProjectionMatrix(camera.combined);
        if(!location.getLocation().equals(changeLocation)){
            if(location.getBodies().size!=0){
                for(Body body : location.getBodies()){
                    Gdx.app.log("GR", "deleting objects");
                    world.destroyBody(body);
                    i++;
                }
                Gdx.app.log("GR", Integer.toString(i) + " objects deleted");
                i=0;
            }
            isaac.b2body.setTransform(startPointX, startPointY, 0);
            location.setLocation(changeLocation);
        }

        location.render(runTime);
        /*if (isaac.getHPos() == 0) {
            if (location.getUpperBodies().size != 0) {
                for (Body body : location.getUpperBodies()) {
                    Gdx.app.log("GR", "deleting objects");
                    world.destroyBody(body);
                    location.getUpperBodies().removeIndex(j);
                    j++;
                }
                j = 0;
            }
        }*/
        stage.act(Gdx.graphics.getDeltaTime());
        if(location.getll().introFinished()) {
            stage.draw();
            score.drawScore(batch, time, height);
            slipperiness.drawSlipperiness(batch, sliplevel, height);
        }
    }

    public void createHud(){
        touchpadSkin = new Skin();
        touchpadSkin.add("touchBackground", new Texture("data/touchBackground.png"));
        touchpadSkin.add("touchKnob", new Texture("data/touchKnob.png"));
        touchpadStyle = new Touchpad.TouchpadStyle();
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(15, 15, 150, 150);

       /* button1Skin = new Skin();
        button1Skin.add("button1", new Texture("data/touchButtonB.png"));
        button1k = button1Skin.getDrawable("button1");
        button1 = new Button(button1k);
        button1.setBounds(525, 50, 50, 50);

        button2Skin = new Skin();
        button2Skin.add("button2", new Texture("data/touchButtonA.png"));
        button2k = button2Skin.getDrawable("button2");
        button2 = new Button(button2k);
        button2.setBounds(600, 50, 50, 50);
        */
    }

    public void setCameraPosition(){
        camera.position.x = isaac.b2body.getPosition().x + isaac.getWidth() / 2;
        camera.position.y = isaac.b2body.getPosition().y + isaac.getHeight() / 2;

        if(location.getMapWidth()*0.3f < camera.viewportWidth*0.7f)
            camera.position.x = location.getMapWidth()*0.3f/ 2f;
        else if(camera.position.x-camera.viewportWidth/2*0.7f <= 0)
            camera.position.x = camera.viewportWidth/2*0.7f;
        else if(camera.position.x+camera.viewportWidth/2*0.7f >= location.getMapWidth()*0.3f)
            camera.position.x = location.getMapWidth()*0.3f - camera.viewportWidth/2*0.7f;

        if(location.getMapHeight()*0.3f < camera.viewportHeight*0.7f)
            camera.position.y = location.getMapHeight()*0.3f / 2;
        else if(camera.position.y-camera.viewportHeight/2*0.7f <= 0)
            camera.position.y = 0 + camera.viewportHeight/2*0.7f;
        else if(camera.position.y+camera.viewportHeight/2*0.7f >= location.getMapHeight()*0.3f)
            camera.position.y = location.getMapHeight()*0.3f - camera.viewportHeight/2*0.7f;
        camera.update();
    }

    public Viewport getViewport(){
        return stage.getViewport();
    }

    public OrthographicCamera getCam() { return camera; }

    public Isaac getIsaac(){
        return isaac;
    }

    public Penguin getPenguin() {
        return penguin;
    }

    public Touchpad getTouchpad(){
        return touchpad;
    }

    public Button getButton1(){
        return button1;
    }

    public Button getButton2(){
        return button2;
    }

    public World getWorld(){
        return world;
    }

    public SpriteBatch getBatch(){
        return batch;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(String s, float x, float y){
        changeLocation = s;
        startPointX = x;
        startPointY = y;
    }

    public Score getScore(){
        return score;
    }

    public Slipperiness getSlipperiness(){
        return slipperiness;
    }

    public float getSlipLevel(){
        return sliplevel;
    }
}
