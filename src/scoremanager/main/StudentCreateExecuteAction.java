package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String entYearStr = req.getParameter("ent_year");
		int entYear = Integer.parseInt(entYearStr);
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String classNum = req.getParameter("class_num");
		Student student = new Student();
		StudentDao sDao = new StudentDao();

		student.setSchool(teacher.getSchool());

		if (entYear == 0) {
			student.setNo(no);
			student.setName(name);
			student.setClassNum(classNum);
			req.getRequestDispatcher("student_create.jsp").forward(req, res);
		} else {
			student.setEntYear(entYear);
			student.setNo(no);
			student.setName(name);
			student.setClassNum(classNum);
			boolean save = sDao.save(student);

			if (save == true) {
				req.getRequestDispatcher("student_create_done.jsp").forward(req, res);
			} else {
				req.getRequestDispatcher("student_create.jsp").forward(req, res);
			}
		}

	}
}
