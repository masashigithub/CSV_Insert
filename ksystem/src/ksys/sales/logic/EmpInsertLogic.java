package ksys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ksys.sales.common.BusinessException;
import ksys.sales.common.SystemException;
import ksys.sales.dao.ConnectionManager;
import ksys.sales.dao.EmployeeDAO;
import ksys.sales.entity.Employee;

public class EmpInsertLogic {

	/**
	 * 従業員リストを登録
	 * @param empList
	 * @return
	 * @throws SystemException
	 * @throws BusinessException
	 */
	public boolean insertEmp(ArrayList<Employee> empList) throws SystemException, BusinessException {

		Connection con = null;
		boolean result= false;

		try {
			con = ConnectionManager.getConnection();
			EmployeeDAO empDAO = new EmployeeDAO(con);
			result = empDAO.empInsertDAO(empList);
			if (!result) {
				throw new BusinessException("登録が失敗しました。確認して再度ファイルを配置してください。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
