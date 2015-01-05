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
  public void trace(int speed){
    vel.set(mouseX-location.x,mouseY-location.y);
    vel.mult(0.15);
    location.add(vel);
    if(location.x>width-50){
      location.x=width-50;
    } else if(location.x<50){
      location.x=50;
    }
    fuel -= speed*0.5;
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
    noStroke();
  }
  public PVector getLocation(){
    return location;
  }

}
