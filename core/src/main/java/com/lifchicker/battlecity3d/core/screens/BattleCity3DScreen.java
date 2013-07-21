/*
* BattleCity3DScreen.java
*
* Created on 26 06 2013, 15:08
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.core.screens;

import com.badlogic.gdx.Screen;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-26
 */
public abstract class BattleCity3DScreen  implements Screen {
    public abstract void update (float delta);

    public abstract void draw (float delta);

    public abstract boolean isDone ();

    public void render (float delta) {
        update(delta);
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void hide() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dispose() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
