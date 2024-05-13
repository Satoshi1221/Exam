package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class TestListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// セッションからユーザーデータを取得
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		ClassNumDao cDao = new ClassNumDao();
		SubjectDao sDao = new SubjectDao();
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		List<Integer> entYearSet = new ArrayList<>();

		// 10年前から１年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		// セッションのユーザーデータから学校のクラスデータを取得
		List<String> classNumSet = cDao.filter(teacher.getSchool());
		// セッションのユーザーデータから学校の科目データを取得
		List<Subject> subjectSet = sDao.filter(teacher.getSchool());

		// レスポンス値をセット
		req.setAttribute("ent_year_set", entYearSet);
		req.setAttribute("class_num_set", classNumSet);
		req.setAttribute("subject_set", subjectSet);

		// フォワード
		req.getRequestDispatcher("test_list.jsp").forward(req, res);
	}

	private void setTestListSubject(HttpServletRequest req, HttpServletResponse res) {

	}

	private void setTestListStudent(HttpServletRequest req, HttpServletResponse res) {

	}
}
