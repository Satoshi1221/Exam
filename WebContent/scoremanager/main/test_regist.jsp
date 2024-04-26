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
									<option value="${subject.cd}" <c:if test="${subject.cd==f3}">selected</c:if>>${subject.cd}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select class="f4">
								<option value="0">--------</option>
								<c:forEach var="count" items="${count}">
									<option value="${count}">${count}</option>
								</c:forEach>
							</select>
						</th>
					</tr>
				</table>
				<button class="btn btn-secondary" id="filter-button">検索</button>
			</form>
		</section>
	</c:param>
</c:import>
