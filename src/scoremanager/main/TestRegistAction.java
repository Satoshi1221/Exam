package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		List<String> classList = new ArrayList<>();

		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String classNum
		ClassNumDao cDao = new ClassNumDao();
		classList = cDao.filter(teacher);

	}

	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {

	}
}
