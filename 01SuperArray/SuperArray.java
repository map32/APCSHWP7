public class SuperArray {
    public Object[] array;
    public int length;

    public SuperArray() {
	this(10);
    }

    public SuperArray(int size) {
	array = new Object[size];
	length = 0;
    }
    
    public String toString() {
	String str = "[ ";
	for(int i=0;i<length;i++) {
	    str+=array[i];
	    str+=" ";
	}
	str+="]";
	return str;
    }

    public void add(Object e) {
	add(length,e);
    }

    public void add(int index, Object o) {
	if(array.length<=length){
	    resize((int)(array.length*1.5));
	}
	for(int i=length-1;i>=index;i--){
	    array[i+1]=array[i];
	}
	array[index]=o;
	length++;
    }

    public int size(){
	return length;
    }

    public void resize(int newCapacity){
	Object[] array2 = new Object[newCapacity];
	for(int i=0;i<length;i++){
	    array2[i]=array[i];
	}
	array=array2;
    }

    public void clear(){
	array = new Object[10];
    }

    public Object get(int index){
	if(index<0 || index>=length){
	    System.out.println("out of range m9");
	    return null;
	}
	return array[index];
    }

    public void sety(int index, Object e){
	if(index<0 || index>=length){
	    System.out.println("out of range m9");
	} else {
	    array[index]=e;
	}
    }

    public Object set(int index, Object o){
	if(index<0 || index>= length) {
	    System.out.println("out of range m9");
	    return null;
	}
	sety(index,o);
	return array[index+1];
    }

    public void insertionSort(){
	String temp;
	for(int i=1;i<length;i++){
	    temp = (String)array[i];
	    int j = i-1;
	    while(j>=0){
		if(array[j].toString().compareTo(temp)>0){
		    set(j+1,array[j]);
		    set(j,temp);
		}
		j--;
	    }
	}
	
    }
    
    /*public void badInsertionSort(){
        SuperArray c = new SuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
	} */

    public void selectionSort(){
	
    }

    public Object remove(int index){
	if(index<0 || index>= length) {
	    System.out.println("out of range m9");
	    return null;
	}
	Object o = array[index];
	for(int i=index+1;i<length;i++){
	    array[i-1]=array[i];
	}
	resize(array.length-1);
	length--;
	return o;
    }

    public int getLength(){
	return length;
    }

    public static void main(String[]adads){
	SuperArray L = new SuperArray();
	for(int i=0;i<100;i++){
	    L.add(Integer.toString(i));
	}
	System.out.println(L.toString());
	long start = System.nanoTime();
	L.insertionSort();
	long end = System.nanoTime();
	System.out.println(L.toString());
	System.out.println(end-start);
    }
}
