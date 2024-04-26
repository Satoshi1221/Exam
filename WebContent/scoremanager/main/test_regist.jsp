<%-- 成績管理一覧JSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="score">
			<h2>成績管理</h2>
			<form action="TestRegist.action" method="post">
				<table>
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>科目</th>
						<th>回数</th>
					</tr>
					<tr>
						<th>
							<select name="f1">
								<option value="0">--------</option>
								<c:forEach var="year" items="${ent_year_set}">
									<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select name="f2">
								<option value="0">--------</option>
								<c:forEach var="num" items="${class_num}">
									<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select name="f3">
								<option value="0">--------</option>
								<c:forEach var="subject" items="${subject_set}">
									<option value="${subject.cd}" <c:if test="${subject.cd==f3}">selected</c:if>>${subject}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select class="f4">
								<option value="0">--------</option>
								<c:forEach var="count" begin="1" end="5">
									<option value=count>${count}</option>
								</c:forEach>
							</select>
						</th>
					</tr>
				</table>
				<button class="btn btn-secondary" id="filter-button">検索</button>
			</form>
				<c:if test="${students.size()}>0">
					<h2>科目：${subject}（${count}回）</h2>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>点数</th>
						</tr>
						<c:forEach var="student" items="${students}">
							<tr>
								<th>${student.entYear}</th>
								<td>${student.classNum}</td>
								<td>${student.no}</td>
								<td>${student.name}</td>
								<td><input type="text" name="point_${student.no}"></td>
							</tr>
						</c:forEach>
					</table>
					<button class="btn btn-secondary" id="filter-button">登録して終了</button>
				</c:if>
		</section>
	</c:param>
</c:import>
