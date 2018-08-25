/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bresenham.pontosplotagem;

import java.util.Scanner;
/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
public class ObterPontos {
    
    Scanner scanner = new Scanner(System.in);
    public int xInicial;
    public int yInicial;
    public int xFinal;
    public int yFinal;
    
    public void viewInicial(){
        
        //Leio os pontos inicial e final da reta: 
        System.out.println("\nInforme o ponto x inicial da reta: ");
        xInicial = scanner.nextInt();
        System.out.println("X Inicial: "+xInicial);
        System.out.println("\nInforme o ponto y inicial da reta: ");
        yInicial = scanner.nextInt();
        System.out.println("y Inicial: "+yInicial);
        System.out.println("\nInforme o ponto x final da reta: ");
        xFinal = scanner.nextInt();
        System.out.println("X final: "+xFinal);
        System.out.println("\nInforme o ponto y final da reta: ");
        yFinal = scanner.nextInt();
        System.out.println("Y final: "+yFinal);
        
        getPontos(xInicial, xFinal, yInicial, yFinal);
    }
    public void getPontos(int xInicio, int xFim, int yInicio, int yFim){
        int d = 0;
        int diferenca_x = Math.abs(xInicio - xFim); //pega o valor absoluto da diferença entre o inicio e fim no eixo x
        int diferenca_y = Math.abs(yInicio - yFim); //pega o valor absoluto da diferença entre o inicio e fim no eixo y
        
        int diferenca_x2 = diferenca_x * 2;
        int diferenca_y2 = diferenca_y * 2;
        
        
        //Se xInicio < xFim, entao ix = 1. Senão, ix = -1
        int ix = xInicio < xFim ? 1 : -1; 
        
        //se yInicio < yFim, então iy recebe 1. Senão, -1
        int iy = yInicio < yFim ? 1 : -1; 
        
        int x = xInicio;
        int y = yInicio;
        
        if (diferenca_x >= diferenca_y) {
            while (true) {
                System.out.println("Ponto x: "+x+" Ponto y: "+y);
                if (x == xFim)
                    break;
                x += ix;
                d += diferenca_y2;
                if (d > diferenca_x) {
                    y += iy;
                    d -= diferenca_x2;
                }
            }
        } else {
            while (true) {
                System.out.println("Ponto x: "+x+" Ponto y: "+y);
                if (y == yFim)
                    break;
                y += iy;
                d += diferenca_x2;
                if (d > diferenca_y) {
                    x += ix;
                    d -= diferenca_y2;
                }
            }
        }
    }   
        
}
