public class EmployeeWage{
	//CONSTANTS
	public static final int PART_TIME=1;
	public static final int FULL_TIME=2;
	public static final int ABSENT=0;
	public static final int EMP_RATE_PER_HOUR=20;

	public void calculatedEmployeeWage()
	{
		//VARIABLES
		int employeeHour=0;
		int empWage=0;
		int totalSalary=0;
		int salary=0;
		int workingDays=20;

		for(int day=1;day<=workingDays;day++)
		{
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

			empWage=employeeHour * EMP_RATE_PER_HOUR;
			System.out.println("Employee Wage:" + empWage);
		}
		//calculated daily salary
		salary=(EMP_RATE_PER_HOUR * employeeHour);

		//calculated monthly Salary
		totalSalary=(totalSalary+salary);
	}

	//main method
   public static void main(String args[]){

   //create object of class
   EmployeeWage employee = new EmployeeWage();

   //method call
   employee.calculatedEmployeeWage();
  }
}


