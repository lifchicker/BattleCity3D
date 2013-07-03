/*
* MovableObject.java
*
* Created on 03 07 2013, 13:08
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
 * Game object that can be moved.
 *
 * @author Alexey 'lh' Antonov
 * @since 2013-07-03
 */
public class MovableObject extends GameObject{
    protected float velocity;
    protected Vector3 newPosition = position;
    protected Vector3 direction = new Vector3();

    public MovableObject(Model model, Vector3 position, Vector3 direction, float velocity) {
        super(model, position);
        this.direction = direction;
        this.velocity = velocity;
    }

    public Vector3 getPosition () {
        return new Vector3(newPosition);
    }

    public Vector3 getDirection () {
        return new Vector3(direction);
    }

    public boolean collide(Block block) {
        BoundingBox blockBoundingBox = block.getBoundingBox();

        return ((boundingBox.min.x + newPosition.x) < (blockBoundingBox.max.x) && ((newPosition.x + boundingBox.max.x) > blockBoundingBox.min.x)
                && ((boundingBox.min.y + newPosition.y) < blockBoundingBox.max.y) && ((newPosition.y + boundingBox.max.y) > blockBoundingBox.min.y)
                && ((boundingBox.min.z + newPosition.z) < blockBoundingBox.max.z) && ((newPosition.z + boundingBox.max.z) > blockBoundingBox.min.z));
    }
}
