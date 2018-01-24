package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import gameobjects.Isaac;
import gameobjects.Penguin;
import gameobjects.psynergy.Move;
import transitions.MovePsyAccessor;
import transitions.OverlayAccessor;

/**
 * Created by Hareesh on 3/28/2016.
 */
public class Animations {

    public SpriteBatch batch;
    public Isaac isaac;
    public Penguin penguin;
    float stateTime;
    String isaacVertexShader;
    String isaacFragmentShader;
    ShaderProgram shader;
    int i = 0;
    int j = 0;
    int k = 0;
    int n = 0;
    int shake = 1;
    TweenManager manager, manager2, resetmanager;
    Move move;
    public boolean psyActive;
    public Color color;
    private Sprite shadow, shadowP;
    ParticleEffect trail, trailP, snow, crack;
    private Sprite overlay;
    private GameRenderer renderer;

    public Animations(SpriteBatch batch, Isaac isaac, Penguin penguin, GameRenderer renderer){
        this.batch = batch;
        this.isaac = isaac;
        this.penguin = penguin;
        this.renderer = renderer;
        psyActive = false;
        move = new Move(isaac, batch, stateTime);

        Tween.registerAccessor(Move.class, new MovePsyAccessor());
        manager = new TweenManager();
        manager2 = new TweenManager();
        resetmanager = new TweenManager();

        isaacVertexShader = Gdx.files.internal("data/shaders/vertex.glsl").readString();
        isaacFragmentShader = Gdx.files.internal("data/shaders/fragment.glsl").readString();
        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(isaacVertexShader,isaacFragmentShader);
        System.out.println(shader.isCompiled() ? "Shader Compiled" : shader.getLog());

        Texture sh = new Texture(Gdx.files.internal("data/GoldenSun/sprites/shadow.png"));
        shadow = new Sprite(sh);
        shadow.setScale(0.115f);

        shadowP = new Sprite(sh);
        shadowP.setScale(0.115f);

        trail = new ParticleEffect();
        trail.load(Gdx.files.internal("data/GoldenSun/sprites/trail"), Gdx.files.internal("data/GoldenSun/sprites"));
        trail.getEmitters().first().setPosition(isaac.b2body.getPosition().x,isaac.b2body.getPosition().y);
        trail.start();

        trailP = new ParticleEffect();
        trailP.load(Gdx.files.internal("data/GoldenSun/sprites/trailP"), Gdx.files.internal("data/GoldenSun/sprites"));
        trailP.getEmitters().first().setPosition(penguin.b2body.getPosition().x,penguin.b2body.getPosition().y);
        trailP.start();

        snow = new ParticleEffect();
        snow.load(Gdx.files.internal("data/GoldenSun/sprites/snow"), Gdx.files.internal("data/GoldenSun/sprites"));
        snow.getEmitters().first().setPosition(10, 480/3.35f);
        snow.start();

        crack = new ParticleEffect();
        crack.load(Gdx.files.internal("data/GoldenSun/sprites/crack"), Gdx.files.internal("data/GoldenSun/sprites"));
        crack.getEmitters().first().setPosition(165, 110);
        crack.start();

        Texture ov = new Texture(Gdx.files.internal("data/GoldenSun/sprites/overlay.png"));
        overlay = new Sprite(ov);
        overlay.setAlpha(0f);
        overlay.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Tween.registerAccessor(Sprite.class, new OverlayAccessor());
        Tween.to(overlay, OverlayAccessor.ALPHA, 2.5f).target(0.75f).start(manager);
        Tween.to(overlay, OverlayAccessor.ALPHA, 2.5f).target(0f).start(manager2);
        Tween.to(overlay, OverlayAccessor.ALPHA, 0.5f).target(0f).start(resetmanager);
    }

