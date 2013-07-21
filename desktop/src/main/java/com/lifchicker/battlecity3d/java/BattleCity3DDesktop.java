package com.lifchicker.battlecity3d.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.badlogic.gdx.graphics.Color;
import com.lifchicker.battlecity3d.core.BattleCity3D;

public class BattleCity3DDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.title = "BattleCity3D";
        config.useGL20 = true;
        config.width = 1024;
        config.height = 768;
        config.vSyncEnabled = true;
        config.resizable = false;
        config.initialBackgroundColor = new Color(0.45f, 0.45f, 0.45f, 1.0f);

        new LwjglApplication(new BattleCity3D(), config);
    }

}
