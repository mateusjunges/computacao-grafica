/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_01;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mateus
 */
public class FecharJanela extends WindowAdapter{
   
    @Override
    public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
    
    public static void main (String[] argv) {
        try{
            SimpleJava2d f = new SimpleJava2d();
            f.setTitle("Computação Gráfica - Aula 01");
            f.setSize(360,360);
            f.setVisible(true);   
        }catch(Exception excepction){
            System.out.println(excepction);
        }
    }
}
