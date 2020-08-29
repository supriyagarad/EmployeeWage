/********************************************************************************************************************** 
*@Author:-> priyanka
*@purpose:-> Calculated Employee Wage for Multiple company 
*@Date:-> 28/8/2020
**********************************************************************************************************************/
 public class EmployeeWage{

	//VARIABLES
	private String companyName;
	private int empRatePerHour;
	private int maxWorkingHour;
	private int maxDays;
	private int totalWage;

	//CONSTRUCTOR

	public EmployeeWage(final String companyName,final int empRatePerHour,final int maxWorkingHour,final int maxDays){
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


	/**
	*calculate employee daily wages based on type of employee
	*@return-> total employee wage 
	*/
	public int calculatedEmployeeWage()
	{
		//VARIABLES
		int totalEmployeeHour=0;
		int employeeHour=0;
		int totalWage=0;
		int totalWorkingDays=0;

		while(totalWorkingDays<getMaxDays() && totalEmployeeHour<getMaxWorkingHour())
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

		//calculated total Salary
		totalWage=(getEmpRatePerHour() * totalEmployeeHour);
		}
		//return totalWage
		return totalWage;
	}

   public static void main(String args[]){

   //created object of class
   EmployeeWage tcsEmployee = new EmployeeWage("TCS",20,100,20);
	int totalTcsEmpWage=tcsEmployee.calculatedEmployeeWage();
	System.out.println("Total Wage of Tcs Employee:" +totalTcsEmpWage);

   //created object of class
   EmployeeWage infosysEmployee = new EmployeeWage("Infosys",10,50,15);
   int totalInfosysEmpWage= infosysEmployee.calculatedEmployeeWage();
   System.out.println("Total Wage of infosys Employee:" +totalInfosysEmpWage);

	//created object of class
   EmployeeWage wiproEmployee = new EmployeeWage("Wipro",20,40,10);
   int totalWiproEmpWage=wiproEmployee.calculatedEmployeeWage();
   System.out.println("Total Wage of Wipro Employee:" +totalWiproEmpWage);

  }
}


