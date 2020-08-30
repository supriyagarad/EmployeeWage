/**********************************************************************************************************************
 *@Author:-> priyanka 
 *@purpose:-> Calculated Employee Wage for Multiple company 
 *@Date:-> 29/8/2020 
***********************************************************************************************************************/
import java.util.*;
interface employeeWageMethod	{

	public void calculatedEmployeeWage( CompanyEmpWage companyEmployee );
}

public class EmployeeWage  implements employeeWageMethod{

   HashMap<Integer, Integer> empDailyAndTotalWage = new HashMap<>();

	/**
	*calculate employee daily wages based on type of employee
	*@return-> total employee wage 
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
		empDailyWage=employeeHour*companyEmployee.getEmpRatePerHour();

		//total employee Wage
		empTotalWage=totalEmployeeHour*companyEmployee.getEmpRatePerHour();

		empDailyAndTotalWage.put(empDailyWage,empTotalWage);

		for (int i:empDailyAndTotalWage.keySet())
            System.out.println("Daily Wage --> "+ i + "total employee wage-->" + empDailyAndTotalWage.get(i));

		}

	}


		public static void main(String args[]){

    	//created object of class
    	EmployeeWage employeeWage = new EmployeeWage();

    	//DECLARING ARRAY OF COMPANY EMPLOYEE WAGE OBJECT
    	ArrayList<CompanyEmpWage> company=new ArrayList<CompanyEmpWage>();

    	company.add(new CompanyEmpWage("TCS",20,100,20));
    	employeeWage.calculatedEmployeeWage(company.get(0));

    	company.add(new CompanyEmpWage("Infosys",10,50,20));
    	employeeWage.calculatedEmployeeWage(company.get(1));

    	company.add(new CompanyEmpWage("Wipro",10,30,10));
    	employeeWage.calculatedEmployeeWage(company.get(2));
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

	  public void setTotalWage( int totalWage ){
	 	this.totalWage = totalWage;
	  }
}





