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
