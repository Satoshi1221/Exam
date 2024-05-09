<%-- 学生一覧JSP --%>
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
			<h2>成績参照</h2>
			<div >
			科目情報
			</div>

			<form action="TestListSubjectExecute.action" method="post">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">
						<th>入学年度</th>
						<select class="form-select" name="f1">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set}">
								<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-4">
						<th>クラス</th>
						<select class="form-select" name="f2">
							<option value="0">--------</option>
							<c:forEach var="class" items="${ent_class_set}">
								<option value="${year}" <c:if test="${year==f2}">selected</c:if>>${year}</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-4">
						<th>科目</th>
						<select class="form-select"  name="f3">
							<option value="0">--------</option>
							<c:forEach var="subject" items="${class_subject_set}">
								<option value="${subject}" <c:if test="${subject==f3}">selected</c:if>>${subject}</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>

					<div class="col-4">
						<hidden  name="f">
							<c:forEach var="f" items="${class_f_set}">
								<option value="${sb}" <c:if test="${sb==f}">selected</c:if>>${sb}</option>
							</c:forEach>
						</hidden>
					</div>

				</div>
			</form>



				<p>学生情報</p>

			<form action="TestListSubjectExecute.action" method="post">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">

					<div class="col-4">
						<div>学生番号</div>
						<text class="form-text"  name="f4">
							<input value="学生番号を入力してください"></input>
							<c:forEach var="f4" items="${ent_f4_set}">
								<option value="${f4}" <c:if test="$f4==f4}">selected</c:if>>${f4}</option>
							</c:forEach>
						</text>
					</div>

					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>

					<div class="col-4">
						<hidden  name="f">
							<c:forEach var="f" items="${class_f_set}">
								<option value="${st}" <c:if test="${st==f}">selected</c:if>>${st}</option>
							</c:forEach>
						</hidden>
					</div>

					<div class="mt-2 text-warning">${erros.get("f1")}</div>
				</div>
			</form>

			<c:choose>
				<c:when test="${students.size()>0}">
					<div>科目：${students.size()}</div>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>科目</th>

							<th></th>
							<th></th>
						</tr>
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.entYear}</td>
								<td>${student.no}</td>
								<td>${student.name}</td>
								<td>${student.classNum}</td>

							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>科目情報を選択または学生ボタンを入力して検索ボタンをクリックしてください</p>
				</c:otherwise>
			</c:choose>
		</section>
	</c:param>
</c:import>
