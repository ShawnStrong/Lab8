

public class Employee {
	String start;	
	String first;
	String last;
	String dep;
	String num;
	public Employee(String vars)
	{
		start = vars;
		String[] splitted = start.split("\\s+");
		first = splitted[0];
		last = splitted[1];
		dep = splitted[2];
		num = splitted[3];
	}
	public Employee(String a,String b,String c,String d)
	{
		
		first = a;
		last = b;
		dep = c;
		num = d;
	}
	
	public void print()
	{
		System.out.println(last + ", " + first + ", " + num + ", " + dep);
	}
	
	
}
