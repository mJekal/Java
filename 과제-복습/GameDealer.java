package HW;

//과제 #05 GameDealer 클래스: 카드 생성 및 게임 진행: 8점

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GameDealer {

	String[] suit = { "♣", "♠", "◆", "♥" };
	String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	String joker = "Joker";

	// 각 Card 객체를 Collection(ArrayList, Vector, HashMap 등)에 저장하여 1벌의 카드를 생성
	LinkedList<Card> cards = new LinkedList<Card>();

	void set_card() {
		int i, j;
		for (i = 0; i < suit.length; i++) {
			for (j = 0; j < number.length; j++) {
				cards.add(new Card(suit[i], number[j]));
			}
		}
		cards.add(new Card("🃟", joker));
	}

	// shuffle 기능: 랜덤하게 카드의 순서를 섞음
	void shuffle() {
		Collections.shuffle(cards);
	}

	// deal 기능: 초기 생성된 53장의 카드를 랜덤하게 섞은 다음 컴퓨터(Computer)와 인 간(Human)에게 각 27장, 26장을
	// 나누어 줌
	LinkedList<Card> deal() {
		LinkedList<Card> dCards = new LinkedList<Card>();

		if (cards.size() > 27) {
			int i;
			for (i = 0; i < 27; i++) {
				dCards.add(cards.remove(0));
			}
		} else {
			int i;
			for (i = 0; i < 26; i++) {
				dCards.add(cards.remove(0));
			}
		}

		return dCards;
	}

	void display() {
		int i;
		for (i = 0; i < cards.size(); i++) {
			if (i % 13 == 0) {
				System.out.println();
			}
			System.out.print(cards.get(i));
		}
		System.out.println();
	}

	public void play_game() {
		int round = 2;
		String menu;
		Scanner scanner = new Scanner(System.in);

		GameDealer gameDealer = new GameDealer();
		gameDealer.set_card();

		System.out.print("<< 카드 생성 >>");
		gameDealer.display();

		Player humanPlayer = new Player("Human");
		Player computerPlayer = new Player("Computer");

		gameDealer.shuffle();

		computerPlayer.getCard(gameDealer.deal());
		humanPlayer.getCard(gameDealer.deal());

		System.out.println("\n<< 처음 딜러가 나누어 준 카드 >>");

		computerPlayer.display();
		humanPlayer.display();

		System.out.println("\n\n\n\n<< 1 단계 >>\n");
		System.out.println("일치하는 숫자를 가진 카드 공개(2 장씩 허용)");
		computerPlayer.set_openCards();
		humanPlayer.set_openCards();

		// 두 명의 선수 중 한 명의 카드수가 0이 될 때까지 게임을 진행하고, 마지막에 Joker 를 가지고 있는 선수를 찾음
		while (computerPlayer.playerCards.size() != 0 && humanPlayer.playerCards.size() != 0) {
			System.out.println("다음 단계 게임 진행을 위해 Enter 키를 누르세요!");
			menu = scanner.nextLine();

			if (menu == "" + "") {
				System.out.printf("\n\n\n\n<< %d 단계 >>\n\n", round++);
				System.out.println("상대방의 카드를 선택하세요 (Random)");
				computerPlayer.pick_otherCard(humanPlayer);

				System.out.println("일치하는 숫자를 가진 카드 공개(2 장씩 허용)");
				computerPlayer.set_openCards();
				humanPlayer.set_openCards();

				if ((computerPlayer.playerCards.size() == 1 && computerPlayer.playerCards.get(0).number == "Joker")
						|| (humanPlayer.playerCards.size() == 1 && humanPlayer.playerCards.get(0).number == "Joker")) {

					if (computerPlayer.playerCards.size() == 1) {
						System.out.println("경기 종료: Computer 가 Joker 를 가지고 있음.");
					} else {
						System.out.println("경기 종료: Human 이 Joker 를 가지고 있음.");
					}
					break;
				}

			}

		}
		scanner.close();

	}

}