package transitions;

import aurelienribon.tweenengine.TweenAccessor;
import gameobjects.psynergy.Move;

/**
 * Created by Hareesh on 2016-03-30.
 */
public class MovePsyAccessor implements TweenAccessor<Move> {

    public static final int X = 1;
    public static final int Y = 2;
    @Override
    public int getValues(Move target, int tweenType, float[] returnValues) {
        switch(tweenType) {
            case X:
                returnValues[0] = target.getX();
                return 1;
            case Y:
                returnValues[1] = target.getY();
                return 2;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Move target, int tweenType, float[] newValues) {
        switch(tweenType){
            case X:
                target.setX(newValues[0]);
                break;
            case Y:
                target.setY(newValues[1]);
                break;
            default:
                assert false;
        }
    }
}