package bean;

import java.io.Serializable;
import java.util.Map;

public class TestListSubject implements Serializable {

	private int entYear;
	private String studentNo;
	private String studentName;
	private String classNum;
	private Map<Integer, Integer> points;

	public TestListSubject() {

	}

	public int getEntYear() {
<<<<<<< HEAD

	}

	public void setEntYear(int entYear) {

	}

	public String getStudentNo() {

	}

	public void setStudentNo(String studentNo) {

	}

	public String getStudentName() {

	}

	public void setStudentName(String studentName) {

	}

	public String getClassNum() {

	}

	public void setClassNum(String classNum) {

	}

	public Map<Integer, Integer> getPoints() {

	}

	public void setPoints(Map<Integer, Integer> points) {

	}

	public String getPoint(int key) {

	}

	public void putPoint(int key, int value) {

	}
}
=======
		return entYear;
	}

	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String student_no) {
		this.studentNo = student_no;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String student_name) {
		this.studentName = student_name;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public Map<Integer,Integer> getPoints() {
		return points;
	}

	public void setPoints(Map<Integer,Integer> points) {
		this.points = points;
	}

	public String getPoint(int key) {
		return String.valueOf(points.get(key));
	}

	public void putPoint(int key, int value) {
		points.put(key, value);
	}

}
>>>>>>> branch 'master' of https://github.com/Satoshi1221/Exam.git
