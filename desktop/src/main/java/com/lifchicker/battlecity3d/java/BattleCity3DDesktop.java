package com.lifchicker.battlecity3d.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.lifchicker.battlecity3d.core.BattleCity3D;

public class BattleCity3DDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		new LwjglApplication(new BattleCity3D(), config);
	}
}
