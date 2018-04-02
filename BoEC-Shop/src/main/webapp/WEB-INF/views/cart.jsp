<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Giỏ hàng</title>
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
        <jsp:include page="layouts/_header.jsp"></jsp:include> <!--End Header-->
            <div class="content">
                <div class="sitemap">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <span><a href="/BoEC-Shop/">Trang chủ</a></span>
                                <span>Giỏ hàng</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="carts">
                        <div class="table-responsive">
                        <c:if test="${msg!=null}">
                            <p style="color: red">${msg}</p>
                        </c:if>
                        <c:if test="${listProduct.size()>0}">
                            <table class="table custom-table">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Hình ảnh</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listProduct}" var="list">
                                        <tr>
                                            <td>
                                                <div class="text-center">
                                                    <a href="#">${list.product.getName()}</a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="#" class="product-image">
                                                    <img src="${list.product.getImage()}">
                                                </a>
                                            </td>
                                            <td>
                                                <div class="text-center">
                                                    <fmt:formatNumber type="number" value="${list.amount}" />
                                                </div>
                                                <!--                                                <div class="input-group">
                                                                                                    <span class="input-group-btn">
                                                                                                        <button class="btn" type="button">-</button>
                                                                                                    </span>
                                                                                                    <input type="text" class="form-control" value="1">
                                                                                                    <span class="input-group-btn">
                                                                                                        <button class="btn" type="button">+</button>
                                                                                                    </span>
                                                                                                </div>-->
                                            </td>
                                            <td>
                                                <div class="dongia">
                                                    <fmt:formatNumber type="number" value="${list.product.getPrice()}" />
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-center">
                                                    <a href="/BoEC-Shop/cart/deleteincart?id=${list.product.getId()}" class="fa fa-trash-o btn-remove"></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!--                        <div class="text-right">
                                                    <a href="index.html" class="btn btn-default1 btn-md">TIẾP TỤC MUA HÀNG</a>
                                                    <button type="submit" class="btn btn-danger1 btn-md">CẬP NHẬT GIỎ HÀNG</button>
                                                </div>-->
                        <!--<div class="line2"></div>-->
                        <div class="row">
                            <div class="col-sm-4">

                            </div>
                            <div class="col-sm-4">

                            </div>
                            <div class="col-sm-4">
                                <table class="table table-cart-total">
                                    <tr>
                                        <td>Tổng giá trị giỏ hàng:</td>
                                        <td class="text-right" style="color: red"><fmt:formatNumber type="number" value="${amount}" />đ</td>
                                    </tr>
                                </table>
                                <div class="text-right">
                                    <p><a href="pay" class="btn btn-danger1 btn-md fwb">THANH TOÁN</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if><!--End Content-->

        <jsp:include page="layouts/_footer.jsp"></jsp:include><!--Footer bot-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </body>
</html>
