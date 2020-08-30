/********************************************************************************************************************** 
*@Author:-> priyanka
*@purpose:->Calculated Employee Wage for Multiple company 
*@Date:-> 29/8/2020
***********************************************************************************************************************/
import java.util.*;

interface employeeWageBuilder	{
	public void calculatedEmployeeWage(CompanyEmpWage companyEmployee);
}

public class EmployeeWage implements employeeWageBuilder{

	// ArrayList to Store daily Wage along with Monthly Wage
   ArrayList<Integer> empDailyAndTotalWage = new ArrayList<Integer>();

	/**
	*calculate employee daily wages based on type of employee 
	*/
	public void calculatedEmployeeWage(CompanyEmpWage companyEmployee)
	{
		//VARIABLES
		int totalEmployeeHour=0;
		int employeeHour=0;
		int totalWage=0;
		int totalWorkingDays=0;
		int empDailyWage=0;
		int empTotalWage=0;

		while(totalWorkingDays<companyEmployee.getMaxDays() && totalEmployeeHour<companyEmployee.getMaxWorkingHour())
		{
			totalWorkingDays++;

	 		//COMPUTATION
			int empCheck = (int)( Math.random() * 10 ) % 3;

			switch(empCheck){
				case 1:
					employeeHour=4;
					break;

				case 2:
					employeeHour=8;
					break;

				 default:
					employeeHour=0;
			}

		//calculated total employee hour
		totalEmployeeHour=(totalEmployeeHour + employeeHour);

		//Daily Employee Wage
		empDailyWage=(employeeHour*companyEmployee.getEmpRatePerHour());
		empDailyAndTotalWage.add(empDailyWage);
		}

		 //total employee Wage
      empTotalWage=(totalEmployeeHour*companyEmployee.getEmpRatePerHour());
		empDailyAndTotalWage.add(empTotalWage);
		companyEmployee.setTotalWage(empTotalWage);
	}
	  public static void main(String args[]){

     //created object of class
     EmployeeWage employeeWage = new EmployeeWage();

     //DECLARING ARRAY OF COMPANY EMPLOYEE WAGE OBJECT
     ArrayList<CompanyEmpWage> company=new ArrayList<CompanyEmpWage>();

	  while(true){
			System.out.println("Welcome to Employee Wage Portal");
			System.out.println("Enter Your Choice to show company total wage");
			System.out.println("press 1 for TCS");
			System.out.println("press 2 for Infosys");
			System.out.println("press 3 for Wipro");
			System.out.println("Press number to exit");

			Scanner sc=new Scanner(System.in); 
			int choice=sc.nextInt(); 
			switch(choice){
				case 1:
					company.add(new CompanyEmpWage("TCS",20,100,20));
			      employeeWage.calculatedEmployeeWage(company.get(0));
					System.out.println("total Employee Wage of Tcs Company" +company.get(0).getTotalWage());
					break;

				case 2:
               company.add(new CompanyEmpWage("Infosys",20,50,10));
               employeeWage.calculatedEmployeeWage(company.get(1));
               System.out.println("total Employee Wage of Infosys Company"+company.get(1).getTotalWage());
               break;

				 case 3:
               company.add(new CompanyEmpWage("Wipro",10,60,10));
               employeeWage.calculatedEmployeeWage(company.get(2));
               System.out.println("total Employee Wage of Wipro Company"+company.get(2).getTotalWage());
               break;

				default:
   				//System.out.println("Invalid choice");
					System.exit(0);

				}
		}
	}
}

class CompanyEmpWage{
     //VARIABLES
     private String companyName;
     private int empRatePerHour;
     private int maxWorkingHour;
     private int maxDays;
     private int totalWage=0;

     //CONSTRUCTOR
     public CompanyEmpWage(final String companyName,final int empRatePerHour,final int maxWorkingHour,final int maxDays){
       this.companyName=companyName;
       this.empRatePerHour=empRatePerHour;
       this.maxWorkingHour=maxWorkingHour;
       this.maxDays=maxDays;
     }

     public String getCompanyName(){
       return companyName;
     }

     public int getEmpRatePerHour(){
       return empRatePerHour;
     }

     public int getMaxWorkingHour(){
       return maxWorkingHour;
     }

     public int getMaxDays(){
       return maxDays;
     }

     public int getTotalWage(){
       return totalWage;
     }

	  public void setTotalWage(int totalWage){
	 	this.totalWage=totalWage;
	  }
}


