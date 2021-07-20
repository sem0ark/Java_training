package com.Components;

import com.jade.Component;
import com.jade.GameObject;
import com.util.Vector2;

enum BoundsType {
    Box,
    Triangle
}

public abstract class Bounds extends Component {

    public BoundsType type;
    public boolean isSelected;

    abstract public float getWidth();
    abstract public float getHeight();
    abstract public boolean rayCast(Vector2 position);

    public static boolean checkCollision(Bounds b1, Bounds b2) {
        // we know that at least 1 bounds will always be a box
        if (b1.type == b2.type && b1.type == BoundsType.Box) {
            return BoxBounds.checkCollision((BoxBounds) b1, (BoxBounds) b2);
        } else if (b1.type == BoundsType.Box && b2.type == BoundsType.Triangle) {
            return TriangleBounds.checkCollision((BoxBounds) b1, (TriangleBounds) b2);
        } else if (b1.type == BoundsType.Triangle && b2.type == BoundsType.Box) {
            return TriangleBounds.checkCollision((BoxBounds) b2, (TriangleBounds) b1);
        }

        return false;
    }

    public static void resolveCollicsion(Bounds b, GameObject plr) {
        if (b.type == BoundsType.Box) {
            BoxBounds box = (BoxBounds) b;
            box.resolveCollision(plr);
        } else if (b.type == BoundsType.Triangle) {
            plr.getComponent(Player.class).die();
        }
    }
}
