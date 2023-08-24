package HW;

//과제 #02 직원 정보 관리 클래스 (4.5점)

public class Employee {
	
	int age;
	String position;
	String firstname;
	String lastname;
	String fullname;
	int salary;
	
	
	
	//나이 입력 함수
	public void setAge(int age) 
	{
		this.age=age;
	}	
	
	//직위 입력 함수 
	public void setPosition(String position) 
	{
		this.position=position;
	}
	
	//이름 입력 함수
	public void setName(String firstname,String lastname)  
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.fullname=firstname+lastname;
	}
	
	// 월급 입력 함수
	public void setSalary(int salary)  
	{
		this.salary=salary;
	}
	
	// 이름 리턴 함수 
	public String getName() 
	{
		return fullname;
	}
	
	// 월급 리턴 함수
	public int getSalary()  
	{
		return salary;
	}
	
	// 직위 리턴 함수 
	public String getPosition() 
	{
		return position;
	}
	
	// 나이 리턴 함수 
	public int getAge() 
	{
		return age;
	}
	
	// 한 명의 직원 정보 출력 함수 - 이름 , 나이 , 직위 , 월급 순
	public void printEmployeeInfo(int n) 
	{
		System.out.printf("[%d]%17s\t%3d%30s\t%4d\n",n+1,getName(),getAge(),getPosition(),getSalary());
	}
	
	// 이름, 직위 정보 출력
	public void printEmployeePositionInfo(int n) 
	{
		System.out.printf("[%d]%17s\t%3d%30s\n",n+1,getName(),getAge(),getPosition());
	}
	
	// 이름, 월급 정보 출력
	public void printEmployeeSalaryInfo(int n) 
	{
		System.out.printf("[%d]%17s\t%3d%20d\n",n+1,getName(),getAge(),getSalary());
	}
	
	
	
}