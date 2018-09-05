package corgradiente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JApplet;
import javax.swing.JFrame;


/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */

public class GradientPaintDemo2D extends JApplet {

  @Override
  public void init() {
    setBackground(Color.white);
    setForeground(Color.white);
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setPaint(Color.gray);
    int x = 5;
    int y = 7;
    // fill RoundRectangle2D.Double
    GradientPaint redtowhite = new GradientPaint(x, y, Color.red, 200, y,
        Color.blue);
    g2.setPaint(redtowhite);
    g2.fill(new RoundRectangle2D.Double(x, y, 200, 200, 10, 10));
    g2.setPaint(Color.black);
    g2.drawString("Filled RoundRectangle2D", x, 250);

  }

  public static void main(String s[]) {
    JFrame f = new JFrame("");
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    JApplet applet = new GradientPaintDemo2D();
    f.getContentPane().add("Center", applet);
    applet.init();
    f.pack();
    f.setSize(new Dimension(300, 300));
    f.show();
  }
}
