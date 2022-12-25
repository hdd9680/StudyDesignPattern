package pri.designPattern.singleton;

import java.util.Arrays;
import java.util.List;

public class Triple {
	
	private static List<Triple> tripleList = Arrays.asList(new Triple(), new Triple(), new Triple());
	
	private Triple() {
		
	}
	
	public static Triple getInstance(int id) throws Exception {
		
		
		if(id > 2 || id < 0) {
			throw new Exception("해당하는 번호에 Triple 인스턴스는 존재하지 않습니다.");
		}
		
		return tripleList.get(id);
		
	}
	
}
