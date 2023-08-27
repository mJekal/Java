package HW;

//과제 #04 메인 메뉴를 화면에 출력하고, 사용자 입력 처리(오류 처리 기능 추가 (3점)

import java.util.Scanner;

public class ReservationApp {

	public void print_menu() {
		Scanner scanner = new Scanner(System.in);
		int menuNum;
		// 화면 입력을 위해 생성한 Scanner 객체는 AirlineSystem 클래스와 BusSystem 클래스의 생성자의 파라미터로 전달하여
		// 하나의 Scanner 객체를 공유함

		AirlineSystem airlineSystem = new AirlineSystem(scanner);
		airlineSystem.makeSeats(4, 10);

		// “0번 통합 예약 시스템 종료” 메뉴를 선택하기 전까지는 기존 예약된 현황 유지하고 있어야 됨
		BusSystem busSystem = new BusSystem(scanner);
		busSystem.makeSeats(3, 10);

		while (true) {
			System.out.println("------------------------------------");
			System.out.println("K-Startup의 통합 예약 시스템을 방문해 주셔서 감사합니다.");
			System.out.println("  1. 항공사 예약 시스템");
			System.out.println("  2. 버스 예약 시스템");
			System.out.println("  0. 통합 예약 시스템 종료");
			System.out.println("------------------------------------");
			// 메인 메뉴를 화면에 출력하고, 사용자 입력 처리(오류 처리 기능 추가)
			try {
				System.out.print("메뉴를 선택해주세요: ");
				menuNum = scanner.nextInt();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
				scanner.nextLine();
				continue;
			}

			if (menuNum == 1) {

				while (true) {
					System.out.println("--------------------");
					System.out.println("항공기 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("--------------------");

					try {
						System.out.print("번호를 선택해주세요: ");
						airlineSystem.set_airlineMenunum();

					} catch (Exception e) {
						// TODO: handle exception

						System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
						scanner.nextLine();
						continue;
					}

					if (airlineSystem.airlineMenunum == 1) {
						System.out.print("예약할 좌석 이를을 입력하세요: ");
						airlineSystem.set_airlineSeat();
						if (airlineSystem.reserveSeat(airlineSystem.airlineSeat) == 1) {
							airlineSystem.displaySeat("항공기 예약 시스템");
						}
					} else if (airlineSystem.airlineMenunum == 2) {
						System.out.print("취소할 좌석 이를을 입력하세요: ");
						airlineSystem.set_airlineSeat();
						if (airlineSystem.cancelSeat(airlineSystem.airlineSeat) == 1) {
							airlineSystem.displaySeat("항공기 예약 시스템");
						}
					} else if (airlineSystem.airlineMenunum == 3) {
						airlineSystem.displaySeat("항공기 예약 시스템");
					} else if (airlineSystem.airlineMenunum == 4) {
						System.out.println("항공기 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
						break;
					} else {
						System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
					}
				}
			} else if (menuNum == 2) {

				while (true) {
					System.out.println("--------------------");
					System.out.println("버스 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("--------------------");

					try {
						System.out.print("번호를 선택해주세요: ");
						busSystem.set_busMenunum();

					} catch (Exception e) {
						// TODO: handle exception

						System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
						scanner.nextLine();
						continue;
					}

					if (busSystem.busMenunum == 1) {
						System.out.print("예약할 좌석 이름을 입력하세요: ");
						busSystem.set_busSeat();
						if (busSystem.reserveSeat(busSystem.busSeat) == 1) {
							busSystem.displaySeat("버스 예약 시스템");
						}
					} else if (busSystem.busMenunum == 2) {
						System.out.print("취소할 좌석 이름을 입력하세요: ");
						busSystem.set_busSeat();

						if (busSystem.cancelSeat(busSystem.busSeat) == 1) {
							busSystem.displaySeat("버스 예약 시스템");
						}
					} else if (busSystem.busMenunum == 3) {
						busSystem.displaySeat("버스 예약 시스템");
					} else if (busSystem.busMenunum == 4) {
						System.out.println("버스 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
						break;
					} else {
						System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
					}
				}

			} else if (menuNum == 0) {
				System.out.println("K-Startup 통합 예약 시스템을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservationApp reservationApp = new ReservationApp();
		reservationApp.print_menu();
	}

}