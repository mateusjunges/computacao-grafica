/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_01;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Mateus Junges
 */
public class SimpleJava2d extends Frame{

     {
        addWindowListener(new FecharJanela());
     }
     
     @Override
      public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)  g;
        g2d.drawString("Computação Gráfica - Aula ", 30, 50);   
    }
    
}