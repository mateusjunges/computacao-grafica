/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg_2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author alceu
 */
public class CG_2 extends Frame{
    {
        addWindowListener (new FecharJanela());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        GeneralPath gp = new GeneralPath();
        gp.moveTo(60,120);
        gp.lineTo(80,120);
        gp.quadTo(90,140,100,120);
        gp.lineTo(160,120);
        gp.quadTo(170,140,180,120);
        gp.lineTo(200,120);
        gp.curveTo(195,100,200,80,160,80);
        gp.lineTo(110,80);
        gp.lineTo(90,100);
        gp.lineTo(60,100);
        gp.lineTo(60,120);
        gp.moveTo(0,130);
        gp.lineTo(300,130);
        gp.moveTo(200,120);
        gp.lineTo(220,120);
        gp.moveTo(220,120);
        gp.lineTo(220, 90);
        gp.lineTo(315,90);
        gp.lineTo(315,120);
        gp.lineTo(220,120);
        gp.lineTo(270,120);
        gp.quadTo(280,140,290,120);
        g2d.draw(gp);
    }
    public static void main(String[] args) {
        CG_2 aula2 = new CG_2();
        aula2.setSize(500,500);
        aula2.setTitle("Carro");
        aula2.setVisible(true);
    }
    
}
