public class Hud {
  int health;
  int fuel;
  int time;
  int score;
  color fuelColor = color(30416,204,204,128);
  color hpColor = color(1000,204,204,128);
  //boolean sound;
  
  public Hud(int hp, int fl){
    health = hp;
    fuel = fl;
    //sound = sn;
  }
  
  void update(int hp, int fl){
    health = hp;
    pushMatrix();
    camera();
    hint(DISABLE_DEPTH_TEST);
    noLights();
    text((int)frameRate,20,40);
    translate(width,height);
    rotateZ(radians(180));
    //translate(0,1.*(fuel-fl)/fuel*width/2);
    fill(fuelColor);
    translate(width*0.06,0);
    rect(0,0,width*0.04,1.*fl/fuel*height/3);
    translate(width*0.06,0);
    fill(hpColor);
    for(int i=0;i<hp;i++){
      rect(0,0,width*0.05,height*0.05);
      translate(0,height*0.06);
    }
    hint(ENABLE_DEPTH_TEST); // no HUD anymore
    lights();
    popMatrix();
  }
  
  void displayText (String a1) { //http://forum.processing.org/two/discussion/1594/display-frame-rate-in-a-3d-sketch/p1
    camera();
    hint(DISABLE_DEPTH_TEST);
    noLights();
    // ------------------
    textSize(16);
    text (a1, 20, 20);
    // ------------------
    // reset all parameters to defaults
    textAlign(LEFT, BASELINE);
    rectMode(CORNER);
    textSize(32);
    hint(ENABLE_DEPTH_TEST); // no HUD anymore
    lights();
  }  
  
  void displayRect (int x, int y, color c){
  }
  
}
