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
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-27
 */
public class Tank extends ModelInstance {
    private float velocity = 10;

    private Vector3 position = new Vector3(0, 0, 0);
    private BoundingBox boundingBox;
    private Vector3 newPosition = position;
    private float rotationAngle = 0;
    private boolean canMove = true;

    public Tank(Model model, float x, float z) {
        super(model, x, 0, z);

        boundingBox = new BoundingBox();
        model.calculateBoundingBox(boundingBox);

        position.x = x;
        position.y = boundingBox.max.y;
        position.z = z;
    }

    public void update (float delta) {
        if (!(Simulation.PLAYFIELD_MIN_X < (newPosition.x - boundingBox.max.x) &&
                (newPosition.x + boundingBox.max.x) < Simulation.PLAYFIELD_MAX_X))
            canMove = false;

        if (!(Simulation.PLAYFIELD_MIN_Z < (newPosition.z - boundingBox.max.z) &&
                (newPosition.z + boundingBox.max.z) < Simulation.PLAYFIELD_MAX_Z))
            canMove = false;

        if (canMove) {
            position.x = newPosition.x;
            position.z = newPosition.z;
        }

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }

    public void move (float delta, Vector2 moveDirection) {
        newPosition = new Vector3(position);
        newPosition.x += delta * velocity * moveDirection.x;
        newPosition.z += delta * velocity * moveDirection.y;

        if (moveDirection.x > 0.0f)
            rotationAngle = 90;
        else if (moveDirection.x < 0.0f)
            rotationAngle = 270;
        else if (moveDirection.y > 0.0f)
            rotationAngle = 0;
        else if (moveDirection.y < 0.0f)
            rotationAngle = 180;

        canMove = true;
    }

    public Vector3 getPosition () {
        return new Vector3(position);
    }

    public Vector3 getDirection () {
        Vector3 direction = new Vector3();
        switch ((int)rotationAngle) {
            case 0:
                direction.z = 1.0f;
                break;
            case 90:
                direction.x = 1.0f;
                break;
            case 180:
                direction.z = -1.0f;
                break;
            case 270:
                direction.x = -1.0f;
                break;
        }
        return direction;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = false;
    }

    public boolean collide(Block block) {
        BoundingBox blockBoundingBox = block.getBoundingBox();

        return ((boundingBox.min.x + newPosition.x) < (blockBoundingBox.max.x) && ((newPosition.x + boundingBox.max.x) > blockBoundingBox.min.x)
                && ((boundingBox.min.y + newPosition.y) < blockBoundingBox.max.y) && ((newPosition.y + boundingBox.max.y) > blockBoundingBox.min.y)
                && ((boundingBox.min.z + newPosition.z) < blockBoundingBox.max.z) && ((newPosition.z + boundingBox.max.z) > blockBoundingBox.min.z));
    }
}
