package HW;

public class Staff  extends Employee{
	
	private int annualSalary;
	//연봉 계산 함수 (월급 X 12)
	public int getAnnualSalary() { 
		annualSalary=getSalary()*12;
		return annualSalary;
	}
	 //Staff 멤버 출력 함수
	public void printEmployee() { 
		System.out.printf("%17s\t%3d%21s\t%6d\t\t %d\n",getName(),getAge(),getPosition(),getSalary(),getAnnualSalary());
	}
	
	
	
	public void printStaffsalary() {
		System.out.printf("%17s        %5d      \t %5d\n",getName(),getSalary(),getAnnualSalary());
	}
	
	public void printStaffposition() {
		System.out.printf("%17s   %17s\n",getName(),getPosition());
	}
}
