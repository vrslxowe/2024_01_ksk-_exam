import java.util.ArrayList; // 이클립스 안의 라이브러리에서 어레이리스트를 사용하기 위해 불러오는 기능
import java.util.List; //이클립스 안의 라이브러리에서 어레이리스트를 사용하기 위해 불러오는 기능
import java.util.Scanner; //이클립스 안의 라이브러리에서 스캐너를 실행시키기 위해 불러오는 기능

public class App { // 프로그램 실행 시 메인 메서드 안에서 기능 실행이 된다
	private Scanner sc;

	public App(Scanner sc) { // 스캐너 타입을 받을 수 있는 생성자가 있어야 실행이 된다
		this.sc = sc; //객체 안 리모콘
	}

	public void run() { // 메인 메서드에서 실행되는 런 메서드로 기능 실행이 된다
		System.out.println("== 명언 앱 실행 =="); // 런메서드가 실행되자마자 출력문의 내용이 출력된다

		int lastId = 0; // 정수 타입의 lastId 변수를 만들고 0을 담는다 0을 담는 이유는 34째 줄의 문구가 0번이 아닌 1번으로 보여져야하기 때문이다
		List<WiseSaying> wiseSayings = new ArrayList<>();//WiseSaying 객체 안에 id, content, author가 있고 그 객체 내용들을 나중에 꺼내기 위해 저장하는 역할

		while (true) { // 반복문의 조건이 트루이므로 안의 내용이 계속 반복된다
			System.out.print("명령어)"); //반복문이 실행되면 가장 먼저 출력문이 출력되고 출력문 바로 옆에 내용을 입력할 수 있다
			String cmd = sc.nextLine().trim(); //콘솔에 내용을 입력할 수 있는 스캐너 기능이 실행되고 입력 기준 좌우 공백이 있으면 제거 후 그 내용이 cmd변수에 담긴다

			if (cmd.equals("종료")) { //콘솔에 입력한 명령어가 종료와 같다면?
				break; //반복문을 빠져나가서 종료가 된다
			} else if (cmd.equals("등록")) { //콘솔에 입력한 명령어가 입력과 같다면?
				int id = lastId + 1; // id 변수를 를 선언하고 lastId 변수에 1을 더한 값을 id변수에 담는다
				System.out.print("명언 : "); //출력문을 실행시키고 그 옆에 콘솔에 입력할 내용을 적을 수 있다
				String content = sc.nextLine().trim(); //콘솔에 입력할 수 있는 스캐너 기능이 실행되고 콘솔에 적은 내용이 content에 담긴다
				System.out.print("작가 : "); //출력문을 실행시키고 그 옆에 콘솔에 입력할 내용을 적을 수 있다
				String author = sc.nextLine().trim(); //콘솔에 입력할 수 있는 스캐너 기능이 실행되고 콘솔에  내용이 author에 담긴다

				WiseSaying wiseSaying = new WiseSaying(id, content, author); //WiseSaying타입의 객체와 연결될 wiseSaying 변수고 그 객체에 세개의 인자를 받겠다
				wiseSayings.add(wiseSaying); //어레이리스트에 추가

				System.out.printf("%d번 명언이 등록되었습니다.\n", id); //정수 타입의 id 변수안의 정수를 입력받고 출력한다
				lastId++; //반복문 밖에 있는 변수 값을 1증가 시킨다 반복문 안에 있으면 계속 초기에 넣는 값으로 초기화되지만 밖에 있으므로 초기화되지 않고 1증가가 된다
			} else if (cmd.equals("목록")) { //콘솔에 입력한 명령어가 목록과 같다면?
				if (wiseSayings.size() == 0) { //만약 어레이리스트의 사이즈가 0과 같다면? 등록된 적이 한번도 없다면
					System.out.println("등록된 명언 없어"); //위의 조건이 맞다면 출력문을 출력한다
				} else { // 조건문이 거짓일 때 출력문을 출력한다
					System.out.println("등록된 명언 수 : " + wiseSayings.size()); //출력문과 등록된 만큼의 어레이리스트 사이즈를 같이 출력하게 된다
				}
			} else { //조건문의 조건이 거짓일 때 실행된다 
				System.out.println("존재하지 않는 명령어입니다"); //조건문의 조건이 거짓일 때 출력문이 출력된다
			}
		}
	}
}