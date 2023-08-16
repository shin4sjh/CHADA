<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/source/src/main/webapp/resources/css/storelist.css">
<meta charset="UTF-8">
<title>전체 물품</title>
</head>
<body>

	<main>
		<div doz_type="row" doz_grid="12" class="doz_row">
			<div doz_type="grid" doz_grid="12" class="col-dz col-dz-12">
				<div doz_type="widget" id="w20201013909c95be0157f">
					<div class="_widget_data " data-widget-name="메뉴/카테고리"
						data-widget-type="sub_menu" data-widget-anim="none"
						data-widget-anim-duration="0.7" data-widget-anim-delay="0"
						data-widget-parent-is-mobile="N">
						<div class="widget">
							<div
								class="nav sub-menu sub_menu_hide  h-menu-type1 menu-horizontal row-cnt-3 row-cnt-mobile-3">
								<ul class="">

									<li style="" class="depth-01  active   active-real   "
										data-code="#"><a href="/#" data-url="$"
										data-has_child="N" data-is_folder_menu="N"
										class=" _fade_link   active   active-real "> <span
											class="plain_name" data-hover="">Bean</span>
									</a></li>

									<li style="" class="depth-01    " data-code="#"><a
										href="/#" data-url="23" data-has_child="N"
										data-is_folder_menu="N" class=" _fade_link   "> <span
											class="plain_name" data-hover="">Bakery</span>
									</a></li>

									<li style="" class="depth-01    " data-code="#"><a
										href="/#" data-url="#" data-has_child="N"
										data-is_folder_menu="N" class=" _fade_link   "> <span
											class="plain_name" data-hover="">Variation</span>
									</a></li>

									<li style="" class="depth-01    "
										data-code="m20230814747e425371e37"><a href="/#"
										data-url="#" data-has_child="N" data-is_folder_menu="N"
										class=" _fade_link   "> <span class="plain_name"
											data-hover="">MD</span>
									</a></li>

								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div doz_type="row" doz_grid="12" class="doz_row">
			<div doz_type="grid" doz_grid="12" class="col-dz col-dz-12">
				<div doz_type="widget" id="w202306115706a78bb09fd">
					<div class="_widget_data _ds_animated_except" data-widget-name="여백"
						data-widget-type="padding" data-widget-parent-is-mobile="N">
						<div class="widget padding" data-height="15"
							style="margin-top: px; margin-bottom: px;">
							<div id="padding_w202306115706a78bb09fd"
								style="width: 100%; min-height: 1px; height: 15px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div doz_type="row" doz_grid="12" class="doz_row">
			<div doz_type="grid" doz_grid="12" class="col-dz col-dz-12">
				<div doz_type="widget" id="w20200929ff1f5ef9e101d">
					<div class="_widget_data " data-widget-name="쇼핑"
						data-widget-type="shopping" data-widget-anim=""
						data-widget-anim-duration="" data-widget-anim-delay=""
						data-widget-parent-is-mobile="N">
						<div class="shop-content widget">
							<div class="shop-grid">
								<div class="thumb-fluid _item_container show_rendering ">
									<div class="shop-tools clearfix" style="display: none">
										<div class="down-btn" style="display: none">
											<select class="form-control" name="deliv_option_type"
												onchange="document.location.href = encodeURI('/1740509625/?sort='+$(this).val())"
												title="정렬 바꾸기">
												<option value="recent" selected="">등록순</option>
												<option value="like">인기순</option>
												<option value="min_price">낮은가격순</option>
												<option value="max_price">높은가격순</option>
												<option value="comment">상품평 많은순</option>
												<option value="abc">이름순</option>
												<option value="descabc">이름역순</option>
											</select>
										</div>
									</div>
									
									<c:forEach items="${storeList }" var="store">
									<c:forEach items="${store.sattachFileList }" var="file">
									<div
										class="thumb-row m-list-type2 hover_image thumb-item-4 _item_wrap "
										id="container_w20200929ff1f5ef9e101d"
										style="visibility: visible; margin: 50px;">
										<div class="shop-item _shop_item"
											style="width: 313px; padding: 0px; height: 325px;">
											<div class="item-wrap" style="position: relative;">

												<a href="${pageContext.request.contextPath}/store/detail"
													class="_fade_link shop-item-thumb hover_img_none">
													<img data-prodcode="#" alt="${store.sellName }"
													src="${pageContext.request.contextPath}/${file.filePath }" alt="${store.sellName }" height="200" width="200"
													class="_org_img org_img _lazy_img"
													
													style="display: inline;">
													<div class="item-overlay">
														<div class="item-pay">
															<div>
																<h2>${store.sellName }</h2>
																
																<div class="ns-icon clearfix">
																	<!--<span class="new bg-brand">NEW</span>-->
																	<div class="prod_icon text-danger icon_default best">
																		BEST <p class="pay inline-blocked" style="">9,000원</p> </div>
																</div>
															</div>
														</div>
													</div>
												</a>
											</div>
										</div>
									</div>
									</c:forEach>
									</c:forEach>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
		<div doz_type="row" doz_grid="12" class="doz_row">
			<div doz_type="grid" doz_grid="12" class="col-dz col-dz-12">
				<div doz_type="widget" id="w202306123bdcab6a26c08">
					<div class="_widget_data _ds_animated_except" data-widget-name="여백"
						data-widget-type="padding" data-widget-parent-is-mobile="N">
						<div class="widget padding" data-height="40"
							style="margin-top: px; margin-bottom: px;">
							<div id="padding_w202306123bdcab6a26c08"
								style="width: 100%; min-height: 1px; height: 40px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
















	<%--  [[ ${storeList }  ]] 
<c:forEach items="${storeList }" var="store">
<div>${store.sellName }</div>
	<c:forEach items="${store.sattachFileList }" var="file">
		<div><img src="${pageContext.request.contextPath}/${file.filePath }" alt="${storeList }" height="200" width="200">
		<p>${store.sellName }</p>
		
		</div>
			<div>${file.filePath }</div>
	</c:forEach>
	
	<hr>
</c:forEach>  --%>
</body>
</html>