public class OrderedSuperArray extends SuperArray {

    public OrderedSuperArray() {
	this(10);
    }

    public OrderedSuperArray(int size) {
	array = new String[size];
    }

    public void add(Object e) {
	add(e.toString());
    }

    public void add(String e) {
	for(int i=0;i<getLength();i++){
	    if(((String)array[i]).compareTo(e)>=0){
		super.add(i,e);
		return;
	    }
	}
	super.add(getLength(),e);
    }

    public void add(int index, String o){
	add(o);
    }

    public String set(int index, String o){
	if(index<0 || index>= getLength()) {
	    System.out.println("out of range m9");
	    return null;
	}
	remove(index);
	add(o);
	return o;
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }

    public static void main(String[]adads){
	OrderedSuperArray L = new OrderedSuperArray();

	//badinsertionsort
	for(int i=0;i<10000;i++){
	    L.add(i);
	}
	long start = System.nanoTime();
	L.badInsertionSort();
	long end = System.nanoTime();
	System.out.println((end-start)/1000000000.);

	//insertionsort
	L = new OrderedSuperArray();
	for(int i=0;i<10000;i++){
	    L.add(Integer.toString(i));
	}
	start = System.nanoTime();
	L.insertionSort();
	end = System.nanoTime();
	System.out.println(L.toString());
	System.out.println((end-start)/1000000000.);

	//selectionsort
	L = new OrderedSuperArray();
	for(int i=0;i<10000;i++){
	    L.add(Integer.toString(i));
	}
        start = System.nanoTime();
	L.selectionSort();
	end = System.nanoTime();
	System.out.println((end-start)/1000000000.);
    }
}
