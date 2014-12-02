public class OrderedSuperArray extends SuperArray {

    public OrderedSuperArray() {
	this(10);
    }

    public OrderedSuperArray(int size) {
	array = new String[size];
    }

    public void add(String e) {
	for(int i=0;i<getLength();i++){
	    if(((String)array[i]).compareTo(e)>=0){
		add(i,e);
		return;
	    }
	}
	add(getLength(),e);
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

    public static void main(String[]adads){
	OrderedSuperArray L = new OrderedSuperArray();
	L.add("a");
	//L.add("b");
	L.add("c");
	L.add("d");
	L.add("e");
	L.add("f");
	System.out.println(L.toString());
	System.out.println(L.get(3));
	L.add("b");
	System.out.println(L.toString());
	System.out.println(L.remove(1));
	System.out.println(L.toString());
	L.set(2,"b");
	System.out.println(L.toString());
    }
}