<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
<jsp:include page="/views/header.jsp"></jsp:include>
<c:choose>
	<c:when test="${not empty bvo }">
		<h2>제목 : ${bvo.boardCode }</h2>
	</c:when>
	<c:otherwise>
		<script>
			alert("해당하는 글을 읽을 수 없습니다. 다시 글 선택해주세요.");
			location.href="${pageContext.request.contextPath}/board/list";
		</script>
	</c:otherwise>
</c:choose>
	<div>
		<input type="hidden" name="board_code" value="${bvo.boardCode }">
		제목:<input type="text" name="board_code" value="${bvo.boardCode }" readonly>
		<br>
		내용:<textarea rows="10" cols="50" name="bcontent" value="${bvo.boardCode }" readonly></textarea>
		<br>
		<c:forEach items="${bvo.battachFileList }" var="filevo">
			svg는 img 태그로 안보일 수 있음<br>
			<object data="${pageContext.request.contextPath}/${filevo.filepath }" width="200"></object>
			<br>
		</c:forEach>
		<hr>
		<c:if test="${not empty SsLoginNo }">
			<c:if test="${SsLoginNo eq bvo.memberNo }">
				<button type="button" id="btn-board-update">글 수정</button>
				<button type="button" id="btn-board-delete">글 삭제</button>
			</c:if>
		</c:if>
		<button type="button" id="btn-board-reply">댓글달기</button>
		<button type="button" id="btn-board-list">글목록으로 이동</button>
	</div>
	<script>
		$("#btn-add-file").click(function(){
			var cnt = $("[type=file]").length+1;
			htmlVal = '<div>파일첨부(name에 field명 작성하지 말자!) : <input type="file" name="a-'+cnt+'"><button type="button" class="btn-delete-file">파일삭제</button></div>';
			$("#add-file").append(htmlVal);
			$(".btn-delete-file").off('click');
			$(".btn-delete-file").on('click', function(){
				$(this).parent().remove();
			});
		});
		$("#btn-board-list").click(function(){
			location.href="${pageContext.request.contextPath}/board/list";
		});
	</script>
	
	<jsp:include page="/views/footer.jsp"></jsp:include>
</body>
</html>