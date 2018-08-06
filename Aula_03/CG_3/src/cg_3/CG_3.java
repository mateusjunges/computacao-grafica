/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg_3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author alceu
 */
public class CG_3 extends Frame{
   

    private final int windowHeight;
    
    CG_3 (int height){
        addWindowListener (new FecharJanela());
        windowHeight = height;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        GeneralPath gp = new GeneralPath();
        GeneralPath gd = new GeneralPath();
        gp.moveTo(60,120);
        gd.moveTo(60,120);
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
        gd.moveTo(0, 130);
        gd.lineTo(300,130); //chao
        
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
        g2d.draw(gd);
        
        AffineTransform yUp = g2d.getTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(40, windowHeight-50);
        yUp.preConcatenate(translate);
        g2d.transform(yUp);
        g2d.fill(gp);
        
        g2d.setPaint(Color.MAGENTA);
        g2d.draw(gp);
    }
    
    public static void main(String[] args) {
        CG_3 aula3 = new CG_3(500);
        aula3.setSize(500,500);
        aula3.setTitle("Carro");
        aula3.setVisible(true);
    }
    
}
