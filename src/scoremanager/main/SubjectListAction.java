package scoremanager.main;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;



public class SubjectListAction extends Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
//		Teacher teacher = (Teacher)session.getAttribute("user");
		School school = new School();
		school.setCd("tes");
		school.setName("テスト校");

		Teacher teacher = new Teacher();
		teacher.setId("admin1");
		teacher.setName("管理者");
		teacher.setPassword("password");
		teacher.setSchool(school);

//		メンバ変数の定義１
		String Cd="";
		String Name="";
		int entYear =0;
		boolean isAttend = false;
		List<Subject> subjects = null;
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		StudentDao sDao = new StudentDao();
		ClassNumDao cNumDao = new ClassNumDao();
		Map<String, String> errors = new HashMap<>();

		Cd = request.getParameter("f1");
		Name = request.getParameter("f2");


		List<String> list = cNumDao.filter(teacher.getSchool());

//		if (entYear !=0 && !classNum.equals("0")){
//			students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
//		} else if (entYear != 0 && classNum.equals("0")){
//			students = sDao.filter(teacher.getSchool(), entYear, isAttend);
//		} else if (entYear == 0 && classNum == null ||  entYear != 0 && classNum.equals("0")){
//			students = sDao.filter(teacher.getSchool(), isAttend);
//		} else {
//			errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
//			request.setAttribute("errors", errors);
//
//			students = sDao.filter(teacher.getSchool(), isAttend);
//		}
//
//		if (entYearStr != null) {
//			entYear = Integer.parseInt(entYearStr);
//		}
//		List<Integer> entYearSet = new ArrayList<>();
//		for (int i = year - 10; i < year + 1; i ++) {
//			entYearSet.add(i);
//		}

		request.setAttribute("f1", Cd);
		request.setAttribute("f2", Name);
		request.setAttribute("subjects", subjects);
		request.setAttribute("class_num_set", list);
//		request.setAttribute("ent_year_set", entYearSet);

		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
	}
}

