import java.util.*;

public class WordSearch {
    private char[][] grid;
    private int width,length;
    static String[] words;
    private char[] concatenated;
    private Random r;

    public WordSearch(int rows, int cols) {
	grid = new char[rows][cols];
	length = rows;
	width = cols;
	Random r = new Random();
	clear();
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

    public void add() {
	while(true){
	    int i = r.nextInt(words.length);
	    int x = xRange(words[i]);
	    int y = yRange(words[i]);
	    if (2*words[i].length()>width+length) {
		continue;
	    }
	    if(words[i].length()>length && words[i].length()<=width){
		y=r.nextInt(length);
		if(!(fit(words[i],y,x,0))){
		    continue;
		}
		horizontal(words[i],y,x);
	    } else if(words[i].length()>width && words[i].length()<=length){
		x=r.nextInt(width);
		if(!(fit(words[i],y,x,1))){
		    continue;
		}
		vertical(words[i],y,x);
	    } else {
	    int a = r.nextInt(3);
	    if (a==0){
		y=r.nextInt(length);
		if(!(fit(words[i],y,x,0))){
		    continue;
		}
		horizontal(words[i],y,x);
	    } else if (a==1){
		x=r.nextInt(width);
		if(!(fit(words[i],y,x,1))){
		    continue;
		}
		vertical(words[i],y,x);
	    } else if (a==2){
		if(!(fit(words[i],y,x,2))){
		    continue;
		}
		diagonal(words[i],y,x);
	    }
	    
	    }
	}
    }
    private int xRange(String s){
	return r.nextInt(width-s.length()+1);
    }
    private int yRange(String s){
	return r.nextInt(length-s.length()+1);
    }

    private boolean fit(String s, int y, int x, int d){
	for(int i=0;i<s.length();i++){
	    if(d==0){
		if(grid[y][x+i]!=' ' || grid[y][x+i]!=s.charAt(i)){
		    return false;
		}
	    } else if(d==1){
		if(grid[y+i][x]!=' ' || grid[y+i][x]!=s.charAt(i)){
		    return false;
		}
	    } else {
		if(grid[y+i][x+i]!=' ' || grid[y+i][x+i]!=s.charAt(i)){
		    return false;
		}
	    }
	}
	return true;
    }
	
    public void vertical(String s, int rows, int cols){
	
    }	
    
    public void horizontal(String s, int rows, int cols){}
    
    public void diagonal(String s, int rows, int cols){}

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

    public static void main(String[]df) {
	WordSearch map =  new WordSearch(20,20);
	System.out.println(map.toString());
    }
}
