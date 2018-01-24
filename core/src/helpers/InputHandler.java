package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;

import gameobjects.Isaac;
import gameobjects.Penguin;

/**
 * Created by Hareesh on 2016-03-20.
 */
public class InputHandler {

    private Isaac isaac;
    private Penguin penguin;
    boolean activeButtonTouch = false;
    private float isaacSpeed = 75;
    private Touchpad touchpad;
    private Button button1, button2;
    private World world;
    private GameRenderer renderer;
    private FixtureDef fdef = new FixtureDef();
    private EdgeShape coll = new EdgeShape();

    public InputHandler(GameRenderer renderer) {
        this.renderer = renderer;
        isaac = renderer.getIsaac();
        penguin = renderer.getPenguin();
        world = renderer.getWorld();
    }

    public void updateAndroid(final float delta) {
        if(isaac.gameActive) penguinMovement();
        touchpad = renderer.getTouchpad();
        if(touchpad.isTouched()) isaac.gameActive = true;
        button1 = renderer.getButton1();
        button2 = renderer.getButton2();
        //Gdx.app.log("GW", "X " + Float.toString(isaac.b2body.getPosition().x) + " | " + "Y " + Float.toString(isaac.b2body.getPosition().y));
        isaac.setNotMoving(true);
        isaac.onIce = true;
        if (!isaac.disableMovement) {
            /*if (button1.isPressed()) {
                isaacSpeed = 55;
                isaac.setRunning(true);
            } else {
                isaac.setRunning(false);
                isaac.setNotMoving(true);
                activeButtonTouch = false;
                isaacSpeed = 35;
            }
            if (button2.isPressed()) {
                isaac.isMovePsy = true;
            }
            */

            if (touchpad.getKnobY() > 75 && (touchpad.getKnobX() >= 55 && touchpad.getKnobX() <= 95) && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                coll.set(new Vector2(-0.5f, 4.5f), new Vector2(0.5f, 4.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUp(true);
                isaac.setFacing("up");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }

            }
            if (touchpad.getKnobY() < 75 && (touchpad.getKnobX() >= 55 && touchpad.getKnobX() <= 95) && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                coll.set(new Vector2(-0.5f, -4.5f), new Vector2(0.5f, -4.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDown(true);
                isaac.setFacing("down");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,-65));
                }

            }
            if (touchpad.getKnobX() < 75 && (touchpad.getKnobY() >= 55 && touchpad.getKnobY() <= 95) && isaac.b2body.getLinearVelocity().x >= -isaacSpeed) {
                coll.set(new Vector2(-4.5f, 0.5f), new Vector2(-4.5f, -0.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setLeft(true);
                isaac.setFacing("left");
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }

            }
            if (touchpad.getKnobX() > 75 && (touchpad.getKnobY() >= 55 && touchpad.getKnobY() <= 95) && isaac.b2body.getLinearVelocity().x <= isaacSpeed) {
                coll.set(new Vector2(4.5f, 0.5f), new Vector2(4.5f, -0.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setRight(true);
                isaac.setFacing("right");
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }

            }
            if ((touchpad.getKnobX() < 55 && touchpad.getKnobY() > 95) && isaac.b2body.getLinearVelocity().x >= -isaacSpeed && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                coll.set(new Vector2(-3.5f, 2.5f), new Vector2(-2.5f, 3.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUpLeft(true);
                isaac.setFacing("upLeft");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }
            }
            if (touchpad.getKnobX() < 55 && touchpad.getKnobY() < 55 && isaac.b2body.getLinearVelocity().x >= -isaacSpeed && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                coll.set(new Vector2(-3.5f, -2.5f), new Vector2(-2.5f, -3.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDownLeft(true);
                isaac.setFacing("downLeft");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,-65));
                }
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }
            }
            if (touchpad.getKnobX() > 95 && touchpad.getKnobY() > 95 && isaac.b2body.getLinearVelocity().x <= isaacSpeed && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                coll.set(new Vector2(3.5f, 2.5f), new Vector2(2.5f, 3.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUpRight(true);
                isaac.setFacing("upRight");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
            }
            if (touchpad.getKnobX() > 95 && touchpad.getKnobY() < 55 && isaac.b2body.getLinearVelocity().x <= isaacSpeed && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                coll.set(new Vector2(3.5f, -2.5f), new Vector2(2.5f, -3.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDownRight(true);
                isaac.setFacing("downRight");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,-65));
                }
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
            }

           if(!touchpad.isTouched()){
               if(isaac.b2body.getLinearVelocity().x > 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x-0.2f, isaac.b2body.getLinearVelocity().y);
               if(isaac.b2body.getLinearVelocity().x < 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x+0.2f, isaac.b2body.getLinearVelocity().y);
               if(isaac.b2body.getLinearVelocity().y > 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.2f);
               if(isaac.b2body.getLinearVelocity().y < 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.2f);
           }
        }
        if(isaac.doneFalling == true) penguinReset();
    }


    public void updateDesktop(final float delta) {
        if(isaac.gameActive) penguinMovement();
        if (!isaac.disableMovement) {
            //Gdx.app.log("GW", "X " + Float.toString(isaac.b2body.getPosition().x) + " | " + "Y " + Float.toString(isaac.b2body.getPosition().y));
            //Gdx.app.log("GW", Float.toString(isaac.b2body.getLinearVelocity().x) + " | " + Float.toString(isaac.b2body.getLinearVelocity().y));
            /* if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
                isaacSpeed = 55;
                isaac.setRunning(true);
            } else {
                isaac.setRunning(false);
                isaac.setNotMoving(true);
                activeButtonTouch = false;
                isaacSpeed = 55;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                isaac.isMovePsy = true;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                Gdx.app.log("IH", "s");
            }
            */
            isaac.setNotMoving(true);
            isaac.onIce = true;

            if (Gdx.input.isKeyPressed(Input.Keys.UP) && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(-0.5f, 4.5f), new Vector2(0.5f, 4.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUp(true);
                isaac.setFacing("up");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(-0.5f, -4.5f), new Vector2(0.5f, -4.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDown(true);
                isaac.setFacing("down");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f+-renderer.getSlipLevel()/100).clamp(0,-65));
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && isaac.b2body.getLinearVelocity().x >= -isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(-4.5f, 0.5f), new Vector2(-4.5f, -0.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setLeft(true);
                isaac.setFacing("left");
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && isaac.b2body.getLinearVelocity().x <= isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(4.5f, 0.5f), new Vector2(4.5f, -0.5f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setRight(true);
                isaac.setFacing("right");
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.LEFT) && isaac.b2body.getLinearVelocity().x >= -isaacSpeed && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(-4f, 3.0f), new Vector2(-3.0f, 4f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUpLeft(true);
                isaac.setFacing("upLeft");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.LEFT) && isaac.b2body.getLinearVelocity().x >= -isaacSpeed && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(-4f, -3.0f), new Vector2(-3.0f, -4f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDownLeft(true);
                isaac.setFacing("downLeft");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,-65));
                }
                if(isaac.b2body.getLinearVelocity().x > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x-0.5f-renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,-65));
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.RIGHT) && isaac.b2body.getLinearVelocity().x <= isaacSpeed && isaac.b2body.getLinearVelocity().y <= isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(4f, 3.0f), new Vector2(3.0f, 4f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setUpRight(true);
                isaac.setFacing("upRight");
                if(isaac.b2body.getLinearVelocity().y < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+0.5f+renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.RIGHT) && isaac.b2body.getLinearVelocity().x <= isaacSpeed && isaac.b2body.getLinearVelocity().y >= -isaacSpeed) {
                isaac.gameActive = true;
                coll.set(new Vector2(4f, -3.0f), new Vector2(3.0f, -4f));
                fdef.shape = coll;
                fdef.isSensor = false;
                isaac.b2body.destroyFixture(isaac.b2body.getFixtureList().get(1));
                isaac.b2body.createFixture(fdef).setUserData("coll");

                isaac.setNotMoving(false);
                isaac.setDownRight(true);
                isaac.setFacing("downRight");
                if(isaac.b2body.getLinearVelocity().y > 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().y <= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-0.5f-renderer.getSlipLevel()/100).clamp(0,-65));
                }
                if(isaac.b2body.getLinearVelocity().x < 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
                if(isaac.b2body.getLinearVelocity().x >= 0) {
                    isaac.b2body.setLinearVelocity(new Vector2(isaac.b2body.getLinearVelocity().x+0.5f+renderer.getSlipLevel()/100, isaac.b2body.getLinearVelocity().y).clamp(0,65));
                }
            }


            if(!Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN) && !Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                if(isaac.b2body.getLinearVelocity().x > 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x-(1-renderer.getSlipLevel()/100f), isaac.b2body.getLinearVelocity().y);
                if(isaac.b2body.getLinearVelocity().x < 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x+(1-renderer.getSlipLevel()/100f), isaac.b2body.getLinearVelocity().y);
                if(isaac.b2body.getLinearVelocity().y > 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y-(1-renderer.getSlipLevel()/100f));
                if(isaac.b2body.getLinearVelocity().y < 0) isaac.b2body.setLinearVelocity(isaac.b2body.getLinearVelocity().x, isaac.b2body.getLinearVelocity().y+(1-renderer.getSlipLevel()/100f));
            }
        }

        if(isaac.doneFalling == true) penguinReset();
    }

    private void penguinMovement() {
        //Gdx.app.log("IH", Float.toString(penguin.b2body.getLinearVelocity().x) + " | " +  Float.toString(penguin.b2body.getLinearVelocity().y));
        //if(penguin.b2body.getPosition().x < 35) penguin.b2body.setLinearVelocity(-penguin.b2body.getLinearVelocity().x, penguin.b2body.getLinearVelocity().y);
        //else if(penguin.b2body.getPosition().x > 200) penguin.b2body.setLinearVelocity(-penguin.b2body.getLinearVelocity().x, penguin.b2body.getLinearVelocity().y);
        //if(penguin.b2body.getPosition().y < 25) penguin.b2body.setLinearVelocity(penguin.b2body.getLinearVelocity().x, -penguin.b2body.getLinearVelocity().y);
        //else if(penguin.b2body.getPosition().y > 90) penguin.b2body.setLinearVelocity(penguin.b2body.getLinearVelocity().x, -penguin.b2body.getLinearVelocity().y);

        //if(penguin.b2body.getLinearVelocity().x < -50) penguin.b2body.setLinearVelocity(-50, penguin.b2body.getLinearVelocity().y);
        //if(penguin.b2body.getLinearVelocity().x > 50) penguin.b2body.setLinearVelocity(50, penguin.b2body.getLinearVelocity().y);
        //if(penguin.b2body.getLinearVelocity().y < -50) penguin.b2body.setLinearVelocity(penguin.b2body.getLinearVelocity().x,50);
        //if(penguin.b2body.getLinearVelocity().y > 50) penguin.b2body.setLinearVelocity(penguin.b2body.getLinearVelocity().x,-50);

        if(penguin.b2body.getLinearVelocity().x == 0 && penguin.b2body.getLinearVelocity().y == 0) penguin.b2body.setLinearVelocity(60,60);
        penguin.b2body.setLinearVelocity(new Vector2(penguin.b2body.getLinearVelocity().x, penguin.b2body.getLinearVelocity().y).clamp(50,70));
        if(penguin.b2body.getLinearVelocity().x > 0 && (penguin.b2body.getLinearVelocity().y < 9 && penguin.b2body.getLinearVelocity().y > -9)) penguin.setFacing("right");
        if(penguin.b2body.getLinearVelocity().x < 0 && (penguin.b2body.getLinearVelocity().y < 9 && penguin.b2body.getLinearVelocity().y > -9)) penguin.setFacing("left");
        if(penguin.b2body.getLinearVelocity().y > 0 && (penguin.b2body.getLinearVelocity().x < 9 && penguin.b2body.getLinearVelocity().x > -9)) penguin.setFacing("up");
        if(penguin.b2body.getLinearVelocity().y < 0 && (penguin.b2body.getLinearVelocity().x < 9 && penguin.b2body.getLinearVelocity().x > -9)) penguin.setFacing("down");
        if(penguin.b2body.getLinearVelocity().y > 0 && (penguin.b2body.getLinearVelocity().x <= 50 && penguin.b2body.getLinearVelocity().x > 10)) penguin.setFacing("upRight");
        if(penguin.b2body.getLinearVelocity().y > 0 && (penguin.b2body.getLinearVelocity().x >= -50 && penguin.b2body.getLinearVelocity().x < -10)) penguin.setFacing("upLeft");
        if(penguin.b2body.getLinearVelocity().y < 0 && (penguin.b2body.getLinearVelocity().x <= 50 && penguin.b2body.getLinearVelocity().x > 10)) penguin.setFacing("downRight");
        if(penguin.b2body.getLinearVelocity().y < 0 && (penguin.b2body.getLinearVelocity().x >= -50 && penguin.b2body.getLinearVelocity().x < -10)) penguin.setFacing("downLeft");

    }

    private void penguinReset() {
        penguin.setFacing("down");
        penguin.b2body.setTransform(70,65,0);
        penguin.b2body.setLinearVelocity(0,0);
    }
}
