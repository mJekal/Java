package HW;
//과제 #04 인터페이스 기능 구현 내용 (18점)

public interface ReservationInterface {
	/**
	 * 좌석 행과 열의 수를 입력받아서 전체 좌석 배열을 생성
	 * 
	 * @param row 좌석 행의 수
	 * @param col 좌석 열의 수
	 */
	public abstract void makeSeats(int row, int col);

	/**
	 * 좌석 예약 메소드
	 * 
	 * @param seatName 좌석 이름: 1A, 1B 형태의 문자열
	 * @return 0: 예약 성공 -1: 예약 실패 (이미 예약된 좌석)
	 */
	public abstract int reserveSeat(String seatName);

	/**
	 * 예약 취소 메소드
	 * 
	 * @param seatName 좌석 이름: 1A, 1B 형태의 문자열
	 * @return 0: 예약 취소 성공 -1: 예약 실패 (예약이 되지 않은 좌석 )
	 * 
	 */
	public abstract int cancelSeat(String seatName);

	/**
	 * 예약 현황 화면 출력 메소드
	 */
	public abstract void displaySeat(String systemTitle);
}