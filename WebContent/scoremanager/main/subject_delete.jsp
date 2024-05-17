<%-- 学生変更JSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>
			<form action="SubjectDeleteExecute.action">
				<p>「${subject.cd}${subject.name}」を削除してもよろしいですか</p>
				<input type="hidden" name="no" value="${subject.cd}">
				<input type="hidden" name="name" value="${subject.name}">
				<button type="submit" >削除</button>
				<a href="SubjectList.action">戻る</a>
			</form>
		</section>
	</c:param>
</c:import>
