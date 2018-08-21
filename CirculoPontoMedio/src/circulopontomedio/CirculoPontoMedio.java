/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulopontomedio;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
/**
 *
 * @author Mateus Junges
 */
public class CirculoPontoMedio extends Frame{

    public CirculoPontoMedio() {
        addWindowListener(new FecharJanela());
    }
    
    

    @Override
    public void paint(Graphics g){
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
//        g2d.drawOval(30, 30, 200, 200);
        MidpointCircle(15, g2d);
        
    }
    
    void CirclePoints(int x, int y, Graphics2D g2d){
         g2d.drawLine(x, y, x, y);
         g2d.drawLine( x, -y, x, -y);
         g2d.drawLine(-x, y, -x, y);
         g2d.drawLine(-x, -y, -x, -y);
         g2d.drawLine( y, x, y, x);
         g2d.drawLine( y, -x, y, -x);
         g2d.drawLine(-y, x, -y, x);
         g2d.drawLine(-y, -x, -y, -x);
     }    
    
    
    void MidpointCircle(int radius, Graphics2D g2d){
        int x = 0;
        int y = radius;
        x += 200;
        y += 200;
        int d = 1 - radius;
        CirclePoints(x, y, g2d);
        while(y > x) {
            if (d < 0)
                d += 2 * x + 3;
            else {
                d += 2 * (x - y) + 5;
                y--;
            }
            x++;
            CirclePoints(x, y, g2d);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        CirculoPontoMedio CPM22 = new CirculoPontoMedio();
        CPM22.setSize(500, 500);
        CPM22.setTitle("Ponto Médio");
        CPM22.setVisible(true);
    }

     
    
}
