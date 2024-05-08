package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;
import bean.Teacher;

public class TeacherDao extends Dao {

	public Teacher get(String id) {

	}

	public Teacher login(String id, String password) throws Exception {

		// Teacher, Schoolクラスの変数にnullを設定（ID、パスワードが一致しないときnullを返すため）
		Teacher teacher = null;
		School school = null;

		// データベースへのコネクションを確立
		Connection con = getConnection();
		// プリペアードステートメント
		PreparedStatement st = null;

		try {
			// プリペアードステートメントにSQL文をセット
			st = con.prepareStatement("select * from teacher join school on teacher.school_cd = school.school_cd where id = ? and password = ?");
			// IDとパスワードをバインド
			st.setString(1, id);
			st.setString(2, password);
			// プリペアードステートメントを実行
			ResultSet rs = st.executeQuery();

			// リザルトセットを走査
			while (rs.next()) {
				// ID、パスワードが一致すればインスタンスを生成
				teacher = new Teacher();
				school = new School();

				// teacher, schoolインスタンスにフィールド値をセット
				teacher.setId(rs.getString("id"));
				teacher.setName(rs.getString("teacher_name"));
				teacher.setPassword(rs.getString("password"));
				school.setCd(rs.getString("school_cd"));
				school.setName(rs.getString("school_name"));
				teacher.setSchool(school);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (st != null) {
				try {
					st.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションをを閉じる
			if (con != null) {
				try {
					con.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return teacher;
	}
}
