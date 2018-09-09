/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campofutebol_corgradiente;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
public class FecharJanela extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    
}