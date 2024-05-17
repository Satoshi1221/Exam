package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		Subject subject = new Subject();
		SubjectDao sDao = new SubjectDao();
		School school = teacher.getSchool();

		// リクエストパラメーターの取得
		String no = req.getParameter("no");
		String name = req.getParameter("name");

		subject.setCd(no);
		subject.setName(name);
		subject.setSchool(school);

		// 更新
		sDao.save(subject);

		// フォワード
		req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
	}
}
