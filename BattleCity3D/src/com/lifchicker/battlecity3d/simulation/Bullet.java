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
public class Bullet extends MovableObject {
    private float rotationAngle = 0;
    private boolean alive = true;

    public Bullet(Model model, Vector3 position, Vector3 direction) {
        super(model, position, direction, 15.0f);

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
        newPosition = new Vector3(position);
        newPosition.x += delta * velocity * direction.x;
        newPosition.z += delta * velocity * direction.z;

        if (!(Simulation.PLAYFIELD_MIN_X < (newPosition.x - boundingBox.max.x) &&
                (newPosition.x + boundingBox.max.x) < Simulation.PLAYFIELD_MAX_X))
            alive = false;

        if (!(Simulation.PLAYFIELD_MIN_Z < (newPosition.z - boundingBox.max.z) &&
                (newPosition.z + boundingBox.max.z) < Simulation.PLAYFIELD_MAX_Z))
            alive = false;

        if (alive) {
            position = newPosition;
        }

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }
}
