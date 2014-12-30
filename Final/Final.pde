Environment env;
Plane main;
ArrayList<Obstacles> a;

public class Environment {
  int velocity;
  int acc;
  int state;
  int hue;
  PImage img, img_;
  PImage img2;
  PImage img3;
  PImage img4;
  Environment(){
    velocity=150;
    state=0;
    img = loadImage("wall1.png");
    img_ = loadImage("wall1_.png");
    img2 = loadImage("ceiling1.png");
    img3 = loadImage("floor1.png");
    img4 = loadImage("support1.png");
    textureMode(NORMAL);
  }
  public void paint(){
    acc += velocity;
    acc = acc % width;
    noStroke();
    pushMatrix();
    translate(0,0,acc+width);
      for(int i=0;i<15000;i=i+width){
        hallways();
        translate(0,0,-width);  
        hue++;
        hue=hue%50000;
      }
    popMatrix();
  }

  private void hallways(){
    pushMatrix();
    rotateY(radians(90));
    make(width,(int)(height*0.4),img);
    translate(0,height*0.6,0);
    make(width,(int)(height*0.4),img_);
    translate(0,0,width);
    make(width,(int)(height*0.4),img_);
    translate(0,-height*0.6,0);
    make(width,(int)(height*0.4),img);
    translate(0,height*0.4,0);
    make(width,height*0.2,color(hue,240,255));
    translate(0,0,-width);
    make(width,height*0.2,color(hue,240,255));
    popMatrix();
    pushMatrix();
    rotateX(radians(90));
    make(width,width,img2);
    translate(0,0,-height);
    make(width,width,img3);
    popMatrix();
    pushMatrix();
    for(int i=0;i<2;i++){
      for(int j=0;j<2;j++){
        trimake(img4);  
        support(j);  
        translate(0,height,0);
        rotateX(radians(180));
        trimake(img4);
        support(j+1);
        translate(width,0,0);
        rotateY(radians(180));
        trimake(img4);
        support(j);
        translate(0,height,0);
        rotateX(radians(180));
        trimake(img4);
        support(j+1);
        translate(width,0,0);
        rotateY(radians(180));
        translate(0,0,-width/10);
      }
      translate(0,0,width/5);
      translate(0,0,-width/2);
    }
    popMatrix();
      
  }

  private void support(int i){
      if(i%2==1){
        return;
      }
      pushMatrix();
      translate(width/10,0);
      rotateY(radians(90));
      rotateX(radians(-45));
      make(width/10,width/10*sqrt(2),color(255,0,255));
      popMatrix();
  }
  
  private void trimake(PImage i){
      beginShape(TRIANGLES);
      texture(i);
      vertex(0,0,0);
      vertex(width/10,0,0);
      vertex(0,width/10,0);
      endShape();
  }
  
  private void make(PImage i){
    make(width,height,i);
  }

  private void make(int x, int y, PImage i){
    if(state==0){
      beginShape();
      texture(i);
      vertex(0,0,0,0,0);
      vertex(x,0,0,1,0);
      vertex(x,y,0,1,1);
      vertex(0,y,0,0,1);
      endShape();
    }
  }
  
  private void make(float x, float y, color c){
    fill(c);
    rect(0,0,x,y);
    /*if(glow){
      fill(hue(c),60,255,50);
      translate(0,y/2,0);
      box(x,y,40); 
      translate(0,-y/2,0);
    }*/
  }
}

public class Plane {
  PVector location;
  PVector vel;
  //PVector acc;
  int health;
  int fuel;
  public Plane(int x, int y){
    location = new PVector(x,y);
    vel = new PVector(0,0);
    vel.limit(20);
    health = 3;
    fuel = 50000;
  }
  public void trace(){
    vel.set(mouseX-location.x,mouseY-location.y);
    vel.mult(0.1);
    location.add(vel);
    if(location.x>width-50){
      location.x=width-50;
    } else if(location.x<50){
      location.x=50;
    }
    fuel--;
  }
  public void fire(){
  }
  public void paint(){
    pushMatrix();
    //translate(width/2,height/2);
    translate(location.x,location.y);
    make();
    //noFill();
    //stroke(255);
    //box(100,100,-100);
    popMatrix();
  }
  public void make(){
    noFill();
    stroke(255);
    beginShape(TRIANGLES);
    vertex(0,0,-100);
    vertex(-30,0,0);
    vertex(30,0,0);
    
    vertex(0,30,0);
    vertex(30,0,0);
    vertex(-30,0,0);
    
    vertex(0,0,-100);
    vertex(-30,0,0);
    vertex(0,30,0);
    
    vertex(0,0,-100);
    vertex(30,0,0);
    vertex(0,30,0);
    
    vertex(-30,0,0);
    vertex(-30,0,80);
    vertex(-50,0,0);
    
    vertex(30,0,0);
    vertex(30,0,80);
    vertex(50,0,0);
    
    vertex(-10,0,0);
    vertex(10,0,0);
    vertex(0,0,50);
    
    vertex(0,0,50);
    vertex(0,30,0);
    vertex(10,0,0);
    
    vertex(0,0,50);
    vertex(0,30,0);
    vertex(-10,0,0);
    endShape(CLOSE);
    beginShape(QUADS);
    vertex(50,0,0);
    vertex(50,20,0);
    vertex(30,20,80);
    vertex(30,0,80);
    
    vertex(-50,0,0);
    vertex(-50,20,0);
    vertex(-30,20,80);
    vertex(-30,0,80);
    
    vertex(30,0,0);
    vertex(30,20,0);
    vertex(30,20,80);
    vertex(30,0,80);
    
    vertex(-30,0,0);
    vertex(-30,20,0);
    vertex(-30,20,80);
    vertex(-30,0,80);
    endShape(CLOSE);
  }
  public PVector getLocation(){
    return location;
  }

}

public abstract class Rendered{
  abstract void paint();
  abstract void make();
}

void add(){
  int j = (int)random(3);
  if(random(100)>98){
    if(j==0){
      a.add(new Pillar());
    } else if(j==1) {
      a.add(new Missiles());
    } else if(j==2) {
      a.add(new Fuel());
    }
  }
  for(int i=0;i<a.size();i++){
    a.get(i).move(main.location.x,main.location.y);
    a.get(i).paint();
  }
}

void setup() {
  size(640, 480, P3D);
  colorMode(HSB,50000,255,255);
  frameRate(60);
  noStroke();
  float fov = PI/3.0;
  float cameraZ = (height/2.0) / tan(fov/2.0);
  perspective(fov, float(width)/float(height), 
            cameraZ/10.0, cameraZ*30.0);
  main = new Plane(width/2,height/2);
  env = new Environment();
  a = new ArrayList<Obstacles>(10);
}

void draw(){
  background(0);
  main.trace();
  main.paint();
  camera(main.getLocation().x, main.getLocation().y * 0.9, (height/2) / tan(PI/6) * 0.5, main.getLocation().x, main.getLocation().y, 0, 0, 1, 0);
  env.paint();
  add();
  translate(width/2, height/2);
  noFill();

}
