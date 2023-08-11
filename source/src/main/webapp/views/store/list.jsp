<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 물품</title>
</head>
<body>
[[ ${storeList }  ]]
<c:forEach items="${storeList }" var="store">
	<div>${store.sellName }</div>
	<c:forEach items="${store.sattachFileList }" var="file">
		<div><img src="${pageContext.request.contextPath}/${file.filePath }"></div>
		<div>${file.filePath }</div>
	</c:forEach>
	<hr>
</c:forEach> 
</body>
</html>