/********************************************************************************************************************** 
*@Author:-> priyanka
*@purpose:->Calculated Employee Wage for Multiple company 
*@Date:-> 29/8/2020
***********************************************************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

interface EmployeeWageBuilder{
	void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth);
	void computeEmpWage();
	int getTotalWageByCompanyName(final String name);
	}

public class EmployeeWage implements EmployeeWageBuilder{	
	private List<Company>companies;
	private Map<String,Integer>companyWages;

	public EmployeeWage() {
		companies = new ArrayList<Company>();
		companyWages=new HashMap<String,Integer>();
	}

	public static void main(String[] args) {
		final EmployeeWageBuilder empBuilder = new EmployeeWage();

		//Added diffrent companies
		empBuilder.addCompany("Tcs", 20, 10, 500);
		empBuilder.addCompany("Infosys", 20, 20, 110);
		empBuilder.addCompany("Wipro", 20, 10, 100);
		empBuilder.computeEmpWage();

		final int tcsTotalWage=empBuilder.getTotalWageByCompanyName("Tcs");
		System.out.println("Total employee wages for Tcs : "+tcsTotalWage);

		final int infosysTotalWage=empBuilder.getTotalWageByCompanyName("Infosys");
		System.out.println("Total employee wages for Infosys : "+infosysTotalWage);

		final int wiproTotalWage=empBuilder.getTotalWageByCompanyName("Wipro");
		System.out.println("Total employee wages for Wipro : "+wiproTotalWage);
}

	/**
	*total wage of different company
	*@return ->total wage of company
   */
	public int getTotalWageByCompanyName(final String name){
		final int totalWage=companyWages.get(name);
		return totalWage;
	}

	/**
    * Added companies in the arrayList
   */
	@Override
	public void addCompany( String name,  int empRate,  int numOfWorkingDays,  int maxHrsInMonth){
		companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
	}

	/**
    * added key and value in map( key is company name and value is total emp wage)
   */
	@Override
	public void computeEmpWage(){
		for(int i = 0; i< companies.size(); i++){
			final Company company=companies.get(i);
			final int totalWage=computeEmpWage(company);
			company.setTotalEmpWage(totalWage);
		  	companyWages.put(company.getName(),totalWage);
	  	}
		System.out.println("company wages : "+companyWages.toString());
	}

	/**
	 * calculate total employee wages based employee hour
	 * @return total employee wages.
	 */
	private int computeEmpWage(final Company company) {
		System.out.println("\nCalculating company wage for company : " + company.getName());
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
			totalWorkingDays++;
			final int empHrs = getEmpHrs();
			final int empWage = empHrs*company.getEmpRate();
			totalEmpHrs+=empHrs;
			totalWage+=empWage;
		}
		return totalWage;
	}

	/**
	* getting employee hour base on employee working full time,part time  or absent;
	*@return->Emlpoyee Hour;
	**/
	public int getEmpHrs() {
		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

		//get random value
		final int employeeCheck = (int)(Math.random()*10)%3;

		switch(employeeCheck) {

			case isFullTime:
				empHrs = 8;
				break;

			case isPartTime:
				empHrs = 4;
				break;

			default:
				empHrs=0;
				break;
		}
		return empHrs;
	}

}

class Company {

	private String name;
	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;

	public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
		this.name = name;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	}

	public String getName(){
		return this.name;
	}

	public int getEmpRate(){
		return this.empRate;
	}

	public int getNumOfWorkingDays(){
		return this.numOfWorkingDays;
	}

	public int getMaxHrsInMonth(){
		return this.maxHrsInMonth;
	}

	public void setTotalEmpWage(final int totalEmpWage){
		this.totalEmpWage=totalEmpWage;
	}

	@Override
	public String toString(){
		return "Total emp wage for company: "+name+" is "+ totalEmpWage;
	}
}
