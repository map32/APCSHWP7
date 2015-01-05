public class Environment extends Rendered {
  int velocity;
  int acc;
  int state;
  int hue;
  ArrayList<Boxes> boxes;
  PImage img, img_;
  PImage img2;
  PImage img3;
  PImage img4;
  Environment(int vel){
    velocity=vel;
    state=1;
    img = loadImage("wall1.png");
    img_ = loadImage("wall1_.png");
    img2 = loadImage("ceiling1.png");
    img3 = loadImage("floor1.png");
    img4 = loadImage("support1.png");
    boxes = new ArrayList<Boxes>(20);
    textureMode(NORMAL);
  }
  public void paint(){
    if(state==0){
    background(0);
    acc += velocity;
    acc = acc % width;
    noStroke();
    pushMatrix();
    translate(0,0,acc+width);
      for(int i=0;i<12000;i=i+width){
        hallways();
        translate(0,0,-width);  
        hue++;
        hue=hue%50000;
      }
    popMatrix();
    } else if(state==1){
      sss();
    }
  }

  private void sss(){
    //background(color(random(50000),255,255));
    boxes.add(new Boxes(random(200)+100,random(200)+100,random(1000)+500,color(random(50000),255,255,230),velocity));
    hue += 100;
    hue=hue%50000;
    pushMatrix();
    translate(-50,-50,300);
    cube(50,50,12300,color(hue,255,255));
    translate(width+50,0);
    cube(50,50,12300,color(hue,255,255));
    translate(0,height+50);
    cube(50,50,12300,color(hue,255,255));
    translate(-width-50,0);
    cube(50,50,12300,color(hue,255,255));
    for(int i=0;i<boxes.size();i++){
      pushMatrix();
      translate(boxes.get(i).x,boxes.get(i).y,boxes.get(i).z);
      cube(boxes.get(i).a,boxes.get(i).b,boxes.get(i).c,boxes.get(i).k);
      popMatrix();
      boxes.get(i).z += boxes.get(i).v;
      if(boxes.get(i).z>0){
        boxes.remove(boxes.get(i));
      }
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
    make(width,(int)(height*0.2),color(hue,240,255));
    translate(0,0,-width);
    make(width,(int)(height*0.2),color(hue,240,255));
    popMatrix();
    pushMatrix();
    rotateX(radians(90));
    make(width,width,img2);
    translate(0,0,-height);
    make(width,width,img3);
    popMatrix();
    pushMatrix();
    /*for(int i=0;i<2;i++){ //laggy code
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
    }*/
    support(img4);
    //lights();
    translate(0,0,-width*0.3);
    support(img4);
    popMatrix();
      
  }

  private void lights(){
    pushMatrix();
    translate(width/10,0);
    rotateY(radians(90));
    rotateX(radians(-45));
    make(width/10,width/10*sqrt(2),color(255,0,255));
    popMatrix();
    pushMatrix();
    translate(width*0.9,0);
    rotateY(radians(90));
    rotateX(radians(-45));
    make(width/10,width/10*sqrt(2),color(255,0,255));
    popMatrix();
    pushMatrix();
    translate(width/10,height);
    rotateY(radians(90));
    rotateX(radians(45));
    make(width/10,width/10*sqrt(2),color(255,0,255));
    popMatrix();
    translate(width*0.9,height);
    rotateY(radians(-90));
    rotateX(radians(-45));
    make(width/10,width/10*sqrt(2),color(255,0,255));
  }
  
  private void support(PImage i){
    beginShape(TRIANGLES);
    texture(i);
    vertex(0,0,0,0,0);
    vertex(width/10,0,0,1,0);
    vertex(0,width/10,0,0,1);
    
    vertex(width,0,0,0,0);
    vertex(width*0.9,0,0,1,0);
    vertex(width,width/10,0,0,1);
    
    vertex(0,height,0,0,0);
    vertex(width/10,height,0,1,0);
    vertex(0,height*0.9,0,0,1);
    
    vertex(width,height,0,0,0);
    vertex(width*0.9,height,0,1,0);
    vertex(width,height*0.9,0,0,1);
    
    endShape();
  }

  /*private void support(int i){
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
    trimake(i,width/10);
  }
  private void trimake(PImage i, int x){
      beginShape(TRIANGLES);
      texture(i);
      vertex(0,0,0);
      vertex(width/10,0,0);
      vertex(0,width/10,0);
      endShape();
  }*/
  
}

public class Boxes {
  int x,y,z;
  color k;
  int a,b,c;
  int v;
  Boxes(float aa, float bb, float cc, color kk, int vv){
    v = vv+int(random(300));
    c = (int)cc;
    a = (int)aa;
    b = (int)bb;
    k = kk;
    x = (int)random(width*20)-width*10;
    y = (int)random(height*20)-height*10;
    z = -12000;
    if(x>=0){
      x+=width*2;
    } else {
      x-=width*2;
    }
    if(y>=0){
      y+=height*2;
    } else {
      y-=height*2;
    }
  }
}
