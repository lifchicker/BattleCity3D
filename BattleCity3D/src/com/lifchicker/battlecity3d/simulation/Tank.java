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

/**
 * @author Alexey 'lh' Antonov
 * @since 2013-06-27
 */
public class Tank extends ModelInstance {
    public static final float TANK_RADIUS = 1;
    public static final float TANK_VELOCITY = 10;

    private Vector2 position = new Vector2(0, 0);

    public Tank(Model model) {
        super(model);
    }

    public void update (float delta, Vector2 moveDirection) {
        float rotationAngle = 0;
        if (moveDirection.x < -0.00001f || moveDirection.x > 0.00001f)
            position.x += delta*TANK_VELOCITY*moveDirection.x;
        if (moveDirection.y < -0.00001f || moveDirection.y > 0.00001f)
            position.y += delta*TANK_VELOCITY*moveDirection.y;

        if (moveDirection.x > 0.0f)
            rotationAngle = 90;
        else if(moveDirection.x < 0.0f)
            rotationAngle = 270;
        else if (moveDirection.y > 0.0f)
            rotationAngle = 0;
        else if (moveDirection.y < 0.0f)
            rotationAngle = 180;

        transform.setToRotation(0.0f, 1.0f, 0.0f, rotationAngle);
        transform.setTranslation(new Vector3(position.x, 0, position.y));
    }
}
