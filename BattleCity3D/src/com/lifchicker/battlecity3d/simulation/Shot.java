/*
* Shot.java
*
* Created on 02 07 2013, 11:07
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.simulation;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-07-02
 */
public class Shot extends ModelInstance {
    private float velocity = 10f;
    private Vector3 position = new Vector3();
    private Vector3 direction = new Vector3();
    private float rotationAngle = 0;
    private BoundingBox boundingBox;
    private boolean alive = true;

    public Shot(Model model, Vector3 position, Vector3 direction) {
        super(model, position);
        this.position = position;
        this.direction = direction;

        boundingBox = new BoundingBox();
        model.calculateBoundingBox(boundingBox);
        this.position.y = boundingBox.max.y;

        if (direction.x > 0.0f)
            rotationAngle = 90;
        else if (direction.x < 0.0f)
            rotationAngle = 270;
        else if (direction.y > 0.0f)
            rotationAngle = 0;
        else if (direction.y < 0.0f)
            rotationAngle = 180;
    }

    public boolean isAlive () {
        return alive;
    }

    public void destroy() {
        this.alive = false;
    }

    public void update (float delta) {
        position.x += delta * velocity * direction.x;
        position.z += delta * velocity * direction.z;

        if (!(Simulation.PLAYFIELD_MIN_X < (position.x - boundingBox.max.x) &&
                (position.x + boundingBox.max.x) < Simulation.PLAYFIELD_MAX_X))
            alive = false;

        if (!(Simulation.PLAYFIELD_MIN_Z < (position.z - boundingBox.max.z) &&
                (position.z + boundingBox.max.z) < Simulation.PLAYFIELD_MAX_Z))
            alive = false;

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }

    public boolean collide(Block block) {
        BoundingBox blockBoundingBox = block.getBoundingBox();

        return ((boundingBox.min.x + position.x) < (blockBoundingBox.max.x) && ((position.x + boundingBox.max.x) > blockBoundingBox.min.x)
                && ((boundingBox.min.y + position.y) < blockBoundingBox.max.y) && ((position.y + boundingBox.max.y) > blockBoundingBox.min.y)
                && ((boundingBox.min.z + position.z) < blockBoundingBox.max.z) && ((position.z + boundingBox.max.z) > blockBoundingBox.min.z));
    }
}
