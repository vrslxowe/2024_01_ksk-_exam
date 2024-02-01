package com.ws; //해당 패키지에 App 클래스가 있다

import com.ws.system.controller.SystemController; // App클래스에서 SystemController를 사용하기 위해 불러오기함
import com.ws.wiseSaying.controller.WiseSayingController; // App클래스에서 WiseSayingController를 사용하기 위해 불러오기함

public class App { // 프로그램 실행 시 메인 메서드 안에서 App클래스의 기능이 실행이 된다
	
	private byte system_status = 1; //제어문에서 종료를 만났을 때 빠져나와서 다시 반복문으로 올라가지 않게 변수 선언을 해놓는다

	public App() { 

	}

	public void run() { // 메인 메서드에서 실행되는 런 메서드로 기능 실행이 된다
		System.out.println("== 명언 앱 실행 =="); // 런메서드가 실행되면 먼저 출력문의 내용이 출력된다

		SystemController systemController = new SystemController(); // SystemController타입의 객체를 만들고 객체 안의 기능을 담고 실행하기위해 만듦
		WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController타입의 객체를 만들고 객체 안의 기능을 담고 실행하기위해 만듦

		while (system_status == 1) { // system_status과 1과 같을 때 반복문이 실행된다
			System.out.print("명령어 ) "); // 조건이 참일 때 가장 먼저 실행되는 출력문
			String cmd = Container.getScanner().nextLine().trim(); // 콘솔에 입력하기 위해서 컨테이너 클래스 안에 있는 스캐너를 불러오고 한줄 사용과 공백 제거 기능을 cmd변수에 담았다
			Rq rq = new Rq(cmd); //rq 객체를 만들고 cmd를 인자로 받는다 그 값을 rq 변수에 담는다

			switch (rq.getActionCode()) { //스위치 제어문을 사용해서 getActionCode이 실행되고 콘솔에 입력한 값이 남게 된다 그 값을 밑의 케이스들과 맞는 것이 있는지 확인한다
			case "종료": //종료라고 적혀있는 경우
				systemController.exit(); //시스템컨트롤러의 엑시트 메서드를 실행하게 된다
				system_status = 0; //앱 클래스에서 선언한 변수의 값과 반복문의 값이 같지 않기때문에 두번째 반복문은 실행되지 않고 바로 종료된다 
				break; //종료가 실행되고 마지막에 제어문을 빠져나온다
			case "등록": //등록이라고 적혀있는 경우
				wiseSayingController.write(); //시스템컨트롤러의 write메서드를 실행한다
				break; // 등록이 실행되고 마지막에 제어문을 빠져나온다
			case "목록": //목록이라고 적혀있는 경우
				wiseSayingController.list(); //시스템컨트롤러의 list메서드를 실행한다
				break; // 목록이 실행되고 마지막에 제어문을 빠져나온다
			case "삭제": //삭제라고 적혀있는 경우
				wiseSayingController.remove(rq); //위에 선언 된 rq를 이용해서 rq를 넘겨주고 삭제를 하기 위한 기능이 실행된다
				break; // 삭제가 실행되고 마지막에 제어문을 빠져나온다
			case "수정": //수정이라고 적혀있는 경우
				wiseSayingController.modify(rq); //위에 선언 된 rq를 이용해서 rq를 넘겨주고 수정을 하기 위한 기능이 실행된다
				break; // 수정이 실행되고 마지막에 제어문을 빠져나온다
			default: //일치하는 case가 없을 때 실행된다
				System.out.println("존재하지 않는 명령어입니다"); // 일치하지 않는 경우에 출력문이 출력된다
				break; // 출력되고 제어문을 빠져나와서 위의 반복문으로 올라간다 
			}
		}

	}
}