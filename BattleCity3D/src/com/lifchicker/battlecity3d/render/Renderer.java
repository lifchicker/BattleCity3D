/*
* Renderer.java
*
* Created on 26 06 2013, 15:45
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.lights.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.lights.Lights;
import com.badlogic.gdx.graphics.g3d.lights.PointLight;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.lifchicker.battlecity3d.simulation.Simulation;
import com.lifchicker.battlecity3d.simulation.Tank;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-26
 */
public class Renderer {

    private final Matrix4 viewMatrix = new Matrix4();
    private PerspectiveCamera camera;

    private Lights lights = new Lights(Color.BLACK, new DirectionalLight().set(Color.WHITE, new Vector3(0.0f, -5.f, 0.0f).nor()));

    private ModelBatch modelBatch;
    private ShapeRenderer shapeRenderer;

    public Renderer () {
        modelBatch = new ModelBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void dispose () {
        modelBatch.dispose();
        shapeRenderer.dispose();
    }

    public void render (Simulation simulation, float delta) {
        GLCommon gl = Gdx.gl20;

        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        setProjectionAndCamera();

        drawPlayFieldCarcass();

        gl.glEnable(GL20.GL_DEPTH_TEST);
        gl.glEnable(GL20.GL_CULL_FACE);

        modelBatch.begin(camera);
        modelBatch.render(simulation.tank, lights);
        modelBatch.render(simulation.blocks, lights);
        modelBatch.render(simulation.shots, lights);
        modelBatch.end();

        gl.glDisable(GL20.GL_CULL_FACE);
        gl.glDisable(GL20.GL_DEPTH_TEST);

        drawCoordinateSystem();
    }

    private void drawCoordinateSystem() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //red - x-axis
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.line(0, 0, 0, 2.0f, 0, 0);
        //blue - z-axis
        shapeRenderer.setColor(0, 0, 1, 1);
        shapeRenderer.line(0, 0, 0, 0, 0, 2);
        shapeRenderer.end();
    }

    private void drawPlayFieldCarcass() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0.2f, 0.45f, 0.1f, 1);

        for (int i = (int)Simulation.PLAYFIELD_MIN_X; i < (int)Simulation.PLAYFIELD_MAX_X+1; i++)
        {
            shapeRenderer.line(i, 0, Simulation.PLAYFIELD_MIN_Z,
                               i, 0, Simulation.PLAYFIELD_MAX_Z);
        }

        for (int i = (int)Simulation.PLAYFIELD_MIN_Z; i < (int)Simulation.PLAYFIELD_MAX_Z+1; i++)
        {
            shapeRenderer.line(Simulation.PLAYFIELD_MIN_X, 0, i,
                               Simulation.PLAYFIELD_MAX_X, 0, i);
        }

        shapeRenderer.end();
    }

    private void setProjectionAndCamera() {
        camera.position.set(0.0f, 25.0f, -0.1f);
        //camera.position.set(0.0f, 1.0f, -4.0f);
        camera.lookAt(0.0f, 0.0f, 0.0f);
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
}
