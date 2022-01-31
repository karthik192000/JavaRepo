package JavaCaseStudy;

public class Main {

	public static void main(String[] args) {
		
		Donor d1 = new Donor();
		
		d1.setName("Justin");
		d1.setDateOfBirth("11-01-1995");
		d1.setGender("Male");
		d1.setMobileNumber("9994910354");
		d1.setBloodGroup("B+ve");
		d1.setBloodBankName("Blood Assurance");
		d1.setDonorType("Whole Blood");
		d1.setDonationDate("09-07-2017");
		
		d1.displayDonorDetails();
	}

}
