 import java.io.*;
import java.util.*;
//NOTE: WHEN ENTERING INFORMATION LIKE COURSE NAME OR COURSE LOCATION (ANYTHING THAT HAS A SPACE), PLEASE ENTER IT TWICE
//This has methods for serializing the program and unserializing it as seen through the serialize and unserialize methods. 
//I used a menu based system to run through the options for admins and for students.
//There are a lot of if-else statements. I also used a while true, with break, and a for loop.
public class CourseSystem {

	public static void serialize(University uni) {

		try {
			FileOutputStream ONE = new FileOutputStream("src/serialFolder/University.ser");
			ObjectOutputStream TWO = new ObjectOutputStream(ONE);
			TWO.writeObject(uni);
			
			TWO.close();
			ONE.close();
			
			System.out.println("SAVE COMPLETE");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static University unserialize(String place) {
		University uni;
		try {
			FileInputStream ONE = new FileInputStream("src/serialFolder/University.ser");
			
			ObjectInputStream TWO = new ObjectInputStream(ONE);
			
			uni = (University)TWO.readObject();
			
			TWO.close();
			ONE.close();
			
			return uni;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		University nyu;
		int count = 0;

		if (!new File("src/serialFolder/University.ser").exists()) {
			new File("src/serialFolder").mkdir();		
			nyu = new University();
	
			nyu.readIt();
			System.out.println("DONE");
		    }
		 else {
			nyu = unserialize("src/serialFolder/University.ser");
			System.out.println("DONE AND UNSERIALIZED.");
		}
		
		System.out.println("Please enter your username");
		String user = scan.next();
		System.out.println("Please enter your password");
		String pass = scan.next();
		
		if(user.equals("Admin") && pass.equals("Admin001"))  {
			System.out.println("Logged in as: Administrator");
			Admin administrator = new Admin();
			
			while(true) {
				System.out.println("Course Management and Reports:");
				System.out.println("1. Create a new course");
				System.out.println("2. Delete a course");
				System.out.println("3. Edit a course");
				System.out.println("4. Display all information about specified course");
				System.out.println("5. Register a student");
				System.out.println("6. View all courses");
				System.out.println("7. View all full courses");
				System.out.println("8. Write file to list of all full courses");
				System.out.println("9. View students registered in specific course");
				System.out.println("10. View courses specific student is enrolled in");
				System.out.println("11. Sort course list");
				System.out.println("12. Exit system. ");
				
				int val = scan.nextInt();
				
				if(val == 1) {
					administrator.createCourse(nyu.courses);
				}
				else if(val == 2) {
					administrator.deleteCourse(nyu.courses);
				}
				else if(val == 3) {
					administrator.editCourse(nyu.courses);
				}
				else if(val == 4) {
					administrator.displayInfo(nyu.courses);
				}
				else if(val == 5) {
					administrator.registerStudent(nyu.courses, nyu.school);
				}
				else if(val == 6) {
					administrator.viewAll(nyu.courses);
				}
				else if(val == 7) {
					administrator.viewFull(nyu.courses);
				}
				else if(val == 8) {
					administrator.fileToText(nyu.courses);
				}
				else if(val == 9) {
					administrator.allInCourse(nyu.courses);
				}
				else if(val == 10) {
					administrator.studentsCourses(nyu.school);
				}
				else if(val == 11) {
					administrator.sortCourse(nyu.courses);
				}
				else {
					System.out.println("Goodbye");
					serialize(nyu);
					break;
				}
			}
		}
		else {
			for(int i =0 ; i < nyu.school.size(); i++) {
				if(nyu.school.get(i).getUsername().equals(user) && nyu.school.get(i).getPassword().equals(pass)) {
					Student student = nyu.school.get(i);
					
					while(true) {
						System.out.println("Logged in as: " + nyu.school.get(i).getFirst() + " " + nyu.school.get(i).getLast());
						System.out.println("Course management");
						System.out.println("1. View all courses");
						System.out.println("2. View all open courses");
						System.out.println("3. Register in a course");
						System.out.println("4. Withdraw from a course");
						System.out.println("5. View your courses");
						System.out.println("6. Exit");
						
						int val2 = scan.nextInt();
						
						if(val2 == 1) {
							student.viewAll(nyu.courses);
						}
						else if(val2 == 2) {
							student.viewOpen(nyu.courses);
						}
						else if(val2 == 3) {
							student.register(nyu.courses, nyu.school);
						}
						else if(val2 == 4) {
							student.withdraw(nyu.courses, nyu.school);
						}
						else if(val2 == 5) {
							student.viewMyCourses(nyu.school);
						}
						else {
							serialize(nyu);
							break;
						}
					}
				}
				else {
					count++;
				}
			}
			//This occurs once we have established that an admin is not being logged into.
			//If the username and password for what could now only be a student is incorrect for every existing student, this method prints
			if(count == nyu.school.size()) {
				serialize(nyu);
				System.out.println("Wrong username/password");
			}
		}
	}

}

