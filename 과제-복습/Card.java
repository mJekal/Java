package HW;

//과제 #05 Card 클래스: 각 카드의 정보 관리: 2점

public class Card {

	String suit;
	String number;

	// 생성자 구현(suit, numString)으로 구현
	public Card(String suit, String numString) {
		// TODO Auto-generated constructor stub
		this.suit = suit;
		this.number = numString;
	}

	@Override
	// toString() overriding 구현: 모양(suit)과 번호(numString)를 아래와 같이 구성
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%s%5s)", suit, number);
	}

}