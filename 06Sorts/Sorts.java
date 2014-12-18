public class Sorts {

    public static void main(String[] args){
	int[] c = new int[50000];
	long start;
	long end;
	for(int i=0;i<50000;i++){
	    c[i]=50000-i;
	}
	//System.out.println(toString(c));
	start = System.nanoTime();
	bubble(c);
	end = System.nanoTime();
	//System.out.println(toString(c));
	System.out.println((end-start)/1000000000.);

	c = new int[50000];
	for(int i=0;i<50000;i++){
	    c[i]=50000-i;
	}
	//System.out.println(toString(c));
	start = System.nanoTime();
	insertion(c);
	end = System.nanoTime();
	//System.out.println(toString(c));
	System.out.println((end-start)/1000000000.);

	c = new int[50000];
	for(int i=0;i<50000;i++){
	    c[i]=50000-i;
	}
	//System.out.println(toString(c));
	start = System.nanoTime();
	selection(c);
	end = System.nanoTime();
	//System.out.println(toString(c));
	System.out.println((end-start)/1000000000.);
    }


    public static void bubble(int[] c){
	int temp;
	for(int i=0;i<c.length-1;i++){
	    for(int j=0;j<c.length-1-i;j++){
		temp = c[j];
		if(c[j]>c[j+1]){
		    c[j]=c[j+1];
		    c[j+1]=temp;
		}
	    }
	}
    }	

    public static void insertion(int[] c){
	int temp;
	for(int i=1;i<c.length;i++){
	    temp = c[i];
	    for(int j=i-1;j>=0;j--){
		if(c[j]>c[j+1]){
		    c[j+1]=c[j];
		    c[j]=temp;
		}
	    }
	}	
    }

    public static void selection(int[] c){
	for(int i=0;i<c.length;i++){
	    int min=i;
	    for(int j=i;j<c.length;j++){
		if(c[min]>c[j]){
		    min=j;
		}
	    }
	    int mintemp = c[min];
	    c[min]=c[i];
	    c[i]=mintemp;
	}
    }

    public static void radix(int[] c){
	ArrayList<Integer>[] storage = new ArrayList<Integer>[c.length];
	ArrayList<Integer> list = new ArrayList<Integer>;
	int max = 0;
	for(int i=0;i<c.length;i++){
	    list.add(c[i]);
	    if(c[max]<c[i]){
		max=i;
	    }
	}
	for(int i=0;i<c.length;i++){
	    storage[c[i]%10].add(c[i]);
	}
	list.clear();
	for(int i=0;i<c.length;i++){
	    list.addAll(storage[i]);
	}
    }

    public static int digit(){
    }

    public static String toString(int[] c) {
	String str = "[ ";
	for(int i=0;i<c.length;i++) {
	    str+=c[i];
	    str+=" ";
	}
	str+="]";
	return str;
    }
}