    public void run(float runTime) {
        //Gdx.app.log("A", "" + overlay.getColor().a);
        Gdx.gl.glClearColor(41/255f, 184/255f, 231/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(AssetLoader.background, 0, 0, 800/3.337f, 480/3.33f);
        batch.draw(AssetLoader.mapani.getKeyFrame(runTime), 0, 0 , 800/3.337f, 480/3.33f);
        trail.getEmitters().first().duration = Integer.MAX_VALUE;
        trail.getEmitters().first().addParticle();
        trail.update(Gdx.graphics.getDeltaTime());
        trailP.getEmitters().first().duration = Integer.MAX_VALUE;
        trailP.getEmitters().first().addParticle();
        trailP.getEmitters().first().setPosition(penguin.b2body.getPosition().x,penguin.b2body.getPosition().y);
        trailP.update(Gdx.graphics.getDeltaTime());

        snow.getEmitters().first().duration = Integer.MAX_VALUE;
        snow.update(Gdx.graphics.getDeltaTime());
        trail.draw(batch);
        trailP.draw(batch);

        shadowP.setPosition(penguin.b2body.getPosition().x - penguin.getWidth()*2f-3.5f, penguin.b2body.getPosition().y - penguin.getHeight()-11f);
        shadowP.draw(batch);

        if(isaac.doneFalling){

        }
        if(isaac.falling){
            trail.allowCompletion();
            playFalling();
            drawPenguin(runTime);
            if(overlay.getColor().a > 0f) overlay.setAlpha(overlay.getColor().a-0.01f);
        }
        else {
            isaac.doneFalling=false;
            if(renderer.getScore().getScore() > 14+n && renderer.getScore().getScore() < 19+n && overlay.getColor().a < 0.75f) overlay.setAlpha(overlay.getColor().a+0.01f);
            if(renderer.getScore().getScore() > 29+n && renderer.getScore().getScore() < 34+n && overlay.getColor().a > 0f) overlay.setAlpha(overlay.getColor().a-0.01f);
            if(renderer.getScore().getScore() > 44+n && renderer.getScore().getScore() < 49+n && overlay.getColor().a < 0.75f) overlay.setAlpha(overlay.getColor().a+0.01f);
            if(renderer.getScore().getScore() > 59+n && renderer.getScore().getScore() < 64+n && overlay.getColor().a > 0f) overlay.setAlpha(overlay.getColor().a-0.01f);
            if(renderer.getScore().getScore() > 74+n && renderer.getScore().getScore() < 79+n && overlay.getColor().a < 0.75f) overlay.setAlpha(overlay.getColor().a+0.01f);
            if(renderer.getScore().getScore() > 89+n && renderer.getScore().getScore() < 94+n && overlay.getColor().a > 0f) overlay.setAlpha(overlay.getColor().a-0.01f);
            trail.getEmitters().first().setPosition(isaac.b2body.getPosition().x,isaac.b2body.getPosition().y);
            shadow.setPosition(isaac.b2body.getPosition().x - isaac.getWidth()*1.5f+1f, isaac.b2body.getPosition().y - isaac.getHeight()-1f);
            shadow.draw(batch);
            drawPenguin(runTime);
            if (isaac.notMoving) {
                if (isaac.isMovePsy) {
                    isaac.disableMovement = true;
                    //playMovePsy(runTime);
                } else {
                    batch.setShader(null);
                    playSlide(runTime);
                }
            }
            if (isaac.onIce) {
                playSlide(runTime);
            } else {
                if (isaac.isRunning()) playRun(runTime);
                if (!isaac.isRunning()) playWalk(runTime);
            }
        }
        batch.end();
        if(trail.isComplete()) trail.reset();
    }

    public void drawPenguin(float runTime) {

        if (penguin.facing.equals("up")) {
            batch.draw(AssetLoader.pwalkup.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x - penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("down")) {
            batch.draw(AssetLoader.pwalkdown.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x - penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("left")) {
            batch.draw(AssetLoader.pwalkright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x + penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, -penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("right")) {
            batch.draw(AssetLoader.pwalkright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x - penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("upLeft")) {
            batch.draw(AssetLoader.pwalkupright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x + penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, -penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("downLeft")) {
            batch.draw(AssetLoader.pwalkdownright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x + penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, -penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("upRight")) {
            batch.draw(AssetLoader.pwalkupright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x - penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, penguin.getWidth(), penguin.getHeight());
        }
        if (penguin.facing.equals("downRight")) {
            batch.draw(AssetLoader.pwalkdownright.getKeyFrame(runTime),
                    penguin.b2body.getPosition().x - penguin.getWidth() / 2, penguin.b2body.getPosition().y - penguin.getHeight() / 5-2f, penguin.getWidth(), penguin.getHeight());
        }

    }

    private void playFalling() {
        isaac.disableMovement = true;
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(AssetLoader.efall.getKeyFrame(stateTime*20),
                isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());

        if(AssetLoader.efall.isAnimationFinished(stateTime*15)) {
            isaac.falling = false;
            isaac.disableMovement = false;
            isaac.setHPos(1);
            isaac.b2body.setTransform(105, 65, 0);
            isaac.setFacing("down");
            isaac.doneFalling = true;
            isaac.b2body.setLinearVelocity(0,0);
            stateTime = 0;
        }
    }



    /*private void playMovePsy(float runTime) {
        stateTime += Gdx.graphics.getDeltaTime();
        flashMove();
        move.setX(isaac.b2body.getPosition().x - isaac.getWidth() / 2);
        move.setY(isaac.b2body.getPosition().y - isaac.getHeight() / 5);

        if (isaac.facing.equals("up")) {
            batch.draw(AssetLoader.isaacPsyUAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.Y, 1f).target(0, isaac.b2body.getPosition().y - isaac.getHeight() / 5 + 8f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if (isaac.facing.equals("down")) {
            batch.draw(AssetLoader.isaacPsyDAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.Y, 1f).target(0, isaac.b2body.getPosition().y - isaac.getHeight() / 5 - 8f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if (isaac.facing.equals("left")) {
            batch.draw(AssetLoader.isaacPsyRAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.X, 1.0f).target(move.getX() - 4f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if (isaac.facing.equals("right")) {
            batch.draw(AssetLoader.isaacPsyRAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.X, 1.0f).target(move.getX() + 4f).start(manager);
            manager.update(stateTime);
            move.draw();

        }
        if (isaac.facing.equals("upLeft")) {
            batch.draw(AssetLoader.isaacPsyURAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.Y, 1f).target(0, isaac.b2body.getPosition().y - isaac.getHeight() / 5 + 8f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if (isaac.facing.equals("upRight")) {
            batch.draw(AssetLoader.isaacPsyURAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.X, 1.0f).target(move.getX() + 4f).start(manager);
            manager.update(stateTime);
            move.draw();

        }
        if (isaac.facing.equals("downLeft")) {
            batch.draw(AssetLoader.isaacPsyDRAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.X, 1.0f).target(move.getX() - 4f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if (isaac.facing.equals("downRight")) {
            batch.draw(AssetLoader.isaacPsyDRAni.getKeyFrame(stateTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
            batch.setShader(null);
            Tween.to(move, MovePsyAccessor.Y, 1f).target(0, isaac.b2body.getPosition().y - isaac.getHeight() / 5 - 8f).start(manager);
            manager.update(stateTime);
            move.draw();
        }
        if(AssetLoader.isaacPsyDRAni.isAnimationFinished(stateTime / 2)) {
            isaac.isMovePsy = false;
            isaac.disableMovement = false;
            psyActive = false;
            stateTime = 0;
            i = 0;
            j = 0;
            k = 0;
        }

    }
    */

    private void flashMove(){
        if((3*i)%2 == 0){
            if(j < 28){
                if((3*i)%2 == 0) isaac.isFlashingWhite = true;
                j++;
            }
            else isaac.isFlashingWhite = false;
            isaac.isFlashing = true;
        } else isaac.isFlashing = false;
        i++;
        if(isaac.isFlashing) {
            if (isaac.isFlashingWhite) {
                shader.begin();
                shader.setUniformf("u_distort", 255,255,255);
                shader.end();
                batch.setShader(shader);
            }
            else{
                psyActive = true;
                shader.begin();
                shader.setUniformf("u_distort", MathUtils.random(2), MathUtils.random(2), MathUtils.random(2));
                shader.end();
                batch.setShader(shader);
            }
        }
        else batch.setShader(null);
    }

    private void playStanding(float runTime) {
        if (isaac.facing.equals("up")) {
            batch.draw(AssetLoader.isaacBackAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("down")) {
            batch.draw(AssetLoader.isaacFrontAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("left")) {
            batch.draw(AssetLoader.isaacRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("right")) {
            batch.draw(AssetLoader.isaacRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("upLeft")) {
            batch.draw(AssetLoader.isaacUpRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("upRight")) {
            batch.draw(AssetLoader.isaacUpRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("downLeft")) {
            batch.draw(AssetLoader.isaacDownRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.facing.equals("downRight")) {
            batch.draw(AssetLoader.isaacDownRightAni.getKeyFrame(runTime / 6),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
    }

    public void playWalk(float runTime){
        if (isaac.isUp()) {
            batch.draw(AssetLoader.walkUpAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDown()) {
            batch.draw(AssetLoader.walkDownAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isLeft()) {
            batch.draw(AssetLoader.walkRightAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isRight()) {
            batch.draw(AssetLoader.walkRightAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isUpLeft()) {
            batch.draw(AssetLoader.walkUpRightAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDownLeft()) {
            batch.draw(AssetLoader.walkDownRightAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isUpRight()) {
            batch.draw(AssetLoader.walkUpRightAni.getKeyFrame(runTime / 2.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDownRight()) {
            batch.draw(AssetLoader.walkDownRightAni.getKeyFrame(runTime / 2),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
    }

    public void playRun(float runTime){
        if(isaac.isUp()){
            batch.draw(AssetLoader.runUpAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x-isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isDown()){
            batch.draw(AssetLoader.runDownAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x-isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isLeft()){
            batch.draw(AssetLoader.runRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x+isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5,-isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isRight()){
            batch.draw(AssetLoader.runRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x-isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isUpLeft()){
            batch.draw(AssetLoader.runUpRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x+isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, -isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isDownLeft()){
            batch.draw(AssetLoader.runDownRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x+isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, -isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isUpRight()){
            batch.draw(AssetLoader.runUpRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x-isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, isaac.getWidth(), isaac.getHeight());
        }
        if(isaac.isDownRight()){
            batch.draw(AssetLoader.runDownRightAni.getKeyFrame(runTime/1.5f),
                    isaac.b2body.getPosition().x-isaac.getWidth()/2, isaac.b2body.getPosition().y-isaac.getHeight()/5, isaac.getWidth(), isaac.getHeight());
        }
    }

    public void playSlide(float runTime) {
        if (isaac.isUp() || isaac.facing.equals("up")) {
            batch.draw(AssetLoader.ewalkup.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDown() || isaac.facing.equals("down")) {
            batch.draw(AssetLoader.ewalkdown.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isLeft() || isaac.facing.equals("left")) {
            batch.draw(AssetLoader.ewalkright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isRight() || isaac.facing.equals("right")) {
            batch.draw(AssetLoader.ewalkright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isUpLeft() || isaac.facing.equals("upLeft")) {
            batch.draw(AssetLoader.ewalkupright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDownLeft() || isaac.facing.equals("downLeft")) {
            batch.draw(AssetLoader.ewalkdownright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x + isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, -isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isUpRight() || isaac.facing.equals("upRight")) {
            batch.draw(AssetLoader.ewalkupright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
        if (isaac.isDownRight() || isaac.facing.equals("downRight")) {
            batch.draw(AssetLoader.ewalkdownright.getKeyFrame(runTime*1.5f),
                    isaac.b2body.getPosition().x - isaac.getWidth() / 2, isaac.b2body.getPosition().y - isaac.getHeight() / 5, isaac.getWidth(), isaac.getHeight());
        }
    }

    public Color getRandColor(){
        Color defc = new Color(1,1,1,1f);
        color = new Color(1,1,1,1f);
        if(k<60) {
            int rand = MathUtils.random(8);
            switch (rand) {
                case 1:
                    color.set(Color.GREEN.r, Color.GREEN.g, Color.GREEN.b, 0.6f);
                    break;
                case 2:
                    color.set(Color.RED.r, Color.RED.g, Color.RED.b, 0.6f);
                    break;
                case 3:
                    color.set(Color.YELLOW.r, Color.YELLOW.g, Color.YELLOW.b, 0.6f);
                    break;
                case 4:
                    color.set(Color.BLUE.r, Color.BLUE.g, Color.BLUE.b, 0.6f);
                    break;
                case 5:
                    color.set(Color.GRAY.r, Color.GRAY.g, Color.GRAY.b, 0.6f);
                    break;
                case 6:
                    color.set(Color.CYAN.r, Color.CYAN.g, Color.CYAN.b, 0.6f);
                    break;
                case 7:
                    color.set(Color.MAGENTA.r, Color.MAGENTA.g, Color.MAGENTA.b, 0.6f);
                    break;
                case 8:
                    color.set(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, 0.6f);
                    break;
            }
            k++;
            return color;
        }
        else return defc;
    }

    public void playIntro(float runTime){
        batch.begin();
        batch.draw(AssetLoader.introani.getKeyFrame(runTime), 0, 0 , 800/3.337f, 480/3.35f);
        batch.end();
    }

    public void playIntroRepeat(float runTime){
        batch.begin();
        batch.draw(AssetLoader.introrepeatani.getKeyFrame(runTime), 0, 0 , 800/3.337f, 480/3.35f);
        batch.end();
    }

    public void shakeIntroRepeat(float runTime){
        batch.begin();
        batch.draw(AssetLoader.introrepeatani.getKeyFrame(runTime), 2f, 0 , 800/3.337f, 480/3.35f);
        batch.end();
        crack.update(Gdx.graphics.getDeltaTime());
        batch.begin();
        crack.draw(batch);
        batch.end();
        if(crack.isComplete()){
            crack.reset();
        }
    }

    public void shakeLeftIntroRepeat(float runTime){
        batch.begin();
        batch.draw(AssetLoader.introrepeatani.getKeyFrame(runTime), -2f, 0 , 800/3.337f, 480/3.35f);
        batch.end();

    }

    public ParticleEffect getPe(){
        return trail;
    }

    public ParticleEffect getSnow(){
        return snow;
    }

    public ParticleEffect getPeP() {
        return trailP;
    }

    public ParticleEffect getCrack() {
        return crack;
    }

    public Sprite getShadowP() { return shadowP; }

    public Sprite getOverlay() { return overlay; }

}
