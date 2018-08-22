/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midpointcircle;

import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.GeneralPath;


/**
 *
 * @author Mateus Junges
 */
public class MidPointCircle extends Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        MidPointCircle mpc = new MidPointCircle();
        mpc.setSize(500, 500);
        mpc.setVisible(true);
    }

    public MidPointCircle() {
        addWindowListener(new FecharJanela());
    }
    
    public int raio = 213;
    public int centro = 20;
    public Color cor = Color.red;

    @Override
     public void paint(Graphics g) {
         
         GeneralPath carro = new GeneralPath();
        GeneralPath gd = new GeneralPath();
        GeneralPath roda  = new GeneralPath();
        
        carro.moveTo(60, 120);
        gd.moveTo(60, 120);
        carro.lineTo(80, 120);
        roda.moveTo(80, 120);
        roda.quadTo(90, 140, 100, 120);
        carro.lineTo(160, 120);
        roda.moveTo(160, 120);
        roda.quadTo(170, 140, 180, 120);
        carro.lineTo(200, 120);
        carro.curveTo(195, 100, 200, 80, 160, 80);
        carro.lineTo(110, 80);
        carro.lineTo(90,100);
        carro.lineTo(60, 100);
        carro.lineTo(60, 120);
        gd.moveTo(0, 130);
        gd.lineTo(300, 130); //chao
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(carro);
        g2d.draw(gd);
        g2d.draw(roda);
         
         
        
        midPoint(raio, g2d);

     }
     void midPoint(int raio, Graphics2D g2d){
         int d = (5 / 4) * raio;
         int x = 0;
         int y = raio;
        int centro_y = 250;
        int centro_x = 250;
        
         do {
            g2d.setColor(cor);
           
            this.drawPoint(g2d, y, x, centro_x, centro_y);
            
            if (d < 0) {
                d = d + 2 * x + 3;
            } else {
                d = d + 2 * (x - y) + 5;
                y = y - 1;
            }
            x = x + 1;
        } while (x < y);
     }
     
     void drawPoint(Graphics g, int y, int x, int centro_x, int centro_y) {
         g.drawLine(y + centro_y, x + centro_x, y + centro_y, x + centro_x);
            g.drawLine(x + centro_x, y + centro_y, x + centro_x, y + centro_y);
            g.drawLine(x + centro_x, -y + centro_y, x + centro_x, -y + centro_y);
            g.drawLine(y + centro_y, -x + centro_x, y + centro_y, -x + centro_x);
            g.drawLine(-y + centro_y, -x + centro_x, -y + centro_y, -x + centro_x);
            g.drawLine(-x + centro_x, -y + centro_y, -x + centro_x, -y + centro_y);
            g.drawLine(-x + centro_x, y + centro_y, -x + centro_x, y + centro_y);
            g.drawLine(-y + centro_y, x + centro_x, -y + centro_y, x + centro_x);
     }
}
