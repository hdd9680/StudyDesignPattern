package pri.designPattern.visitor;

import java.util.Iterator;

public class Application {

	public static void main(String[] args) throws Exception {
		
		Entry root = new Directory("root");
		Entry bin = new Directory("bin");
		root.add(bin);
		Entry vi = new File("vi", 10000);
		Entry latex = new File("latex", 20000);
		bin.add(vi, latex);
		Entry tmp = new Directory("tmp");
		root.add(tmp);
		Entry usr = new Directory("usr");
		root.add(usr);
		Entry kim = new Directory("Kim");
		usr.add(kim);
		Entry diary = new File("diary.html", 100);
		Entry composite = new File("Composite.java", 200);
		kim.add(diary, composite);
		Entry lee = new Directory("Lee");
		usr.add(lee);
		Entry memo = new File("memo.tex", 300);
		lee.add(memo);
		Entry kang = new Directory("Kang");
		usr.add(kang);
		Entry game = new File("game.doc", 400);
		Entry junk = new File("junk.mail", 500);
		kang.add(game);
		kang.add(junk);
		
		FileFindVisitor visitor = new FileFindVisitor(".java");
		root.accept(visitor);
		
		Iterator<File> iterator = visitor.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getFullName());
		}
		
		System.out.println("root 디렉토리 사이즈 : " + root.getSize());
		
		ArrayListAcceptor arrayListAcceptor = new ArrayListAcceptor();
		arrayListAcceptor.add(root);
		arrayListAcceptor.add(new File("etc.html", 1234));
		
		arrayListAcceptor.accept(new ListVisitor());
		
	}

}
