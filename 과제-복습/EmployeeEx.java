package HW;

import java.util.Scanner;


public class EmployeeEx {
	
	public void print_asterisk(int pary[])
	{
		int i,j;
		for(i=0;i<10;i++)
		{
			System.out.printf("[%4d]: ",i*1000);
			
			for(j=0;j<pary[i];j++)
			{
				System.out.print("#");
			}
			System.out.println("");
		}
	}
	
	public void print_menu() {
		
		
		int statistics[];
		statistics=new int[10];
		
		Scanner scanner=new Scanner(System.in);
		
		Engineer engineer[];
		engineer=new Engineer[3];
		
		Staff staff[];
		staff=new Staff[3];
		
		int i;
		for(i=0;i<engineer.length;i++)
		{
			engineer[i]=new Engineer();
		}
		for(i=0;i<staff.length;i++)
		{
			staff[i]=new Staff();
		}
		
		// Enginner 및 Staff 각각 최대 3명의 직원 정보를 저장할 수 있도록 객체 배열 사
		
		staff[0].setName("John", "Smith");
		staff[0].setAge(28);
		staff[0].setPosition("Newcomer");
		staff[0].setSalary(300);
		

		staff[1].setName("Marry", "Anne");
		staff[1].setAge(45);
		staff[1].setPosition("Executive");
		staff[1].setSalary(600);
		

		staff[2].setName("Sue", "Jones");
		staff[2].setAge(38);
		staff[2].setPosition("Office manager");
		staff[2].setSalary(450);
		
		engineer[0].setName("Bob", "Lewis");
		engineer[0].setAge(28);
		engineer[0].setPosition("Junior Engineer");
		engineer[0].setSalary(350);
		engineer[0].setOverworkingDay(17);
		
		engineer[1].setName("Lisa", "Barnes");
		engineer[1].setAge(37);
		engineer[1].setPosition("Senior Engineer");
		engineer[1].setSalary(580);
		engineer[1].setOverworkingDay(20);
		
		engineer[2].setName("Michael", "Kevin");
		engineer[2].setAge(46);
		engineer[2].setPosition("SW Manager");
		engineer[2].setSalary(650);
		engineer[2].setOverworkingDay(20);
		
		int setMenu;
		
		
		while(true)
		{
			System.out.println("=========================================================");
			System.out.println("1. Display all employee's information ( Staff, Engineer )");
			System.out.println("2. Display all staff's information");
			System.out.println("3. Display all engineer's information");
			System.out.println("4. Display all employee's name,salary,annual salary");
			System.out.println("5. Display all employee's name,position");
			System.out.println("6. Display statistics of annual salary");
			System.out.println("0. Quit");
			System.out.println("==========================================================");
			System.out.print("-> ");
			setMenu=scanner.nextInt();
			
			if(setMenu==1) // 1. Display all employee's information ( Staff, Engineer )
			{
				
				System.out.println("[Staff]\n");
				System.out.println("\t     Name\tAge\t\tPosition\tSalary\tAnnual Salary");
				System.out.println("-----------------------------------------------------------------------------");
				for(i=0;i<staff.length;i++)
				{
					staff[i].printEmployee();
				}
				System.out.println("[Engineer]\n");
				System.out.println("\t    Name\tAge\t\tPosition  Overworking Day      Salary\tAnnual Salary");
				System.out.println("---------------------------------------------------------------------------------------------");
				for(i=0;i<staff.length;i++)
					
				for(i=0;i<engineer.length;i++)
				{
					engineer[i].printEmployee();
				}
				
			}
			else if(setMenu==2) // 2. Display all staff's information
			{
				System.out.println("[Staff]\n");
				System.out.println("\t     Name\tAge\t\tPosition\tSalary\tAnnual Salary");
				System.out.println("-----------------------------------------------------------------------------");
				for(i=0;i<staff.length;i++)
				{
					staff[i].printEmployee();
				}
			}
			else if(setMenu==3) // 3. Display all engineer's information
			{
				System.out.println("[Engineer]\n");
				System.out.println("\t    Name\tAge\t\tPosition  Overworking Day      Salary\tAnnual Salary");
				System.out.println("---------------------------------------------------------------------------------------------");
				for(i=0;i<staff.length;i++)
					
				for(i=0;i<engineer.length;i++)
				{
					engineer[i].printEmployee();
				}
			}
			else if(setMenu==4) // 4. Display all employee's name,salary,annual salary
			{
				System.out.println("[Staff]\n");
				System.out.println("\t     Name\tSalary\t   Year Salary");
				System.out.println("----------------------------------------------");
				for(i=0;i<staff.length;i++)
				{
					staff[i].printStaffsalary();
				}
				System.out.println("");
				System.out.println("[Engineer]\n");
				System.out.println("\t     Name\tSalary\t   Year Salary");
				System.out.println("----------------------------------------------");
				for(i=0;i<engineer.length;i++)
				{
					engineer[i].printEngineersalary();
				}
			}
			else if(setMenu==5) // 5. Display all employee's name,position
			{
				System.out.println("[Staff]\n");
				System.out.println("\t     Name\t     Position");
				System.out.println("-------------------------------------");
				for(i=0;i<staff.length;i++)
				{
					staff[i].printStaffposition();
				}
				System.out.println("");
				System.out.println("[Engineer]\n");
				System.out.println("\t     Name\t     Position");
				System.out.println("-------------------------------------");
				for(i=0;i<engineer.length;i++)
				{
					engineer[i].printEngineerposition();
				}
			}
			else if(setMenu==6) // 6. Display statistics of annual salary
			{
				for(i=0;i<staff.length;i++)
				{
					statistics[staff[i].getAnnualSalary()/1000]++;
				}
				for(i=0;i<engineer.length;i++)
				{
					statistics[engineer[i].getAnnualSalary()/1000]++;
				}
				print_asterisk(statistics);
				
			}
			else if(setMenu==0) // 0. Quit
			{
				System.out.println("Bye!");
				break;
			}
			else // 0~6사이의 수가 아니라면 오류 
			{
				System.out.println("Wrong input. Try again!");
			}
			
		}
		
	}

	public static void main(String[] args) {
		EmployeeEx nEmployeeEx=new EmployeeEx();
		nEmployeeEx.print_menu();
	}

}