package group;

import java.util.ArrayList;

public class Searcher {

	public Searcher() {
		
	}
	
	public ArrayList<Applicant> search(ArrayList<Applicant> database, String searchType, Object searchValue) {
		ArrayList<Applicant> foundItems = new ArrayList<Applicant>();
		
		if(searchValue instanceof String) {
			//if its a string then email, address, last name, or first name are being looked for
			String temp = (String)searchValue;
			
			for(int i = 0; i < database.size(); i++) {
				
				switch(searchType) {
				case "firstName":
					if(database.get(i).getFirstName().contains(temp)) foundItems.add(database.get(i));
					break;
				case "lastName":
					if(database.get(i).getLastName().contains(temp)) foundItems.add(database.get(i));
					break;
				case "address":
					if(database.get(i).getAddress().contains(temp)) foundItems.add(database.get(i));
					break;
				case "email":
					if(database.get(i).getEmail().contains(temp)) foundItems.add(database.get(i));
					break;
				default:
					System.out.println("Something went terribly wrong");
				}
				
			}
			
			return foundItems;
			
		} else if(searchValue instanceof Integer){
			int temp = (Integer)searchValue;
			
			//if its an integer then it can be id, phone number, education score, experience score, skill score,
			//communication score, or overall score
		
			for(int i = 0; i < database.size(); i++) {
				switch(searchType) {
				case "id":
					if(database.get(i).getId() == temp) foundItems.add(database.get(i));
					break;
				case "phoneNumber":
					if(database.get(i).getPhoneNumber() == temp) foundItems.add(database.get(i));
					break;
				case "educationScore":
					if(database.get(i).getEducationScore() == temp) foundItems.add(database.get(i));
					break;
				case "experienceScore":
					if(database.get(i).getExperienceScore() == temp) foundItems.add(database.get(i));
					break;
				case "skillScore":
					if(database.get(i).getSkillScore() == temp) foundItems.add(database.get(i));
					break;
				case "communicationScore":
					if(database.get(i).getCommunicationScore() == temp) foundItems.add(database.get(i));
					break;
				case "overallScore":
					if(database.get(i).getOverallScore() == temp) foundItems.add(database.get(i));
					break;
				default:
					System.out.println("Something is very wrong");
				}
			}
			
			return foundItems;
			
			
		} else {
			//if it's not a String or Integer something is wrong
			return null;
		}
		
		
	}
	
}
