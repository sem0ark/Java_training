package com.Components;

import com.dataStructure.AssetPool;
import com.jade.Component;
import com.jade.Window;
import com.util.Constants;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Player  extends Component {

    Sprite layerOne, layerTwo, layerThree, spaceship;
    public int width, height;
    public boolean onGround = true;
    public PlayerState state;

    public Player(Sprite layerOne, Sprite layerTwo, Sprite layerThree,
                  Color colorOne, Color colorTwo){

        this.spaceship = AssetPool.getSprite("GeometryDash_gameswithgabe/assets/player/spaceship.png");
        this.layerOne = layerOne;
        this.layerTwo = layerTwo;
        this.layerThree = layerThree;

        this.width = Constants.PLAYER_WIDTH;
        this.height = Constants.PLAYER_HEIGHT;
        this.state = PlayerState.NORMAL;

        int threshold = 200;
        for (int y=0; y<layerOne.image.getHeight(); y++) {
            for (int x=0; x<layerOne.image.getWidth(); x++) {
                Color color = new Color(layerOne.image.getRGB(x, y));
                if (color.getRed() >= threshold &&
                    color.getGreen() >= threshold &&
                    color.getBlue() >= threshold) {
                    layerOne.image.setRGB(x, y, colorOne.getRGB());
                }
            }
        }

        for (int y=0; y<layerTwo.image.getHeight(); y++) {
            for (int x=0; x<layerTwo.image.getWidth(); x++) {
                Color color = new Color(layerTwo.image.getRGB(x, y));
                if (color.getRed() >= threshold &&
                        color.getGreen() >= threshold &&
                        color.getBlue() >= threshold) {
                    layerTwo.image.setRGB(x, y, colorTwo.getRGB());
                }
            }
        }
    }

    @Override
    public void update(double dt) {
        if (Window.getWindow().keyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            if (state == PlayerState.NORMAL && onGround) {
                addJumpForce();
            }
            if (state == PlayerState.FLYING) {
                addFlyForce();
            }
            this.onGround = false;
        }

        if (this.state != PlayerState.FLYING && !onGround) {
            gameObject.transform.rotation += 10.0f*dt;
        } else if (this.state != PlayerState.FLYING) {
            gameObject.transform.rotation = (int)gameObject.transform.rotation % 360;
            if (gameObject.transform.rotation > 180 && gameObject.transform.rotation < 360) {
                gameObject.transform.rotation = 0;
            } else if (gameObject.transform.rotation > 0 && gameObject.transform.rotation < 180) {
                gameObject.transform.rotation = 0;
            }
        }
    }

    private void addJumpForce() {
        gameObject.getComponent(RigidBody.class).velocity.y = Constants.JUMP_FORCE;
    }

    private void addFlyForce() {
        gameObject.getComponent(RigidBody.class).velocity.y = Constants.JUMP_FORCE / 1.5f;
    }

    @Override
    public void draw(Graphics2D g2) {
        AffineTransform transform = new AffineTransform();

        if (state == PlayerState.NORMAL) {
            transform.setToIdentity();
            transform.translate(gameObject.transform.position.x, gameObject.transform.position.y);
            transform.rotate(gameObject.transform.rotation,
                    width * gameObject.transform.scale.x / 2.0,
                    height * gameObject.transform.scale.y / 2.0);
            transform.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);

            g2.drawImage(layerOne.image, transform, null);
            g2.drawImage(layerTwo.image, transform, null);
            g2.drawImage(layerThree.image, transform, null);
        } else {

            transform.setToIdentity();
            transform.translate(gameObject.transform.position.x, gameObject.transform.position.y);
            transform.rotate(gameObject.transform.rotation,
                    width * gameObject.transform.scale.x / 4.0,
                    height * gameObject.transform.scale.y / 4.0);
            transform.scale(gameObject.transform.scale.x / 2.0, gameObject.transform.scale.y / 2.0);
            transform.translate(15, 15);
            g2.drawImage(layerOne.image, transform, null);
            g2.drawImage(layerTwo.image, transform, null);
            g2.drawImage(layerThree.image, transform, null);


            transform.setToIdentity();
            transform.translate(gameObject.transform.position.x, gameObject.transform.position.y);
            transform.rotate(gameObject.transform.rotation,
                    width * gameObject.transform.scale.x / 2.0,
                    height * gameObject.transform.scale.y / 2.0);
            transform.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);

            g2.drawImage(spaceship.image, transform, null);
        }
    }

    public void die() {
        gameObject.transform.position.x=0;
        gameObject.transform.position.y=380;
        gameObject.getComponent(RigidBody.class).velocity.y = 0;
        gameObject.transform.rotation = 0;
        Window.getWindow().getCurrentScene().camera.position.x = 0;
    }

    @Override
    public Component copy() {
        return null;
    }

    @Override
    public String serialize(int tabSize) {
        return "";
    }
}
