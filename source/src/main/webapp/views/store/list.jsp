<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>전체 물품</title>
<style>
.wrap-grid.store{
display:grid;
grid-template-columns:auto auto;
}
.btn-black{
background-color: gray;
}
</style>
</head>
<body>
<script>
	var msg = '${msg}';
	if(msg){
		alert(msg);
	}
</script>
<jsp:include page="/views/header.jsp"></jsp:include>

<section id="latest-blog" class="padding-large overflow-hidden">
    <div class="container">
      <div class="row">
        <div class="section-header text-center">
          <h2 class="section-title">CHADA</h2>
          <p>store</p>
        </div>
        <div class="row d-flex flex-wrap">
          
          		<c:forEach items="${storeList }" var="store">
          <article class="col-md-4 post-item">
            <div class="image-holder">
            	<c:forEach items="${store.sattachFileList }" var="file">
                <img src="${pageContext.request.contextPath}/${file.filePath }" width="100%" alt="post" class="post-image">
                </c:forEach>
            </div>
            <div class="post-content">
              <div class="post-header text-center">
                <h3 class="post-title">
                  <a href="single-post.html">${store.sellName }</a>
                </h3>
                <p>단위 당: ${store.priceUnit }원</p>
              </div>
            </div>
          </article>
       	</c:forEach> 
          
          
          
        </div>
        <div class="btn-center">
          <a href="#" class="btn btn-medium btn-black">위로</a>
        </div>
      </div>
    </div>
  </section>






  <%-- [[ ${storeList }  ]]
<div class="wrap-grid store">
	<c:forEach items="${storeList }" var="store">
	<div class="card" style="width: 18rem;">
		<c:forEach items="${store.sattachFileList }" var="file">
	  		<img src="${pageContext.request.contextPath}/${file.filePath }" class="card-img-top" alt="...">
		</c:forEach>
	  <div class="card-body">
	    <h5 class="card-title">>${store.sellName }</h5>
	    <p class="card-text">${store.priceUnit }</p>
	    <a href="#" class="btn btn-primary">Order</a>
	  </div>
	</div>
	</c:forEach>  --%>
</div> 

<jsp:include page="/views/footer.jsp"></jsp:include>

</body>
</html>