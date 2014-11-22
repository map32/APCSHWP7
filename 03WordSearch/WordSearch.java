import java.util.*;

public class WordSearch {
    private char[][] grid;
    private int width,length;
    static String[] words = {"abc","ebd"};
    private char[] concatenated;
    private Random r;

    public WordSearch(int rows, int cols) {
	grid = new char[rows][cols];
	length = rows;
	width = cols;
	r = new Random();
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

    public void add(int numberWords) {
	int limit = 0;
	int number = 0;
	while(numberWords>number && limit <=100){
	    int i = r.nextInt(words.length);
	    int x = xRange(words[i]);
	    int y = yRange(words[i]);
	    int c = r.nextInt(2);
	    if (2*words[i].length()>width+length) {
		System.out.println("0");
		limit++;
		continue;
	    }
	    if(words[i].length()>length && words[i].length()<=width){
		y=r.nextInt(length);
		if(!(fit(words[i],y,x,0,c))){
		    //System.out.println("1");
		    limit++;
		    continue;
		}
		horizontal(words[i],y,x,c);
	    } else if(words[i].length()>width && words[i].length()<=length){
		x=r.nextInt(width);
		if(!(fit(words[i],y,x,1,c))){
		    //System.out.println("2");
		    limit++;
		    continue;
		}
		vertical(words[i],y,x,c);
	    } else {
		int a = r.nextInt(3);
		if (a==0){
		    y=r.nextInt(length);
		    if(!(fit(words[i],y,x,0,c))){
			//System.out.println("3");
			limit++;
			continue;
		    }
		    horizontal(words[i],y,x,c);
		} else if (a==1){
		    x=r.nextInt(width);
		    if(!(fit(words[i],y,x,1,c))){
			//System.out.println("4");
			limit++;
			continue;
		    }
		    vertical(words[i],y,x,c);
		} else if (a==2){
		    if(!(fit(words[i],y,x,2,c))){
			//System.out.println("5");
			limit++;
			continue;
		    }
		    diagonal(words[i],y,x,c);
		}
		
	    }
	    number++;
	    limit++;
	    System.out.println(this.toString());
	}
	if(limit>=200){
	    System.out.println(limit+" "+"limit reached");
	}
    }
    private int xRange(String s){
	return r.nextInt(width-s.length()+1);
    }
    private int yRange(String s){
	return r.nextInt(length-s.length()+1);
    }

    private boolean fit(String s, int y, int x, int d, int j){
	if(j==0){
	    y=length-y-1;
	    x=length-x-1;
	    j=-1;
	}
	for(int i=0;i<s.length();i++){
	    if(d==0){
		/*if(grid[y][x+i*j]!=' '){
		    System.out.println(s.charAt(i)+","+grid[y][x+i*j]+","+(grid[y][x+i*j]!=' ' && grid[y][x+i*j]!=s.charAt(i)));
		    }*/
		
		if(grid[y][x+i*j]!=' ' && grid[y][x+i*j]!=s.charAt(i)){
		    return false;
		}
	    } else if(d==1){
		if(grid[y+i*j][x]!=' ' && grid[y+i*j][x]!=s.charAt(i)){
		    return false;
		}
	    } else {
		if(grid[y+i*j][x+i*j]!=' ' && grid[y+i*j][x+i*j]!=s.charAt(i)){
		    return false;
		}
	    }
	}
	return true;
    }
	
    public void vertical(String s, int rows, int cols, int j){
	if(j==0){
	    rows=length-rows-1;
	    j=-1;
	}
	for(int i=0;i<s.length();i++){
	    grid[rows+i*j][cols]=s.charAt(i);
	}
    }	
    
    public void horizontal(String s, int rows, int cols,int j){
	if(j==0){
	    cols=length-cols-1;
	    j=-1;
	}
	for(int i=0;i<s.length();i++){
	    grid[rows][cols+i*j]=s.charAt(i);
	}
}
    
    public void diagonal(String s, int rows, int cols, int j){
	if(j==0){
	    rows=length-rows-1;
	    cols=length-cols-1;
	    j=-1;
	}
	for(int i=0;i<s.length();i++){
	    grid[rows+i*j][cols+i*j]=s.charAt(i);
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

    public static void main(String[]df) {
	WordSearch map =  new WordSearch(3,3);
	map.add(2);
	System.out.println(map.toString());
    }
}
