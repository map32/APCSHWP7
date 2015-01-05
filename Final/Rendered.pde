public abstract class Rendered {
  
  public abstract void paint();
  
  public void make(PImage i){
    make(width,height,i);
  }
  
  public void cube(int x, int y, int z, PImage i){
    pushMatrix();
    make(x,y,i);
    translate(0,0,-z);
    make(x,y,i);
    popMatrix();
    pushMatrix();
    rotateY(radians(90));
    make(z,y,i);
    translate(0,0,z);
    make(z,y,i);
    popMatrix();
    pushMatrix();
    rotateX(radians(-90));
    make(x,z,i);
    translate(0,0,y);
    make(x,z,i);
    popMatrix();
  }
  
  public void cube(int x, int y, int z, color i){
    pushMatrix();
    make(x,y,i);
    translate(0,0,-z);
    make(x,y,i);
    popMatrix();
    pushMatrix();
    rotateY(radians(90));
    make(z,y,i);
    translate(0,0,z);
    make(z,y,i);
    popMatrix();
    pushMatrix();
    rotateX(radians(-90));
    make(x,z,i);
    translate(0,0,y);
    make(x,z,i);
    popMatrix();
  }
  
  public void make(int x, int y, PImage i){
    beginShape(QUADS);
    texture(i);
    vertex(0,0,0,0,0);
    vertex(0,y,0,0,1);
    vertex(x,y,0,1,1);
    vertex(x,0,0,1,0);
    endShape();
  }

  public void make(int x, float y, color c){
    make(x,(int)y,c);
  }
  
  public void make(int x, int y, color c){
    fill(c);
    rect(0,0,x,y);
  }
}

