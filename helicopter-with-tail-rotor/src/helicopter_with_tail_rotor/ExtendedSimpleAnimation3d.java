package helicopter_with_tail_rotor;

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.vp.*;
import javax.swing.JFrame;


/**
* @author Mateus Junges <contato@mateusjunges.com>
*/
public class ExtendedSimpleAnimation3d extends JFrame
{

  //A tela para desenhar.
  public Canvas3D myCanvas3D;


  public ExtendedSimpleAnimation3d()
  {
    //Mecanismo para fechar a janela e sair do programa
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Configuração padrão para o universo do visualizador
    myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());


    //Primeiro crie junto com a tela
    SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);


    //Posicionamento padrão do espectador
    simpUniv.getViewingPlatform().setNominalViewingTransform();
    
    //A cena é criada nesse método.
    createSceneGraph(simpUniv);

    //Adicionando luz
    addLight(simpUniv);


    //Isso permite que você mude o ponto de vista do visualizador com o mouse
    OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
    ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
    simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);


    //Representação da tela / janela:
    setTitle("Eine kleine Animation");
    setSize(700,700);
    getContentPane().add("Center", myCanvas3D);
    setVisible(true);

  }




  public static void main(String[] args)
  {
     ExtendedSimpleAnimation3d esa = new ExtendedSimpleAnimation3d();
  }


  //Neste método, os objetos da cena são construídos, os movimentos
  //definido e adicionado ao SimpleUniverse su.
  public void createSceneGraph(SimpleUniverse su)
  {

//*** A plataforma na qual o helicóptero está ***
//*** e seu grupo de transformação:              ***

      //Aparência para tornar a plataforma vermelha
      Appearance redApp = new Appearance();
      setToMyDefaultAppearance(redApp,new Color3f(0.8f,0.0f,0.0f));
      
      float platformSize = 0.1f;

      //Geração da plataforma como um cubo
      Box platform = new Box(platformSize,platformSize,platformSize,redApp);

      //transformação que gira a plataforma ligeiramente.
      Transform3D tfPlatform = new Transform3D();
      tfPlatform.rotY(Math.PI/6);

      //O grupo de transformação da plataforma
      TransformGroup tgPlatform = new TransformGroup(tfPlatform);
      tgPlatform.addChild(platform);


//*** A cabine do helicóptero ****

      //Uma aparição para pintar a cabine Gruen.
      Appearance greenApp = new Appearance();
      setToMyDefaultAppearance(greenApp,new Color3f(0.0f,0.7f,0.0f));

      //Raio da Cabine
      float cabinRadius = 0.1f;

      //Geração da cabine como uma bola
      Sphere cabin = new Sphere(cabinRadius,greenApp);

       /*O grupo de transformação da cabine.
       A cabine inicialmente fica na origem das coordenadas. Será mais tarde
       todo o helicóptero foi para a plataforma.*/
      TransformGroup tgCabin = new TransformGroup();
      tgCabin.addChild(cabin);




//*** O rotor do helicóptero com rotação ***

    //Uma aparência para colorir o rotor azul.
    Appearance blueApp = new Appearance();
    setToMyDefaultAppearance(blueApp,new Color3f(0.0f,0.0f,1.0f));

    //Geração do rotor como cubos
    Box rotor = new Box(0.4f,0.0001f,0.01f,blueApp);

    //O grupo de transformação para o rotor, no qual também a rotação
    //é modelado.
    TransformGroup tgmRotor = new TransformGroup();
    tgmRotor.addChild(rotor);

    //A rotação de partida lenta do rotor
    Transform3D bladeRotationAxis = new Transform3D();
    int timeStartRotor = 2000;   // O rotor deve começar a girar após 2 segundos.
    int noStartRotations = 2;    // Ele primeiro executa 2 voltas lentas.
    int timeSlowRotation = 1500; // volta lenta que leva 1,5 segundos.

    //O alfa para a rotação lenta
    Alpha bladeRotationStartAlpha = new Alpha(noStartRotations,
                                              Alpha.INCREASING_ENABLE,
                                              timeStartRotor,
                                              0,timeSlowRotation,0,0,0,0,0);



    //rotação lenta
    RotationInterpolator bladeRotationStart = new RotationInterpolator(
                                             bladeRotationStartAlpha,tgmRotor,
                                             bladeRotationAxis,0.0f,(float) Math.PI*2);

    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
    bladeRotationStart.setSchedulingBounds(bounds);



    int timeFastRotation = 500;  // Um giro rápido que leva 0,5 segundos.
    int timeOneWayFlight = 2000; // O helicóptero deve subir em 2 segundos.
    int timeHovering = 1000;     // helicoptero fica no ar por dois segundos.
    int timeStartWait = 1000;   

    //O tempo total em que o helicóptero decola.
    int timeFlightStart = timeStartRotor+timeSlowRotation*noStartRotations+timeStartWait;
    //Número de rotações rápidas
    int noFastRotations = 1+ ((timeStartWait+2*timeOneWayFlight+timeHovering)/timeFastRotation);

    //O alfa para a rotação rápida.
    Alpha bladeRotationAlpha = new Alpha(noFastRotations,Alpha.INCREASING_ENABLE,
                                         timeStartRotor+timeSlowRotation*noStartRotations,
                                         0,timeFastRotation,0,0,0,0,0);


    //O movimento rápido de rotação
    RotationInterpolator bladeRotation = new RotationInterpolator(
                                             bladeRotationAlpha,tgmRotor,
                                             bladeRotationAxis,0.0f,(float) Math.PI*2);
    bladeRotation.setSchedulingBounds(bounds);


    /* A rotação lenta e rápida se torna o grupo de transformação
     adicionado ao rotor. Essas rotações ainda estão no
     coordena a origem.*/
    tgmRotor.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgmRotor.addChild(bladeRotationStart);
    tgmRotor.addChild(bladeRotation);


/* O grupo de transformação para posicionar o rotor no topo da cabine ***
      A rotação do rotor é assim também do topo da cabina
      movido.*/
    Transform3D tfRotor = new Transform3D();
    tfRotor.setTranslation(new Vector3f(0.0f,cabinRadius,0.0f));
    TransformGroup tgRotor = new TransformGroup(tfRotor);
    tgRotor.addChild(tgmRotor);



//*** A popa do helicóptero ***

    //Comprimento da popa
    float halfTailLength = 0.2f;

    //A popa é criada como um cuboide verde
    Box tail = new Box(halfTailLength,0.02f,0.02f,greenApp);

    //Uma transformação que desloca a popa para a borda da cabine.
    Transform3D tfTail = new Transform3D();
    tfTail.setTranslation(new Vector3f(cabinRadius+halfTailLength,0.0f,0.0f));

    //O grupo de transformação para a popa
    TransformGroup tgTail = new TransformGroup(tfTail);
    tgTail.addChild(tail);

    //A barbatana é gerada a partir de três cubóides.
    float BoxLength1 = 0.03f;  // Comprimento do cubo abaixo
    float BoxLength2 = 0.02f; 
    float BoxLength3 = 0.01f;  // Comprimento do cubo acima
    float BoxHeight = 0.01f;   // Altura de todos os cubóides


    //Os três cubos são criados como caixas verdes
    Box GroundHeck = new Box(BoxLength1,BoxHeight,0.01f,greenApp);
    Box MiddleHeck = new Box(BoxLength2,BoxHeight,0.01f,greenApp);
    Box TopHeck = new Box(BoxLength3,BoxHeight,0.01f,greenApp);

    //A transformação que coloca os cubos em cima uns dos outros
    Transform3D tfGroundHeck = new Transform3D();
    tfGroundHeck.setTranslation(new Vector3f(0.0f,0.0f,0.0f));
    Transform3D tfMiddleHeck = new Transform3D();
    tfMiddleHeck.setTranslation(new Vector3f(BoxLength1-BoxLength2,2*BoxHeight,0.0f));
    Transform3D tfTopHeck = new Transform3D();
    tfTopHeck.setTranslation(new Vector3f(BoxLength1-BoxLength3,4*BoxHeight,0.0f));

    //Os grupos de transformação dos três cubos da ponta da cauda
    TransformGroup tgGroundHeck = new TransformGroup(tfGroundHeck);
    tgGroundHeck.addChild(GroundHeck);
    TransformGroup tgMiddleHeck = new TransformGroup(tfMiddleHeck);
    tgMiddleHeck.addChild(MiddleHeck);
    TransformGroup tgTopHeck = new TransformGroup(tfTopHeck);
    tgTopHeck.addChild(TopHeck);

    //A transformação que define os cubos na cauda
    Transform3D tfHeck = new Transform3D();
    tfHeck.setTranslation(new Vector3f(cabinRadius+2*halfTailLength-BoxLength1,3*BoxHeight,0.0f));

    TransformGroup tgHeck = new TransformGroup(tfHeck);
    tgHeck.addChild(tgGroundHeck);
    tgHeck.addChild(tgMiddleHeck);
    tgHeck.addChild(tgTopHeck);

    //O rotor de cauda é gerado como uma caixa azul
    float HeckRotorLength = 0.1f;

    Box HeckRotor = new Box(HeckRotorLength,0.01f,0.0001f,blueApp);
    TransformGroup tgmHeckRotor = new TransformGroup();
    tgmHeckRotor.addChild(HeckRotor);

    //A rotação de partida lenta do rotor
    Transform3D bladeHeckRotationAxis = new Transform3D();
    bladeHeckRotationAxis.rotX(Math.PI/2);
    int timeStartHeckRotor = 2000; //O rotor deve começar a girar após 2 segundos.
    int noStartHeckRotations = 7;  //Ele primeiro executa 2 voltas lentas.
    int timeSlowHeckRotation = 1500;//Uma volta lenta que leva 1,5 segundos.

    //O alfa para a rotação lenta
    Alpha bladeHeckRotationStartAlpha = new Alpha(noStartHeckRotations,
                                              Alpha.INCREASING_ENABLE,
                                              timeStartHeckRotor,
                                              0,timeSlowHeckRotation,0,0,0,0,0);



    //A rotação lenta da helice traseira
    RotationInterpolator bladeHeckRotationStart = new RotationInterpolator(
                                             bladeHeckRotationStartAlpha,tgmHeckRotor,
                                             bladeHeckRotationAxis,0.0f,(float) Math.PI*2);

    BoundingSphere Heckbounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
    bladeHeckRotationStart.setSchedulingBounds(Heckbounds);

    tgmHeckRotor.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgmHeckRotor.addChild(bladeHeckRotationStart);

    Transform3D tfHeckRotor = new Transform3D();
    tfHeckRotor.setTranslation(new Vector3f(cabinRadius+2*halfTailLength-BoxLength1,0.0f,0.02f));
    TransformGroup tgHeckRotor = new TransformGroup(tfHeckRotor);
    tgHeckRotor.addChild(tgmHeckRotor);


//*** O grupo de transformação para o movimento do helicóptero. ***
    //O movimento é descrito com respeito à origem das coordenadas e depois
    //mudou-se para a plataforma.
    TransformGroup tgmHelicopter = new TransformGroup();

    //Adicione todas as partes do helicóptero.
    tgmHelicopter.addChild(tgCabin);
    tgmHelicopter.addChild(tgRotor);
    tgmHelicopter.addChild(tgTail);
    tgmHelicopter.addChild(tgHeck);
    tgmHelicopter.addChild(tgHeckRotor);

    //Define o movimento.
    int timeAcc = 300; //A fase de aceleração / desaceleração dura 0,3 segundos cada.
    //O helicóptero deve subir um pouco para cima.
    Transform3D helicopterFlightAxis = new Transform3D();
    helicopterFlightAxis.rotZ(0.4*Math.PI);

    //O alfa para o movimento do helicóptero.
    Alpha helicopterAlpha = new Alpha(1,Alpha.INCREASING_ENABLE+Alpha.DECREASING_ENABLE,
                                      timeFlightStart,0,timeOneWayFlight,timeAcc,
                                      timeHovering,timeOneWayFlight,timeAcc,0);



    //O movimento do helicóptero
    PositionInterpolator posIPHelicopter = new PositionInterpolator(helicopterAlpha,
                                                   tgmHelicopter,helicopterFlightAxis,
                                                   0.0f,0.5f);

    posIPHelicopter.setSchedulingBounds(bounds);

    //Adicione o movimento ao grupo de transformação do helicóptero.
    tgmHelicopter.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgmHelicopter.addChild(posIPHelicopter);


//*** O grupo de transformação para posicionar o helicóptero na plataforma
    Transform3D tfHelicopter = new Transform3D();
    tfHelicopter.setTranslation(new Vector3f(0.0f,platformSize+cabinRadius,0.0f));
    TransformGroup tgHelicopter = new TransformGroup(tfHelicopter);
    tgHelicopter.addChild(tgmHelicopter);

//*** O helicóptero e a plataforma formam um grupo de transformações,***
//*** porque eles devem ser posicionados juntos na cena.          ***
    Transform3D tfHeliPlat = new Transform3D();
    tfHeliPlat.setTranslation(new Vector3f(0.0f,0.1f,0.0f));
    TransformGroup tgHeliPlat = new TransformGroup(tfHeliPlat);
    tgHeliPlat.addChild(tgHelicopter);
    tgHeliPlat.addChild(tgPlatform);


//*** tronco de árvore***

    //Uma aparência para pintar o tronco de árvore marrom.
    Appearance brownApp = new Appearance();
    setToMyDefaultAppearance(brownApp,new Color3f(0.5f,0.2f,0.2f));

    //Altura do tronco da árvore
    float trunkHeight = 0.4f;

    //Geração do tronco da árvore como um cilindro
    Cylinder trunk = new Cylinder(0.05f,trunkHeight,brownApp);

    /*O grupo de transformação do tronco da árvore. O tronco da árvore permanece
    primeiro na origem coordenada e estará junto com a coroa
     posicionado como uma árvore no total.*/
    TransformGroup tgTrunk = new TransformGroup();
    tgTrunk.addChild(trunk);


//*** A copa das árvores ***

    //Altura da copa das árvores
    float leavesHeight = 0.4f;

    //Geração da copa das árvores como um cone verde
    Cone leaves = new Cone(0.3f,leavesHeight,greenApp);

    //Uma transformação para colocar a copa das árvores no tronco da árvore.
    Transform3D tfLeaves = new Transform3D();
    tfLeaves.setTranslation(new Vector3f(0.0f,(trunkHeight+leavesHeight)/2,0.0f));

    //O grupo de transformação da copa das árvores.
    TransformGroup tgLeaves = new TransformGroup(tfLeaves);
    tgLeaves.addChild(leaves);


//*** A árvore, apenas dos grupos de transformação    ***
//*** para tronco de árvore e coroa deve ser composta.   ***

    //transformação para posicionar a árvore na cena.
    Transform3D tfTree = new Transform3D();
    tfTree.setTranslation(new Vector3f(-0.6f,0.0f,0.0f));

    //O grupo de transformação da árvore
    TransformGroup tgTree = new TransformGroup(tfTree);
    tgTree.addChild(tgTrunk);
    tgTree.addChild(tgLeaves);






//*** A raiz do gráfico que contém a cena. ***
    BranchGroup theScene = new BranchGroup();


    //Anexar o helicóptero e a árvore para a cena.
    theScene.addChild(tgHeliPlat);
    theScene.addChild(tgTree);



    theScene.compile();

    //Adicione a cena
    su.addBranchGraph(theScene);

  }

  public static void setToMyDefaultAppearance(Appearance app, Color3f col)
  {
    app.setMaterial(new Material(col,col,col,col,150.0f));
  }



  //Aqui, alguma luz é adicionada à cena.
  public void addLight(SimpleUniverse su)
  {

    BranchGroup bgLight = new BranchGroup();

    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
    Color3f lightColour1 = new Color3f(1.0f,1.0f,1.0f);
    Vector3f lightDir1  = new Vector3f(-1.0f,0.0f,-0.5f);
    DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
    light1.setInfluencingBounds(bounds);

    bgLight.addChild(light1);
    su.addBranchGraph(bgLight);
  }




}