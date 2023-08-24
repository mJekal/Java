package HW;

//과제 #02 직원 정보 관리 클래스 (15.5점)

import java.util.Scanner;

public class EmployeeApp extends Employee{

	public static void main(String[] args) {
		
		Employee employee[];
		employee=new Employee[5];
		
		int i;
		for(i=0;i<employee.length;i++)
		{
			employee[i]=new Employee();
		}
		
		employee[0].setAge(28);
		employee[0].setName("John"," Smith");
		employee[0].setPosition("Senior Software Engineer");
		employee[0].setSalary(300);
		
		employee[1].setAge(24);
		employee[1].setName("Kim"," Young");
		employee[1].setPosition("Junior Software Engineer");
		employee[1].setSalary(250);
		
		employee[2].setAge(37);
		employee[2].setName("Lisa"," Barnes");
		employee[2].setPosition("Team Leader");
		employee[2].setSalary(580);
		
		employee[3].setAge(46);
		employee[3].setName("Michael"," Kevin");
		employee[3].setPosition("Project manager");
		employee[3].setSalary(650);
		
		employee[4].setAge(35);
		employee[4].setName("Mary"," Anne");
		employee[4].setPosition("Senior Software Engineer");
		employee[4].setSalary(350);
		
	
		
		Scanner scanner = new Scanner(System.in);
		int MenuNum; 
		
		int num2Index;
		String num2Position;
		
		int num3Index;
		int num3Salary;
		
		while(true)
		{
			System.out.println("=================================");
			System.out.println("Employee Management System");
			System.out.println("=================================");
			System.out.println("1. Display Employee's Information");
			System.out.println("2. Change Employee's Position");
			System.out.println("3. Change Employee's Salary");
			System.out.println("0. Quit");
			System.out.println("=================================");
			System.out.print("-> ");
			MenuNum=scanner.nextInt();
			// Display Employee's Information 메뉴 
			if(MenuNum==1) 
			{
				System.out.println("\t\tName\tAge\t\t\tPosition\tSalary");
				System.out.println("-----------------------------------------------------------------------");
				for(i=0;i<employee.length;i++)
				{
					employee[i].printEmployeeInfo(i);
				}
			}
			// Change Employee's Position 메뉴 
			else if(MenuNum==2) 
			{
				for(i=0;i<employee.length;i++)
				{
					employee[i].printEmployeePositionInfo(i); 
				}
				
				while(true)
				{
					System.out.print("Input index(1~5) and new position : ");
					num2Index=scanner.nextInt();
					num2Position=scanner.nextLine();
					//변경할 index와 position을 입력 받음
					
					if(num2Index>0&&num2Index<=5)
					{	
						employee[num2Index-1].setPosition(num2Position);
						System.out.println("------------------------------------------------------");
						employee[num2Index-1].printEmployeePositionInfo(num2Index-1); 
						System.out.println("------------------------------------------------------");
						System.out.println("");
						
						break;
					
					}
					else
					{
						System.out.println("Wrong index. Type again");  
					}
				}
			}
			// Change Employee's Salary 메뉴
			else if(MenuNum==3)  
			{
				for(i=0;i<employee.length;i++)
				{
					employee[i].printEmployeeSalaryInfo(i);
				}
				
				System.out.print("Input index(1~5) and new Salary : ");
				num3Index=scanner.nextInt();
				num3Salary=scanner.nextInt();
				// 변경할 index와 salary를 입력 받음
				
				while(true)
				{
					
					if(num3Index>0&&num3Index<=5)
					{	
						employee[num3Index-1].setSalary(num3Salary);
						System.out.println("------------------------------------------------------");
						employee[num3Index-1].printEmployeeSalaryInfo(num3Index-1);  
						System.out.println("------------------------------------------------------");
						System.out.println("");
						
						break;
					
					}
					else
					{
						System.out.println("Wrong index. Type again"); 
					}
				}
			}
			// Quit 메뉴
			else if(MenuNum==0) 
			{
				System.out.println("Bye!");
				break;
			}
			else
			{
				System.out.println("Wrong input. Try again\n"); 
				
			}
		}
	}

}