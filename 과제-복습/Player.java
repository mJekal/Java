package HW;

//과제 #05 Player 클래스: 10점

import java.util.LinkedList;

public class Player {
	// 처음 딜러로 부터 받은 카드 목록을 사용하는 Collection 객체에 저장함
	LinkedList<Card> playerCards = new LinkedList<Card>();
	LinkedList<Card> openCards = new LinkedList<Card>();
	String nameString;

	public Player(String name) {
		// TODO Auto-generated constructor stub

		this.nameString = name;
	}

	void getCard(LinkedList<Card> card) {
		playerCards = card;
	}

	void display_openCard() {
		int i;
		System.out.print("공개한 카드 : " + openCards.size() + "장");

		for (i = 0; i < openCards.size(); i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(openCards.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	void display_currentCard() {
		int i;
		System.out.print("가지고 있는 카드 :" + playerCards.size() + "장");
		for (i = 0; i < playerCards.size(); i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("[%2d]" + playerCards.get(i), i);
		}
		System.out.println();
	}

	// 두개의카드목록(숨긴카드목록,공개한카드목록)출력함수구현
	void display() {

		if (playerCards.size() > 26) {
			System.out.printf("[%s]\n", this.nameString);
			display_openCard();
			display_currentCard();
		} else {
			System.out.printf("[%s]\n", this.nameString);
			display_openCard();
			display_currentCard();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------");
	}

	void set_openCards() {
		int i, j;

		for (i = 0; i < playerCards.size() - 1; i++) {
			for (j = i + 1; j < playerCards.size(); j++) {
				if (playerCards.get(i).number == playerCards.get(j).number) {
					openCards.add(playerCards.remove(i));
					openCards.add(playerCards.remove(j - 1));
					i--;
					j--;
					break;

				}
			}

		}

		display();

	}

	// 각 단계가 진행될 때마다, 상대방이 가지고 있는 카드를 1장 선택(랜덤 선택)해 서 자신의 카드에 추가하고 추가된 카드와 같은 번호나 같은
	// 이름이 있으면 가 지고 있는 목록에서 삭제하고 공개 카드 목록으로 이동 시킴
	void pick_otherCard(Object obj) {
		Player player = (Player) obj;

		Card tempA, tempB;
		int indexA, indexB;

		indexA = (int) (Math.random() * player.playerCards.size());
		tempA = player.playerCards.get(indexA);
		// 자신이 선택한 상대방 카드를 자신의 카드 목록에 추가
		this.playerCards.add(tempA);
		// 상대방이 선택한 카드 인덱스를 자신의 목록에서 삭제
		player.playerCards.remove(indexA);

		if (player.playerCards.size() == 1 && player.playerCards.get(0).number == "Joker") {
			System.out.println("==========================");
			System.out.printf("%s 선택 :[%2d](%s%5s)\n", this.nameString, indexA, tempA.suit, tempA.number);
			System.out.println("==========================");
			this.display();
			player.display();
			return;
		}

		indexB = (int) (Math.random() * this.playerCards.size());
		tempB = this.playerCards.get(indexB);
		player.playerCards.add(tempB);
		this.playerCards.remove(indexB);

		if (player.playerCards.size() == 1 && player.playerCards.get(0).number == "Joker") {
			System.out.println("==========================");
			System.out.printf("%s    선택 :[%2d](%s%5s)\n", player.nameString, indexB, tempB.suit, tempB.number);
			System.out.println("==========================");

			this.display();
			player.display();
			return;
		}

		System.out.println("==========================");
		System.out.printf("%s 선택 :[%2d](%s%5s)\n", this.nameString, indexA, tempA.suit, tempA.number);
		System.out.printf("%s    선택 :[%2d](%s%5s)\n", player.nameString, indexB, tempB.suit, tempB.number);
		System.out.println("==========================");

		this.display();
		player.display();

	}

}