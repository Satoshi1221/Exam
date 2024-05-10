package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao {

	private String baseSql = "select * from student where school_cd=?";

	private List<TestListSubject> postFilter(ResultSet rSet) throws Exception {
		// リストを初期化
		List<TestListSubject> list = new ArrayList<>();
		try {
			// リザルトセットを全件走査
			while (rSet.next()) {
				// テスト・教科インスタンスを初期化
				Test test = new Test();
				Student student = new Student();
				School school = new School();
				Subject subject = new Subject();
				// 生徒インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				// 教科インスタンスに検索結果をセット
				subject.setCd(rSet.getString("subject_cd"));
				subject.setName(rSet.getString("name"));
				subject.setSchool(school);
				// テストインスタンスに検索結果をセット
				test.setClassNum(rSet.getString("class_num"));
				test.setNo(rSet.getInt("no"));
				test.setPoint(rSet.getInt("point"));
				test.setSchool(school);
				test.setStudent(student);
				test.setSubject(subject);
				// リストの追加
				list.add(test);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<TestListSubject> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
		// リストを初期化
		List<TestListSubject> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(
					"select * from test join student on test.student_no = student.no where ent_year = ? and test.class_num = ? and test.no = ? order by student_no");
			// プリペアードステートメントに入学年度をバインド
			statement.setInt(1, entYear);
			// プリペアードステートメントにクラス番号をバインド
			statement.setString(2, classNum);
			// プリペアードステートメントに教科コードをバインド
			statement.setString(3, subject.getCd());
			// プリペアードステートメントに回数をバインド
			statement.setInt(4,num);
			// プリペアードステートメントを実行
			rSet = statement.executeQuery();
			// リストへの格納処理を実行
			list = postFilter(rSet,school);
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		// コネクションを閉じる
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				throw sqle;
			}
		}
			return list;
		}
	}
}