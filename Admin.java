import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.nio.file.Path;
public class Admin extends User implements Serializable, Administration {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6450815202158586542L;
	private String username;
	private String password;
	private ArrayList<Student> studentList;

	Admin(){
		
	}
	
	Admin(String username, String password, ArrayList<Student> studentList){
		this.username = username;
		this.password = password;
		this.studentList = studentList;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	//Creates and adds a new course to the list
	public void createCourse(ArrayList<Course> a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the course name");
		String course = scan.nextLine();
		String coursename = scan.nextLine();
		System.out.println("Enter the course ID");
		String cid = scan.next();
		System.out.println("Enter the max amount of students");
		int max = scan.nextInt();
		System.out.println("Enter the instructor");
		String inuct = scan.nextLine();
		String instruct = scan.nextLine();
		System.out.println("Enter the section number");
		int section = scan.nextInt();
		System.out.println("Enter the location of the course");
		String locon = scan.nextLine();
		String location = scan.nextLine();
		
		Course test = new Course(coursename, cid, max, 0, instruct, section, location);
		a.add(test);
	}
	//Removes specific course from the ArrayList
	public void deleteCourse(ArrayList<Course> a) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.println("Enter the name of the course");
		String coe = scan.nextLine();
		String course = scan.nextLine();
		
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getcName().equals(course)) {
				a.remove(i);
				System.out.println("Course removed");
				break;
			}
			else {
				count++;
			}
		}
		if(count == a.size()) {
			System.out.println("Course not found... Could not delete " + course);
		}
		
	}
	//Will edit all information about the course, except for the course name and the course ID.
	public void editCourse(ArrayList<Course> a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of course you want to edit");
		String ce = scan.nextLine();
		String cname = scan.nextLine();
		
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getcName().equals(cname)) {

				System.out.println("Enter new student maximum");
				int newmax = scan.nextInt();
				a.get(i).setMaximum(newmax);
				System.out.println("Enter new instructor");
				String newinstru = scan.nextLine();
				String newinstructor = scan.nextLine();
				a.get(i).setInstructor(newinstructor);
				System.out.println("Enter new section number");
				int newsecnum = scan.nextInt();
				a.get(i).setcSection(newsecnum);
				System.out.println("Enter new course location");
				String newLocn = scan.nextLine();
				String newLocation = scan.nextLine();
				a.get(i).setLocation(newLocation);
			}
		}
		
	}
	//Prints the name of every single course in the list
	public void viewAll(ArrayList<Course> b) {
		for (int i = 0; i < b.size(); i++) {
		System.out.println(b.get(i).getcName());
		}
	}
	//Prints the name of every single FULL course in the list
	public void viewFull(ArrayList<Course> b) {
		for (int i = 0;  i < b.size(); i++) {
			if (b.get(i).getCurrStu() == b.get(i).getMaximum()){
				System.out.println(b.get(i).getcName());
			}
			System.out.println("These are the courses you're viewing as an administrator");
		}
	}
	//Prints the name of the students enrolled in a specific course
	public void allInCourse(ArrayList<Course> b) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.println("Enter the course ID");
		String cID = scan.next();
		
		for(int i = 0;  i < b.size(); i++) {
			if(b.get(i).getCourseID().equals(cID)) {
				for(int y = 0; y < b.get(i).getsList().size(); y++) {
					System.out.println(b.get(i).getsList().get(y).getFirst() + " " + b.get(i).getsList().get(y).getLast());
				}
			}
			else {
				count++;
			}
		}
		
		if(count == b.size()) {
			System.out.println("Course not found");
		}
	}
	//Print the specific student's courses
	public void studentsCourses(ArrayList<Student> a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the student's first name");
		String first = scan.next();
		System.out.println("Enter the student's last name");
		String last = scan.next();
		
		for(int i = 0; i <a.size(); i++) {
			if(a.get(i).getFirst().equals(first) && a.get(i).getLast().equals(last)) {
				for(int z = 0;  z < a.get(i).getList().size(); z++) {
					System.out.println(a.get(i).getList().get(z).getcName());
				}
			}
		}
	}
	//Prints all the information about the specific course
	public void displayInfo(ArrayList<Course> a) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.println("Enter the course ID");
		String iD = scan.nextLine();
		
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getCourseID().equals(iD)) {
				System.out.println("Course name: " + a.get(i).getcName());
				System.out.println("Course ID: " + a.get(i).getCourseID());
				System.out.println("Course section: " + a.get(i).getcSection());
				System.out.println("Current number of students enrolled: " + a.get(i).getCurrStu());
				System.out.println("Current instructor: " + a.get(i).getInstructor());
				System.out.println("Current course location: " + a.get(i).getLocation());
				System.out.println("Current max: " + a.get(i).getMaximum());
			}
			else {
				count++;
			}
		}
		
		if(count == a.size()) {
			System.out.println("Course not found");
		}
	}
	
	//Registers student into the specific course
	public String registerStudent(ArrayList<Course> a, ArrayList<Student> b) {
		Scanner scan = new Scanner(System.in);
		int counter = 0;
		
		System.out.println("Enter the student's first name");
		String sFirst = scan.next();
		System.out.println("Enter the student's last name");
		String sLast = scan.next();
		System.out.println("Enter the course ID");
		String cID = scan.next();
		System.out.println("Enter student username");
		String studentUsername = scan.next();
		System.out.println("Enter user password");
		String studentPassword = scan.next();
		
		Student stud = new Student(studentUsername, studentPassword, sFirst, sLast);
		b.add(stud);
		Course cour = new Course();
		
		for(int y = 0; y < a.size(); y++) {
			if(a.get(y).getCourseID().equals(cID)) {
				cour = a.get(y);
			}
		}
	
		//Check to see if the course is full. If not, place the student in the course.
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getCourseID().equals(cID)) {
				if(a.get(i).getCurrStu() == a.get(i).getMaximum()) {
					return "Course is full";
				}
				else {
					//Places the course into the student's list of courses
					for(int x = 0; x < b.size(); x++) {
						if(b.get(x).getFirst().contentEquals(sFirst) && b.get(x).getLast().equals(sLast)) {
							b.get(x).getList().add(cour);
						}
					}
					
					a.get(i).setCurrStu(a.get(i).getCurrStu() + 1);
					a.get(i).getsList().add(stud);
					return "Student added";
				}
			}
		}
		return cID;

	}
	
	//Writes file to text
	public void fileToText(ArrayList<Course> a) {
		String text = "";
		
		for(int i = 0;  i < a.size(); i++) {
			if(a.get(i).getCurrStu() == a.get(i).getMaximum()) {
				text += a.get(i).getcName() + ", ";
			}
		}
		
		String fileName = "text.txt";
		Scanner scan = new Scanner(System.in);
		
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			
//Always close writer
			bufferedWriter.close();
		}

		//Always close files

		catch (IOException exk) {
			System.out.println( "Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}
	//This sorts the course list by comparing the amount of students currently within each course
	public void sortCourse(ArrayList<Course> a) {
		Course hold;
		
		for(int i = 0; i < a.size()-1; i++) {
			if(a.get(i).getCurrStu() > a.get(i+1).getCurrStu()) {
				hold = a.get(i);
				a.set(i, a.get(i+1));
				a.set(i+1, hold);
			}
		}
	}

	@Override
	public void studentUserPass(ArrayList<Student> a) {
		for(int i = 0; i < a.size(); i++) {
			a.get(i).setUsername(a.get(i).getUsername()+ (int) Math.random()* 100 + 1000);
			a.get(i).setPassword(a.get(i).getLast() +  (int) Math.random()*100 + 1000);
		}
		
	}
	
	


}
