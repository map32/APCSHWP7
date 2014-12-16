public class Sorts {

    public static void bubble(int[] c){
	int temp;
	for(int i=0;i<length-1;i++){
	    temp = c[i];
	    for(int j=i;j<length-i;j++){
		if(c[j]>c[j+1]){
		    c[j]=c[j+1];
		    c[j+1]=temp;
		}
	    }
	}
    }	

    public static void insertion(int[] c){
	int temp;
	for(int i=1;i<length;i++){
	    temp = array[i];
	    for(int j=i-1;j>=0;j--){
		if(c[j]>c[i]){
		    c[j+1]=c[j];
		    c[j]=temp;
		}
	    }
	}	
    }

    public static void selection(int[] c){
	for(int i=0;i<length;i++){
	    int min=i;
	    for(int j=i;j<length;j++){
		if(c[min]>c[j]){
		    min=j;
		}
	    }
	    int mintemp = c[min];
	    c[min]=c[i];
	    c[i]=mintemp;
	}
    }
}