package DAAProject;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Character> odd = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));
		
		Chinese_Postman_algo c = new Chinese_Postman_algo();
		c.gen_pair(odd);
	}

}
