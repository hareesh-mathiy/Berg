package gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.Constants;

/**
 * Created by Hareesh on 5/15/2016.
 */
public class Penguin {

    private Vector2 position;
    private float rotation;
    private int width;
    private int height;
    public boolean gameOver;
    public boolean res;
    public boolean isUp, isDown, isLeft, isRight, isUpRight, isDownRight, isUpLeft, isDownLeft,
            notMoving, isRunning, colliding, isSliding, onIce;
    public String facing, turn;
    public World world;
    public Body b2body;
    public int hpos;
    public boolean wallCollideUp, wallCollideDown, wallCollideLeft, wallCollideRight;
    public boolean isTaunting;
    public boolean disableMovement;
    public boolean isFlashing;
    public boolean isMovePsy;
    public boolean isFlashingWhite;
    public boolean onIceMoving;
    public boolean HC;
    public boolean falling;
    public boolean doneFalling;

    public Penguin(World world, float x, float y, int width, int height) {
        this.world = world;
        this.width = width;
        this.height = height;
        this.world = world;
        position = new Vector2(x, y);
        gameOver = false;
        res = false;
        isUp = false;
        isDown = true;
        isLeft = false;
        isRight = false;
        isUpLeft = false;
        isDownLeft = false;
        isUpRight = false;
        isDownRight = false;
        notMoving = true;
        isRunning = false;
        colliding = false;
        isSliding = false;
        onIce = false;
        wallCollideUp = false;
        wallCollideDown = false;
        wallCollideLeft = false;
        wallCollideRight = false;
        isTaunting = false;
        isFlashing = false;
        isFlashingWhite = false;
        disableMovement = false;
        onIceMoving = false;
        isMovePsy = false;
        rotation = 0;
        facing = "down";
        turn = null;
        hpos = 1;
        HC = false;
        definePenguin();
        falling = false;
        doneFalling = false;
    }

    public void definePenguin(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(position.x+width/2-1.5f,position.y+height/2-1.5f);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(4f);
        fdef.restitution = 1.25f;
        fdef.shape = shape;
        fdef.friction = 0f;
        fdef.density = 0.025f;
        fdef.filter.categoryBits = Constants.BIT_PENGUIN;
        b2body.createFixture(fdef).setUserData("penguin");

        shape.dispose();
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void setX(float x) { position.x = x; }

    public void setY(float y) { position.y = y; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Boolean isRunning(){ return isRunning;}
    public void setRunning(Boolean running){ isRunning = running;}

    public Boolean notMoving(){ return notMoving;}

    public void setNotMoving(Boolean notmoving){
        notMoving = notmoving;
        isUp = false;
        isDown = false;
        isLeft = false;
        isRight = false;
        isDownLeft = false;
        isDownRight = false;
        isUpLeft = false;
        isUpRight = false;
    }

    public void setFacing(String fcg){
        facing = fcg;
    }

    public String getFacing(){
        return facing;
    }

    public void setTurn(String t) { turn = t; }

    public String getTurn(){ return turn; }

    public int getHPos() {
        return hpos;
    }

    public void setHPos(int hpos) {
        this.hpos = hpos;
    }

    public void setHC(Boolean HC) {
        this.HC = HC;
    }
}

