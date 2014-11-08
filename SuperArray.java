public class SuperArray {
    public Object[] array;
    private int length=0;

    public SuperArray() {
	this(10);
    }

    public SuperArray(int size) {
	array = new Object[size];
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

    public static void main(String[]adads){
	Integer x = new Integer(5);
	SuperArray L = new SuperArray();
	L.add(new Integer(0));
	L.add(new Integer(1));
	L.add(new Integer(2));
	L.add(new Integer(3));
	L.add(new Integer(4));
	L.add(new Integer(5));
	System.out.println(L.toString());
	System.out.println(L.get(3));
	L.add(3,new Double(3.5));
	System.out.println(L.toString());
	L.set(3,new Double(3.1));
	System.out.println(L.toString());
	System.out.println(L.remove(3));
	System.out.println(L.toString());
    }
}
