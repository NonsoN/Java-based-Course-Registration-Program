import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6776421732934191655L;
	private String username;
	private String password;
	private String first;
	private String last;
	
	User() {
		
	}
	
	User(String us, String pass, String fir, String las){
		username = us;
		password = pass;
		first = fir;
		last = las;
	}
	
	//This simply prints out the name of every course.
	public void viewAll(ArrayList<Course> b) {
		for (int i = 0; i < b.size(); i++) {
		System.out.println(b.get(i).getcName());
		}
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

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
}
