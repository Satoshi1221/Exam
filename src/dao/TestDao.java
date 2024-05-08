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

public class TestDao extends Dao {

	private String baseSql = "select * from test";

	public Test get(Student student, Subject subject, School school, int no) {

	}

	private List<Test> postFilter(ResultSet rSet, School school) {
		// リストを初期化
		List<Test> list = new ArrayList<>();
		try {
			// リザルトセットを全件走査
			while (rSet.next()) {
				// テスト・教科インスタンスを初期化
				Test test = new Test();
				Student student = new Student();
				Subject subject = new Subject();
				// 生徒インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(school);
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
				// リストに追加
				list.add(test);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
		// リストを初期化
		List<Test> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(
				"select * from test join student on test.student_no = student.no where ent_year = ? and test.class_num = ? and subject_cd = ? and test.no = ? order by student_no");
			// プリペアードステートメントに入学年度をバインド
			statement.setInt(1, entYear);
			// プリペアードステートメントにクラス番号をバインド
			statement.setString(2, classNum);
			// プリペアードステートメントに教科コードをバインド
			statement.setString(3, subject.getCd());
			// プリペアードステートメントに回数をバインド
			statement.setInt(4, num);
			// プライベートステートメントを実行
			rSet = statement.executeQuery();
			// リストへの格納処理を実行
			list = postFilter(rSet, school);
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
	}

		return list;
	}

	public boolean save(List<Test> list) throws Exception {
		Connection con = getConnection();  // コネクションを確立
		boolean flg = false;  // フラグ
		int count = 0;  // 実行件数

		// DBに保存
		for (int i = 0; i < list.size(); i++) {
			save(list.get(i), con);
			flg = true;  // 実行されたらtureに
		}

		if (flg) {
			// 実行件数1以上
			return true;
		} else {
			// 実行件数0
			return false;
		}
	}

	private boolean save(Test test, Connection con) throws Exception {
		// プリペアードステートメント
		PreparedStatement st = null;
		// 実行件数
		int count = 0;
		// 入力された点数を取り出す
		int point = test.getPoint();

		try {
			st = con.prepareStatement("update test set point = ?");
			st.setInt(1, point);
			// プリペアードステートメントを実行
			count = st.executeUpdate();

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
			// コネクションを閉じる
			if (con != null) {
				try {
					con.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			// 実行件数が１件以上ある場合
			return true;
		} else {
			// 実行件数が0件の場合
			return false;
		}
	}

	public boolean delete(List<Test> list) {

	}

	private boolean delete(Test test, Connection connection) {

	}

}
