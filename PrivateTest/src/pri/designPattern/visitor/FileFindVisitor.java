package pri.designPattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {

	private String extension;
	private List<File> findFileList;
	
	public FileFindVisitor(String extension) {
		this.extension = extension;
		this.findFileList = new ArrayList<>();
	}
	
	public Iterator<File> iterator() {
		return findFileList.iterator();
	}
	
	@Override
	public void visit(File file) {
		if(file.getName().endsWith(extension)) {
			findFileList.add(file);
		}
	}

	@Override
	public void visit(Directory directory) {
		Iterator<Entry> iterator = directory.iterator();
		
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			entry.accept(this);
		}
	}

}
