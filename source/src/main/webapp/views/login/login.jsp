<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
.form {
display:inline-bloxk;
text-align:center;

}

.table {
margin-left:auto;
margin-right:auto;

}

</style>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<script>
	var msg = '${msg}';
	if(msg){
		alert(msg);
	}
</script>
	<div>
		<div>
			<div class="form">
				<img alt="차다" src="<%=request.getContextPath()%>/resources/images/chada2.png" width="187">
				<h2>로그인</h2>
				<form action="<%=request.getContextPath() %>/login.login" method="post">
					<table class="table">
						<tr>						
							<td> id: </td> <td> <input type="text" name="memberId" required="required"><br> </td>
						</tr>
						<tr>
							<td> pw: </td> <td> <input type="password" name="memberPassword" required="required"><br> </td>
						</tr>					
					</table>
					<button type="submit">로그인</button>
					<button type="button">회원가입 : TODO</button>
				</form>
			
			</div>
		</div>
	</div>
</body>
</html>