package campofutebol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static sun.java2d.loops.SurfaceType.TexturePaint;


/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
public class CampoFutebol extends Frame{

    public CampoFutebol() {
        addWindowListener(new FecharJanela());
    }
    
    private int texture_width = 50;
    private int texture_height = 50;
    private String path_to_texture = "img\\texture.jpg";
    private BufferedImage getTexture() {
            BufferedImage image = new BufferedImage(texture_width, texture_height, BufferedImage.TYPE_INT_ARGB);
            try {
                image = ImageIO.read(new File(path_to_texture)); //le a imagem do diretorio informado
            }
            catch (IOException e) { 
                /* Se ocorrer um erro durante o carregamento da textura, coloca a cor verde para o fundo */
                //System.out.println(e);
                image = new BufferedImage (50,50, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = image.createGraphics();
                graphics.setColor(Color.GREEN);
                graphics.fillRect(0, 0, texture_width, texture_height);
                graphics.dispose();
                return image;
            }
            return image;
        }
    
    public void paint(Graphics g){
     
        Graphics2D g2d =  (Graphics2D) g;
    
        GeneralPath areaEsquerda = new GeneralPath();
        GeneralPath areaDireita = new GeneralPath();
        GeneralPath escanteio = new GeneralPath();
        GeneralPath rectangle = new GeneralPath();
        GeneralPath linha_meio = new GeneralPath();
        
        TexturePaint texture = new TexturePaint(getTexture(), new Rectangle (0,0,50,50));
        
        rectangle.moveTo(150, 150);//move para o ponto inicial
        rectangle.lineTo(150, 800);//desenha a linha vertical esquerda
        rectangle.lineTo(1400, 800);//desenha a linha de baixo
        rectangle.lineTo(1400, 150);//desenha a linha vertical direita
        rectangle.lineTo(150, 150);//desenha a linha do topo
        linha_meio.moveTo(775, 150);//move para o meio da linha do topo
        linha_meio.lineTo(775, 800);//desenha a linha de meio de campo
        
        g2d.setPaint(texture); //set na textura que vai preecher o retangulo
        g2d.fill(rectangle); //preenche o retangulo com a textura
        g2d.draw(rectangle); //desenha o retângulo
        
        areaEsquerda.moveTo(150, 375);//inicio superior pequena area
        areaEsquerda.lineTo(275,375);//linha superior pequena area
        areaEsquerda.lineTo(275, 575);//linha frontal pequena area
        areaEsquerda.lineTo(150, 575);//linha baixo pequena area
        
        areaEsquerda.moveTo(150,300);//move para o inicio da linha superior da grande area da esquerda
        areaEsquerda.lineTo(400,300);//desenha a linha superior da grande area da esquerda
        areaEsquerda.lineTo(400, 650);//desenha a linha da frente da grande area esquerda
        areaEsquerda.lineTo(150, 650);//desenha a linha inferior da grande area esquerda
        
        areaDireita.moveTo(1400, 300);//ponto inicial grande area direita
        areaDireita.lineTo(1150, 300);//linha superior grande area direita
        areaDireita.lineTo(1150, 650);//linha da frente da grande area da direita
        areaDireita.lineTo(1400, 650);//linha de baixo da grande area da direita
        
        areaDireita.moveTo(1400, 375);//ponto inicial pequena area
        areaDireita.lineTo(1250, 375);//linha superior pequena area direita
        areaDireita.lineTo(1250, 575);//linha frontal pequena area
        areaDireita.lineTo(1400, 575);//linha de baixo da pequena area
        
        
        Ellipse2D.Double penalti = new Ellipse2D.Double(337.5, 475 , 7, 7); //penalti esquerda
        Ellipse2D.Double penalti2 = new Ellipse2D.Double(1200, 475, 7, 7);//penalti direita
        Ellipse2D.Double meio_campo = new Ellipse2D.Double(625, 325,300,300); //meio de campo
        Ellipse2D.Double marca_meio = new Ellipse2D.Double(770, 472, 10, 10); //marca do meio de campo
        

        g2d.setColor(Color.white); //muda a cor pra branco
        g2d.draw(meio_campo); //desenha o meio campo
        g2d.draw(marca_meio);//desenha a marca do meio campo
        g2d.draw(linha_meio); //desenha a linha do meio
        g2d.draw(areaDireita); //desenha a area direita
        g2d.draw(areaEsquerda); //desenha a area esquerda
        g2d.draw(escanteio); //desenha os escanteios
        g2d.draw(penalti); //desenha a marca de penalti
        g2d.draw(penalti2); //desenha a outra marca do penalti
        
        /*
            Utilizado para desenhar as duas meia-luas
        */
        int xIniResq = 375;
        int yIniResq = 375;
        int xIniRdir = 1123;
        int yIniRdir = 375;
        int largR = 55;
        int AltR = 200;
        /******/
        
        Arc2D meiaLuaEsq = new Arc2D.Double(xIniResq, yIniResq, largR, AltR, 270, 180, Arc2D.OPEN); // desenha a parte de 270 até 180 graus de um circulo
        g2d.setColor(Color.white); //coloca a cor para branco
        g2d.draw(meiaLuaEsq); //desenha a meia lua esquerda
        Arc2D meiaLuaDir = new Arc2D.Double(xIniRdir, yIniRdir, largR, AltR, 270, -180, Arc2D.OPEN); // desenha a parte de 270 até 180 graus de um circulo
        g2d.draw(meiaLuaDir);// desenha a meia lua direita
        
        int l_escanteio = 30; //largura do escanteio
        int h_escanteio = 30; //altura do escanteio
        
        int xescanteioES = 135; //posição em X do escanteio Esquerda superior
        int yescanteioES = 135; //posição em Y do escanteio da esquerda superior
        int xescanteioDS = 1385;//posição em X do escanteio da direita superior
        int yescanteioDS = 135;//posição em Y do escanteio da direita superior
        int xescanteioEI = 135;//posição em X do escanteio da esquerda inferior
        int yescanteioEI = 785;//posição em Y do escanteio da esquerda inferior
        int xescanteioDI = 1385;//posição em X do escanteio da direita inferior
        int yescanteioDI = 785;//posição em Y do escanteio da direita inferior
        
        Arc2D escanteioES = new Arc2D.Double(xescanteioES, yescanteioES, l_escanteio, h_escanteio, 270, 90, Arc2D.OPEN); //cria o arco para o escanteio
        Arc2D escanteioDS = new Arc2D.Double(xescanteioDS, yescanteioDS, l_escanteio, h_escanteio, 180, 90, Arc2D.OPEN); //cria o arco para o escanteio
        Arc2D escanteioEI = new Arc2D.Double(xescanteioEI, yescanteioEI, l_escanteio, h_escanteio, 0, 90, Arc2D.OPEN); //cria o arco para o escanteio
        Arc2D escanteioDI = new Arc2D.Double(xescanteioDI, yescanteioDI, l_escanteio, h_escanteio, 90, 90, Arc2D.OPEN); //cria o arco para o escanteio
        
        g2d.setColor(Color.white); //muda a cor para branco
        /*  Desenha os escanteios: */
        g2d.draw(escanteioES); 
        g2d.draw(escanteioDS);
        g2d.draw(escanteioEI);
        g2d.draw(escanteioDI);
         /* termino desenho dos escanteios*/
       
        g2d.setColor(Color.white); //cor branco
        g2d.setFont(new Font("Arial", Font.BOLD, 30) ); //fonte, tamanho e negrito
        g2d.drawString("Computação UEPG", 640, 140);//Escrita topo
        g2d.rotate(Math.toRadians(90),1150, 500); //gira 90º
        g2d.drawString("Computação Gráfica - 2018", 940, 250);
        g2d.rotate(Math.toRadians(90),1150,500); //gira 90º
        g2d.drawString("Mateus Junges", 1430, 190);
        g2d.rotate(Math.toRadians(90), 1150, 500); //gira 90º
        g2d.drawString("Engenharia de Computação - 3º Ano", 930, -510);
        
        /*
        Buffered Image é usado para criar o objeto de imagem que vai ser usado
        usado com o ImageIO pra operações de leitura e escrita
        */
        int image_width = 50;      //largura da imagem
        int image_height = 50;     // altura da imagem
        BufferedImage image = null;
        File file = null;
        
        String path_to_image = "img\\logo-fc-comp.png";
        
       
        //ler o arquivo de imagem:
        file = new File(path_to_image);
        image = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
        try { /* Try catch para abrir a imagem */
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(CampoFutebol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g2d.rotate(Math.toRadians(90), image.getWidth()/2, image.getHeight()/2  );//gira
        g2d.drawImage(image, image.getWidth()/2-421, image.getHeight()/2-1180,null);//desenha a imagem
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CampoFutebol cf = new CampoFutebol();
        cf.setSize(1500, 900); //tamanho
        cf.setBackground(Color.black); //cor de fundo
        cf.setTitle("Campo de futebol - Mateus Junges"); //titulo da janela
        cf.setVisible(true);
    }
    
    
}
