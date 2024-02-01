package com.ws; // 해당 패키지에 Rq클래스가 있다

import java.util.HashMap; //이클립스 안의 라이브러리에서 해쉬맵을 사용하기 위해 불러오는 기능
import java.util.Map; //이클립스 안의 라이브러리에서 해쉬맵을 사용하기 위해 불러오는 기능

// Rq == Request(요청)
public class Rq { // Rq클래스는 명령어를 파싱하기 위해 만든 클래스이다
	private String actionCode; //해당 클래스에서 사용할 수 있는 actionCode 변수를 선언한다
	private Map<String, String> params; //해당 클래스에서 사용할 수 있는 맵 객체를 만들고 params 변수를 선언한다

	public Rq(String cmd) {// Rq의 cmd를 받으면 실행 시 파싱 기능이 실행된다 
		String[] cmdBits = cmd.split("\\?", 2);//cmd변수에 들어있는 데이터를 물음표 기준으로 쪼갠 값이 cmdBits 배열에 담겨있다

		actionCode = cmdBits[0]; //cmd에서 쪼개진 첫 문자를 액션코드 변수에 담는다

		params = new HashMap<>(); //HashMap객체를 생성하고 params 변수에 넣는다

		if (cmdBits.length == 1) { //cmdBits의 길이가 1과 같으면 안쪽을 실행한다
			return; //리턴이기 때문에 조건문이 종료된다
		}

		String[] paramBits = cmdBits[1].split("&"); //쪼갠 1번 배열을 & 기준으로 또 쪼개서 paramBits에 담는다

		for (String paramStr : paramBits) { //paramBits를 순회하면서 paramStr에 담는다
			String[] paramStrBits = paramStr.split("=", 2); // 담겨있는 변수 paramStr를 = 기준으로 쪼개서 paramStrBits배열에 담는다

			if (paramStrBits.length == 1) { // 조건문을 넣어서 paramStrBits의 길이가 1과 같은지 확인하고 같으면 안쪽을 실행한다
				continue; //컨티뉴이므로 조건이 참일 때 가장 가까운 반복문으로 올라간다
			}

			String key = paramStrBits[0]; //쪼개진 paramStrBits의 첫번째 문자열을 키값에 넣어준다
			String value = paramStrBits[1]; //쪼개진 paramStrBits의 두번째 문자열을 밸류값에 넣어준다
			params.put(key, value); //params맵 객체에 담는 기능
		}

	}

	public String getActionCode() { // 메서드를 호출하면 안쪽이 실행된다
		return actionCode; // 액션코드에 담겨있는 값을 반환한다
	}

	public String getParam(String name) { // 매개변수로 키 값 name 문자열을 받아와서 안쪽을 실행한다
		return params.get(name); //받아온 문자열을 데이터를 리턴한다
	}

	public int getIntParam(String name, int defaultValue) { //
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}