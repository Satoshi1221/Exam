package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import bean.Test;
import dao.TestDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();  // セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		Test test = new Test();


		// 入力された値をいれる
		String entYear = req.getParameter("f1"); //入学年度
		String classNum = req.getParameter("f2"); //クラス
		String subject = req.getParameter("f3"); //科目成績データ
		TestDao tDao = new TestDao();

		// 項目が未入力の場合
		if (entYear.equals("0") || classNum.equals("0") || subject.equals("0")) {
			req.getParameter("test_list.jsp");
		}

		// フォワード{
		req.getRequestDispatcher("test_list_student.jsp").forward(req, res);{

		}

	}
}
