package com.jade;

import com.util.Constants;
import com.util.Time;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Window extends JFrame implements Runnable {

    public ML mouseListener;
    public KL keyListener;
    public boolean isInEditor;

    private static Window window = null;
    private boolean isRunning = true;

    private Scene currentScene = null;
    private Image doubleBufferImage = null;
    private Graphics doubleBufferGraphics = null;

    public Window() {
        this.mouseListener = new ML();
        this.keyListener = new KL();

//        this.setSize(1280, 720);
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.addKeyListener(keyListener);

        this.setVisible(true);
    }

    public void init() {
        changeScene(0);
//        draw(getGraphics());
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void changeScene(int scene) {
        switch (scene) {
            case 0:
                isInEditor = true;
                currentScene = new LevelEditorScene("Level Editor");
                currentScene.init();
                break;
            case 1:
                isInEditor = false;
                currentScene = new LevelScene("Level");
                currentScene.init();
                break;
            default:
                System.out.println("Unknown scene");
                currentScene = null;
                break;
        }
    }

    public void update(double dt) {
        currentScene.update(dt);
        draw(getGraphics());
    }

    public  void draw(Graphics g) {
        if (doubleBufferImage == null) {
            doubleBufferImage = createImage(getWidth(), getHeight());
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }

        renderOffscreen(doubleBufferGraphics);

        g.drawImage(doubleBufferImage, 0, 0,getWidth(), getHeight(), null);
    }

    public void renderOffscreen(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g2);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        try {
            while(isRunning) {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                update(deltaTime);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Scene getScene() {
        return getWindow().getCurrentScene();
    }

    public static ML mouseListener() {
        return getWindow().mouseListener;
    }

    public static KL keyListener() {
        return getWindow().keyListener;
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }
        return Window.window;
    }
}
