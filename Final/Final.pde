Environment env;
Plane main;
Hud hud;
ArrayList<Obstacles> a;

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
  hud = new Hud(main.health,main.fuel);
  textFont(loadFont("SegoeUI-Light-40.vlw"));
}

void draw(){
  background(0);
  main.trace(env.velocity);
  main.paint();
  camera(main.getLocation().x, main.getLocation().y * 0.9, (height/2) / tan(PI/6) * 0.5, main.getLocation().x, main.getLocation().y, 0, 0, 1, 0);
  env.paint();
  add();
  hud.update(main.health,main.fuel);
  //resetMatrix();
}
