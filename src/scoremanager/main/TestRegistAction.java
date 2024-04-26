package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

<<<<<<< HEAD
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String classNum = "";
		ClassNumDao cDao = new ClassNumDao();
		classList = cDao.filter(teacher.getSchool());
=======
		String entYearStr = "";
		String classNum = "";
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

	}

	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {


		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}
}
