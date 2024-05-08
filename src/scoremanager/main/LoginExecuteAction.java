package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;
import tool.Action;

public class LoginExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.login(id, password);

		if (teacher != null) {
			teacher.setAuthenticated(true);
			session.setAttribute("user", teacher);
			req.getRequestDispatcher("menu.jsp").forward(req, res);
			return;
		}

		req.setAttribute("id", id);
		req.setAttribute("password", password);
		req.getRequestDispatcher("login.jsp").forward(req, res);

	}
}
