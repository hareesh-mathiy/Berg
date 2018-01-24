package gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import gamelocations.LevelLoader;
import helpers.GameRenderer;

/**
 * Created by Hareesh on 3/28/2016.
 */
public class PenguinBounds extends InteractiveTileObjectPeng{
    MapObjects objects;
    MapObject object;
    String hc;

    public PenguinBounds(World world, TiledMap map, Shape shape, LevelLoader ll, MapObject object) {
        super(world, map, shape, ll, object);
        this.object = object;
        fixture.setUserData(this);
    }

    @Override
    public void onHit(GameRenderer renderer) {
        Gdx.app.log("PenguinBounds", "start hit");
        renderer.getPenguin().colliding = true;

    }

    @Override
    public void onEndHit(GameRenderer renderer) {
        Gdx.app.log("PenguinBounds", "end hit");
        renderer.getPenguin().colliding = false;



    }
}
