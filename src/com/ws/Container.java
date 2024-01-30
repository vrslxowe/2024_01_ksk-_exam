package com.ws; //해당 패키지에 Container 클래스가 있다

import java.util.Scanner; //이클립스 안의 라이브러리에서 스캐너를 실행시키기 위해 불러오는 기능

public class Container {
	private static Scanner sc;

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() {
		return sc;
	}
}