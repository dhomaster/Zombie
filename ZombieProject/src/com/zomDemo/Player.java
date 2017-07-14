package com.zomDemo;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by derekho01778 on 7/11/17.
 */
public class Player {
    Rectangle bounds;
    protected double vx, vy, maxSpeed, acceleration;
    int health;

    protected boolean isAlive;


    public Player() {
        isAlive = true;
        bounds = new Rectangle(20, 20, 5, 5);
        vx = 0;
        vy = 0;
        maxSpeed = 5;
        acceleration = 0.5;
        health = 50;



    }
    public void hit(){
        isAlive=false;
    }


    public void draw(Graphics g) {
        if (isAlive == true) {
            g.setColor(Color.BLACK);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }


    public void move(ArrayList<String> dirs) {
        for (int i = 0; i < dirs.size(); i++) {
            if (vx > maxSpeed) {
                vx = maxSpeed;
            }
            if (vy > maxSpeed) {
                vy = maxSpeed;
            }
            if (vx < -maxSpeed) {
                vx = -maxSpeed;
            }

            if (vy < -maxSpeed) {
                vy = -maxSpeed;
            }
            if (dirs.contains("up")) {
                vy -= acceleration;

            }
            if (dirs.contains("down")) {
                vy += acceleration;
            }
            if (dirs.contains("left")) {
                vx -= acceleration;
            }
            if (dirs.contains("right")) {
                vx += acceleration;
            }
        }








        bounds.y+=(int)vy;
        bounds.x+=(int)vx;
        vx*=.92;
        vy*=.92;


    }
    public Rectangle getBounds(){
        return bounds;
    }

}
