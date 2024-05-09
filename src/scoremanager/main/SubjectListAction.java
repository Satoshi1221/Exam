package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();  // セッション
		Util util = (Util)session.getAttribute("user");

		Teacher teacher = getUser(req);
		ClassNumDao cNumDao = new ClassNumDao();
		LocalDate todaysDate = LocalDate.now();  // LocalDateインスタンスを取得
		int year = todaysDate.getYear();

		String Cd = "";  // 入力された入学年度
		String Name = "";  // 入力されたクラス番号
		List<Subject> subject = null;  // 学生リスト
		StudentDao sDao = new StudentDao();  // 学生Dao
		Map<String, String> errors = new HashMap<>();  // エラーメッセージ



		// リクエストパラメーターの取得
		Cd = req.getParameter("f1");
		Name = req.getParameter("f2");

		// DBからデータ取得
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());

		//↓？？？
		if (entYear != 0 && !classNum.equals("0")) {
			// 入学年度とクラス番号を指定
			students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
		} else if (entYear != 0 && classNum.equals("0")) {
			// 入学年度のみ指定
			students = sDao.filter(teacher.getSchool(), entYear, isAttend);
		} else if (entYear == 0 && classNum == null || entYear == 0 && classNum.equals("0")) {
			// 指定なしの場合
			// 全学生情報を取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		} else {
			errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
			req.setAttribute("errors", errors);
			// 全学生情報を取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		}

		// ビジネスロジック
		if (entYearStr != null) {
			// 数値に変換
			entYear = Integer.parseInt(entYearStr);
		}
		// リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年前から１年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		// レスポンス値をセット
		// リクエストに入学年度をセット
		req.setAttribute("f1", Cd);
		// リクエストにクラス番号をセット
		req.setAttribute("f2", Name);
		// リクエストに学生リストをセット
		req.setAttribute("students", students);
		// リクエストにデータをセット
		req.setAttribute("class_num_set", list);
		req.setAttribute("ent_year_set", entYearSet);

		// JSPへフォワード
		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
	}

}
