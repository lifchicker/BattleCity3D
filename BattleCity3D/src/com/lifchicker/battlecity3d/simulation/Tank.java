/*
* Tank.java
*
* Created on 27 06 2013, 15:50
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.simulation;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-27
 */
public class Tank extends MovableObject {
    private float rotationAngle = 0;
    private boolean canMove = true;

    public Tank(Model model, Vector3 position, Vector3 direction) {
        super(model, position, direction, 10.0f);
    }

    public void update (float delta) {
        if (!(Simulation.PLAYFIELD_MIN_X < (newPosition.x - boundingBox.max.x) &&
                (newPosition.x + boundingBox.max.x) < Simulation.PLAYFIELD_MAX_X))
            canMove = false;

        if (!(Simulation.PLAYFIELD_MIN_Z < (newPosition.z - boundingBox.max.z) &&
                (newPosition.z + boundingBox.max.z) < Simulation.PLAYFIELD_MAX_Z))
            canMove = false;

        if (canMove) {
            position = newPosition;
        }

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }

    public void move (float delta, Vector3 direction) {
        this.direction = direction;
        newPosition = new Vector3(position);
        newPosition.x += delta * velocity * direction.x;
        newPosition.z += delta * velocity * direction.z;

        if (direction.x > 0.0f)
            rotationAngle = 90;
        else if (direction.x < 0.0f)
            rotationAngle = 270;
        else if (direction.z > 0.0f)
            rotationAngle = 0;
        else if (direction.z < 0.0f)
            rotationAngle = 180;

        canMove = true;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = false;
    }
}
