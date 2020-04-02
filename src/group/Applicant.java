package group;

public class Applicant {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private long phoneNumber;
	//education score makes up 20%
	private int educationScore;
	//experience score makes up 30% (I THINK THIS IS THE RIGHT NUMBER)
	private int experienceScore;
	//skill score makes up 10%
	private int skillScore;
	//communication score makes up 40% (CAN'T REMEMBER IF THIS IS RIGHT)
	private int communicationScore;
	private int overallScore;

	public Applicant() {
		
	}

	//GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEducationScore() {
		return educationScore;
	}

	public void setEducationScore(int educationScore) {
		this.educationScore = educationScore;
	}

	public int getExperienceScore() {
		return experienceScore;
	}

	public void setExperienceScore(int experienceScore) {
		this.experienceScore = experienceScore;
	}

	public int getSkillScore() {
		return skillScore;
	}

	public void setSkillScore(int skillScore) {
		this.skillScore = skillScore;
	}

	public int getCommunicationScore() {
		return communicationScore;
	}

	public void setCommunicationScore(int communicationScore) {
		this.communicationScore = communicationScore;
	}

	public int getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}
	//END GETTERS AND SETTERS
	
	
	@Override
	public String toString() {
		return "Applicant named : " + firstName + " " + lastName;
	}
	
	

}
