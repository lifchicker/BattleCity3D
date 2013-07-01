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
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.materials.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.materials.TextureAttribute;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

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
    public ArrayList<Block> blocks = new ArrayList<>();
    public Model blockModel;

    public Simulation () {
        loadLevel();
    }

    private void loadLevel() {
        ObjLoader objLoader = new ObjLoader();
        tankModel = objLoader.loadModel(Gdx.files.internal("data/tank.obj"));
        final Texture tankTexture = new Texture(Gdx.files.internal("data/tank.png"), Pixmap.Format.RGB565, true);
        tankTexture.setFilter(Texture.TextureFilter.MipMap, Texture.TextureFilter.Linear);
        tankModel.materials.get(0).set(TextureAttribute.createDiffuse(tankTexture));

        blockModel = objLoader.loadModel(Gdx.files.internal("data/block.obj"));
        ((ColorAttribute)blockModel.materials.get(0).get(ColorAttribute.Diffuse)).color.set(0.76f, 0.4f, 0.1f, 1f);

        tank = new Tank(tankModel, 0, PLAYFIELD_MIN_Z+1);

        blocks.add(new Block(blockModel, 0.5f, 0.5f));
        blocks.add(new Block(blockModel, -0.5f, 0.5f));
        blocks.add(new Block(blockModel, 0.5f, -0.5f));
    }

    public void dispose() {
        tankModel.dispose();
        blockModel.dispose();
    }

    public void update(float delta) {
        for (Block block : blocks) {
            if (tank.collide(block)) {
                tank.setCanMove(false);
            }
        }

        tank.update(delta);
    }

    public void moveTank(float delta, Vector2 moveDirection) {
        tank.move(delta, moveDirection);
    }
}
