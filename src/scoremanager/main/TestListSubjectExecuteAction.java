package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();  // セッション
		Teacher teacher = (Teacher)session.getAttribute("user");

		//入力されたやつぶち込む
		String entYear = ""; //入学年度
		String classNum = ""; //クラス
		String point = ""; //科目成績データ
		boolean save = tDAO.save(test);

		//リクエストパラメータ取得(いる？)
		entYear = req.getParameter("1"); //入学年度
		classNum = req.getParameter("2"); //クラス
		point = req.getParameter("3"); //科目成績データ

		//レスポンス値ぶち込む
		req.setAttribute("1",entYear);
		req.setAttribute("2",classNum);
		req.setAttribute("3",point);

		//フォワード
		if (save == true) {
			req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
		} else {
		req.getRequestDispatcher("test_list.jsp").forward(req, res);
		}

	}
}
