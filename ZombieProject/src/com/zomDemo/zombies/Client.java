package com.zomDemo.zombies;

import com.zomDemo.Player;
import com.zomDemo.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by derekho01778 on 7/11/17.
 */

public class Client extends JApplet implements KeyListener {
    private Graphics bg;
    private Image offScreen;
    Player Jack;
    private ArrayList<String> dirs;
    private ArrayList<Zombie> death;


    public void init() {
        Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        offScreen = createImage(screen.width, screen.height);
        setSize(screen.width, screen.height);
        bg = offScreen.getGraphics();
        death = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            death.add(new Zombie(new Rectangle(((int)(Math.random()*screen.width)), (int)(Math.random()*screen.height), 10, 10), (int)(Math.random()*3)+1));

        }

        Jack = new Player();

        dirs = new ArrayList<>();
        Timer timer = new Timer(30, ae -> {
            Jack.move(dirs);
            for (Zombie awesome:death){
                awesome.move(Jack);
            }
            repaint();
        });
        timer.start();
        setFocusable(true);
        addKeyListener(this);


    }




    public void paint(Graphics g) {
        bg.clearRect(0, 0, offScreen.getWidth(this), offScreen.getHeight(this));

        Jack.draw(bg);

        for(Zombie awesome:death){
            awesome.paint(bg);
        }
        g.drawImage(offScreen, 0, 0, this);



    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            if (!dirs.contains("up"))
                dirs.add("up");
        }
        if (e.getKeyChar() == 's') {
            if (!dirs.contains("down"))
                dirs.add("down");
        }
        if (e.getKeyChar() == 'a') {
            if (!dirs.contains("left"))
                dirs.add("left");
        }
        if (e.getKeyChar() == 'd') {
            if (!dirs.contains("right"))
                dirs.add("right");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {



        if (e.getKeyChar() == 'w') {
            dirs.remove("up");
        }
        if (e.getKeyChar() == 's') {

            dirs.remove("down");
        }
        if (e.getKeyChar() == 'a') {

            dirs.remove("left");
        }
        if (e.getKeyChar() == 'd') {

            dirs.remove("right");
        }


    }
}
