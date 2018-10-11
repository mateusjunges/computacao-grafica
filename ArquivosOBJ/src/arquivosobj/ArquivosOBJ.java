package arquivosobj;

import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.behaviors.vp.*;
import javax.swing.JFrame;
import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.*;
import java.util.Hashtable;
import java.util.Enumeration;


/**
 *
 @author Mateus Junges <contato@mateusjunges.com>
 */

public class ArquivosOBJ extends JFrame
{

  //The canvas to be drawn upon.
  public Canvas3D canvas;


  public ArquivosOBJ()
  {

   //Fecha a janela quando o programa termina
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //DConfigurações padrao para o observador
    canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());


    //Constroi o universo usando canvas
    SimpleUniverse myUniverse = new SimpleUniverse(canvas);


    //Posição padrao do observador
    myUniverse.getViewingPlatform().setNominalViewingTransform();


    //Gera a cena
    createSceneGraph(myUniverse);


    //Adiciona luz
    addLight(myUniverse);

    //Permite rodar o objeto
    OrbitBehavior ob = new OrbitBehavior(canvas);
    ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
    myUniverse.getViewingPlatform().setViewPlatformBehavior(ob);


      //Mostra a janela
    setTitle("Objeto carregado de um arquivo");
    setSize(700,700);
    getContentPane().add("Center", canvas);
    setVisible(true);


  }




  public static void main(String[] args)
  {
     ArquivosOBJ le = new ArquivosOBJ();
  }

  //Neste método os objetos sao gerados e adicionados ao universo
  public void createSceneGraph(SimpleUniverse su)
  {



    //Carrega um arquivo obj
    ObjectFile f = new ObjectFile(ObjectFile.RESIZE);
    Scene s = null;

    try
    {
      s = f.load("schiff.obj");
    }
    catch (Exception e)
    {
      System.out.println("O carregamento falhou:" + e);
    }

    //Gera um grupo de transformações para o objeto
    Transform3D tfObject = new Transform3D();
    tfObject.rotZ(0.4*Math.PI);
    Transform3D xRotation = new Transform3D();
    xRotation.rotY(0.4*Math.PI);
    tfObject.mul(xRotation);
    TransformGroup tgObject = new TransformGroup(tfObject);
    tgObject.addChild(s.getSceneGroup());

    //Nesta parte, os nomes das partes dos objetos podem ser obtidos.
    Hashtable namedObjects = s.getNamedObjects();
    Enumeration enumer = namedObjects.keys();
    String name;
    while (enumer.hasMoreElements())
    {
      name = (String) enumer.nextElement();
      System.out.println("Nome: "+name);
    }
    
    Appearance lightBlueApp = new Appearance();
    setToMyDefaultAppearance(lightBlueApp,new Color3f(0.7f,0.5f,1f));
    Shape3D partOfTheObject = (Shape3D) namedObjects.get("flugdeck");
    partOfTheObject.setAppearance(lightBlueApp);


    BranchGroup theScene = new BranchGroup();

    theScene.addChild(tgObject);

   
    //Gera o fundo branco
    Background bg = new Background(new Color3f(1.0f,1.0f,1.0f));
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
    bg.setApplicationBounds(bounds);
    theScene.addChild(bg);


    theScene.compile();

    //Adiciona a cena
    su.addBranchGraph(theScene);
  }

  public static void setToMyDefaultAppearance(Appearance app, Color3f col)
  {
    app.setMaterial(new Material(col,col,col,col,150.0f));
  }



  //Adiciona luz
  public void addLight(SimpleUniverse su)
  {

    BranchGroup bgLight = new BranchGroup();

    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
    Color3f lightColour1 = new Color3f(0.2f,0f,0.2f);
    Vector3f lightDir1  = new Vector3f(-1.0f,0.0f,-0.5f);
    DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
    light1.setInfluencingBounds(bounds);

    bgLight.addChild(light1);
    su.addBranchGraph(bgLight);
  }



}
