<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
header {
    height: 93px;
    position: static;
    z-index: 1000
}
a {
        text-decoration: none
    }
header,
header .inner {
    align-items: center;
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
    width: 1200px
}

header .inner .logo a {
    display: flex
}

header .menu-list {
    display: flex;
    gap: 70px
}

header .menu-list .list-item a {
    position: relative
}

header .menu-list .list-item a:after {
    border-bottom: 2px solid #98EECC;
    bottom: -5px;
    content: "";
    left: 0;
    position: absolute;
    transition: .5s ease;
    width: 0
}

header .menu-list .list-item:hover>a {
    color: #98EECC;
    font-weight: 700
}

header .menu-list .list-item:hover>a:after {
    width: 100%
}

header .menu-list .list-item {
    padding: 34px 0 !important
}

header .menu-list .list-item>a {
    font-size: 16px
}

 .dEzzaX {
     width: 100%;
     position: sticky;
     top: 0px;
     background-color: rgba(255, 255, 255, 0.9);
 }
</style>

<header width="100%" id="header"
	class="sc-gLLvby dEzzaX sc-fHekdT hDfwhw">
	<div class="inner">
		<h1 class="logo">
			<a href="<%=request.getContextPath()%>/store/list"> <!-- <img src="https://www.banapresso.com/from_open_storage?ws=fprocess&amp;file=banapresso/open/logo/h_logo_3138e3904929.png" alt="Banapresso"> -->
				<img src="<%=request.getContextPath()%>/resources/images/chada1.png" width="87" alt="logo">
			</a>
		</h1>
		<ul class="menu-list">
		<c:choose>
			<c:when test="${empty SsLoginNo }">
			<li class="list-item"><a href="<%=request.getContextPath()%>/login"><span>로그인</span></a></li>
			</c:when>
			<c:otherwise>
			<li class="list-item"><a href="<%=request.getContextPath()%>/login.logout"><span>로그아웃</span></a></li>
			</c:otherwise>		
		</c:choose>
			<li class="list-item"><a href="<%=request.getContextPath()%>/store/list"><span>메뉴</span></a></li>
			<li class="list-item"><a href="<%=request.getContextPath()%>/board/list"><span>게시판</span></a></li>
			<li class="list-item"><a href="<%=request.getContextPath()%>/article/list"><span>칼럼</span></a></li>
			<li class="list-item"><a href="<%=request.getContextPath()%>/mypage/search"><span>마이페이지</span></a></li>
		</ul>
	</div>

</header>