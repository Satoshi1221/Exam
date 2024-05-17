package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDao extends Dao {

	public Subject get(String cd, School school) throws Exception {
		// 教科インスタンスを初期化
		Subject subject = new Subject();
		// データベースへのコネクションを確立
		Connection con = getConnection();
		// プリペアードステートメント
		PreparedStatement st = null;

		try {
			// プリペアードステートメントにSQL文をセット
			st = con.prepareStatement("select * from subject where cd=?");
			// プリペアードステートメントに学生番号をバインド
			st.setString(1, cd);
			// プリペアードステートメントを実行
			ResultSet rSet = st.executeQuery();

			if (rSet.next()) {
				// リザルトセットが存在する場合
				// 教科インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
				subject.setSchool(school);
			} else {
				// リザルトセットが存在しない場合
				// 教科インスタンスにnullをセット
				subject = null;
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
		// コネクションを閉じる
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sqle) {
				throw sqle;
				}
			}
		}

		return subject;
	}

	public List<Subject> filter(School school) throws Exception {
		// リストを初期化
		List<Subject> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from subject where school_cd = ?");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, school.getCd());
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			// リストへの格納処理を実行
			try {
				// リザルトセットを全件走査
				while (rSet.next()) {
					// 学生インスタンスを初期化
					Subject subject = new Subject();
					// 学生インスタンスに検索結果をセット
					subject.setCd(rSet.getString("cd"));
					subject.setName(rSet.getString("name"));
					subject.setSchool(school);
					// リストに追加
					list.add(subject);
				}
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}

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

	public boolean save(Subject subject) throws Exception {
		// コネクションを確立
		Connection con = getConnection();
		// プリペアードステートメント
		PreparedStatement st = null;
		// 実行件数
		int count = 0;
		String cd = subject.getCd();
		School school = subject.getSchool();

		try {
			// データベースから科目を取得
			Subject old = get(cd, school);
			if (old == null) {
				// 科目が存在しなかった場合
				// プリペアードステートメントにINSERT文をセット
				st = con.prepareStatement(
					"insert into subject(school_cd, cd, name) values(?, ?, ?)");
				// プリペアードステートメントに値をバインド
				st.setString(1, school.getCd());
				st.setString(2, cd);
				st.setString(3, subject.getName());
			} else {
				// 科目が存在した場合
				// プリペアードステートメントにUPDATE文をセット
				st = con.prepareStatement("update subject set school_cd = ?, name = ? where cd = ?");
				// プリペアードステートメントに値をバインド
				st.setString(1, school.getCd());
				st.setString(2, subject.getName());
				st.setString(3, cd);
			}
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

	public void delete(Subject subject) throws Exception {
		// コネクションを確立
		Connection con = ds.getConnection();

		// SQL文
		PreparedStatement st = con.prepareStatement(
			"delete from subject where cd = ?");
		st.setString(1, subject.getCd());

		st.executeUpdate();
		// プリペアードステートメントを閉じる
		st.close();
		// コネクションを閉じる
		con.close();
	}
}
