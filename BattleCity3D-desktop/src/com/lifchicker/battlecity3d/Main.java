package com.lifchicker.battlecity3d;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "BattleCity3D";
		cfg.useGL20 = true;
		cfg.width = 1024;
		cfg.height = 768;
        cfg.vSyncEnabled = true;

		new LwjglApplication(new BattleCity3D(), cfg);
	}
}
