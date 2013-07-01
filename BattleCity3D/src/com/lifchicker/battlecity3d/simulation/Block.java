/*
* Block.java
*
* Created on 01 07 2013, 12:27
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
 * @since 2013-07-01
 */
public class Block extends ModelInstance {
    private BoundingBox boundingBox;

    public Block(Model model, float x, float z) {
        super(model);
        boundingBox = new BoundingBox();
        model.calculateBoundingBox(boundingBox);

        Vector3 position = new Vector3(x, boundingBox.max.y, z);
        transform.setTranslation(position);

        boundingBox.min.add(position);
        boundingBox.max.add(position);
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
