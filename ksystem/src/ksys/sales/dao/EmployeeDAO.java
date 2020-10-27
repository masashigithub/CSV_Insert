package ksys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ksys.sales.entity.Employee;

public class EmployeeDAO {

	/**
	 * DB接続オブジェクト
	 */
	private Connection con = null;

	/**
	 * コンストラクタ
	 * @param con
	 */
	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 従業員リストをemployeeテーブルに登録する
	 * @param empList
	 * @return
	 * @throws SQLException
	 */
	public boolean empInsertDAO(ArrayList<Employee> empList) throws SQLException {

		String sql = "insert into employee (name, age, adress) values (?, ?, ?)";
		PreparedStatement stmt = null;
		Boolean result = false;
		int num = 0;

		try {
			stmt = con.prepareStatement(sql);
			for(Employee emp:empList){
				stmt.setString(1, emp.getName());
				stmt.setInt(2, emp.getAge());
				stmt.setString(3, emp.getAdress());
				num = stmt.executeUpdate();
			}

			if(num > 0){
				result = true;
			}
		} finally {
			if(stmt != null){
				stmt.close();
			}

		}

		return result;

	}

}
