<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Đăng kí</title>
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
        <jsp:include page="_header.jsp"></jsp:include> <!--End Header-->

            <div class="content">
                <div class="sitemap">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <span><a href="home">Trang chủ</a></span>
                                <span>Đăng kí</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
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
                        </div>

                        <div class="col-md-9">
                        <c:choose>
                            <c:when test="${msg==null}">
                                <form action="registration" method="POST">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Tên đăng nhập:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <input type="text" name="username" class="input-text add-product">
                                        </div>
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Mật khẩu:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <input type="password" name="password" class="input-text add-product">
                                        </div>
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Tên khách hàng:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <input type="text" name="fullName" class="input-text add-product">
                                        </div>
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Giới tính:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <select class="input-text add-product" name="gender">
                                                <option value="nam">Nam</option>
                                                <option value="nu">Nữ</option>
                                            </select>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Email:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <input type="text" name="email" class="input-text add-product">
                                        </div>
                                        <div class="col-md-5">
                                            <div class="add-title">
                                                <div>Số điện thoại:</div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <input type="text" name="tel" class="input-text add-product">
                                        </div>
                                        <div class="col-md-7 col-offset-5">
                                            <input type="submit" name="" value="Xác nhận" class="btn add-btn">
                                        </div>
                                    </div>
                                </form>
                            </c:when>
                            <c:when test="${msg!=null}">
                                <div class="row">
                                    <div class="text-center" style="color: red">${msg}</div>
                                </div>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div> <!--End Content-->

        <jsp:include page="_footer.jsp"></jsp:include><!--Footer bot-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </body>
</html>
