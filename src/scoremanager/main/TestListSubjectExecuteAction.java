package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import bean.Test;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();  // セッション
		Teacher teacher = (Teacher)session.getAttribute("user");

		//入力された値をいれる
		String entYear = ""; //入学年度
		String classNum = ""; //クラス
		String score = ""; //科目成績データ

		//チェック
		if (entYear == null) {
			Test.setEntYear(entYear);
			Test.setclassNum(classNum);
			Test.setPoint(point);
			req.getRequestDispatcher("test_list.jsp").forward(req, res);
		} else {
			Test.setEntYear(entYear);
			Test.setclassNum(classNum);
			Test.setPoint(point);
			boolean save = tDao.save(test);
		}

		//リクエストパラメータ取得
		entYear = req.getParameter("1"); //入学年度
		classNum = req.getParameter("2"); //クラス
		score = req.getParameter("3"); //科目成績データ

		//レスポンス値入れる
		req.setAttribute("1",entYear);
		req.setAttribute("2",classNum);
		req.setAttribute("3",score);

		//フォワード{
			req.getRequestDispatcher("test_list_student.jsp").forward(req, res);{

		}


	}
}
