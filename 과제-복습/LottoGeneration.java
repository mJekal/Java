package HW;

import java.util.*;

// 과제 #01 - 2 로또 번호 생성 및 빈도수 계산 프로그램 (14점)

public class LottoGeneration {
	Scanner in = new Scanner(System.in);

	int[] lotto = new int[6];
	int[] count = new int[46];

	int trylottonum = 0;
	
	// 로또번호 저장할 배열 생성 및 저장
    public void random() {
        for (int i = 0; i < lotto.length; i++) {
            int r = (int) (Math.random() * 45 + 1);
            lotto[i] = r;
        }
    }
    
   // 배열에 중복되는 값이 있는지 검사 기능을 함수로 구현
    public void duplication() {
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    random();
                    duplication(); 
                }
            }
        }
    }
    
    // 실행 횟수 입력시 양의 정수값만 입력 받도록 에러 체크 기능 구현
    public void trylotto() {    	
    	System.out.print("Lotto 수행 회수를 입력하세요(1~5): ");
    	
    	trylottonum = in.nextInt();
    	if (trylottonum > 5 || trylottonum < 1) {
    		System.out.println("1에서 5사이의 숫자를 다시 입력하세요.");
    		System.out.println(" ");
    		trylotto();
    }
  }
    
    // 입력된 실행 횟수에 맞게 일차원 배열에 로또 번호 저장 및 반복 기능
    public void lottogenerate() {
    	for (int i=1; i < trylottonum+1; i++) {
    		random();
    		duplication();
    		System.out.print("Lotto" + "[" + i + "]:");
    		for (int k=0; k < lotto.length; k++) {
    		System.out.print(lotto[k] + " ");
    		count[lotto[k]] += 1;
    	}
    		System.out.println(" ");
    	}
    }
    //생성된 로또 번호의 빈도수가 0보다 큰 경우, 숫자의 개수를 "*"로 화면에 출력함
    public void lottoprint() {
    	System.out.println("Lotto 번호별 빈도수");
    	for(int i = 0; i < 46; i++ ) {
    		if (count[i] != 0) {
        		System.out.println(i+":"+ "*".repeat(count[i]));
        	}
    	}
    }

    public static void main(String[] args) {
    	LottoGeneration LottoGeneration = new LottoGeneration();
    	LottoGeneration.trylotto();
    	LottoGeneration.lottogenerate();
    	LottoGeneration.lottoprint();
    }
}
