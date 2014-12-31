public class Hud {
  int health;
  int fuel;
  int time;
  int score;
  color fuelColor = color(30416,204,204,192);
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
    translate(width,height);
    rotateZ(radians(180));
    //translate(0,1.*(fuel-fl)/fuel*width/2);
    fill(fuelColor);
    translate(width*0.06,0);
    rect(0,0,width*0.04,1.*fl/fuel*height/3);
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
