package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		SubjectDao sDao = new SubjectDao();
		String no = req.getParameter("no");
		School school = teacher.getSchool();

		// 入力された科目コードの詳細データを取得
		Subject subject = sDao.get(no, school);

		// レスポンス値をセット
		req.setAttribute("subject", subject);

		// フォワード
		req.getRequestDispatcher("subject_delete.jsp").forward(req, res);
	}
}
