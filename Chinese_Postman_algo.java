package DAAProject;

import java.util.ArrayList;

public class Chinese_Postman_algo {

	private ArrayList<ArrayList<String>> pairing_sum = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> gen_pair(ArrayList<Character> odd) {
		
		ArrayList<ArrayList<String>> pairs = new ArrayList<ArrayList<String>>();
		int len = odd.size();
		
		for(int i = 0; i < len-1; i++) {
			ArrayList<String> tmp = new ArrayList<String>();
			for(int j = i+1; j < len; j++) {
				tmp.add(""+odd.get(i)+odd.get(j));
			}
			pairs.add(tmp);
		}
//		print_func(pairs);
		ArrayList<Character> done = new ArrayList<Character>();
		ArrayList<String> last = new ArrayList<String>();
		get_pair(pairs, (pairs.size()+1)/2, 0, done, last);
		
		print_func(pairing_sum);
		return pairs;
		
	}
	
	
	public void get_pair(ArrayList<ArrayList<String>> pairs, int l, int start_index, ArrayList<Character> done, ArrayList<String> last) {
		ArrayList<String> tmp = pairs.get(start_index);
		char c = tmp.get(0).charAt(0);
		boolean flag = false;
		for(int i = 0; i < done.size(); i++) {
			if(done.get(i) == c) {
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			done.add(c);
			
			for(int i = 0; i < tmp.size(); i++) {
				ArrayList<String> lst = new ArrayList<>(last);
				ArrayList<Character> val = new ArrayList<>(done);
				boolean flag1 = false;
				for(int j = 0; j < val.size(); j++) {
					if(tmp.get(i).charAt(1) == (val).get(j)) {
						flag1 = true;
						break;
					}
				}
				
				if(flag1 == false) {
					lst.add(tmp.get(i));
				} else {
					continue;
				}
				
				if(lst.size() == l) {
					pairing_sum.add(lst);
					return;
				} else {
					val.add(tmp.get(i).charAt(1));
					get_pair(pairs, l, start_index+1, done, last);
				}
				
			}
			
		}else {
			get_pair(pairs, l, start_index+1, done, last);
		}
	}
	
	public void print_func(ArrayList<ArrayList<String>> pair) {
		int len = pair.size();
		for(int i = 0; i < len; i++) {
			System.out.println(pair.get(i).toString());
		}
	}
}
