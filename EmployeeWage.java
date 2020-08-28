/********************************************************************************************************************** 
*@Author:-> priyanka
*@purpose:-> Calculated Employee Wage for Multiple company 
*@Date:-> 28/8/2020
**********************************************************************************************************************/
 public class EmployeeWage{
	//CONSTANTS
	final int ABSENT=0;
	final int PART_TIME=1;
	final int FULL_TIME=2;

	//VARIABLES
	final String companyName;
	final int empRatePerHour;
	final int maxWorkingHour;
	final int maxDays;

	//CONSTRUCTOR

	public EmployeeWage(String companyName,int empRatePerHour,int maxWorkingHour,int maxDays){
		this.companyName=companyName;
		this.empRatePerHour=empRatePerHour;
		this.maxWorkingHour=maxWorkingHour;
		this.maxDays=maxDays;
	}

	/**
	*calculate employee daily wages based on type of employee
	*@return-> total employee wage 
	*/
	public int calculatedEmployeeWage()
	{
		//VARIABLES
		int totalEmployeeHour=0;
		int employeeHour=0;
		int totalSalary=0;
		int totalWorkingDays=0;

		while(totalWorkingDays<maxDays && totalEmployeeHour<maxWorkingHour)
		{
			totalWorkingDays++;

	 		//COMPUTATION
			int empCheck = (int)( Math.random() * 10 ) % 3;

			switch(empCheck){
				case PART_TIME:
					employeeHour=4;
					break;

				case FULL_TIME:
					employeeHour=8;
					break;

				case ABSENT:
            	employeeHour = 0;
                break;

				 default:
					System.out.println("invalid choice");
			}

		//calculated total employee hour
		totalEmployeeHour=(totalEmployeeHour + employeeHour);

		//calculated total Salary
		totalSalary=(empRatePerHour * totalEmployeeHour);
		}
		return totalSalary;
	}

	//main method
   public static void main(String args[]){

   //created object of class
   EmployeeWage tcsEmployee = new EmployeeWage("TCS",20,100,20);
	int totalTcsEmpWage=tcsEmployee.calculatedEmployeeWage();
	System.out.println("Total Wage of Tcs Employee:" +totalTcsEmpWage);

   //created object of class
   EmployeeWage infosysEmployee = new EmployeeWage("Infosys",20,100,20);
   int totalInfosysEmpWage=infosysEmployee.calculatedEmployeeWage();
   System.out.println("Total Wage of infosys Employee:" +totalInfosysEmpWage);

	//created object of class
   EmployeeWage wiproEmployee = new EmployeeWage("Wipro",20,100,20);
   int totalWiproEmpWage=wiproEmployee.calculatedEmployeeWage();
   System.out.println("Total Wage of Wipro Employee:" +totalWiproEmpWage);

  }
}


