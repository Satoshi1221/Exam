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
			<h2 class="h3 mb-3 fw-norma bg-opacity-10 px-2 px-2 px-4">科目情報変更</h2>
				<label>科目コード</label>
				<input type="text" name="code" value="${code}" maxlength="10" required placeholder="科目コードを入力してください">
				<label>科目名</label>
				<input type="text" name="name" value="${name}" maxlength="20" required placeholder="科目名を入力してください">
				<div class="col-2 text-center">
					<button class="btn btn-secondary" id="filter-button">変更</button>
					<a href="SubjectList.action">戻る</a>
				</div>
		</section>
	</c:param>
</c:import>