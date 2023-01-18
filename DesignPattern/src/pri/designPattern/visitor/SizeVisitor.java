package pri.designPattern.visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {

	private int totalSize;
	
	@Override
	public void visit(File file) {
		totalSize += file.getSize();
	}

	@Override
	public void visit(Directory directory) {
		Iterator<Entry> iterator = directory.iterator();
		
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			entry.accept(this);
		}
	}
	
	public int getSize() {
		return this.totalSize;
	}

}
