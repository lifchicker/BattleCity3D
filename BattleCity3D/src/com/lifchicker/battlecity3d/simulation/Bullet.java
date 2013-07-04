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
import com.badlogic.gdx.math.Vector3;

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-07-02
 */
public class Bullet extends MovableObject {
    public Bullet(Model model, Vector3 position, Vector3 direction) {
        super(model, position, direction, 15.0f);
    }

    public void update (float delta) {
        if (canMove) {
            position = newPosition;
        }

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(position);
    }
}
