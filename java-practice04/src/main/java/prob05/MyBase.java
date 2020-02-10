package prob05;

public class MyBase extends Base {
//	public void service(String state) {
//		if (state.equals("낮")) {
//			day();
//		} else if (state.equals("밤")) {
//			night();
//		} else {
//			afternoon();
//		}
//	}
	@Override
	public void service(String state) {
		if("오후".equals(state)) {
			//state.equals("오후") 는 null 처리 x
			afternoon();
			//return으로 반환처리하고 끝
			return;
		}
		super.service(state);
	}

	public void day() {
		System.out.println("낮에는 열심히 일하자");
	}


	public void afternoon() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}

}