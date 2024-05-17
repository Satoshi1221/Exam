package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		Subject subject = new Subject();
		SubjectDao sDao = new SubjectDao();

		// リクエストパラメーターの取得
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		School school = teacher.getSchool();

		subject.setCd(no);
		subject.setName(name);
		subject.setSchool(school);

		sDao.delete(subject);

		req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
	}
}
