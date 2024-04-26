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
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
		HttpSession session = req.getSession();
<<<<<<< HEAD
		List<String> classList = new ArrayList<>();

		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String classNum =
=======
<<<<<<< HEAD
		Teacher teacher = (Teacher)session.getAttribute("user");s
		String classNum = "";
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
		ClassNumDao cDao = new ClassNumDao();
		classList = cDao.filter(teacher.getSchool());
		String entYearStr = "";

=======

		Class_Num class_num = new Class_Num();
		Subject subject = new Subject();
		Test test = new Test();
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}
<<<<<<< HEAD

	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {


		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
=======
	private void setRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
<<<<<<< HEAD


=======
		return ;
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
	}
}