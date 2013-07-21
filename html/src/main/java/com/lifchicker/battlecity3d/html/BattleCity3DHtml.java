package com.lifchicker.battlecity3d.html;

import com.lifchicker.battlecity3d.core.BattleCity3D;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class BattleCity3DHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new BattleCity3D();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
