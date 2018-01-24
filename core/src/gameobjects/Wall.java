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
public class Wall extends InteractiveTileObject{
    MapObjects objects;
    MapObject object;
    String hc;

    public Wall(World world, TiledMap map, Shape shape, LevelLoader ll, MapObject object) {
        super(world, map, shape, ll, object);
        this.object = object;
        fixture.setUserData(this);
    }

    @Override
    public void onHit(GameRenderer renderer) {
        Gdx.app.log("WALL", "start hit");
        renderer.getIsaac().colliding = true;
        objects = map.getLayers().get(4).getObjects();
        for (MapObject obj : objects) {
            hc = (String) obj.getProperties().get("a");
            if (hc != null) {
                if((object.equals(obj)) && Integer.parseInt(hc) == 1) {
                    renderer.getIsaac().setHPos(0);
                }
            }
        }
        renderer.getIsaac().falling = true;

    }

    @Override
    public void onEndHit(GameRenderer renderer) {
        Gdx.app.log("WALL", "end hit");
        renderer.getIsaac().colliding = false;



    }
}
