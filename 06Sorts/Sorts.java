public class Sorts {

    public static void main(String[] args){
	int[] c = new int[10];
	for(int i=0;i<10;i++){
	    c[i]=10-i;
	}
	bubble(c);
	System.out.println(toString(c));
    }


    public static void bubble(int[] c){
	int temp;
	for(int i=0;i<c.length-1;i++){
	    temp = c[i];
	    for(int j=i;j<c.length-1;j++){
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
		if(c[j]>c[i]){
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