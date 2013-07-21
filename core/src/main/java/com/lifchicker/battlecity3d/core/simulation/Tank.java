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

package com.lifchicker.battlecity3d.core.simulation;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-27
 */
public class Tank extends MovableObject {
    public Tank(Model model, Vector3 position, Vector3 direction) {
        super(model, position, direction, 10.0f);
    }

    public void update (float delta) {
        if (canMove) {
            position = newPosition;
        }

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }
}
