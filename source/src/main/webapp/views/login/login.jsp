<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h2>로그인</h2>
			<form action="<%=request.getContextPath() %>/login.login" method="post">
				id: <input type="text" name="memberId" required="required"><br>
				pw: <input type="password" name="memberPassword" required="required"><br>
				<button type="submit">로그인</button>
				<button type="button">회원가입 : TODO</button>
			</form>
		</div>
	</div>
</body>
</html>