package microestrutura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
class Riblet extends JFrame{
    int tamanho_amostra;
    float alpha, x,y, x0,y0;
    float xR, dR_0, dR, altura;
    
    public Riblet(int tamanho_amostra, float altura, float alpha, float dR, float dR_0){
 
        this.tamanho_amostra = tamanho_amostra;
        this.altura = altura;
        alpha = (float) ((alpha/180)*Math.PI);
        this.alpha = alpha;
        this.dR = dR;
        this.dR_0 = dR_0;  
        
        xR= (float) (2*altura*Math.tan(alpha));
    }

    @Override
    public void paint(Graphics graphics){
        GeneralPath line = new GeneralPath();
        Graphics2D graphics2d = (Graphics2D) graphics;
        y0 = 150;
        x0 = 100;
        line.moveTo(x0, y0);
        x = x0 + (dR_0 - (xR/2));
        y = y0;
        
        int i = 0;
        while( i < tamanho_amostra ){
            line.lineTo(x,y);
            x = x + (xR / 2);
            y = y0 - altura;
            line.lineTo(x, y);
            x = x +(xR / 2);
            y = y0;
            line.lineTo(x, y);
            x = x + (dR - xR);
            line.lineTo(x, y);
            i++;
        }
        x = x + 30;
        line.lineTo(x, y);
        graphics2d.setColor(Color.black);
        graphics2d.draw(line);
    }
    
    
}
