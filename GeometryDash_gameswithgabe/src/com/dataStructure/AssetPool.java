package com.dataStructure;

import com.Components.Sprite;
import com.Components.SpriteSheet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AssetPool {

    static Map<String, Sprite> sprites = new HashMap<>();
    static Map<String, SpriteSheet> spritesheets = new HashMap<>();

    public static boolean hasSprite(String pictureFile) {
        File file = new File(pictureFile);
        return AssetPool.sprites.containsKey(file.getAbsolutePath());
    }

    public static boolean hasSpriteSheet(String pictureFile) {
        File file = new File(pictureFile);
        return AssetPool.sprites.containsKey(file.getAbsolutePath());
    }

    public static Sprite getSprite(String pictureFile) {
        File file = new File(pictureFile);
        if (AssetPool.hasSprite(file.getAbsolutePath())) {
            return AssetPool.sprites.get(file.getAbsolutePath());
        } else {
            Sprite sprite = new Sprite(pictureFile);
            AssetPool.addSprite(file.getAbsolutePath().toString(), sprite);
            return AssetPool.sprites.get(file.getAbsolutePath());
        }
    }

    public static SpriteSheet getSpriteSheet(String pictureFile) {
        File file = new File(pictureFile);
        if (AssetPool.hasSpriteSheet(file.getAbsolutePath())) {
            return AssetPool.spritesheets.get(file.getAbsolutePath());
        } else {
            System.out.println("SpriteSheet " + pictureFile + "does not exists");
            System.exit(-1);
        }
        return null;
    }

    public static void addSprite(String pictureFile, Sprite sprite) {
        File file = new File(pictureFile);
        if (!AssetPool.hasSprite(file.getAbsolutePath())) {
            AssetPool.sprites.put(file.getAbsolutePath(), sprite);
        } else {
            System.out.println("Asset pool already has asset: " + file.getAbsolutePath());
            System.exit(-1);
        }
    }

    public static void addSpriteSheet(String pictureFile, int tileWidth, int tileHeight,
                                      int spacing, int columns, int size) {
        File file  = new File(pictureFile);
        if (!AssetPool.hasSpriteSheet(file.getAbsolutePath())) {
            SpriteSheet spriteSheet = new SpriteSheet(pictureFile,tileWidth,
                    tileHeight, spacing, columns, size);
            AssetPool.spritesheets.put(file.getAbsolutePath(), spriteSheet);
        }

    }
}
