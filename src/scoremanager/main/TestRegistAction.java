package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;
import tool.Util;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
<<<<<<< HEAD

=======
<<<<<<< HEAD
		Teacher teacher = (Teacher)session.getAttribute("user");
=======
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

		List<String> classList = new ArrayList<>();

		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String classNum =

		Teacher teacher = (Teacher)session.getAttribute("user");
		String classNum = "";

		ClassNumDao cDao = new ClassNumDao();
		classList = cDao.filter(teacher.getSchool());
		String entYearStr = "";


<<<<<<< HEAD
=======
=======
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

<<<<<<< HEAD
		// 変数を用意
		String entYearStr = "";  // 入力された入学年度
		int entYear = 0;
		String classNum = "";  // 入力されたクラス番号
		School school = teacher.getSchool();
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		String countStr = "";  // 入力されたテストの回数
		int count = 0;
		SubjectDao subjectDao = new SubjectDao();
		TestDao testDao = new TestDao();
		String subjectCd;
		List<Test> tests = null;
=======
		Class_Num class_num = new Class_Num();
		Subject subject = new Subject();
		Test test = new Test();

<<<<<<< HEAD
=======
=======
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

		// リクエストパラメーターの取得
		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		subjectCd = req.getParameter("f3");
		countStr = req.getParameter("f4");

		Subject subject = subjectDao.get(subjectCd, school);

		if (entYearStr != null) {
			entYear = Integer.parseInt(entYearStr);
		}

		if (countStr != null) {
			count = Integer.parseInt(countStr);
		}

		// 入力値をもとに成績データを取得
		// 入力値のチェック
		if (entYear == 0 || classNum.equals("0") || subjectCd.equals("0") || count == 0) {

		} else {
			tests = testDao.filter(entYear, classNum, subject, count, school);
		}

		// リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年前から１年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		// レスポンス値をセット
		setRequestData(req, res);
		req.setAttribute("count", count);
		req.setAttribute("tests", tests);
		req.setAttribute("subject", subject);


		// フォワード
		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git

	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {
<<<<<<< HEAD
		Util util = new Util();
		util.setClassNumSet(req);
		util.setEntYearSet(req);
		util.setSubjects(req);
=======


		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	private void setRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{

	private void setRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{


		return ;

<<<<<<< HEAD

=======
=======
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
	}
}
