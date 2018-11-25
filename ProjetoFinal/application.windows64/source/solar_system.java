import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class solar_system extends PApplet {



Planet sun; //Define um planeta chamado sol (sim, eu sei que o sol não é um planeta)
PeasyCam cam;

PImage sunTexture;
PImage[] textures = new PImage[3];
PImage backgroundImage;

public void setup(){
  
  sunTexture = loadImage("images/sun.jpg");
  textures[0] = loadImage("images/mars.jpg");
  textures[1] = loadImage("images/earth.jpg");
  textures[2] = loadImage("images/mercury.jpg");
  backgroundImage = loadImage("images/background.jpg");
  cam = new PeasyCam(this, 500);
  sun = new Planet(50, 0, 0, sunTexture);
  sun.spawnMoons(4, 1);
}

public void draw(){
  background(backgroundImage);
  lights();
  pointLight(255, 255, 255, 0, 0, 0);
  sun.show(); //Mostra o sol na tela
  sun.orbit();
}
  
class Planet {
  float radius;   // Raio de rotação do planeta
  float angle;    // Angulo para definir sua posição
  float distance; // Distância em relação ao sol
  float orbitSpeed; //Velocidade de rotação do planeta
  PVector vector;
  
  PShape globe;
  /*
    Um planeta possui luas, e o sol possui X planetas rotacionando
    em seu redor. O vetor abaixo armazena a quantidade de 'filhos'
    que um planeta possui.
  */
  Planet[] planets;
  
  Planet(float r, float d, float o, PImage image){
    /*
      r: Radius
      d: distance
      o: orbitSpeed
    */
     vector = PVector.random3D();
     radius = r;
     distance = d;
     vector.mult(distance);
     angle = random(TWO_PI);
     orbitSpeed = o;
     
     noStroke();
     noFill();
     globe = createShape(SPHERE, radius);
     globe.setTexture(image);
  }
  
  //Órbita dos planetas
  public void orbit(){ 
    angle = angle + orbitSpeed;
    if (planets != null){
      for (int i = 0; i < planets.length; i++){
        planets[i].orbit();
      }
    }
  }
  
  public void spawnMoons(int total, int level){
    /* 
      total: Total de luas que um planeta possui.
    */
    planets = new Planet[total];
    for (int i = 0; i < planets.length; i++){
      float r = radius / (level * 2); //raio da lua
      float moonDistance = random((radius + r), ((radius + r)*2)); //distância da lua em relação ao planeta
      float orbitSpeed = random(-0.3f, 0.3f); //Velocidade de rotação das luas
      int index = PApplet.parseInt(random(0, textures.length));
      planets[i] = new Planet(r, moonDistance, orbitSpeed, textures[index]); //Cria uma lua
      if (level < 3){
        int numberOfMoons = PApplet.parseInt(random(0, 4)); //O planeta vai ter entre 0  e 4 luas
        planets[i].spawnMoons(numberOfMoons, level + 1);
      }
    }
  }
  /*
    Função para desenhar o planeta e suas luas
  */
  public void show(){
    pushMatrix();
    noStroke();
    fill(255);
    PVector vector2 = new PVector(1, 0, 1);
    PVector p = vector.cross(vector2);
    rotate(p.x, p.y, p.z, angle);
    translate(vector.x, vector.y, vector.z);
    ellipse(0, 0, radius*2, radius*2);
    
    sphere(radius);
    shape(globe);
    if (planets != null){ //se o planeta possui luas, então preciso mostrá-las:
      for (int i = 0; i < planets.length; i++){
        planets[i].show();
      }
    }
    popMatrix();
  }
}
  public void settings() {  size(600, 600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "solar_system" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
