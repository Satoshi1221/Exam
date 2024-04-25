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
		<section class="login">
			<h2 class="login-headline">ログイン</h2>
			<ul>
				<li>ログインに失敗しました。IDまたはパスワードが正しくありません。</li>
			</ul>
			<form action="LoginExecute.action" method="post">
				<div class="id-input">
					<input type="text" name="id" maxlength="20" style="ime-mode: active" placeholder="半角でご入力ください" required>
				</div>
				<div class="password-input">
					<input type="password" name="password" id="inputPassword" maxlength="20" style="ime-mode: active" placeholder="20文字以内の半角英数字でご入力ください" required>
				</div>
				<div class="password-disp">
					<input type="checkbox" name="chk_d_ps" id="inputCheckbox">
					<label for="password-disp-check">パスワードを表示</label>
				</div>
				<div class="login-button">
					<input type="submit" value="ログイン">
				</div>
			</form>
		</section>
	</c:param>
</c:import>
