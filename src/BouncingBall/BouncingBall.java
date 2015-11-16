/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BouncingBall;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yi
 */
public class BouncingBall extends Frame{
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.jpg");
    double x = 100;
    double y = 100;
    double degree = 3.14/3;
    @Override
    public void paint(Graphics g) {
        g.drawImage(ball, (int)x, (int)y, null);
        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);
        if (y > 600 || y < 30){
            degree = -degree;
        }
        if (x > 900 || x < 0){
            degree = 3.14 - degree;
        }

    }
    
    void launchFrame(){
        setSize(930, 630);
        setLocation(50, 50);
        setTitle("Billiards");
        setBackground(Color.WHITE);
        setVisible(true);
        new PaintThread().start();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BouncingBall().launchFrame();
    }
    
    class PaintThread extends Thread{
        public void run(){
            while (true) {                
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BouncingBall.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
