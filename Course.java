import java.util.*;
import java.io.*;
public class Course implements Comparable<Course>, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7258729988362478284L;
	private String cName;
	private String courseID;
	private int maximum;
	private int currStu;
	private ArrayList<Student> sList = new ArrayList<Student>(0);
	private String instructor;
	private int cSection;
	private String location;
	
	Course() {
		
	}

	public Course(String cName, String cID, int maximum, int currStu, String instructor, int cSection,
			String location) {
		super();
		this.cName = cName;
		courseID = cID;
		this.maximum = maximum;
		this.currStu = currStu;
		this.sList = new ArrayList<Student>(0);
		this.instructor = instructor;
		this.cSection = cSection;
		this.location = location;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getCurrStu() {
		return currStu;
	}

	public void setCurrStu(int currStu) {
		this.currStu = currStu;
	}
	

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public ArrayList<Student> getsList() {
		return sList;
	}

	public void setsList(ArrayList<Student> sList) {
		this.sList = sList;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getcSection() {
		return cSection;
	}

	public void setcSection(int cSection) {
		this.cSection = cSection;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//Used for sorting the courses.
	public int compareTo(Course o) {
		if(this.getCurrStu() > o.getCurrStu()) {
			return 1;
		}
		
		if(this.getCurrStu() < o.currStu) {
			return -1;
		}
		
		return 0;
	}
	
	
}
