package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		SubjectDao sDao = new SubjectDao();  // 科目Dao
		String cd = "";  // 科目コード
		String name = "";  // 科目名
		Subject subject = null;//学生
		Map<String, String> errors = new HashMap<>();// エラーメッセージ
		Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得

		//リクエストパラメータ―の取得 2
		cd = req.getParameter("cd");  // 科目番号
		name = req.getParameter("name");  // 科目名

		// DBからデータを取得
		subject = sDao.get(cd, teacher.getSchool());

		//ビジネスロジック 4
		//DBへデータ保存 5
		//条件で手順4~5の内容が分岐
		if (cd.length() != 3) {
			errors.put("cd", "科目コードは3文字で入力してください");
		} else {
			if (subject == null) {
				subject = new Subject();
				subject.setCd(cd);
				subject.setName(name);
				subject.setSchool(teacher.getSchool());
				// DBに保存
				sDao.save(subject);
			} else {
				errors.put("cd", "科目コードが重複しています");
			}
		}

		if(!errors.isEmpty()){
			// リクエスト属性をセット
			req.setAttribute("errors", errors);
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			req.getRequestDispatcher("subject_create.jsp").forward(req, res);
			return;
		}
		req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
	}
}
