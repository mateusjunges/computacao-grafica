
package java3d_objects;

import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.PlatformGeometry;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;


/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */


public class Rocket extends Applet {

 private SimpleUniverse universe = null;
 private Canvas3D canvas = null;
 private TransformGroup viewtrans = null;

 public Rocket() {
  setLayout(new BorderLayout());
  GraphicsConfiguration config = SimpleUniverse
    .getPreferredConfiguration();

  canvas = new Canvas3D(config);
  add("Center", canvas);
  universe = new SimpleUniverse(canvas);

  BranchGroup scene = createSceneGraph();
  universe.getViewingPlatform().setNominalViewingTransform();

  universe.getViewer().getView().setBackClipDistance(100.0);
  universe.addBranchGraph(scene);
 }

 private BranchGroup createSceneGraph() {
  BranchGroup objRoot = new BranchGroup();

  BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

  viewtrans = universe.getViewingPlatform().getViewPlatformTransform();

  KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
  keyNavBeh.setSchedulingBounds(bounds);
  PlatformGeometry platformGeom = new PlatformGeometry();
  platformGeom.addChild(keyNavBeh);
  universe.getViewingPlatform().setPlatformGeometry(platformGeom);

  objRoot.addChild(createRocket());

  return objRoot;
 }

 private BranchGroup createRocket() {

  BranchGroup objRoot = new BranchGroup();

  TransformGroup tg = new TransformGroup();
  Transform3D t3d = new Transform3D();

  t3d.setTranslation(new Vector3d(0.0, 0.0, -15.0));
  tg.setTransform(t3d);

  TransformGroup tg_sp = new TransformGroup();
  Transform3D t3d_sp = new Transform3D();

  t3d_sp.setTranslation(new Vector3d(0.0, 1.0, 0.0));
  tg_sp.setTransform(t3d_sp);

  Appearance ap_sp = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_sp.addChild(new Sphere(0.5f, ap_sp));

  TransformGroup tg_cy = new TransformGroup();
  Transform3D t3d_cy = new Transform3D();

  t3d_cy.setTranslation(new Vector3d(0.0, 0.0, 0.0));
  tg_cy.setTransform(t3d_cy);

  Appearance ap_cy = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_cy.addChild(new Cylinder(0.5f, 2.0f, ap_cy));

  TransformGroup tg_cy1 = new TransformGroup();
  Transform3D t3d_cy1 = new Transform3D();

  t3d_cy1.setTranslation(new Vector3d(-0.6, -0.5, 0.0));
  tg_cy1.setTransform(t3d_cy1);

  Appearance ap_cy1 = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_cy1.addChild(new Cylinder(0.05f, 1.5f, ap_cy1));

  TransformGroup tg_cy2 = new TransformGroup();
  Transform3D t3d_cy2 = new Transform3D();

  t3d_cy2.setTranslation(new Vector3d(0.6, -0.5, 0.0));
  tg_cy2.setTransform(t3d_cy2);

  Appearance ap_cy2 = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_cy2.addChild(new Cylinder(0.05f, 1.5f, ap_cy2));

  TransformGroup tg_cy3 = new TransformGroup();
  Transform3D t3d_cy3 = new Transform3D();

  t3d_cy3.setTranslation(new Vector3d(0.0, -0.5, 0.6));
  tg_cy3.setTransform(t3d_cy3);

  Appearance ap_cy3 = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_cy3.addChild(new Cylinder(0.05f, 1.5f, ap_cy3));

  TransformGroup tg_cy4 = new TransformGroup();
  Transform3D t3d_cy4 = new Transform3D();

  t3d_cy4.setTranslation(new Vector3d(0.0, -0.5, -0.6));
  tg_cy4.setTransform(t3d_cy4);

  Appearance ap_cy4 = createAppearance(new Color3f(1.0f, 0.3f, 0.0f));
  tg_cy4.addChild(new Cylinder(0.05f, 1.5f, ap_cy4));

  TransformGroup tg_sp2 = new TransformGroup();
  Transform3D t3d_sp2 = new Transform3D();

  t3d_sp2.setTranslation(new Vector3d(0.0, -0.7, 0.0));
  tg_sp2.setTransform(t3d_sp2);

  Appearance ap_sp2 = createAppearance(new Color3f(1.0f, 1.0f, 1.0f));
  tg_sp2.addChild(new Sphere(0.45f, ap_sp2));

  tg.addChild(tg_sp);
  tg.addChild(tg_cy);
  tg.addChild(tg_cy1);
  tg.addChild(tg_cy2);
  tg.addChild(tg_cy3);
  tg.addChild(tg_cy4);
  tg.addChild(tg_sp2);
  objRoot.addChild(tg);

  objRoot.addChild(createLight());

  objRoot.compile();

  return objRoot;

 }

 private Appearance createAppearance(Color3f col) {
  Appearance ap = new Appearance();
  Material ma = new Material();
  ma.setDiffuseColor(col);
  ma.setEmissiveColor(col);
  ap.setMaterial(ma);
  return ap;
 }

 private Light createLight() {
  DirectionalLight light = new DirectionalLight(true, new Color3f(1.0f,
    1.0f, 1.0f), new Vector3f(-0.3f, 0.2f, -1.0f));

  light.setInfluencingBounds(new BoundingSphere(new Point3d(), 10000.0));

  return light;
 }

 public static void main(String[] args) {
  Rocket applet = new Rocket();
  Frame frame = new MainFrame(applet, 800, 600);
 }
}