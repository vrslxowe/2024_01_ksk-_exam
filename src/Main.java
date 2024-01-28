import java.util.Scanner; //이클립스 안의 라이브러리에서 스캐너를 실행시키기 위해 불러오는 기능

public class Main { //  프로그램 실행 시 가장 먼저 찾아가는 메인 클래스
	public static void main(String[] args) { // 프로그램 실행 시 메인 클래스를 찾고 다음으로 메인 메서드를 찾아서 그 안의 내용을 실행함

		Scanner sc = new Scanner(System.in); // 콘솔에 명령어와 내용을 입력받기 위한 기능

		new App(sc).run(); // 앱 클래스를 만들고 안에 메서드를 실행한다 앱 클래스에 객체를 만들고 스캐너 변수를 해당 클래스에서 실행하기 위해 인자로 넘겨준다

		sc.close(); // 메인 메서드가 종료되는 시점에 스캐너 기능이 종료된다
	}
}