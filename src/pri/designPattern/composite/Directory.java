package pri.designPattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry {
	
	private String name;
	private List<Entry> entrys;
	
	public Directory(String name) {
		this.name = name;
		entrys = new ArrayList<>();
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getSize() {
		return entrys.stream().mapToInt(each->each.getSize()).sum();
	}
	
	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this.toString());
		
		Iterator<Entry> iterator = entrys.iterator();
		while(iterator.hasNext()) {
			iterator.next().printList(prefix + "/" + this.name);
		}
		
	}
	
	@Override
	public Entry add(Entry entry) throws Exception {
		entrys.add(entry);
		entry.parent = this;
		return this;
	}
	
	@Override
	public Entry add(Entry... entrys) throws Exception {
		for(Entry entry : entrys) {
			add(entry);
		}
		
		return this;
	}
}
