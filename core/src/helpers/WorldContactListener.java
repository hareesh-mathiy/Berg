package helpers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import gameobjects.InteractiveTileObject;
import gameobjects.InteractiveTileObjectPeng;

/**
 * Created by Hareesh on 3/25/2016.
 */
public class WorldContactListener implements ContactListener {

    GameRenderer renderer;

    public WorldContactListener(GameRenderer renderer){
        this.renderer = renderer;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if(fixA.getUserData() == "isaac" || fixB.getUserData() == "isaac"){
            Fixture isaac = fixA.getUserData() == "isaac" ? fixA : fixB;
            Fixture object = isaac == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObject){
                ((InteractiveTileObject) object.getUserData()).onHit(renderer);
            }
        }

        if(fixA.getUserData() == "penguin" || fixB.getUserData() == "penguin"){
            Fixture isaac = fixA.getUserData() == "penguin" ? fixA : fixB;
            Fixture object = isaac == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObjectPeng){
                ((InteractiveTileObjectPeng) object.getUserData()).onHit(renderer);
            }
        }
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if(fixA.getUserData() == "isaac" || fixB.getUserData() == "isaac"){
            Fixture isaac = fixA.getUserData() == "isaac" ? fixA : fixB;
            Fixture object = isaac == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObject){
                ((InteractiveTileObject) object.getUserData()).onEndHit(renderer);
            }
        }
        if(fixA.getUserData() == "penguin" || fixB.getUserData() == "penguin"){
            Fixture isaac = fixA.getUserData() == "penguin" ? fixA : fixB;
            Fixture object = isaac == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObjectPeng){
                ((InteractiveTileObjectPeng) object.getUserData()).onEndHit(renderer);
            }
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
