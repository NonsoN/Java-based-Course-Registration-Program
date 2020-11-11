import java.io.Serializable;
import java.util.*;
//FOR REGISTER, ASSUME STUDENT IS NOT ENROLLED
public class Student extends User implements Serializable, Desk  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8848074438207857585L;
	private String username;
	private String password;
	private String first;
	private String last;
	private ArrayList<Course> list = new ArrayList<Course>(0);
	
	//Blank Constructor
	Student (){
		
	}
	
	//Constructor with parameters
	Student(String us, String pass, String fir, String las){
		username = us;
		password = pass;
		first = fir;
		last = las;
		list = new ArrayList<Course>(0);
	}
	
	//Displays every existing course
	public void viewAll(ArrayList<Course> b) {
		for (int i = 0; i < b.size(); i++) {	
		System.out.println(b.get(i).getcName());
		}
		System.out.println("These are the courses you're currently viewing as a student");
	}
	
	//Displays every existing course that is not full
	public void viewOpen(ArrayList<Course> b) {
		for (int i = 0;  i < b.size(); i++) {
			if (b.get(i).getCurrStu() < b.get(i).getMaximum()){
				System.out.println(b.get(i).getcName());
			}
		}
	}
	
	//Prints every course the student is enrolled in
	public void viewMyCourses(ArrayList<Student> a) {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getFirst().equals(this.getFirst()) && a.get(i).getLast().equals(this.getLast())){
				for(int y = 0; y < this.getList().size(); y++) {
					System.out.println(this.getList().get(y).getcName());
				}
			}
		}
		
		if(this.getList().size()== 0) {
			System.out.println("You are not enrolled in any courses");
		}
	}
	
	//Registers student into specified course
	public String register(ArrayList<Course> b, ArrayList<Student> a) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Which course do you what to register in?");
		String xy = scan.nextLine();
		String x = scan.nextLine();
		System.out.println("What is the section?");
		int y = scan.nextInt();
		System.out.println("What is your first name?");
		String name = scan.next();
		System.out.println("What is your last name?");
		String last = scan.next();
		
		//If future error occurs regarding registering for courses. Refer to this area
		Student sav = new Student();
		Course cour = new Course();
		
		for(int p = 0 ; p < b.size(); p++) {
			if(b.get(p).getcName().equals(x)) {
				cour =  b.get(p);
			}
		}
		
		for(int z = 0; z < a.size(); z++) {
			if(a.get(z).getFirst().equals(name) && a.get(z).getLast().equals(last))
				sav = a.get(z);
		}
		
		for(int i = 0; i < b.size(); i++) {
			if(b.get(i).getcName().equals(x) && b.get(i).getcSection() == y) {
				//Check if course is full
				if(b.get(i).getCurrStu() == b.get(i).getMaximum()) {
					return "Course is full";
				}
				//adds student to course and adds course to student's course list
				//increments current number of students in course by 1
				else { 
					sav.getList().add(cour);
					b.get(i).getsList().add(sav);
					b.get(i).setCurrStu(b.get(i).getCurrStu() + 1);
					return "Registered in course";
				}		
			}
		}
		return "You are registered in the course";
	}
	
	//Withdraws student from specified course
	public String withdraw(ArrayList<Course> b, ArrayList<Student> a) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		System.out.println("Enter your first name");
		String fn = scan.next();
		System.out.println("Enter your last name");
		String ln = scan.next();
		System.out.println("Enter the course name");
		String cn = scan.next();
		
		//Goes into the student's specific course list and removes that course from said list.
		for(int s = 0; s < a.size(); s++) {
			if(a.get(s).getFirst().equals(fn) && a.get(s).getLast().equals(ln)) {
				for(int y = 0; y < a.get(s).getList().size(); s++ ) {
					if( a.get(s).getList().get(y).getcName().equals(cn)) {
						a.get(s).getList().remove(y);
					}
				}
			}
		}
		
		//Goes into the course list and searches for the student.
		//If the student is found (via first and last name), they are removed from the course.
		//If the course is not found, count increments by 1. 
		//If the course does not exist (count is equal to the size of the ArrayList), a message is displayed saying the course is not found.
		for(int i = 0; i < b.size(); i++ ) {
			if(b.get(i).getcName().equals(cn)) {
				for(int j = 0; j < b.get(i).getsList().size(); j++) {
					if(b.get(i).getsList().get(j).getFirst().equals(fn) && b.get(i).getsList().get(j).getLast().equals(ln)) {
						b.get(i).setCurrStu(b.get(i).getCurrStu() - 1);
						b.get(i).getsList().remove(j);
						return "You have withdrawn from this course.";
					}
				}
			}
			else {
				count++;
			}
			
		}
		
		if(count == b.size()) {
			return "Course not found.";
		}
		
		//All the for loops should fail if this message is returned.
		//The student is not enrolled in the specified course, but the course does exist.
		return "Error. Student not enrolled in specified course.";
	}
	
	//Displays the courses the student is enrolled in
	public void display(Student a) {
		for(int i = 0; i < a.getList().size(); i++) {
			System.out.println(a.getList().get(i).getcName());
		}
		
		if(a.getList().size() == 0) {
			System.out.println("Student is not enrolled in any courses.");
		}
	}
	
	//These are basic and standard getters and setters
	
	public ArrayList<Course> getList() {
		return list;
	}
	
	public void setList(ArrayList<Course> list) {
		this.list = list;
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

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	

	
	
	
	
}
