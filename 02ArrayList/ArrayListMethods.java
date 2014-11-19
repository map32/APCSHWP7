import java.util.*;

public class ArrayListMethods {

    public static void randomize( ArrayList<Integer> L ) {
	int y;
	int z;
	Random r = new Random();
	int x = L.size()-1;
        while(x>0){
	    y = L.get(L.size()-1);
	    z = r.nextInt(x+1);
	    L.set(L.size()-1,L.get(z));
	    L.set(z,y);
	    x--;
	}
    }   

    /*Change the order of the elements of L into a random permutation
    *@param L The values to be put into random order
    */

    public static void collapseDuplicates( ArrayList<Integer> L) { 
	if (L.size()>1) {
	    for (int i = 1;i<L.size();i++){
		if (L.get(i-1).equals(L.get(i))){
		    L.remove(i);
		    i--;
		}
	    }
	}
    }
    

    public static void main(String[]args){
        ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(1);
	L.add(1);
	L.add(1);
	L.add(1);
	L.add(1);
	L.add(1);
	L.add(2);
	L.add(2);
	L.add(2);
	L.add(2);
	L.add(3);
	L.add(3);
	L.add(3);

	System.out.println(L.toString());
	collapseDuplicates(L);
	System.out.println(L.toString());

	L.clear();
	for (int i=0;i<30;i++){
	    L.add(i);
	}
	System.out.println(L.toString());
	randomize(L);
	System.out.println(L.toString());
	randomize(L);
	System.out.println(L.toString());
	randomize(L);
	System.out.println(L.toString());
	randomize(L);
	System.out.println(L.toString());

    }

}
