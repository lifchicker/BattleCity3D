package com.lifchicker.battlecity3d.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.lifchicker.battlecity3d.core.screens.BattleCity3DScreen;
import com.lifchicker.battlecity3d.core.screens.GameLoop;
import com.lifchicker.battlecity3d.core.screens.ScreenManager;
import com.lifchicker.battlecity3d.core.screens.Screens;


public class BattleCity3D extends Game {

    private FPSLogger fpsLogger;


    public void create() {
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().show(Screens.GAME);
        fpsLogger = new FPSLogger();
	}

	public void dispose() {
        super.dispose();
        ScreenManager.getInstance().dispose();
	}

	public void render() {
        BattleCity3DScreen screen = getScreen();

        screen.render(Gdx.graphics.getDeltaTime());

        fpsLogger.log();
    }

    @Override
    public BattleCity3DScreen getScreen () {
        return (BattleCity3DScreen) super.getScreen();
    }
}
