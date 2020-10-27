package ksys.salse.test.empDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ksys.sales.dao.ConnectionManager;
import ksys.sales.dao.EmployeeDAO;
import ksys.sales.entity.Employee;

public class TestInsertEmpDAO {

	public static void main(String[] args) {
		Connection con = null;

		try {
			 con =ConnectionManager.getConnection();
			 System.out.println("OK");

			 EmployeeDAO empDAO = new EmployeeDAO(con);
			 ArrayList<Employee> empList = new ArrayList<Employee>();
			 empList.add(new Employee("kamoshida",20,"Tokyo"));
			 empList.add(new Employee("sato",30,"Osaka"));
			 empList.add(new Employee("kimura",40,"Okinawa"));

			 boolean result = empDAO.empInsertDAO(empList);
			 System.out.println(result);

		} catch (SQLException e) {
			System.out.println("NG");
			e.printStackTrace();
		}finally {
			try {
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
