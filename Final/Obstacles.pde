public abstract class Obstacles extends Rendered{
  PVector location;
  PVector velocity;
  //PVector acc;
  int rangeX;
  int rangeY;
  boolean destructible;
  
  public Obstacles(int vel){
    location = new PVector((int)random(width),(int)random(height),-15000);
    velocity = new PVector(0,0,vel);
  }
  
  public Obstacles(int x, int y, int z, int vel){
    location = new PVector(x,y,z);
    velocity = new PVector(0,0,vel);
  }
  
  public void move(float planeX, float planeY){
    location.add(velocity);
  }
  
  public void move(){
    location.add(velocity);
  }
  
  
  //public boolean isHit(Plane plane){
  //}
}

public class Pillar extends Obstacles{
  int axis;
  PImage img;
  color c;
  
  public Pillar(int v){
    super(0,(int)random(height),-15000,v);
    c = color((int)random(50000),255,255,200);
    //axis = (int)random(2);
    axis = (int)random(2);
    if(axis==1){
      location.y=0;
      location.x=(int)random(width);
    }
    img = loadImage("pillar.png");
    rangeX=width;
    rangeY=height/3;
  }
  
  public void paint(){
    pushMatrix();
    translate(location.x,location.y,location.z);
    if(axis==0){
      pushMatrix();
      translate(0,rangeY/4,-rangeY/4);
      cube(rangeX,rangeY/2,rangeY/2,color(c));
      popMatrix();
      pushMatrix();
      cube(rangeX/16*3,rangeY,rangeY,img);
      translate(rangeX/4,0,0);
      cube(rangeX/8,rangeY,rangeY,img);
      translate(rangeX/16*3,0,0);
      cube(rangeX/8,rangeY,rangeY,img);
      translate(rangeX/16*3,0,0);
      cube(rangeX/8,rangeY,rangeY,img);
      translate(rangeX/16*3,0,0);
      cube(rangeX/16*3,rangeY,rangeY,img);
      popMatrix();
      popMatrix();
    } else {
      pushMatrix();
      translate(rangeY/4,0,-rangeY/4);
      cube(rangeY/2,rangeX,rangeY/2,color(c));
      popMatrix();
      pushMatrix();
      cube(rangeY,rangeX/16*3,rangeY,img);
      translate(0,rangeX/4,0);
      cube(rangeY,rangeX/8,rangeY,img);
      translate(0,rangeX/16*3,0);
      cube(rangeY,rangeX/8,rangeY,img);
      translate(0,rangeX/16*3,0);
      cube(rangeY,rangeX/8,rangeY,img);
      translate(0,rangeX/16*3,0);
      cube(rangeY,rangeX/16*3,rangeY,img);
      popMatrix();
      popMatrix();
    }
  }
}

public class Missiles extends Obstacles{
  int acc = 5;
  int angle = 0;
  public Missiles(int v){
    super(v);
  }
  
  public void move(float planeX, float planeY){
    if(location.x<0){
      location.x=1;
    } else if(location.x>width){
      location.x=width-1;
    }
    if(location.y<0){
      location.y=1;
    } else if(location.y>height){
      location.y=height-1;
    }
    velocity.z += acc;
    velocity.add((planeX-location.x)/400,(planeY-location.y)/400,acc);
    location.add(velocity);
  }
  
  public void paint(){
    pushMatrix();
    translate(location.x,location.y,location.z);
    angle+=1;
    rotateZ(radians(angle));
    stroke(0);
    box(100);
    noStroke();
    popMatrix();
  }
}

public class Health extends Obstacles {
  int hp;
  color red = color(0,220,255,192);
  
  public Health(int h, int v){
    super(v);
    hp = h;
  }
  
  public void paint(){
    pushMatrix();
    translate(location.x,location.y,location.z);
    cube(40,150,40,red);
    translate(-55,55,0);
    cube(150,40,40,red);
    popMatrix();
  }
}

public class Fuel extends Obstacles {
  int fuel;
  
  public Fuel(int v){
    super(v);
  }
  
  public void paint(){
    pushMatrix();
    translate(location.x,location.y,location.z);
    cube(90,30,90,color(130*50000/255,255,255,192));
    translate(0,30,0);
    cube(90,60,90,color(228*50000/255,255,255,192));
    translate(0,60,0);
    cube(90,30,90,color(130*50000/255,255,255,192));
    popMatrix();
  }
}
  
public class Invincible extends Obstacles {
  int hue = 0;
  public Invincible(int v){
    super(v);
  }
  
  public void paint(){
    fill(color(hue,255,255,192));
    hue += 20;
    sphere(100);
  }
}  

  
