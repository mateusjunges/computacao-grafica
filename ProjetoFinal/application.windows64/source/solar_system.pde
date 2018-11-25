import peasy.*;

Planet sun; //Define um planeta chamado sol (sim, eu sei que o sol não é um planeta)
PeasyCam cam;

PImage sunTexture;
PImage[] textures = new PImage[3];
PImage backgroundImage;

void setup(){
  size(600, 600, P3D);
  sunTexture = loadImage("images/sun.jpg");
  textures[0] = loadImage("images/mars.jpg");
  textures[1] = loadImage("images/earth.jpg");
  textures[2] = loadImage("images/mercury.jpg");
  backgroundImage = loadImage("images/background.jpg");
  cam = new PeasyCam(this, 500);
  sun = new Planet(50, 0, 0, sunTexture);
  sun.spawnMoons(4, 1);
}

void draw(){
  background(backgroundImage);
  lights();
  pointLight(255, 255, 255, 0, 0, 0);
  sun.show(); //Mostra o sol na tela
  sun.orbit();
}
  
