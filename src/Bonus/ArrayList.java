package Bonus;

public class ArrayList {
	private int defalutSize = 10;
	private Object[] obj;
	private int size;
	
	public ArrayList() {
		obj = new Object[defalutSize];
	}
	
	public ArrayList(int size) {
		obj = new Object[size];
	}
	
	public void add(Object o) {
		if (defalutSize == size) {
			obj[size++] = o;
		} else {
			
		}
	}
	
	public Object get(int i) {
		return obj[i];
	}
	
	public void remove(int i) {
		return obj[i];
	}
}
