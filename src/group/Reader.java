package group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	String filename;
	Scanner input;
	
	public Reader(String filename) {
		this.filename = filename;
		try {
			input = new Scanner(new File(filename));
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
	}
	
	/**
	 * Stores all the data from the text file into the given array list
	 * @param database the array list being stored into
	 */
	public void read(ArrayList<Applicant> database) {
		
		//first line in the file is the number of applicants in the database
		int numOfApplicants = Integer.parseInt(input.nextLine());
		System.out.println("Reading " + numOfApplicants + " applicants");
		//this loop goes once for each applicant
		for(int i = 0; i < numOfApplicants; i++) {
				Applicant temp = new Applicant();
				temp.setId(Integer.parseInt(input.nextLine()));
				temp.setFirstName(input.nextLine());
				temp.setLastName(input.nextLine());
				temp.setAddress(input.nextLine());
				temp.setEmail(input.nextLine());
				temp.setPhoneNumber(Long.parseLong(input.nextLine()));
				temp.setEducationScore(Integer.parseInt(input.nextLine()));
				temp.setExperienceScore(Integer.parseInt(input.nextLine()));
				temp.setSkillScore(Integer.parseInt(input.nextLine()));
				temp.setCommunicationScore(Integer.parseInt(input.nextLine()));
				temp.setOverallScore(Integer.parseInt(input.nextLine()));
				database.add(temp);
		}
		System.out.println("Successfully read in all Applicants");
		
	}
	
	
}
