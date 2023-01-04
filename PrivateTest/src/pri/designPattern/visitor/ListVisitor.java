package pri.designPattern.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {

	private String currentDir = "";
	
	@Override
	public void visit(File file) {
		System.out.println(currentDir + "/" + file.toString());
	}

	@Override
	public void visit(Directory directory) {
		System.out.println(currentDir + "/" + directory.toString());
		String saveDir = currentDir;
		currentDir = currentDir + "/" + directory.getName();
		Iterator<Entry> iterator = directory.iterator();
		
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			entry.accept(this);
		}
		currentDir = saveDir;
	}

}
