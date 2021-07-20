package com.Components;

import com.file.Parser;
import com.jade.Component;
import com.jade.GameObject;
import com.util.Constants;
import com.util.Vector2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class BoxBounds extends Bounds {
    public float width, height;
    public float halfWidth, halfHeight;
    public Vector2 center = new Vector2();
    public boolean isTrigger;
    public float xBuffer=0.0f, yBuffer=0.0f;

    public float enclosingRadius;

    public BoxBounds(float width, float height) {
        init(width, height, false, 0.0f, 0.0f);
    }

    public BoxBounds(float width, float height, float xBuffer, float yBuffer) {
        init(width, height, false, xBuffer, yBuffer);
    }

    public BoxBounds(float width, float height, boolean isTrigger, float xBuffer, float yBuffer) {
        init(width, height, isTrigger, xBuffer, yBuffer);
    }

    public BoxBounds(float width, float height, boolean isTrigger) {
        init(width, height, isTrigger, 0.0f,0.0f);
    }

    public void init(float width, float height, boolean isTrigger, float xBuffer, float yBuffer) {
        this.width = width;
        this.height = height;
        this.halfHeight = height / 2.0f;
        this.halfWidth = width / 2.0f;
        this.type = BoundsType.Box;
        this.enclosingRadius = (float) Math.sqrt(this.halfHeight*this.halfHeight + this.halfWidth*this.halfWidth);
        this.isTrigger = isTrigger;
        this.xBuffer = xBuffer;
        this.yBuffer = yBuffer;
    }

    @Override
    public void start() {
        this.calculateCenter();
    }

    public void calculateCenter() {
        this.center.x = this.gameObject.transform.position.x + this.halfWidth + this.xBuffer;
        this.center.y = this.gameObject.transform.position.y + this.halfHeight + this.yBuffer;
    }

    @Override
    public void update(double dt) {
    }

    public static boolean checkCollision(BoxBounds b1, BoxBounds b2) {
        b1.calculateCenter();
        b2.calculateCenter();

        float dx = b2.center.x - b1.center.x;
        float dy = b2.center.y - b1.center.y;

        float combinedHalfWidth = b1.halfWidth + b2.halfWidth;
        float combinedHalfHeight= b1.halfHeight + b2.halfHeight;

        if (Math.abs(dx) <= combinedHalfWidth) {
            return Math.abs(dy) <= combinedHalfHeight;
        }

        return false;
    }

    public void resolveCollision(GameObject player) {
        if (isTrigger) return;

        BoxBounds playerBounds = player.getComponent(BoxBounds.class);

        playerBounds.calculateCenter();
        this.calculateCenter();

        float dx = this.center.x - playerBounds.center.x;
        float dy = this.center.y - playerBounds.center.y;

        float combinedHalfWidth = playerBounds.halfWidth + this.halfWidth;
        float combinedHalfHeight= playerBounds.halfHeight + this.halfHeight;

        float overlapX = combinedHalfWidth - Math.abs(dx);
        float overlapY = combinedHalfHeight - Math.abs(dy);

        if (overlapX >= overlapY) {
            if (dy > 0) {
                // collision on the top of the player
                player.transform.position.y = gameObject.transform.position.y - playerBounds.getHeight() + yBuffer;
                player.getComponent(RigidBody.class).velocity.y = 0;
                player.getComponent(Player.class).onGround = true;
            } else {
                player.getComponent(Player.class).die();
            }
        } else {
            // Collision on the left or right of the player
            if (dx < 0 && dy <= 0.3) {
                player.transform.position.y = gameObject.transform.position.y - playerBounds.getHeight() + yBuffer;
                player.getComponent(RigidBody.class).velocity.y = 0;
                player.getComponent(Player.class).onGround = true;
            } else {
                player.getComponent(Player.class).die();
            }
        }
    }

    @Override
    public Component copy() {
        return new BoxBounds(width, height, isTrigger, xBuffer, yBuffer);
    }


    @Override
    public String serialize(int tabSize) {
        StringBuilder builder = new StringBuilder();

        builder.append(beginObjectProperty("BoxBounds", tabSize));
        builder.append(addFloatProperty("width", this.width, tabSize + 1, true, true));
        builder.append(addFloatProperty("height", this.height, tabSize + 1, true, true));
        builder.append(addFloatProperty("xBuffer", this.xBuffer, tabSize + 1, true, true));
        builder.append(addFloatProperty("yBuffer", this.yBuffer, tabSize + 1, true, true));
        builder.append(addBooleanProperty("isTrigger", this.isTrigger, tabSize + 1, true, false));
        builder.append(closeObjectProperty(tabSize));

        return builder.toString();
    }

    public static BoxBounds deserialize() {
        float width = Parser.consumeFloatProperty("width");
        Parser.consume(',');
        float height = Parser.consumeFloatProperty("height");
        Parser.consume(',');
        float xBuffer = Parser.consumeFloatProperty("xBuffer");
        Parser.consume(',');
        float yBuffer = Parser.consumeFloatProperty("yBuffer");
        Parser.consume(',');
        boolean isTrigger = Parser.consumeBooleanProperty("isTrigger");
        Parser.consumeEndObjectProperty();

        return new BoxBounds(width, height, isTrigger, xBuffer, yBuffer);
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public boolean rayCast(Vector2 position) {
        return position.x > this.gameObject.transform.position.x + this.xBuffer &&
                position.x < this.gameObject.transform.position.x + this.width + this.xBuffer&&
                position.y > this.gameObject.transform.position.y + this.yBuffer &&
                position.y < this.gameObject.transform.position.y + this.height + this.yBuffer;
    }

    @Override
    public void draw(Graphics2D g2) {
        if (isSelected) {
            g2.setColor(Color.GREEN);
            g2.setStroke(Constants.THICK_LINE);
            g2.draw(new Rectangle2D.Float(
                    this.gameObject.transform.position.x + this.xBuffer,
                    this.gameObject.transform.position.y + this.yBuffer,
                    this.width, this.height));
            g2.setStroke(Constants.LINE);
        }
    }
}
