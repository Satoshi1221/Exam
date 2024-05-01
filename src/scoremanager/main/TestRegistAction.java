package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import bean.Teacher;
import dao.ClassNumDao;
=======
import bean.Subject;
import bean.Test;
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		HttpSession session = req.getSession();

		List<String> classList = new ArrayList<>();

		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String classNum =

		Teacher teacher = (Teacher)session.getAttribute("user");s
		String classNum = "";

		ClassNumDao cDao = new ClassNumDao();
		classList = cDao.filter(teacher.getSchool());
		String entYearStr = "";



		Class_Num class_num = new Class_Num();
		Subject subject = new Subject();
		Test test = new Test();


		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}


	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {


		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	private void setRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{


		return ;

	}
}