import java.util.*;

public class WordSearch {
    private char[][] grid;
    private int width,length;
    static String[] words;
    private char[] concatenated;

    public WordSearch(int x, int y) {
	Grid = new char[x][y];
	width = x;
	length = y;
	for (int i=0;i<x;i++) {
	    for (int j=0;j<y;j++) {
		grid[i][j] = '#';
	    }
	}
    }

    public void concatenate(String s) {
	for (int i=0;i<s.length();i++){
	    concatenated[i] = s.substring(i,i+1);
	}
    }

    public void add() {
	Random r = new Random();
	while(true){
	    int i = r.nextInt(words.length);
	    if (2*words[i].length()>width+length)
		continue;
	    if(words[i].length()<length){
		horizontal(words[i],r.nextInt(2));
	    }
	    if(words[i].length()<width){
		vertical(words[i],r.nextInt(2));
	    }
	}
    }
    public void vertical();
    
    public void horizontal();

    public void diagonal();

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