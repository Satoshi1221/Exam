<%-- 学生登録JSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 px-2 px-4">科目情報登録</h2>
			<form action="SubjectCreateExecute.action" method="post">
				<div class="">
					<label>科目コード</label>
				</div>
				<div>
					<p><input size="90" type="text" name="cd" value="${cd}" maxlength="3" required placeholder="科目コードを入力してください">
				</div>
				<div>
					<label>科目名</label>
				</div>
				<div>
					<p><input size="90" type="text" name="name" value="${name}" maxlength="20" required placeholder="科目名を入力してください">
				</div>
				<button class="btn btn-secondary" id="filter-button">登録</button>
			</form>
			<a href="SubjectList.action">戻る</a>
		</section>
	</c:param>
</c:import>
