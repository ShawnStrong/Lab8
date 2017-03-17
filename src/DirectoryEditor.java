
import java.util.*;

import com.google.gson.Gson;

public class DirectoryEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean off = false;
		boolean off2 = false;
		Scanner console = new Scanner(System.in);
		String in;
		DirectoryProxy s = new DirectoryProxy();
		
		while(!off2){
			System.out.println("Enter a command CLR, ADD, PRINT, OR EXIT");
			in = console.nextLine();
			if(in.equalsIgnoreCase("add")){
				off2 = false;
				while(!off){
					System.out.println("Add someone: [first] [last] [dept] [phone] or End to end.");
					in = console.nextLine();
					if(in.equalsIgnoreCase("end")){
						off = true;
					}else{
						s.add(in);
					}
					
				}
			}else if(in.equalsIgnoreCase("print")){
				s.print();
			}else if(in.equalsIgnoreCase("clr")){
				s.clear();
			}else if(in.equalsIgnoreCase("exit")){
				off2 = true;
			}else{
				System.out.println("Wrong command");
			}
			off = false;
		}
		console.close();
	}

}
