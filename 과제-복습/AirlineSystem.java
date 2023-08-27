package HW;
//과제 #04 ReservationSystem 클래스를 상속받아서 항공사 예약 시스템 기능 구현 (3점)

import java.util.Scanner;

public class AirlineSystem extends ReservationSystem {

	int Airline[][];

	Scanner scanner;

	int airlineMenunum;

	String airlineSeat;
	int airlineSeatnum;
	int airlineSeatnum2;
	char airlineSeatstr;

	public AirlineSystem(Scanner scanner) {
		this.scanner = scanner;
	}

	public void set_airlineMenunum() {
		this.airlineMenunum = scanner.nextInt();
	}

	public void set_airlineSeat() {
		this.airlineSeat = scanner.next();
	}

	public String get_airlineString() {
		return airlineSeat;
	}

	@Override
	public void makeSeats(int row, int col) {
		// TODO Auto-generated method stub

		Airline = new int[row][col];
		this.row = row;
		this.col = col;

		super.makeSeats(row, col);
	}

	@Override
	public int reserveSeat(String seatName) {
		// TODO Auto-generated method stub

		int n = seatName.length();

		if (n == 3) {
			airlineSeatnum = seatName.charAt(n - 3) - '0';
			airlineSeatnum2 = seatName.charAt(n - 2) - '0';

			airlineSeatnum = (airlineSeatnum * 10) + airlineSeatnum2;

			airlineSeatstr = seatName.charAt(n - 1);
		} else if (n == 2) {

			airlineSeatnum = seatName.charAt(n - 2) - '0';
			airlineSeatstr = seatName.charAt(n - 1);

			if (airlineSeatnum >= 10) {
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n", seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}

		} else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
			return 0;
		}

		try {

			// seatName이 "10D"인 경우, (10: 10열, D: 0행)
			if (this.Airline[68 - airlineSeatstr][airlineSeatnum - 1] == 0) {
				// 예약된 좌석은 배열의 위치에 1(OCCUPIED)로 표시함
				this.Airline[68 - airlineSeatstr][airlineSeatnum - 1] = 1;
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
		int n=seatName.length();
		
		if(n==3)
		{
			airlineSeatnum=seatName.charAt(n-3)-'0';
			airlineSeatnum2=seatName.charAt(n-2)-'0';
			
			
			airlineSeatnum=(airlineSeatnum*10)+airlineSeatnum2;

			airlineSeatstr=seatName.charAt(n-1);
		}
		else if(n==2){
			
			airlineSeatnum=seatName.charAt(n-2)-'0';
			airlineSeatstr=seatName.charAt(n-1);
			
			if(airlineSeatnum>=10)
			{
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n",seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}
			
		
		}
		else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다."); 
			return 0;
		}
		
		try {
			
			
			if(this.Airline[68-airlineSeatstr][airlineSeatnum-1]==1)
			{
				this.Airline[68-airlineSeatstr][airlineSeatnum-1]=0;
				System.out.printf("[예약 취소 성공] %s\n",seatName); 
				this.count--;
				return 1;
			}
			else
			{
				System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n",seatName); 
  
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다."); 
		}
		return 0;
		
		
	}

	// 현재 좌석 현황을 출력
	@Override
	public void displaySeat(String systemTitle) {
		// TODO Auto-generated method stub

		int i, j;
		System.out.printf("[%s 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n\n", systemTitle, reserveNum(), totalNum());

		for (i = 0; i < this.row; i++) {
			for (j = 0; j < this.col; j++) {
				System.out.printf("[%2d%c]", j + 1, 68 - i);
			}
			System.out.println("");

			for (j = 0; j < this.col; j++) {
				if (Airline[i][j] == 1) {
					System.out.print("    X");
				} else {
					System.out.printf("%5d", this.Airline[i][j]);
				}
			}
			System.out.println("");

			if (i == 1) {
				System.out.println("--------------------------------------------------");
				System.out.println(" 앞                     통로                       뒤");
				System.out.println("--------------------------------------------------");
			}

		}
		super.displaySeat(systemTitle);
	}

}