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
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 px-2 px-4">成績参照</h2>
				<div class="my-2 text-end px-4">
				科目情報
				</div>
				<form action=""method="post">
					<label>入学年度</label>
					<select name="ent_year">
						<option value="0">--------</option>
						<c:forEach var="year" items="${ent_year_set}">
						<<option value="${year}">${year}</option>
						</c:forEach>
					</select>
					<label>クラス</label>
					<select name="class_num">
						<option value="0">--------</option>
						<c:forEach var="num" items="${class_num}">
							<option value="${num}">${num}</option>
						</c:forEach>
					</select>
					<label>科目</label>
					<select name="class_num">
						<option value="0">--------</option>
						<c:forEach var="subject" items="${subject_set}">
							<option value="${subject.cd}">${subject.cd}</option>
						</c:forEach>
					</select>
					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>
					<p class="my-2 text-end px-4">
					学生情報
					</p>
					<label>学生番号</label>
					<input type="text" name="no" value="${no}" maxlength="10" required placeholder="学生番号を入力してください">
					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>
				</form>
				<c:choose>
					<c:when test="${students.size()>0}">
						<div>氏名：${students.name()}</div>
						<table class="table table-hover">
							<tr>
								<th>科目名</th>
								<th>科目コード</th>
								<th>回数</th>
								<th>点数</th>
								<th></th>
								<th></th>
							</tr>
							<c:forEach var="student" items="${students}">
								<tr>
									<td>${subject.name}</td>
									<td>${subject.kode}</td>
									<td>${count}</td>
									<td>${point}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
				</c:choose>
			</section>
		</c:param>
	</c:import>