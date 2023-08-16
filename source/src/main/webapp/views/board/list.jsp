<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>


<style>
<jsp:include page="/resources/css/boardlist.css"></jsp:include>
.wrap-flex{
	display: flex;
}
.wrap-grid{
	display:grid;
	grid-template-columns: auto auto auto auto auto;
}
.new{
    background-color : skyblue;
	color: white;
}
</style>
</head>
<body>
<jsp:include page="/views/header.jsp"></jsp:include>
<div>

<c:choose>
			<c:when test="${empty SsLoginNo }">
			
			</c:when>
			<c:otherwise>
			[ ${SsLoginId } ] 접속중 
			</c:otherwise>		
		</c:choose>


<script>
	var msg = '${successFailMsg}';
	if(msg){
		alert(msg);
	}
</script>
<%-- <c:choose>
	<c:when test="${not empty SsLoginId }">
<form action="<%=request.getContextPath() %>/login.logout" method="post">
<a href="${pageContext.request.contextPath}/board/list">로그아웃</a>
</form>
	</c:when>
	<c:otherwise>
<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:otherwise>
</c:choose> --%>

</div>

<div class="navbar">
  <a href="#">자유</a>
  <a href="#">질의응답</a>
  <a href="<%=request.getContextPath()%>/article/list" class="right">칼럼</a>
</div>

<div class="row">
  <div class="main">
    <h2>게시글</h2>
    <div><a class="new" href="<%=request.getContextPath()%>/board/write">새글등록</a></div>
    <div class="wrap-grid">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>옵션</div>	
<c:if test="${not empty boardList }">
	<c:forEach items="${boardList }" var="vo">
		<div>${vo.boardCode }</div>
		<div>
		<a href="<%=request.getContextPath()%>/board/read?boardCode=${vo.boardCode }">
		<c:forEach begin="1" end="${vo.boardLevel }">
		&#8618; 
		</c:forEach>
		${vo.boardTitle }
		</a>
		</div>
		<div>${vo.memberId }</div>
		<div>${vo.boardDate }</div>
		<div><a href="<%=request.getContextPath()%>/board/write?boardCode=${vo.boardCode }">답글</a></div>
	</c:forEach>
</c:if>
	</div>
  </div>
</div>
	
<jsp:include page="/views/footer.jsp"></jsp:include>
</body>
</html>