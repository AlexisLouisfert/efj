package iut.efj.tp1;

import java.util.ArrayList;

public abstract class AbstractStack {

	protected ArrayList<Object> _list = new ArrayList<Object>();

	abstract protected int getIndex();
	
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	public Object get() {
		if (isEmpty()) {
			return null;
		}
		Object o = _list.get(getIndex());
		_list.remove(o);
		return o;
	}

	public void put(Object o) {
		_list.add(o);
	}

}
