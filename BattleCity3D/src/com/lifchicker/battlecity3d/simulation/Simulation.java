/*
* Simulation.java
*
* Created on 26 06 2013, 15:25
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.materials.TextureAttribute;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-26
 */
public class Simulation implements Disposable {
    public static final float PLAYFIELD_MIN_X = -13;
    public static final float PLAYFIELD_MAX_X = 13;
    public static final float PLAYFIELD_MIN_Z = -14;
    public static final float PLAYFIELD_MAX_Z = 14;

    public Tank tank;
    public Model tankModel;


    public Simulation () {
        createTank();
    }

    private void createTank() {
        ObjLoader objLoader = new ObjLoader();
        tankModel = objLoader.loadModel(Gdx.files.internal("data/tank.obj"));
        final Texture tankTexture = new Texture(Gdx.files.internal("data/tank.png"), Pixmap.Format.RGB565, true);
        tankTexture.setFilter(Texture.TextureFilter.MipMap, Texture.TextureFilter.Linear);
        tankModel.materials.get(0).set(TextureAttribute.createDiffuse(tankTexture));

        tank = new Tank(tankModel);
    }

    public void dispose() {
        tankModel.dispose();
    }

    public void update(float delta) {
    }

    public void moveTank(float delta, Vector2 moveDirection) {
        tank.update(delta, moveDirection);
    }
}
