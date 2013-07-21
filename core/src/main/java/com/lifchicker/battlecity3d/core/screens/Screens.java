package com.lifchicker.battlecity3d.core.screens;

import com.badlogic.gdx.Screen;

/**
 * Created with IntelliJ IDEA.
 * Project BattleCity3D
 * User: valor
 * Date: 21.07.13
 * Time: 10:10
 *
 *  All available interaction screens.
 *
 */
public enum Screens {

    INTRO {
        @Override
        protected Screen getScreenInstance() {
            return new Intro();
        }
    },

    MAIN_MENU {
        @Override
        protected Screen getScreenInstance() {
            return new MainMenu();
        }
    },

    GAME {
        @Override
        protected Screen getScreenInstance() {
            return new GameLoop();
        }
    },

    CREDITS {
        @Override
        protected Screen getScreenInstance() {
            return new MainMenu(); //TODO: NOT IMPLEMENTED
        }
    };

    protected abstract Screen getScreenInstance();

}