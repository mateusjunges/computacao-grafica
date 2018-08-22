/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campofutebol;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
public class CampoFutebol extends Frame{

    public CampoFutebol() {
        addWindowListener(new FecharJanela());
    }
    
    
    public void paint(Graphics g){
        GeneralPath gp = new GeneralPath();
        Graphics2D g2d =  (Graphics2D) g;
        gp.moveTo(150, 150);//move para o ponto inicial
        gp.lineTo(150, 800);//desenha a linha vertical esquerda
        gp.lineTo(1400, 800);//desenha a linha de baixo
        gp.lineTo(1400, 150);//desenha a linha vertical direita
        gp.lineTo(150, 150);//desenha a linha do topo
        gp.moveTo(775, 150);//move para o meio da linha do topo
        gp.lineTo(775, 800);//desenha a linha de meio de campo
        
        gp.moveTo(150, 375);//inicio superior pequena area
        gp.lineTo(275,375);//linha superior pequena area
        gp.lineTo(275, 575);//linha frontal pequena area
        gp.lineTo(150, 575);//linha baixo pequena area
        
        gp.moveTo(150,300);//move para o inicio da linha superior da grande area da esquerda
        gp.lineTo(400,300);//desenha a linha superior da grande area da esquerda
        gp.lineTo(400, 650);//desenha a linha da frente da grande area esquerda
        gp.lineTo(150, 650);//desenha a linha inferior da grande area esquerda
        
        gp.moveTo(1400, 300);//ponto inicial grande area direita
        gp.lineTo(1150, 300);//linha superior grande area direita
        gp.lineTo(1150, 650);//linha da frente da grande area da direita
        gp.lineTo(1400, 650);//linha de baixo da grande area da direita
        
        gp.moveTo(1400, 375);//ponto inicial pequena area
        gp.lineTo(1250, 375);//linha superior pequena area direita
        gp.lineTo(1250, 575);//linha frontal pequena area
        gp.lineTo(1400, 575);//linha de baixo da pequena area
        
        Ellipse2D.Double penalti = new Ellipse2D.Double(337.5, 475 , 5, 5); //penalti esquerda
        Ellipse2D.Double meio_campo = new Ellipse2D.Double(625, 325,300,300); //meio de campo
        Ellipse2D.Double marca_meio = new Ellipse2D.Double(770, 472, 10, 10); //marca do meio de campo
        Ellipse2D.Double penalti2 = new Ellipse2D.Double(1200, 475, 5, 5);
        
        g2d.draw(gp);
        g2d.fill(penalti);
        g2d.draw(penalti);
        g2d.draw(meio_campo);
        g2d.fill(marca_meio);
        g2d.draw(marca_meio);
        g2d.fill(penalti2);
        g2d.draw(penalti2);
        
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CampoFutebol cf = new CampoFutebol();
        cf.setSize(1500, 900);
        cf.setVisible(true);
    }
    
    
}
