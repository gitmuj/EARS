package addApplicant;

import org.apache.poi.hslf.record.CString;

public class Applicant {


	private int id;
	private int jobId;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phoneNumber;
	//education score makes up 20%
	private int educationScore;
	//experience score makes up 30% (I THINK THIS IS THE RIGHT NUMBER)
	private int experienceScore;
	//skill score makes up 10%
	private int skillScore;
	//communication score makes up 40% (CAN'T REMEMBER IF THIS IS RIGHT)
	private int communicationScore;
	private int overallScore;





	//new properties added
	private String major;
	private String school;
	private String lastRole;
	private String organization;
	private String attachmentPath;
	private String comments;
	private  int yearsOfExp;

	//GETTERS AND SETTERS


	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getOrganization() {
		return organization;
	}



	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}



	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getMajor() {
		return major;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLastRole() {
		return lastRole;
	}

	public void setLastRole(String lastRole) {
		this.lastRole = lastRole;
	}





	public int getYearsOfExp() {
		return yearsOfExp;
	}

	public void setYearsOfExp(int yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}

	public Applicant() {
		
	}


	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

	public void setOverallScore() {
		this.overallScore = (int) ((educationScore + experienceScore + skillScore + communicationScore)/20.00*100);
	}





	//END GETTERS AND SETTERS
	
	
	@Override
	public String toString() {
		return "addApplicant.Applicant named : " + firstName + " " + lastName;
	}
	
	

}
