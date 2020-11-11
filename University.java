import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class University implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336950192169787810L;
	protected ArrayList<Course> courses = new ArrayList<>();
	protected ArrayList<Student> school = new ArrayList<>();

	//Used for reading the csv
	public void readIt() {
		
		BufferedReader rd = null;
		
		try {
			rd = new BufferedReader(new FileReader("src/MyUniversityCourses.csv"));
			String hold;
			ArrayList<String> holds = new ArrayList<String>();
			
			while( (hold = rd.readLine()) !=  null) {
				holds.add(hold);
			}
			//Puts everything into an array of type String and adds them accordingly. This means that the parameters for the course
			//constructor must be in a specific order like the one shown here.
			for(int i = 1; i < holds.size(); i++) {
				String[] temp = holds.get(i).split(",");
				String name = temp[0];
				String cID = temp[1];
				int max = Integer.parseInt(temp[2]);
				int currentStudents = Integer.parseInt(temp[3]);
				String instructor = temp[5];
				int section = Integer.parseInt(temp[6]);
				String location = temp[7];
				
				Course cour = new Course(name, cID, max, currentStudents, instructor, section, location);
				courses.add(cour);
				
			}
		}
		catch (FileNotFoundException x) {
			x.printStackTrace();
		}
		catch (IOException y) {
			y.printStackTrace();
		}
	}


}
