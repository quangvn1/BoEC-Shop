<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Danh sách sản phẩm</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <link rel="icon" type="text/x-icon" href="images/logo.png">
        <link rel="stylesheet" type="text/css" href="styles/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="styles/css/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="styles/css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="styles/css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <!-- Script -->
        <script type="text/javascript" src="styles/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="styles/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="styles/js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="styles/js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="styles/js/main.js"></script>
    </head>
    <body>
        <jsp:include page="layouts/_header.jsp"></jsp:include> <!--Header-->

            <div class="content">
                <div class="sitemap">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <span><a href="home">Trang chủ</a></span>
                                <span>Sản phẩm hot</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="title-choice">
                                <div>Sắp xếp theo</div>
                            </div>
                            <div class="sort-choice">
                                <div class="sort-by-firm">
                                    <h3>Lọc theo hãng</h3>
                                    <ul class="list-choice">
                                        <li><a href="#">canon</a></li>
                                        <li><a href="#">samsung</a></li>
                                        <li><a href="#">apple</a></li>
                                        <li><a href="#">nikon</a></li>
                                        <li><a href="#">dell</a></li>
                                        <li><a href="#">sony</a></li>
                                    </ul>
                                </div>
                                <div class="sort-by-price">
                                    <h3>Lọc theo giá</h3>
                                    <form>
                                        <span><input type="text" name="" class="input-text" value="0"></span>
                                        <span><input type="text" name="" class="input-text" value="999"></span>
                                        <button type="submit" name="" class="btn">Tìm</button>
                                    </form>
                                </div>
                            </div>
                            <div class="banner-left"><a href="#"><img src="images/ads/ads-01.jpg" alt=""></a>
                                <div class="banner-content">
                                    <h1>Giảm giá tới</h1>
                                    <h2>20%</h2>
                                    <p>số lượng có hạn</p>
                                    <a href="#">Mua ngay</a>
                                </div>
                            </div>

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
                                                                <div class="price"><fmt:formatNumber type="number" value="${special.price}" /></div>
                                                            </div>
                                                            <div class="old-price">
                                                                <div class="price"><fmt:formatNumber type="number" value="${special.oldPrice}" /></div>
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
                        <div class="ads">
                            <div class="banner"><a href="#"><img alt="" src="images/ads/ads-05.jpg"></a></div>
                        </div>

                        <div class="page-title">
                            <h1>danh sách sản phẩm</h1>
                        </div>

                        <div class="show-list-product">
                            <div class="tool-bar">
                                <div class="icon-page hot-page"></div>
                            </div>
                            <div class="list-product row">
                                <c:forEach items="${listProduct}" var="product">
                                    <div class="col-md-3 col-sm-6">
                                        <div class="product-item item">
                                            <div class="item-inner">
                                                <div class="image-container">
                                                    <a href="#" class="product-image" style="height: 200px; width: 150px">
                                                        <img src="${product.image}">
                                                    </a>
                                                    <div class="box-hover">
                                                        <ul>
                                                            <li><a href="productdetail?id=${product.id}" class="quickview">Chi tiết</a></li>
                                                            <li><a href="#" class="favorite">Quan tâm</a></li>
                                                            <li><a href="#" class="compare">So sánh</a></li>
                                                                <c:if test="${user!=null}">
                                                                <li><a href="addtocart?id=${product.id}" class="addtocart">Mua ngay</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="des-container">
                                                    <h2 class="product-name"><a href="#">${product.name}</a></h2>
                                                    <div class="price-container">
                                                        <div class="new-price">
                                                            <div class="price"><fmt:formatNumber type="number" value="${product.price}" /></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul> 
                        </div>
                    </div>
                </div>
            </div>
        </div> <!--End Content-->


        <jsp:include page="layouts/_footer.jsp"></jsp:include><!--Footer-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </body>
</html>
