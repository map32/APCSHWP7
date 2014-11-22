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
	    if (2*words[i].length()>width+length) {
		continue;
	    }
	    if(words[i].length()>length && words[i].length()<=width){
		horizontal(words[i],r.nextInt(length),xRange(words[i]));
		continue;
	    }
	    if(words[i].length()>width && words[i].length()<=length){
		vertical(words[i],yRange(words[i]),r.nextInt(width));
		continue;
	    }
	    int a = r.nextInt(3);
	    if (a==0){
		horizontal(words[i],r.nextInt(length),xRange(words[i]));
	    } else if (a==1){
		vertical(words[i],yRange(words[i]),r.nextInt(width));
	    } else if (a==2){
		diagonal(words[i],yRange(words[i]),xRange(words[i]));
	    }
	}
    }
    
    private int xRange(String s){
	return r.nextInt(width-s.length()+1);
    }
    private int yRange(String s){
	return r.nextInt(length-s.length()+1);
    }

    public void vertical(String s, int rows, int cols){}	
    
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
