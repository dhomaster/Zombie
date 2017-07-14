package com.zomDemo;

import java.awt.*;

/**
 * Created by derekho01778 on 7/13/17.
 */
public class Zombie {
    int speed;
    Rectangle bounds;
    double a, b, c;



    public Zombie(Rectangle bounds, int speed){
        this.bounds = bounds;
        this.speed = speed;

    }
    public void move(Player player) {
        Rectangle pBounds = player.getBounds();
        if (inRange(pBounds)) {


            if (bounds.x < pBounds.x) {
                bounds.x += speed;
            }
            if (bounds.x > pBounds.x) {
                bounds.x -= speed;
            }
            if (bounds.y < pBounds.y) {
                bounds.y += speed;
            }
            if (bounds.y > pBounds.y) {
                bounds.y -= speed;
            }
            act(player);

        }
        else{
            bounds.x+=(Math.random()*30)-14;
            bounds.y+=(Math.random()*30)-14;





        }
    }

    private boolean inRange(Rectangle awesome){
        a = awesome.x-bounds.x;
        b = awesome.y-bounds.y;
        c = Math.pow(a, 2) + Math.pow(b, 2);
        if (Math.sqrt(c)<100){
            return true;
        }
        else{
            return false;
        }

    }



    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(bounds.x, bounds.y, 10, 10);

    }
    public boolean collision(Rectangle rect){
        return bounds.intersects(rect);
    }
    public void act(Player player){
        if (collision(player.bounds)){
            player.hit();
        }
    }
}
