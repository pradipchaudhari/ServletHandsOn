import java.util.*;

public class EmpDao {

	static List<Emp> employeeList = new ArrayList<Emp>() {

		private static final long serialVersionUID = -1170947989690724535L;

		{
			add(new Emp(1, "Pradip", "Male", "pradip.chaudhari@gmail.com",
					"India"));
			add(new Emp(2, "Amit", "Male", "amit.patel@gmail.com", "India"));
			add(new Emp(3, "Priti", "Female", "priti.patel@gmail.com", "UK"));
		}
	};

	public static boolean save(Emp e) {
		int employeId = employeeList.size();
		e.setId(++employeId);
		return employeeList.add(e);
	}

	public static boolean update(Emp e) {
		for (Emp emp : employeeList) {
			if (emp.getId() == e.getId()) {
				emp.setName(e.getName());
				emp.setGender(e.getGender());
				emp.setEmail(e.getEmail());
				emp.setCountry(e.getCountry());
				return true;
			}
		}
		return false;

	}

	public static boolean delete(int id) {
		for (Emp emp : employeeList) {
			if (emp.getId() == id) {
				return employeeList.remove(emp);
			}
		}
		return false;
	}

	public static Emp getEmployeeById(int id) {

		for (Emp emp : employeeList) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

	public static List<Emp> getAllEmployees() {
		return employeeList;
	}
}
