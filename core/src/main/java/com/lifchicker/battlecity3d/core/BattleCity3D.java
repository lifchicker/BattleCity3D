package com.lifchicker.battlecity3d.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.lifchicker.battlecity3d.core.screens.BattleCity3DScreen;
import com.lifchicker.battlecity3d.core.screens.GameLoop;


public class BattleCity3D extends Game {

    private FPSLogger fpsLogger;


    public void create() {
        setScreen(new GameLoop());
        fpsLogger = new FPSLogger();
	}

	public void dispose() {
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
