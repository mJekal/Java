package HW;

//과제 #04 ReservationSystem 클래스를 상속받아서 버스 예약 시스템 기능 구현 (3점)

import java.util.Scanner;

public class BusSystem extends ReservationSystem {

	int Bus[][];
	int busMenunum;

	Scanner scanner;

	String busSeat;
	int busSeatnum;
	int busSeatnum2;
	char busSeatstr;

	public BusSystem(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner = scanner;
	}

	public void set_busMenunum()

	{
		this.busMenunum = scanner.nextInt();
	}

	public void set_busSeat() {
		this.busSeat = scanner.next();
	}

	public String get_busSeat() {
		return this.busSeat;
	}

	@Override
	public void makeSeats(int row, int col) {
		// TODO Auto-generated method stub

		this.Bus = new int[row][col];
		this.row = row;
		this.col = col;

		super.makeSeats(row, col);
	}

	@Override
	public int reserveSeat(String seatName) {
		// TODO Auto-generated method stub

		int n = seatName.length();

		if (n == 3) {
			busSeatnum = seatName.charAt(n - 3) - '0';
			busSeatnum2 = seatName.charAt(n - 2) - '0';

			busSeatnum = (busSeatnum * 10) + busSeatnum2;

			busSeatstr = seatName.charAt(n - 1);
		} else if (n == 2) {

			busSeatnum = seatName.charAt(n - 2) - '0';
			busSeatstr = seatName.charAt(n - 1);

			if (busSeatnum >= 10) {
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n", seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}

		} else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
			return 0;
		}

		try {

			if (this.Bus[67 - busSeatstr][busSeatnum - 1] == 0) {
				this.Bus[67 - busSeatstr][busSeatnum - 1] = 1;
				System.out.printf("[예약 성공] %s\n", seatName);
				this.count++;
				return 1;
			} else {
				System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n", seatName);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n", seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
		}
		return 0;

	}

	@Override
	public int cancelSeat(String seatName) {
		// TODO Auto-generated method stub

		int n = seatName.length();

		if (n == 3) {
			busSeatnum = seatName.charAt(n - 3) - '0';
			busSeatnum2 = seatName.charAt(n - 2) - '0';

			busSeatnum = (busSeatnum * 10) + busSeatnum2;

			busSeatstr = seatName.charAt(n - 1);
		} else if (n == 2) {

			busSeatnum = seatName.charAt(n - 2) - '0';
			busSeatstr = seatName.charAt(n - 1);

			if (busSeatnum >= 10) {
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n", seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}

		} else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
			return 0;
		}

		try {

			if (this.Bus[67 - busSeatstr][busSeatnum - 1] == 1) {
				this.Bus[67 - busSeatstr][busSeatnum - 1] = 0;
				System.out.printf("[예약 취소 성공] %s\n", seatName);
				this.count--;
				return 1;
			} else {
				System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n", seatName);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n", seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
		}
		return 0;
	}

	@Override
	public void displaySeat(String systemTitle) {
		// TODO Auto-generated method stub

		int i, j;
		System.out.printf("[%s 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n\n", systemTitle, reserveNum(), totalNum());

		for (i = 0; i < this.row; i++) {
			for (j = 0; j < this.col; j++) {
				System.out.printf("[%2d%c]", j + 1, 67 - i);
			}
			System.out.println("");
			for (j = 0; j < this.col; j++) {
				if (Bus[i][j] == 1) {
					System.out.print("    X");
				} else {
					System.out.printf("%5d", this.Bus[i][j]);
				}
			}
			System.out.println("");

			if (i == 0) {
				System.out.println("--------------------------------------------------");
				System.out.println(" 앞                     통로                       뒤");
				System.out.println("--------------------------------------------------");
			}

		}
		super.displaySeat(systemTitle);
	}

}