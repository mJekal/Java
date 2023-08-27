package HW;
//과제 #04 ReservationInterface의 각 기능을 구현 또는 dummy function 추가 (3점)

public class ReservationSystem implements ReservationInterface {

	int row, col;
	int count = 0;

	@Override
	public void makeSeats(int row, int col) {
		// TODO Auto-generated method stub

	}

	@Override
	public int reserveSeat(String seatName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancelSeat(String seatName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displaySeat(String systemTitle) {
		// TODO Auto-generated method stub

	}

	public int totalNum() {
		return this.row * this.col;
	}

	public int reserveNum() {
		return this.count;
	}

}
