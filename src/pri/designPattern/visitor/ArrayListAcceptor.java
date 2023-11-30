package pri.designPattern.visitor;

import java.util.ArrayList;

public class ArrayListAcceptor extends ArrayList<Object> implements Acceptor {

	private static final long serialVersionUID = 2241777762047225389L;

	@Override
	public void accept(Visitor visitor) {
		for(Object acceptor : this) {
			((Acceptor)acceptor).accept(visitor);
		}
	}

}
