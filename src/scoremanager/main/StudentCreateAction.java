package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String entYearStr = null;      // 入力された入学年度
		String studentNum = "";   // 入力された学生番号
		String studentName = "";  // 入力された氏名
		String classNum = "";         // 入力されたクラス番号
		int entYear = 0;              // 入学年度
		LocalDate todaysDate = LocalDate.now();  // LocalDateインスタンスを取得
		int year = todaysDate.getYear();  // 現在の年を取得
		ClassNumDao cNumDao = new ClassNumDao();  // クラス番号Daoを初期化


		// DBからデータ取得
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());

		// 数値に変換
		if (entYearStr != null) {
			entYear = Integer.parseInt(entYearStr);
		}

		// リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年前から10年後までの年をリストに追加
		for (int i = year - 10; i <= year + 10; i++) {
			entYearSet.add(i);
		}

		// レスポンス値をセット
		// リクエストに入学年度をセット
		req.setAttribute("ent_year_set", entYearSet);
		// リクエストに学生番号をセット
		req.setAttribute("no", studentNum);
		// リクエストに氏名をセット
		req.setAttribute("name", studentName);
		// リクエストにクラス番号をセット
		req.setAttribute("class_num_set", list);

		// フォワード
		req.getRequestDispatcher("student_create.jsp").forward(req, res);
	}
}
