<%-- ログインJSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">メニュー</h2>


			<div class="col d-flex align-items-center justify-content-center mx-2 rounded shadow"

				style="width:200px;  height:100px; float:left; background-color: #dbb;">

				<a href="StudentList.action">学生管理</a>
			</div>

			<div class="col text-center  mx-2 rounded shadow"
				style="width:200px;  height:100px; float:left;  background-color: #99cc99;">
				<div>成績管理</div>
				<a href="TestRegist.action">成績登録</a><br>
				<a href="TestList.action">成績参照</a>
			</div>

			<div class="col d-flex align-items-center justify-content-center mx-2 rounded shadow"
				style="width:200px;  height:100px; float:left;  background-color: #9999CC;">
				<a href="SubjectList.action">科目管理</a>
			</div>

		</section>
	</c:param>
</c:import>
