package com.lifchicker.battlecity3d;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "BattleCity3D";
		cfg.useGL20 = true;
		cfg.width = 1024;
		cfg.height = 768;
        cfg.vSyncEnabled = true;
        cfg.resizable = false;
        cfg.initialBackgroundColor = new Color(0.45f, 0.45f, 0.45f, 1.0f);

		new LwjglApplication(new BattleCity3D(), cfg);
	}
}
