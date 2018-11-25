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
  void orbit(){ 
    angle = angle + orbitSpeed;
    if (planets != null){
      for (int i = 0; i < planets.length; i++){
        planets[i].orbit();
      }
    }
  }
  
  void spawnMoons(int total, int level){
    /* 
      total: Total de luas que um planeta possui.
    */
    planets = new Planet[total];
    for (int i = 0; i < planets.length; i++){
      float r = radius / (level * 2); //raio da lua
      float moonDistance = random((radius + r), ((radius + r)*2)); //distância da lua em relação ao planeta
      float orbitSpeed = random(-0.3, 0.3); //Velocidade de rotação das luas
      int index = int(random(0, textures.length));
      planets[i] = new Planet(r, moonDistance, orbitSpeed, textures[index]); //Cria uma lua
      if (level < 3){
        int numberOfMoons = int(random(0, 4)); //O planeta vai ter entre 0  e 4 luas
        planets[i].spawnMoons(numberOfMoons, level + 1);
      }
    }
  }
  /*
    Função para desenhar o planeta e suas luas
  */
  void show(){
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
