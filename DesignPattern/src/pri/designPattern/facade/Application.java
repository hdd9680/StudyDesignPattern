package pri.designPattern.facade;

import pri.designPattern.facade.pageMaker.PageMaker;

public class Application {

	public static void main(String[] args) {
		PageMaker.makeLinkPage("linkPage.html");
	}

}
