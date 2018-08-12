package cg_3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Mateus Junges
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
        
        
        GeneralPath carro = new GeneralPath();
        GeneralPath gd = new GeneralPath();
        GeneralPath roda = new GeneralPath();
        GeneralPath carreta = new GeneralPath();
        
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
        
        carreta.moveTo(200, 120);
        carreta.lineTo(220, 120);
        carreta.moveTo(220, 120);
        carreta.lineTo(220, 90);
        carreta.lineTo(315, 90);
        carreta.lineTo(315, 120);
        carreta.lineTo(220, 120);
        carreta.lineTo(270, 120);
        roda.moveTo(270, 120);
        roda.quadTo(280, 140, 290, 120);
        
         g2d.setColor(Color.RED);
        g2d.fill(carro);
        g2d.setPaint(Color.BLACK);
        g2d.draw(carro);
        g2d.setColor(Color.GRAY);
        g2d.fill(roda);
        g2d.setColor(Color.BLACK);
        g2d.draw(roda);
        g2d.setColor(Color.BLUE);
        g2d.fill(carreta);
        g2d.setColor(Color.BLACK);
        g2d.draw(carreta);
        
        
        
        AffineTransform yUp = g2d.getTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, windowHeight-200);
        yUp.preConcatenate(translate);
        
        g2d.transform(yUp);
        g2d.setColor(Color.RED);
        g2d.fill(carro);
        g2d.setPaint(Color.BLACK);
        g2d.draw(carro);
        g2d.setColor(Color.GRAY);
        g2d.fill(roda);
        g2d.setColor(Color.BLACK);
        g2d.draw(roda);
        g2d.setColor(Color.BLUE);
        g2d.fill(carreta);
        g2d.setColor(Color.BLACK);
        g2d.draw(carreta);
    }
    
    public static void main(String[] args) {
        CG_3 aula3 = new CG_3(500);
        aula3.setSize(500,500);
        aula3.setTitle("Exercício do carrinho tombado - Mateus Junges");
        aula3.setVisible(true);
    }
    
}
