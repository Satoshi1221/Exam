package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Test;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();

		Class_Num class_num = new Class_Num();
		Subject subject = new Subject();
		Test test = new Test();

		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}
	private void setRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{


	}
}