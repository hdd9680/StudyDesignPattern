package pri.designPattern.builder;

public class Director {
	
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Object construct() {
		builder.makeTitle("Greeting");
		builder.makeString("아침과 낮에");
		builder.makeItem("좋은 아침입니다"
						,"안녕하세요");
		builder.makeString("밤에");
		builder.makeItem("안녕하세요"
						,"안녕히 주무세요"
						,"안녕히 계세요");
		
		return builder.getResult();
	}

}
