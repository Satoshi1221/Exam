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
					<c:forEach name=""></c:forEach></form></section></c:param></c:import>