/*
* GameObject.java
*
* Created on 03 07 2013, 12:55
*
* Copyright (C) 2013 Alexey 'lh' Antonov
*
* For more info read COPYRIGHT file in project root directory.
*
*/

package com.lifchicker.battlecity3d.core.simulation;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-07-03
 */
public class GameObject extends ModelInstance {
    protected Vector3 position = new Vector3();
    protected BoundingBox boundingBox;

    public GameObject(Model model, Vector3 position) {
        super(model);
        this.position = position;

        boundingBox = new BoundingBox();
        model.calculateBoundingBox(boundingBox);
        this.position.y = boundingBox.max.y;
        transform.setTranslation(position);
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
