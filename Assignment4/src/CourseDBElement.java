
public class CourseDBElement implements Comparable {
	private String courseID;
	private int CRN;
	private int numOfCredits;
	private String roomNum;
	private String instructor;
	
	
	/**
	 * default constructor
	 */
	public CourseDBElement() {
		this(null, 0, 0, null, null);
	}
	/**
	 * contructor which adds given values to create the Element object
	 * @param courseID
	 * @param CRN
	 * @param numOfCredits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String courseID, int CRN, int numOfCredits, String roomNum, String instructor) {
		this.courseID = courseID;
		this.CRN = CRN;
		this.numOfCredits = numOfCredits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	/**
	 * method to return course ID 
	 * @return
	 */
	public String getID() {
		return courseID;
	}
	
	/**
	 * sets course id
	 * @param courseID
	 */
	public void setCourseID (String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * return room number value
	 * @return
	 */
	public String getRoomNum() {
		return roomNum;
	}
	/**
	 * sets the room number
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	/**
	 * gets course crn number
	 * @return
	 */
	public int getCRN() {
		return CRN;
	}
	
	/**
	 * this method sets the CRN
	 * @param CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}
	/**
	 * sets the instructor
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * returns instructor name
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * set number of credits
	 * @param numOfCredits
	 */
	public void setNumOfCredits (int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}
	/**
	 * return number of credits
	 * @return
	 */
	public int getNumOfCredits() {
		return numOfCredits;
	}
	/**
	 * method for creating a hashcode of the string value of the crn number
	 */
	public int hashCode() {
		String s = String.valueOf(getCRN());	// converts CRN number to a string value
		int hash = 0;
		int g = 31;	// use of 31 since its a prime number and prime numbers give a better spread 
		for(int i = 0; i < s.length(); i++) {
			hash = g * hash + s.charAt(i);	// generates hash code for each char
		}
		return hash;
	}

	/**
	 * compares  the hashCode of this CourseDBElement object to the element given by the parameter
	 * @param element
	 */
	@Override
	public boolean compareTo(CourseDBElement element) {
		CourseDBElement cde = new CourseDBElement(this.courseID, this.CRN, this.numOfCredits, this.roomNum, this.instructor);
		
		if (cde.getCRN() != element.getCRN()) {	// if crn numbers are not equal
			return false;	// return false
		}
		else {
			return true;
		}
	}

	

	

	
}

