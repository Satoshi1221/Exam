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
							<select>
								<option value="0">--------</option>
							</select>
						</th>
					</tr>
				</table>
			</form>
		</section>
	</c:param>
</c:import>
