package com.ws.wiseSaying.entity; // 해당 패키지에 WiseSaying클래스가 있다

public class WiseSaying { //객체화 시켜서 조립하기 위해 만들어진 클래스
	private int id; // 해당 클래스 내에서 사용할 수 있는 id변수 선언 
	private String content; // 해당 클래스 내에서 사용할 수 있는 content변수 선언
	private String author; // 해당 클래스 내에서 사용할 수 있는 author변수 선언

	public WiseSaying(int id, String content, String author) { //WiseSaying객체 안에 인자값들을 받고 꺼내서 쓸 수 있게하는 역할
		this.id = id; // 콘솔에 적은 내용이 WiseSaying객체 안 id에 담겨있고 그 내용을 꺼낼 수 있다
		this.content = content; // 콘솔에 적은 내용이 WiseSaying객체 안 content에 담겨있고 그 내용을 꺼낼 수 있다
		this.author = author; // 콘솔에 적은 내용이 WiseSaying객체 안 author에 담겨있고 그 내용을 꺼낼 수 있다
	}

	public int getId() { //id에 저장된 값을 해당 클래스 외부에서 사용할 수 있다
		return id; // 메서드가 실행되면 id값을 반환한다
	}

	public void setId(int id) { //해당 클래스 외부에서 받은 인자를 int id로 전달받고 id에 저장한다
		this.id = id; //매개변수에 인자값을 받아서 WiseSaying객체 안 id에 저장된다
	}

	public String getContent() { //content에 저장된 값을 해당 클래스 외부에서 사용할 수 있다
		return content; // 메서드가 실행되면 content값을 반환한다
	}

	public void setContent(String content) { //해당 클래스 외부에서 받은 인자를 String content로 전달받고 content에 저장한다
		this.content = content; //매개변수에 인자값을 받아서 WiseSaying객체 안 content에 저장된다
	}

	public String getAuthor() { //author에 저장된 값을 해당 클래스 외부에서 사용할 수 있다
		return author; // 메서드가 실행되면 author값을 반환한다
	}

	public void setAuthor(String author) { //해당 클래스 외부에서 받은 인자를 String author로 전달받고 author에 저장한다
		this.author = author; //매개변수에 인자값을 받아서 WiseSaying객체 안 author에 저장된다
	}

}