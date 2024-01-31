package com.ws; //해당 패키지에 Container 클래스가 있다

import java.util.Scanner; //이클립스 안의 라이브러리에서 스캐너를 실행시키기 위해 불러오는 기능

public class Container { // 공공재들을 모아놓으려고 만든 클래스
	private static Scanner sc; //static끼리 연결이 가능하고 스캐너 변수를 선언했다

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() { // init메서드가 실행되면 스캐너 기능이 실행된다
		sc = new Scanner(System.in); //  스캐너 객체가 만들어지고 sc변수에 담기게 된다
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() { // 스캐너 객체를 닫기 위한 메서드
		sc.close(); // 해제 된 스캐너 객체를 닫아준다
	}

	public static Scanner getScanner() {//  getScanner() 메서드를 호출
		return sc; // 호출 시 스캐너 객체가 리턴됨
	}
}