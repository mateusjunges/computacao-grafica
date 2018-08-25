package bresenham;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
 
    private final int pixelSize = 10; /*
        Tamanho do do pixel que vou colocar na tela.
        Uso drawoval para simular um pixel, fazendo 
        com que seja possível visualizar melhor o que está acontecendo.
    */
 
    BresenhamPanel() {
        setPreferredSize(new Dimension(1500, 1500));//dimensão da tela
        setBackground(Color.WHITE);//cor de fundo da tela
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2; //ponto X máximo
        int maxY = (h - 1) / 2; //ponto Y máximo
        
        /*Pontos iniciais e finais das linhas o exercício*/
        int Xfinal1 = -30;
        int Yfinal1 = 18;
        int Xfinal2 = 11;
        int Yfinal2 = 7;

        drawLine(g, 20, 10, Xfinal1, Yfinal1); //Desenha a linha da letra A
        drawLine(g, 0, 0, Xfinal2, Yfinal2); //Desenha a linha da letra B do exercício

    }
   
    private void plot(Graphics g, int x, int y) {//função para plotar o pixel na tela
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2;
        int maxY = (h - 1) / 2;
 
        int borderX = getWidth() - ((2 * maxX + 1) * pixelSize + 1); // borda em X
        int borderY = getHeight() - ((2 * maxY + 1) * pixelSize + 1); //borda em Y
        int left = (x + maxX) * pixelSize + borderX / 2; 
        int top = (y + maxY) * pixelSize + borderY / 2;
 
        g.setColor(Color.black);//cor em que vou desenhar
        g.drawOval(left, top, pixelSize, pixelSize);//desenha um circulo para simular o pixel

    }
 
    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int d = 0;
 
        int dx = Math.abs(x2 - x1); //pega o valor absoluto
        int dy = Math.abs(y2 - y1); //pega o valor absoluto
 
        int dx2 = 2 * dx; // fatores de escala de inclinação
        int dy2 = 2 * dy; // evitar ponto flutuante
 
        
        int ix = x1 < x2 ? 1 : -1; 
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                plot(g, x, y); //plota o ponto em xy
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
