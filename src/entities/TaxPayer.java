package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public static double salaryTax(double salaryIncome) {

		if (salaryIncome / 12 < 3000) {
			return 0;
		} else if (salaryIncome / 12 < 5000) {
			return salaryIncome * 0.10;
		} else {
			return salaryIncome * 0.20;
		}
	}

	public static double servicesTax(double servicesIncome) {
		if (servicesIncome > 0) {
			return servicesIncome * 0.15;
		} else {
			return 0;
		}
	}

	public static double capitalTax(double capitalIncome) {
		if (capitalIncome > 0) {
			return capitalIncome * 0.20;
		} else {
			return 0;
		}
	}

	public static double grossTax(double salaryIncome, double servicesIncome, double capitalIncome) {
		return salaryTax(salaryIncome) + servicesTax(servicesIncome) + capitalTax(capitalIncome);

	}

	public static double taxRebate(double salaryIncome, double servicesIncome, double capitalIncome,
			double healthSpending, double educationSpending) {
		if (grossTax(salaryIncome, servicesIncome, capitalIncome) * 0.3 > healthSpending + educationSpending) {
			return healthSpending + educationSpending;
		} else {
			return grossTax(salaryIncome, servicesIncome, capitalIncome) * 0.3;
		}
	}

	public static double netTax(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		return grossTax(salaryIncome, servicesIncome, capitalIncome)
				- taxRebate(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
	}

	public String toString() {
		return  "Imposto bruto total: " 
				+ String.format("%.2f", grossTax(salaryIncome, servicesIncome, capitalIncome))
				+ "\n"
				+ "Abatimento: "
				+ taxRebate(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending) 
				+ "\n"
				+ "Imposto devido: "
				+ String.format("%.2f", netTax(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));

	}

}
