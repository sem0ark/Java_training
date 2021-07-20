package com.main;

import com.jade.Window;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Window window = Window.getWindow();
        window.init();
        Thread mainThread = new Thread(window);
        mainThread.start();
    }

}
