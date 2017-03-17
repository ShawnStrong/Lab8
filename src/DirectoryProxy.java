import java.util.LinkedList;

import com.google.gson.Gson;

public class DirectoryProxy implements Directory {
	LinkedList<Employee> sort = new LinkedList<>();
	MainDirectory dir = new MainDirectory();
	Gson g = new Gson();

	@Override
	public void print() {
		// TODO Auto-generated method stub

		String out = "";
		out = g.toJson(sort);
		dir.reconstruct(out);
		dir.print();
		sort.clear();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		sort.clear();
		dir.clear();

	}

	public void add(String str) {
		// TODO Auto-generated method stub
		sort.add(new Employee(str));
	}

}
