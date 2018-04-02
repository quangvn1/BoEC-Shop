<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Chi tiết sản phẩm</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <link rel="icon" type="text/x-icon" href="images/logo.png">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
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
    </head>
    <body>
        <jsp:include page="layouts/_header.jsp"></jsp:include><!--End Header-->

            <div class="content">
                <div class="sitemap">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <span><a href="home">Trang chủ</a></span>
                                <span>Chi tiết sản phẩm</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9 col-right">
                            <div class="product-view">
                                <div class="row">
                                    <div class="col-sm-5">
                                        <p class="product-image">
                                            <img src="${product.image}">
                                    </p>
                                </div>
                                <div class="product-inf col-sm-7 col-sm-offset-5">
                                    <div class="product-name">
                                        <h1>${product.name}</h1>
                                        <span class="amount-star">${avg}</span>
                                    </div>
                                    <div class="price-container">
                                        <div class="new-price">
                                            <div class="price"><fmt:formatNumber type="number" value="${product.price}" /></div>
                                        </div>
                                    </div>
                                    <div class="desc std">
                                        ${product.des}
                                    </div>
                                    <form action="/BoEC-Shop/addtocart" method="POST" class="form-horizontal">
                                        <div class="form-group" style="margin-left: 0px;">
                                            <input type="text" value="${product.id}" class="hidden" name="id">
                                            <label class="col-md-2 col-sm-3 control-label">Số lượng:</label>
                                            <div class="col-md-3 col-sm-5">
                                                <div class="input-group qty">
                                                    <span class="input-group-btn">
                                                        <button class="btn sub-btn" type="button">-</button>
                                                    </span>
                                                    <input type="text" name="number" class="form-control qty-text" value="1">
                                                    <span class="input-group-btn">
                                                        <button class="btn add-btn" type="button">+</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <c:if test="${user==null}">
                                            <a class="btn btn-cart btn-danger1" onclick="alert('Hãy đăng nhập để sử dụng chức năng này!');">Đặt hàng</a>
                                        </c:if>
                                        <c:if test="${user!=null}">
                                            <button type="submit" class="btn btn-cart btn-danger1">Đặt hàng</button>
                                        </c:if>
                                        <a class="btn btn-favorite">Yêu thích</a>
                                        <a class="btn btn-compare">So sánh</a>
                                    </form>
                                </div>
                            </div>
                            <div class="product-tab tab-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#product-review" data-toggle="tab">ĐÁNH GIÁ</a></li>
                                    <li class=""><a href="#video-ads" data-toggle="tab">VIDEO</a></li> 
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="product-review">
                                        <div id="danhgia">
                                            <div class="tieude-danhgia">
                                                <div class="heading">Gửi đánh giá của bạn</div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <form action="vote" method="POST">
                                                        <input type="text" value="${product.id}" class="hidden" name="id">
                                                        <div class="stars">
                                                            <input class="star star-5" id="star-5" type="radio" name="star" value="5">
                                                            <label class="star star-5" for="star-5"></label>
                                                            <input class="star star-4" id="star-4" type="radio" name="star" value="4"/>
                                                            <label class="star star-4" for="star-4"></label>
                                                            <input class="star star-3" id="star-3" type="radio" name="star" value="3"/>
                                                            <label class="star star-3" for="star-3"></label>
                                                            <input class="star star-2" id="star-2" type="radio" name="star" value="2"/>
                                                            <label class="star star-2" for="star-2"></label>
                                                            <input class="star star-1" id="star-1" type="radio" name="star" value="1"/>
                                                            <label class="star star-1" for="star-1"></label>
                                                        </div>
                                                        <input type="text" name="comment" class="txtinput">
                                                        <input type="submit" name="" class="btn-danhgia" value="Gửi đánh giá">
                                                    </form>	
                                                </div>
                                            </div>	
                                        </div>
                                        <div class="comment">
                                            <ul>
                                                <c:forEach items="${listRes}" var="listR">
                                                    <li>
                                                        <strong>
                                                            ${listR.firstName}:
                                                        </strong>
                                                        <p>
                                                            ${listR.cmt}
                                                        </p>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div> 
                                    </div>
                                    <div class="tab-pane" id="video-ads">
                                        <h3 style="margin-bottom: 20px;">Video review sản phẩm</h3>
                                        <div id="video-container">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
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

                        <div class="banner-left"><a href="#"><img src="images/ads/ads-01.jpg" alt=""></a>
                            <div class="banner-content">
                                <h1>Giảm giá tới</h1>
                                <h2>20%</h2>
                                <p>số lượng có hạn</p>
                                <a href="#">Mua ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!--End Content-->

        <jsp:include page="layouts/_footer.jsp"></jsp:include><!--Footer bot-->

            <script type="text/javascript">
                $(function () {
                    $('.mega-menu')[0].style.display = "none";
                    $('button.sub-btn').click(function () {
                        var qty = $('input.qty-text').val();
                        if (qty > 1) {
                            qty--;
                            $('input.qty-text').val(qty);
                        }
                    });
                    $('button.add-btn').click(function () {
                        var qty = $('input.qty-text').val();
                        qty++;
                        $('input.qty-text').val(qty);
                    });
                });
                function tplawesome(e, t) {
                    res = e;
                    for (var n = 0; n < t.length; n++) {
                        res = res.replace(/\{\{(.*?)\}\}/g, function (e, r) {
                            return t[n][r];
                        });
                    }
                    return res;
                }
                function init() {
                    gapi.client.setApiKey("AIzaSyAlX1fyuOpfVay_VojvS9XVdgL4oBWBUj8");
                    gapi.client.load("youtube", "v3", function () {
                        search("${product.name} " + "${product.company}");
                    });
                }
                function search(query) {
                    query = query + " review";
                    var request = gapi.client.youtube.search.list({
                        part: 'snippet',
                        q: query,
                        type: 'video',
                        maxResults: 1,
                        order: 'viewCount'
                    });

                    request.execute(function (response) {
                        var result = response.result;
                        $("#video-container").html("");
                        $.get("item.jsp", function (data) {
                            $("#video-container").append(tplawesome(data, [{"videoid": result.items[0].id.videoId}]));
                        });
                    });
                }
        </script>
        <script type="text/javascript" src="https://apis.google.com/js/client.js?onload=init"></script>
    </body>
</html>
