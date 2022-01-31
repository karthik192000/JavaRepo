package JavaCaseStudy;

public class Donor extends Person {

	private String bloodBankName;
	private String donorType;
	private String donationDate;

	public String getBloodBankName() {
		return bloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}

	public String getDonorType() {
		return donorType;
	}

	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}
	
	
	public void displayDonorDetails() {
		System.out.println("Donor Details: ");
		System.out.println("Name: " + this.getName());
		System.out.println("Date Of Birth: " + this.getDateOfBirth());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Mobie Number: " + this.getMobileNumber());
		System.out.println("Blood Group: " + this.getBloodGroup());
		System.out.println("Blood Bank Name: " + this.getBloodBankName());
		System.out.println("Donor Type: " + this.getDonorType());
		System.out.println("Donation Date: " + this.getDonationDate());
	}
	}


