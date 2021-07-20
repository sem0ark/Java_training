package com.ui;

import com.Components.Bounds;
import com.Components.BoxBounds;
import com.Components.PlayerState;
import com.Components.Portal;
import com.Components.Sprite;
import com.Components.SpriteSheet;
import com.Components.TriangleBounds;
import com.dataStructure.AssetPool;
import com.dataStructure.Transform;
import com.jade.Component;
import com.jade.GameObject;
import com.jade.Window;
import com.util.Constants;
import com.util.Vector2;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainContainer extends Component {
    public Sprite containerBg;

    public List<GameObject> menuItems;

    public List<GameObject> tabs;
    public Map<GameObject, List<GameObject>> tabMaps;
    private GameObject hotTab;

    private GameObject hotButton = null;

    public MainContainer() {
        this.menuItems = new ArrayList<>();
        this.tabs = new ArrayList<>();
        this.tabMaps = new HashMap<>();
        this.containerBg = AssetPool.getSprite(
                "GeometryDash_gameswithgabe/assets/ui/menuContainerBackground.png");
        init();
    }

    public void init() {
        SpriteSheet tabSprites = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/ui/tabs.png");

        for (int i=0; i<tabSprites.sprites.size(); i++) {
            Sprite currentTab = tabSprites.sprites.get(i);

            int x = Constants.TAB_OFFSET_X + (currentTab.column * Constants.TAB_WIDTH) +
                    (currentTab.column * Constants.TAB_HORIZONTAL_SPACING);
            int y = Constants.TAB_OFFSET_Y;

            GameObject obj = new GameObject("Tab", new Transform(new Vector2(x, y)), 10);
            obj.setUi(true);
            obj.setNonSerializable();
            TabItem tabItem = new TabItem(x, y, Constants.TAB_WIDTH, Constants.TAB_HEIGHT,
                    currentTab, this);
            obj.addComponent(tabItem);

            this.tabs.add(obj);
            this.tabMaps.put(obj, new ArrayList<>());
            Window.getWindow().getCurrentScene().addGameObject(obj);
        }

        this.hotTab = this.tabs.get(0);
        this.hotTab.getComponent(TabItem.class).isSelected = true;

        addTabObjects();

    }

    private void addTabObjects() {
        SpriteSheet groundSpirtes = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/spritesheet.png");
        SpriteSheet buttonSprites = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/ui/buttonSprites.png");
        SpriteSheet spikeSprites= AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/spikes.png");
        SpriteSheet bigSprites = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/bigSprites.png");
        SpriteSheet smallBlocks = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/smallBlocks.png");
        SpriteSheet portalSprites = AssetPool.getSpriteSheet("GeometryDash_gameswithgabe/assets/portal.png");

        for (int i=0; i<groundSpirtes.sprites.size(); i++) {
            Sprite currentSprite = groundSpirtes.sprites.get(i);
            int x = Constants.BUTTON_OFFSET_X + currentSprite.column *
                    (Constants.BUTTON_WIDTH + Constants.BUTTON_SPACING_HZ);
            int y = Constants.BUTTON_OFFSET_Y + currentSprite.row *
                    (Constants.BUTTON_HEIGHT + Constants.BUTTON_SPACING_VT);

            // Add first tab conteiner objs
            GameObject obj = new GameObject("Gen", new Transform(new Vector2(x, y)), 10);
            obj.setUi(true);
            obj.setNonSerializable();
            obj.addComponent(currentSprite.copy());
            MenuItem menuItem = new MenuItem(x, y, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT,
                    buttonSprites.sprites.get(0), buttonSprites.sprites.get(1), this);
            obj.addComponent(menuItem);
            obj.addComponent(new BoxBounds(Constants.TILE_WIDTH, Constants.TILE_HEIGHT));
            this.tabMaps.get(this.tabs.get(0)).add(obj);

            // Add second tab container objs
            if (i < smallBlocks.sprites.size()) {
                obj = addObjectTab(menuItem.copy(), smallBlocks, i, x, y);

                if (i==0) {
                    obj.addComponent(new BoxBounds(Constants.TILE_WIDTH, 16,0,26));
                }

                this.tabMaps.get(tabs.get(1)).add(obj);
            }

            // Add fourth tab container objs
            if (i < spikeSprites.sprites.size()) {
                obj = addObjectTab(menuItem.copy(), spikeSprites, i, x, y);

                // TODO:: Add triangleBounds component here
//                obj.addComponent(new TriangleBounds(42, 42));
                Bounds t;
                switch (i) {
                    case 0:
                        t = new TriangleBounds(42, 42);
                        break;
                    case 1, 3:
                        t = new TriangleBounds(42, 18, 0, 24);
                        break;
                    case 2:
                        t = new TriangleBounds(21, 21, 10.5f, 21);
                        break;
                    default:
                        t = new TriangleBounds(42, 42);
                        break;
                }
                obj.addComponent(t);
                this.tabMaps.get(this.tabs.get(3)).add(obj);
            }

            // Add fifth tab container objs
            if (i == 0) {
                obj = addObjectTab(menuItem.copy(), bigSprites, i, x, y);
                obj.addComponent(new BoxBounds(Constants.TILE_WIDTH * 2, 56));
                this.tabMaps.get(tabs.get(4)).add(obj);
            }

            // Add fifth tab container objs
            if (i < portalSprites.sprites.size()) {
                obj = addObjectTab(menuItem.copy(), portalSprites, i, x, y);

                obj.addComponent(new BoxBounds(44, 85, true));

                // TODO:: create portalComponent here

                if (i==0) obj.addComponent(new Portal(PlayerState.FLYING));
                else obj.addComponent(new Portal(PlayerState.NORMAL));

                this.tabMaps.get(tabs.get(5)).add(obj);
            }
        }
    }

    private GameObject addObjectTab(MenuItem menuItem, SpriteSheet spriteSheet, int i, int x, int y) {
        GameObject obj = new GameObject("Gen", new Transform(new Vector2(x, y)), 10);
        obj.setUi(true);
        obj.setNonSerializable();
        obj.addComponent(spriteSheet.sprites.get(i));
        obj.addComponent(menuItem);
        return obj;
    }

    @Override
    public void start() {
        for (GameObject g: tabs) {
            for (GameObject g2: tabMaps.get(g)) {
                for (Component c : g2.getAllComponents()) {
                    c.start();
                }
            }
        }
    }

    @Override
    public void update(double dt) {
        for (GameObject g: this.tabMaps.get(hotTab)) {
            g.update(dt);

            MenuItem menuItem = g.getComponent(MenuItem.class);
            if (g != hotButton && menuItem.isSelected) {
                menuItem.isSelected = false;
            }
        }

        for (GameObject g : this.tabs) {
            TabItem tabItem = g.getComponent(TabItem.class);
            if (g != hotTab && tabItem.isSelected) {
                tabItem.isSelected = false;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(this.containerBg.image, 0, Constants.CONTAINER_OFFSET_Y,
                this.containerBg.width, this.containerBg.height, null);

        for (GameObject g: this.tabMaps.get(hotTab)) {
            g.draw(g2);
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

    public void setHotButton(GameObject obj) {
        this.hotButton = obj;
    }

    public void setHotTab(GameObject obj) {
        this.hotTab = obj;
    }
}
