/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bresenham;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
 
public class Bresenham {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bresenham::run);
    }
 
    private static void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Bresenham");
 
        f.getContentPane().add(new BresenhamPanel());
        f.pack();
 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
 
class BresenhamPanel extends JPanel {
 
    private final int pixelSize = 10; //Tamanho do pixel que vou colocar na tela
 
    BresenhamPanel() {
        setPreferredSize(new Dimension(600, 500));
        setBackground(Color.WHITE);//cor de fundo da tela
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2;
        int maxY = (h - 1) / 2;
        int x1 = -maxX, x2 = maxX * -2 / 3, x3 = maxX * 2 / 3, x4 = maxX;
        int y1 = -maxY, y2 = maxY * -2 / 3, y3 = maxY * 2 / 3, y4 = maxY;
 
     
        int[] vectorA = new int[5];
        int[] vectorB = new int[5];
        vectorA[0] = 1;
        vectorA[1] = 2;
        vectorA[2] = 3;
        vectorA[3] = 4;
        vectorA[4] = 5;
        vectorB[0] = 5;
        vectorB[1] = 6;
        vectorB[2] = 7;
        vectorB[3] = 8;
        vectorB[4] = 9;

        
        int fA = 0;
        int fB = 0;
        int fX = 0;
        
        
        for(int i = 0; i<vectorA.length; i++){
            plot(g, 0, (int) returnY(vectorA[i], vectorB[i], 0));
        }
        
        
        
        
        
        
       // drawLine(g, 0, 50, x3, y1); // NNE
//        drawLine(g, 0, 0, x4, y2); // ENE
//        drawLine(g, 0, 0, x4, y3); // ESE
//        drawLine(g, 0, 0, x3, y4); // SSE
//        drawLine(g, 0, 0, x2, y4); // SSW
//        drawLine(g, 0, 0, x1, y3); // WSW
//        drawLine(g, 0, 0, x1, y2); // WNW
//        drawLine(g, 0, 0, x2, y1); // NNW
    }
    private float returnY(int fA, int fB, int fX){
        return (float) (-fA+Math.sqrt(fX)+fB);
    }
 
    private void plot(Graphics g, int x, int y) {
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2;
        int maxY = (h - 1) / 2;
 
        int borderX = getWidth() - ((2 * maxX + 1) * pixelSize + 1);
        int borderY = getHeight() - ((2 * maxY + 1) * pixelSize + 1);
        int left = (x + maxX) * pixelSize + borderX / 2;
        int top = (y + maxY) * pixelSize + borderY / 2;
 
        g.setColor(Color.black);
        g.drawOval(left, top, pixelSize, pixelSize);
    }
 
    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                plot(g, x, y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                plot(g, x, y);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }
    
}
