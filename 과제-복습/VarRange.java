package HW;

// 과제 #01 - 1 변수 범위

public class VarRange {
	public static void main(String[] args) {
			
			int year=365*24*3600;
			int day=24*3600;
			int hour=3600;

			short totalCount1=Short.MAX_VALUE;
			
			short syear=  (short) (totalCount1/(year));
			short sday= (short) ((totalCount1%year)/(day));
			short shour= (short) ((totalCount1%day)/hour);
			
			System.out.println("short max :"+totalCount1);
			System.out.println("short 변수 사용 :"+syear+"년 "+sday+"일 "+shour+"시 ");
			
			int totalCount2=Integer.MAX_VALUE;

			int iyear=totalCount2/year;
		    int iday=(totalCount2%year)/day;
			int ihour=(totalCount2%day)/hour;
			
			System.out.println("int max :"+totalCount2);
			System.out.println("int 변수 사용 :"+iyear+"년 "+iday+"일 "+ihour+"시 ");
			
			long totalCount3=Long.MAX_VALUE;
			
			long lyear=totalCount3/year;
		    long lday=(totalCount3%year)/day;
			long lhour=(totalCount3%day)/hour;
			
			System.out.println("long max :"+totalCount3);
			System.out.println("long 변수 사용 :"+lyear+"년 "+lday+"일 "+lhour+"시 ");
		}

	}
			
		

