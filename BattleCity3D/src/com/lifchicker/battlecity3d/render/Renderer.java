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

    private Lights lights = new Lights(Color.BLACK, new DirectionalLight().set(Color.WHITE, new Vector3(0.0f, -20.f, 10.0f).nor()));

    private ModelBatch modelBatch;
    private ShapeRenderer shapeRenderer;

    public Renderer () {
        modelBatch = new ModelBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void dispose () {
        modelBatch.dispose();
    }

    public void render (Simulation simulation, float delta) {
        GLCommon gl = Gdx.gl20;

        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        setProjectionAndCamera();

        gl.glEnable(GL20.GL_DEPTH_TEST);
        gl.glEnable(GL20.GL_CULL_FACE);

        modelBatch.begin(camera);
        modelBatch.render(simulation.tank, lights);
        modelBatch.end();

        gl.glDisable(GL20.GL_CULL_FACE);
        gl.glDisable(GL20.GL_DEPTH_TEST);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        // x axis
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.line(0, 0, 0, 5, 0, 0);
        // y axis
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.line(0, 0, 0, 0, 5, 0);
        // z axis
        shapeRenderer.setColor(0, 0, 1, 1);
        shapeRenderer.line(0, 0, 0, 0, 0, 5);
        shapeRenderer.end();
    }

    private void setProjectionAndCamera() {
        camera.position.set(10, 30, -10.1f);
        camera.lookAt(0, 0, 0);
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
}
