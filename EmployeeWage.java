/**********************************************************************************************************************
*@purpose:-> Calculate Employees total salary with working hour. 
**********************************************************************************************************************/
public class EmployeeWage{
	//CONSTANTS
	final int ABSENT=0;
   final int PART_TIME=1;
	final int FULL_TIME=2;
	final int EMP_RATE_PER_HOUR;
	final int MAX_WORKING_HOUR;
	final int MAX_DAYS;

	//CONSTRUCTOR

	public EmployeeWage(int EMP_RATE_PER_HOUR,int MAX_WORKING_HOUR,int MAX_DAYS){
		this.EMP_RATE_PER_HOUR= EMP_RATE_PER_HOUR;
		this.MAX_WORKING_HOUR= MAX_WORKING_HOUR;
		this.MAX_DAYS=MAX_DAYS;
	}


	public void calculatedEmployeeWage()
	{
		//VARIABLES
		int totalEmployeeHour=0;
		int employeeHour=0;
		int totalSalary=0;
		int totalWorkingDays=0;

		while(totalWorkingDays<MAX_DAYS && totalEmployeeHour<MAX_WORKING_HOUR)
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
		totalSalary=(EMP_RATE_PER_HOUR * totalEmployeeHour);
		}

		System.out.println("total salary of employee:" +totalSalary);
	}

	//main method
   public static void main(String args[]){

   //create object of class
   EmployeeWage employee = new EmployeeWage(20,100,20);

   //method call
   employee.calculatedEmployeeWage();
  }
}


