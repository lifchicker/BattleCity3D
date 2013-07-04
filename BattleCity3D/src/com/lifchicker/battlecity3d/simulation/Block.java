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
import com.badlogic.gdx.math.Vector3;

/**
 * Block is not movable object.
 * Therefore we don't need to recalculate bounding box in a world space every frame.
 *
 * @author Alexey 'lh' Antonov
 * @since 2013-07-01
 */
public class Block extends GameObject {
    public Block(Model model, Vector3 position) {
        super(model, position);
        boundingBox.min.add(this.position);
        boundingBox.max.add(this.position);
    }
}
