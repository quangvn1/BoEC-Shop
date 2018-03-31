<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Trang chủ</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <link rel="icon" type="text/x-icon" href="images/logo.png">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <!-- Script -->
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript" src="https://apis.google.com/js/client.js"></script>
    </head>
    <body>
        <jsp:include page="layouts/_header.jsp"></jsp:include> <!--Header-->
        
            <div class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-md-offset-3">
                            <div class="slider">
                                <div id="ma-slider" class="nivoSlider">
                                    <img src="images/sliders/slide-01.jpg" class="dn" alt="" title="#banner7-caption1"/>
                                    <img src="images/sliders/slide-02.jpg" class="dn" alt="" title="#banner7-caption2"/>
                                </div>
                                <div id="banner7-caption1" class="nivo-html-caption nivo-caption">
                                    <div class="banner7-content slider-1">
                                        <img class="img1" src="images/sliders/img-04.png" alt=""/>
                                    </div>
                                </div>
                                <div id="banner7-caption2" class="nivo-html-caption nivo-caption">
                                    <div class="banner7-content">
                                        <img class="img2" src="images/sliders/img-05.png" alt=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3">
                            <div class="banner-left"><a href="#"><img src="images/ads/ads-01.jpg" alt=""></a>
                                <div class="banner-content">
                                    <h1>Giảm giá tới</h1>
                                    <h2>20%</h2>
                                    <p>số lượng có hạn</p>
                                    <a href="#">Mua ngay</a>
                                </div>
                            </div>

                            <div class="offer-container">
                                <div class="title-group"><h2>Ưu đãi</h2></div>
                                <div id="offer" class="owl-container">
                                    <div class="owl">
                                    <c:forEach items="${listEndow}" var="endow">
                                        <div class="offer-item item">
                                            <div class="image-container">
                                                <a href="#" class="product-image">
                                                    <img src="${endow.image}">
                                                </a>
                                                <div class="countbox_1 timer-grid"></div>
                                            </div>
                                            <div class="content-container">
                                                <h2 class="product-name"><a href="">${endow.name}</a></h2>
                                                <div class="price-container">
                                                    <div class="new-price">
                                                        <div class="price"><fmt:formatNumber type="number" value="${endow.price}"/></div>
                                                    </div>
                                                    <div class="old-price">
                                                        <div class="price"><fmt:formatNumber type="number" value="${endow.oldPrice}"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div><!-- Offer Container -->

                        <div class="special-container">
                            <div class="title-group">
                                <h2>đặc biệt</h2>
                            </div>
                            <div id="special-product" class="owl-container">
                                <div class="owl">
                                    <c:forEach begin="1" end="3">
                                        <div class="special-item item">
                                            <c:forEach items="${listSpecial}" var="special">
                                                <div class="item-inner first">
                                                    <div class="image-container">
                                                        <a href="#" class="product-image">
                                                            <img src="${special.image}">
                                                        </a>
                                                    </div>
                                                    <div class="des-container">
                                                        <h2 class="product-name"><a href="#">${special.name}</a></h2>
                                                        <div class="price-container">
                                                            <div class="new-price">
                                                                <div class="price"><fmt:formatNumber type="number" value="${special.price}"/></div>
                                                            </div>
                                                            <div class="old-price">
                                                                <div class="price"><fmt:formatNumber type="number" value="${special.oldPrice}"/></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9">
                        <div class="hotgroup-container">
                            <div class="title-group1"><h2>Hot</h2></div>
                            <div id="hotproducts" class="owl-container">
                                <div class="owl">
                                    <c:forEach items="${listHot}" var="hot">
                                        <div class="product-item item">
                                            <div class="item-inner">
                                                <div class="image-container">
                                                    <a href="#" class="product-image" style="width: 150px;height: 200px">
                                                        <img src="${hot.image}">
                                                    </a>
                                                    <div class="box-hover">
                                                        <ul>
                                                            <li><a href="productdetail?id=${hot.id}" class="quickview">Chi tiết</a></li>
                                                            <li><a href="#" class="favorite">Quan tâm</a></li>
                                                            <li><a href="#" class="compare">So sánh</a></li>
                                                                <c:if test="${user!=null}">
                                                                <li><a href="addtocart?id=${hot.id}" class="addtocart">Mua ngay</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="des-container">
                                                    <h2 class="product-name"><a href="#">${hot.name}</a></h2>
                                                    <div class="price-container">
                                                        <div class="new-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${hot.price}"/></div>
                                                        </div>
                                                        <div class="old-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${hot.oldPrice}"/></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="ads">
                        <div class="col-md-5">
                            <div class="banner"><a href="#"><img alt="" src="images/ads/ads-02.jpg"></a></div>
                            <div class="banner"><a href="#"><img alt="" src="images/ads/ads-03.jpg"></a></div>
                        </div>
                        <div class="col-md-4">
                            <div class="banner"><a href="#"><img alt="" src="images/ads/ads-04.jpg"></a></div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="salegroup-container">
                            <div class="title-group2"><h2>Khuyến mại</h2></div>
                            <div id="saleproduct" class="owl-container">
                                <div class="owl">
                                    <c:forEach items="${listSaleOff}" var="saleOff">
                                        <div class="product-item item">
                                            <div class="item-inner">
                                                <div class="image-container">
                                                    <a href="#" class="product-image">
                                                        <img src="${saleOff.image}">
                                                    </a>
                                                    <div class="box-hover">
                                                        <ul>
                                                            <li><a href="productdetail?id=${saleOff.id}" class="quickview">Chi tiết</a></li>
                                                            <li><a href="#" class="favorite">Quan tâm</a></li>
                                                            <li><a href="#" class="compare">So sánh</a></li>
                                                                <c:if test="${user!=null}">
                                                                <li><a href="addtocart?id=${saleOff.id}" class="addtocart">Mua ngay</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="des-container">
                                                    <h2 class="product-name"><a href="#">${saleOff.name}</a></h2>
                                                    <div class="price-container">
                                                        <div class="new-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${saleOff.price}"/></div>
                                                        </div>
                                                        <div class="old-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${saleOff.oldPrice}"/></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="ads">
                        <div class="col-md-9">
                            <div class="banner"><a href="#"><img alt="" src="images/ads/ads-17.jpg"></a></div>
                        </div>
                    </div>

                    <div class="col-md-9">
                        <div class="newgroup-container">
                            <div class="title-group3"><h2>Mới</h2></div>
                            <div id="newproduct" class="owl-container">
                                <div class="owl">
                                    <c:forEach items="${listNew}" var="newProduct">
                                        <div class="product-item item">
                                            <div class="item-inner">
                                                <div class="image-container">
                                                    <a href="#" class="product-image" style="height: 200px;width: 150px">
                                                        <img src="${newProduct.image}">
                                                    </a>
                                                    <div class="box-hover">
                                                        <ul>
                                                            <li><a href="productdetail?id=${newProduct.id}" class="quickview">Chi tiết</a></li>
                                                            <li><a href="#" class="favorite">Quan tâm</a></li>
                                                            <li><a href="#" class="compare">So sánh</a></li>
                                                                <c:if test="${user!=null}">
                                                                <li><a href="addtocart?id=${newProduct.id}" class="addtocart">Mua ngay</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="des-container">
                                                    <h2 class="product-name"><a href="#">${newProduct.name}</a></h2>
                                                    <div class="price-container">
                                                        <div class="new-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${newProduct.price}"/></div>
                                                        </div>
                                                        <div class="old-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${newProduct.oldPrice}"/></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!--End Content-->

        <jsp:include page="layouts/_footer.jsp"></jsp:include><!--Footer-->

    </body>
</html>