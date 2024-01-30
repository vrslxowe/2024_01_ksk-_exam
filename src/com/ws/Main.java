package com.ws; //해당 패키지에 Main 클래스가 있다

public class Main { //  프로그램 실행 시 가장 먼저 찾아가는 메인 클래스
	public static void main(String[] args) { // 프로그램 실행 시 메인 클래스를 찾고 다음으로 메인 메서드를 찾아서 그 안의 내용을 실행함
		
		Container.init();
		
		new App().run(); // 앱 클래스를 만들고 그 안에 있는 메서드를 실행한다

		Container.close();
	}
}