import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;

public class WordSearch {
    private char[][] grid;
    private int width,length;
    private String[] words;
    private char[] concatenated;
    private Random r;
    private int picked;

    public WordSearch(int rows, int cols) {
	grid = new char[rows][cols];
	length = rows;
	width = cols;
	r = new Random();
	read();
	clear();
	
    }

    public void read(){
	try {
	    File text = new File("list.txt");
	    Scanner scan = new Scanner(text);
	    int i=0;
	    while(scan.hasNextLine()){
		scan.nextLine();
		i++;
	    }
	    scan = new Scanner(text);
	    words = new String[i];
	    i=0;
	    while(scan.hasNextLine()){
		words[i]=scan.nextLine().toUpperCase();
		i++;
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("file not found");
	}
    }

    public void clear() {
	for (int i=0;i<length;i++) {
	    for (int j=0;j<width;j++) {
		grid[i][j] = ' ';
	    }
	}
    }

    public void concatenate(String s) {
	for (int i=0;i<s.length();i++){
	    concatenated[i] = s.charAt(i);
	}
    }
    
    public void pick(){
	int j = words.length-picked-1;
	int i = r.nextInt(j+1);
	System.out.println(words[i]);
	String s = words[j];
	words[j]=words[i];
	words[i]=s;
	picked++;
    }

    public void add() {
	int limit = 0;
	int number = 0;
	int[] yx = new int[2];
	int[] dydx = new int[2];
	while(limit<=100){
	    int i = r.nextInt(words.length);
	    if (2*words[i].length()>width+length) {  //word is too big
		limit++;
		continue;
	    }
	    yx = locate(words[i]);
	    dydx = direct(words[i],yx[0],yx[1]);
	    if (dydx[0] == 0 && dydx[1] == 0){
		limit++;
		continue;
	    }
	    assign(words[i],yx[0],yx[1],dydx[0],dydx[1]);
	    number++;
	    limit++;
	}
    }
    private int xRange(String s){
	return r.nextInt(width-s.length()+1);
    }
    private int yRange(String s){
	return r.nextInt(length-s.length()+1);
    }

    private int[] direct(String s, int y, int x){
	int dy = r.nextInt(3)-1;
	int dx = r.nextInt(3)-1;
	if (!(fit(s,y,x,dy,dx))){
	    dy=0;
	    dx=0;
	}
	int[] dydx = {dy,dx};
	return dydx;
    }

    private int[] locate(String s){
	int[] yx = new int[2];
	yx[0]=yRange(s);
	yx[1]=xRange(s);
	return yx;
    }

    private boolean fit(String s, int y, int x, int dy, int dx) throws ArrayIndexOutOfBoundsException{
	for(int i=0;i<s.length();i++){
	    try{
		if(grid[y+i*dy][x+i*dx]!=' ' && grid[y+i*dy][x+i*dx]!=s.charAt(i)){
		    return false;
		}
	    } catch(ArrayIndexOutOfBoundsException e) {
		return false;
	    }
	}
	return true;
    }
    
    public void assign(String s, int rows, int cols, int dy, int dx){
	System.out.println(s);
	for(int i=0;i<s.length();i++){
	    grid[rows+i*dy][cols+i*dx]=s.charAt(i);
	}
    }
    
    public void obfuscate(){
	String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int i=0;i<length;i++) {
	    for (int j=0;j<width;j++) {
		if(grid[i][j]==' ')
		    grid[i][j] = abc.charAt(r.nextInt(abc.length()));
	    }
	}
    }

    public String toString() {
	String s = "";
	for (int i=0;i<width;i++) {
	    for (int j=0;j<length;j++) {
		s+=grid[i][j];
		s+=" ";
	    }
	    s+="\n";
	}
	return s;
    }

    public static void main(String[]args) {
	if(args.length<2){
	    System.out.println("Usage: java Driver rows cols [seed [answer]]");
	} else {
	    WordSearch map =  new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    map.add();
	    //map.obfuscate();
	    System.out.println(map.toString());
    }
    }
}
