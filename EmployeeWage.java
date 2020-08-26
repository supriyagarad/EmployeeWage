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

	 //main method
    public static void main(String args[]){

    //create object of class
    EmployeeWage employee = new EmployeeWage();

    //method call
    employee.calculatedEmployeeWage();
    }
}


