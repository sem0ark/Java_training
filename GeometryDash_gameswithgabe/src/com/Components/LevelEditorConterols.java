package com.Components;

import com.jade.Component;
import com.jade.GameObject;
import com.jade.LevelEditorScene;
import com.jade.Window;
import com.util.Constants;
import com.util.Vector2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

public class LevelEditorConterols extends Component {

    private float debounceTime = 0.2f;
    private float debounceLeft = 0.0f;

    private float debounceKey = 0.2f;
    private float debounceKeyLeft = 0.0f;

    private boolean shiftKeyPressed = false;
    private float dragX, dragY, dragWidth, dragHeight;

    private List<GameObject> selectedObjects;

    int gridWidth, gridHeight;
    private float worldX, worldY;
    private boolean isEditing = false;

    private boolean wasDragged = false;

    public LevelEditorConterols(int gridWidth, int gridHeight) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.selectedObjects = new ArrayList<>();
    }

    public void updateSpritePosition() {
        this.worldX = (float) Math.floor((Window.getWindow().mouseListener.x +
                Window.getWindow().getCurrentScene().camera.position.x +
                Window.getWindow().mouseListener.dx) / gridWidth);

        this.worldY = (float) Math.floor((Window.getWindow().mouseListener.y +
                Window.getWindow().getCurrentScene().camera.position.y +
                Window.getWindow().mouseListener.dy) / gridHeight);

        this.gameObject.transform.position.x = worldX * gridWidth -
                Window.getWindow().getCurrentScene().camera.position.x;
        this.gameObject.transform.position.y = worldY * gridHeight -
                Window.getWindow().getCurrentScene().camera.position.y;
    }

    public void copyGameObjectToScene() {
        GameObject object = gameObject.copy();
        object.transform.position = new Vector2(worldX * gridWidth, worldY * gridHeight);
        Window.getWindow().getCurrentScene().addGameObject(object);
    }

    public void addGameObjectToSlected(Vector2 mousePos) {
        mousePos.x += Window.getScene().camera.position.x;
        mousePos.y += Window.getScene().camera.position.y;
        for (GameObject go : Window.getScene().getAllGameObjects()) {
            Bounds bounds = go.getComponent(Bounds.class);
            if (bounds != null && bounds.rayCast(mousePos)) {
                selectedObjects.add(go);
                bounds.isSelected = true;
                break;
            }
        }
    }

    public List<GameObject> boxCast(float x, float y, float width, float height) {
        float x0 = x + Window.getScene().camera.position.x;
        float y0 = y + Window.getScene().camera.position.y;

        List<GameObject> objs = new ArrayList<>();
        for (GameObject go : Window.getScene().getAllGameObjects()) {
            Bounds b = go.getComponent(Bounds.class);
            if (b != null) {
                if (go.transform.position.x + b.getWidth() <= x0 + width &&
                    go.transform.position.y + b.getHeight() <= y0 + height &&
                    go.transform.position.x >= x0 &&
                    go.transform.position.y >= y0) {
                    objs.add(go);
                }
            }
        }

        return objs;
    }

    public void clearSelectedObjects() {
        for (GameObject go : selectedObjects) {
            go.getComponent(Bounds.class).isSelected = false;
        }
        selectedObjects.clear();
    }

    public void escapeKeyPressed() {
        GameObject newGameObj = new GameObject("Mouse cursor",
                this.gameObject.transform.copy(), this.gameObject.zIndex);
        newGameObj.addComponent(this);
        LevelEditorScene scene = (LevelEditorScene) Window.getScene();
        scene.mouseCursor = newGameObj;
        isEditing = false;
    }

    @Override
    public void update (double dt) {
        debounceLeft -= dt;
        debounceKeyLeft -= dt;

        if (!isEditing && this.gameObject.getComponent(Sprite.class) != null) {
            this.isEditing = true;
        }

        if (isEditing) {
            if (selectedObjects.size() != 0) clearSelectedObjects();
            updateSpritePosition();
        }

        if (Window.getWindow().mouseListener.y < Constants.TAB_OFFSET_Y &&
            Window.getWindow().mouseListener.mousePressed &&
            Window.getWindow().mouseListener.mouseButton == MouseEvent.BUTTON1 &&
            debounceLeft < 0 && !wasDragged) {
            // Mouse has been clicked
            debounceLeft = debounceTime;
            if (isEditing) {
                copyGameObjectToScene();
            } else if (Window.keyListener().isKeyPressed(KeyEvent.VK_SHIFT)){
                addGameObjectToSlected(new Vector2(Window.mouseListener().x, Window.mouseListener().y));
            } else {
                clearSelectedObjects();
                addGameObjectToSlected(new Vector2(Window.mouseListener().x, Window.mouseListener().y));
            }
        } else if (!Window.mouseListener().mousePressed && wasDragged) {
            wasDragged = false;
            clearSelectedObjects();
            List<GameObject> objs = boxCast(dragX, dragY, dragWidth, dragHeight);
            for (GameObject go : objs) {
                selectedObjects.add(go);
                Bounds b = go.getComponent(Bounds.class);
                if (b != null) {
                    b.isSelected = true;
                }
            }
        }

        if (Window.keyListener().isKeyPressed(KeyEvent.VK_ESCAPE)) {
            escapeKeyPressed();
        }

        shiftKeyPressed = Window.keyListener().isKeyPressed(KeyEvent.VK_SHIFT);



        if (debounceKeyLeft <= 0) {
            if (Window.keyListener().isKeyPressed(KeyEvent.VK_LEFT)) {
                debounceKeyLeft = debounceKey;
                moveObjects(Direction.LEFT, shiftKeyPressed ? 0.1f : 1.0f);
            } else if (Window.keyListener().isKeyPressed(KeyEvent.VK_RIGHT)) {
                debounceKeyLeft = debounceKey;
                moveObjects(Direction.RIGHT, shiftKeyPressed ? 0.1f : 1.0f);
            } else if (Window.keyListener().isKeyPressed(KeyEvent.VK_DOWN)) {
                debounceKeyLeft = debounceKey;
                moveObjects(Direction.DOWN, shiftKeyPressed ? 0.1f : 1.0f);
            } else if (Window.keyListener().isKeyPressed(KeyEvent.VK_UP)) {
                debounceKeyLeft = debounceKey;
                moveObjects(Direction.UP, shiftKeyPressed ? 0.1f : 1.0f);
            }

            if (Window.keyListener().isKeyPressed(KeyEvent.VK_D)) {
                if (Window.keyListener().isKeyPressed(KeyEvent.VK_CONTROL)) {
                    duplicate();
                    debounceKeyLeft = debounceKey;
                }
            }

            if (Window.keyListener().isKeyPressed(KeyEvent.VK_Q)) {
                rotateObjects(90);
                debounceKeyLeft = debounceKey;
            } else if (Window.keyListener().isKeyPressed(KeyEvent.VK_E)){
                rotateObjects(-90);
                debounceKeyLeft = debounceKey;
                System.out.println("rotated right");
            }

            if (Window.keyListener().isKeyPressed(KeyEvent.VK_DELETE)) {
                for (GameObject go : selectedObjects) {
                    Window.getScene().removeGameObject(go);
                }
                selectedObjects.clear();
                debounceKeyLeft = debounceKey;
            }
        }
    }

    public void rotateObjects(float degrees) {
        for (GameObject go : selectedObjects) {
            go.transform.rotation += degrees;
            TriangleBounds b = go.getComponent(TriangleBounds.class);
            if (b != null) b.calculateTransform();
        }
    }

    public void moveObjects(Direction direction, float scale) {
        Vector2 distance = new Vector2(0.0f, 0.0f);
        switch (direction) {
            case UP:
                distance.y = -Constants.TILE_HEIGHT * scale;
                break;
            case DOWN:
                distance.y = Constants.TILE_HEIGHT * scale;
                break;
            case LEFT:
                distance.x = -Constants.TILE_WIDTH * scale;
                break;
            case RIGHT:
                distance.x = Constants.TILE_WIDTH * scale;
                break;
            default:
                System.out.println("Error: Direction has no enum '" + direction +"'");
                System.exit(-1);
                break;
        }

        for (GameObject go : selectedObjects) {
            go.transform.position.y += distance.y;
            go.transform.position.x += distance.x;
            float gridX = (float)(Math.floor((go.transform.position.x / Constants.TILE_WIDTH) + 1) * Constants.TILE_WIDTH);
            float gridY = (float)(Math.floor(go.transform.position.x / Constants.TILE_WIDTH) * Constants.TILE_WIDTH);

            if (go.transform.position.x < gridX + 1 && go.transform.position.x > gridX - 1) {
                go.transform.position.x = gridX;
            }

            if (go.transform.position.y < gridY + 1 && go.transform.position.y > gridY - 1) {
                go.transform.position.y = gridY;
            }

            TriangleBounds b = go.getComponent(TriangleBounds.class);
            if (b != null) b.calculateTransform();
        }
    }

    public void duplicate() {
        for (GameObject go : selectedObjects) {
            Window.getScene().addGameObject(go.copy());
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (isEditing) {
            Sprite sprite = gameObject.getComponent(Sprite.class);
            if (sprite != null) {
                float alpha = 0.5f;
                AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
                g2.setComposite(ac);
                g2.drawImage(sprite.image,
                        (int) gameObject.transform.position.x,
                        (int) gameObject.transform.position.y,
                        (int) sprite.width, (int) sprite.height, null);
                alpha = 1.0f;
                ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
                g2.setComposite(ac);
            }
        } else if (Window.mouseListener().mouseDragged &&
                Window.mouseListener().mouseButton == MouseEvent.BUTTON1) {
            wasDragged = true;
            g2.setColor(new Color(1f, 1f, 1f, 0.3f));
            dragX = Window.mouseListener().x;
            dragY = Window.mouseListener().y;
            dragWidth = Window.mouseListener().dx;
            dragHeight = Window.mouseListener().dy;
            if (dragWidth < 0) {
                dragWidth *= -1;
                dragX -= dragWidth;
            }
            if (dragHeight < 0) {
                dragHeight *= -1;
                dragY -= dragHeight;
            }
            g2.fillRect((int)dragX, (int)dragY, (int)dragWidth, (int)dragHeight);
        }
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
