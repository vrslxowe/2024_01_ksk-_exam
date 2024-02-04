package com.ws.wiseSaying.controller; // 해당 패키지에 WiseSayingController클래스가 있다

import java.util.ArrayList; // 이클립스 안의 라이브러리에서 어레이리스트를 사용하기 위해 불러오는 기능
import java.util.List; //이클립스 안의 라이브러리에서 어레이리스트를 사용하기 위해 불러오는 기능

import com.ws.Container; // WiseSayingController클래스에서 Container를 사용하기 위해 불러오기함
import com.ws.Rq; // WiseSayingController클래스에서 Rq를 사용하기 위해 불러오기함
import com.ws.wiseSaying.entity.WiseSaying; // WiseSayingController클래스에서 WiseSaying을 사용하기 위해 불러오기함

public class WiseSayingController { // WiseSayingController를 

	private int lastId; // 클래스 안쪽에서 사용할 수 있도록 정수만을 담을 수 있는 변수를 선언
	private List<WiseSaying> wiseSayings; 

	public WiseSayingController() {
		lastId = 0;
		wiseSayings = new ArrayList<>();
	}

	private WiseSaying findById(int id) {
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}

		return null;
	}

	public void write() { //콘솔에 등록이라고 입력했을 경우 write 메서드가 실행된다
		int id = lastId + 1; //id 변수를 를 선언하고 lastId 변수에 1을 더한 값을 id변수에 담는다
		System.out.print("명언 : "); //출력문을 실행시키고 그 옆에 콘솔에 입력할 내용을 적을 수 있다
		String content = Container.getScanner().nextLine().trim(); //콘솔에 입력할 수 있는 스캐너 기능이 실행되고 콘솔에 적은 내용이 content에 담긴다
		System.out.print("작가 : "); //출력문을 실행시키고 그 옆에 콘솔에 입력할 내용을 적을 수 있다
		String author = Container.getScanner().nextLine().trim(); //콘솔에 입력할 수 있는 스캐너 기능이 실행되고 콘솔에  내용이 author에 담긴다

		WiseSaying wiseSaying = new WiseSaying(id, content, author); //WiseSaying타입의 객체와 연결될 wiseSaying 변수고 그 객체에 세개의 인자를 받는다
		wiseSayings.add(wiseSaying); //WiseSaying타입의 wiseSayings에 wiseSaying에서 받은 값 추가

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); //id값을 받아서 출력한다
		lastId++; //등록 번호가 하나씩 올라가도록 lastId의 번호를 1증가 시킨다

	}

	public void list() {//콘솔에 목록이라고 입력했을 경우 list 메서드가 실행된다
		if (wiseSayings.size() == 0) {//wiseSayings.size가 0과 같을 때 실행된다
			System.out.println("등록 된 명언이 없어"); //위의 조건이 참일 때 출력문을 실행한다
		} else { //위의 조건이 거짓일 때 실행된다 즉 등록된 명언이 있을 때 실행된다
			System.out.println("번호  /  작가  /  명언  "); //등록된 명언이 있을 때 출력문이 출력된다
			System.out.println("=".repeat(30)); // = 기호를 30번 출력한다

			for (int i = wiseSayings.size() - 1; i >= 0; i--) { //wiseSayings.size의 사이즈와 인덱스 번호를 맞춰놓기 위해 -1한 값을 i에 넣고 인덱스 번호가 0번인것까지 봐야하기때문에 0을 포함시킨다 역순으로 목록을 봐야하기때문에 1감소 시킨다
				WiseSaying ws = wiseSayings.get(i); //i값이 0보다 작아지기 전까지 wiseSayings.get(i)의 값을 가져와서 ws에 넣는다

				System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent()); //가져온 값을 차례대로 넣어주고 출력시킨다
			}

		}

	}

	public void remove(Rq rq) { //콘솔에 삭제라고 입력했을 경우 remove 메서드가 실행되고 Rq의 인자값 rq를 받는다
		int id = rq.getIntParam("id", -1); // Rq클래스로 인자값을 넘겨주고 남겨진 값을 id 변수에 담는다

		if (id == -1) { // 담겨진 id값이 -1과 같을 때 조건문이 실행된다
			System.out.println("id(정수)를 제대로 입력해주세요"); //
			return; //밑으로 내려가지 않고 이 시점에서 종료된다
		}
		WiseSaying wiseSaying = findById(id); // 입력된 id와 일치하는 명언 객체를 찾는다

		if (wiseSaying == null) { //
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayings.remove(wiseSaying);

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);
	}

}