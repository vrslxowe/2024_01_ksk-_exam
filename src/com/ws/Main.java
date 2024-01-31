package com.ws; //해당 패키지에 Main 클래스가 있다

public class Main { //  프로그램 실행 시 가장 먼저 찾아가는 메인 클래스
	public static void main(String[] args) { // 프로그램 실행 시 메인 클래스를 찾고 다음으로 메인 메서드를 찾아서 그 안의 내용을 실행함
		
		Container.init();//컨테이너 클래스 안에 init 메서드의 기능을 실행한다 스캐너가 실행된다
		
		new App().run(); // 앱 클래스를 만들고 그 안에 있는 메서드를 실행한다

		Container.close(); //실행했던 클래스의 기능 실행이 끝나고 닫아준다
	}
}