package ksys.sales.action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ksys.sales.common.BusinessException;
import ksys.sales.common.SystemException;
import ksys.sales.entity.Employee;
import ksys.sales.logic.EmpInsertLogic;

public class EmpInsertAction {

	public String insertEmp(HttpServletRequest req) {
		String page = "/EmpInsert.jsp";
		BufferedReader bfReader = null;

		try {
			FileInputStream fInput = new FileInputStream("C:\\Users\\kamos\\Desktop\\sample1.csv");
			InputStreamReader isReader = new InputStreamReader(fInput);
			bfReader = new BufferedReader(isReader);

			ArrayList<Employee> empList = new ArrayList<Employee>();
			String currentContent;
			int row = 0;

			while ((currentContent = bfReader.readLine()) != null) {
				if (row > 0) {
					String[] arrayColumnData = currentContent.split(",");
					Employee emp = new Employee(arrayColumnData[0], Integer.parseInt(arrayColumnData[1]),
							arrayColumnData[2]);
					empList.add(emp);
				}
				row++;
			}

			EmpInsertLogic empLgc = new EmpInsertLogic();
			boolean result = empLgc.insertEmp(empList);

			if(result){
				req.setAttribute("message", "登録が完了しました。");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("message", "ファイルがありません。指定箇所にファイルを配置してください。");
		} catch (IOException e) {
			e.printStackTrace();
			req.setAttribute("message", "テキストがありません");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("message", "内容に誤りがあります。確認して再度ファイルを配置してください。");
		} catch (SystemException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		} catch (BusinessException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		} finally {
			try {
				if(bfReader != null){
					bfReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return page;
	}
}
