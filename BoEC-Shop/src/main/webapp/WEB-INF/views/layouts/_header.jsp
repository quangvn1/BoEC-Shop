<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="header">
    <div class="topbar">
        <div class="container">
            <div class="topbar-left">
                <ul class="topbar-nav">
                    <li><span class="phone">(0123) 456 789</span></li>
                    <li><span class="email">smartshop@gmail.com</span></li>
                </ul>
            </div>

            <c:choose>
                <c:when test="${user==null}">
                    <div class="topbar-right">
                        <ul class="topbar-nav clearfix">
                            <li data-toggle="modal" data-target="#myModal"><a href="#" class="login">Đăng nhập</a></li>
                            <li><a href="/BoEC-Shop/registration" class="registration">Đăng ký</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:when test="${user!=null}">
                    <div class="topbar-right">
                        <ul class="topbar-nav clearfix">
                            <li><a href="#" class="login">Xin chào, ${fullname}</a></li>
                            <li><a href="/BoEC-Shop/logout" class="registration">Đăng xuất</a></li>
                        </ul>
                    </div>
                </c:when>
            </c:choose>

            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <form id="checkLogin" method="POST" action="/BoEC-Shop/checkLogin" autocomplete="off">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Đăng nhập</h4>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <label class="col-sm-3">Tên đăng nhập</label>
                                    <span>
                                        <input type="text" name="username" id="username" class="input-text"/>
                                    </span>
                                </div>
                                <div class="form-group">
                                    <div>
                                        <label class="col-sm-3">Mật khẩu</label>
                                        <span>
                                            <input type="password" name="password" id="password" class="input-text"/>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <span><input type="submit" id="login" class="btn btn-default1" data-bind="modal" value="Đăng nhập"></span>
                                <!--<span><a id="login" class="btn btn-default1" data-dismiss="modal" onclick="reload()">Đăng nhập</a></span>-->
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div> <!--End Top Bar-->

    <div class="header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="logo">
                        <a href="/BoEC-Shop/" class="logo-img"><img src="images/logo.png" alt=""></a>
                        <span class="logo-text">mart Shop</span>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="service">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="box-container time">
                                    <div class="box-inner">
                                        <h2>Thời gian làm việc</h2>
                                        <div>T2-CN: 8:00-17:30</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="box-container free-ship">
                                    <div class="box-inner">
                                        <h2>Free ship</h2>
                                        <div>Đơn hàng trên 5 triệu</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="box-container hoan-tien">
                                    <div class="box-inner">
                                        <h2>Hoàn tiền 100%</h2>
                                        <div>Trong vòng 14 ngày</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <form class="form-search" action="searchproduct" method="POST">
                        <input type="text" class="input-text" name="key" id="search" placeholder="Tìm kiếm sản phẩm...">
                        <button type="submit" class="btn btn-danger1"><span class="fa fa-search"></span></button>
                    </form>
                    <c:if test="${user!=null}">
                        <div class="cart">
                            <div class="cart-title">
                                <a href="/BoEC-Shop/cart" class="cart-text">Giỏ hàng</a>
                                <c:if test="${cart!=null}">
                                    <span class="amount-cart">(${cart.getTotalAmount()})</span>
                                </c:if>
                                <c:if test="${cart==null}">
                                    <span class="amount-cart">(0)</span>
                                </c:if>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="mega-menu-container visible-lg visible-md">
                        <div class="navleft-container">
                            <div class="mega-menu-title"><h3>Danh mục sản phẩm</h3></div>
                            <div class="mega-menu">
                                <ul class="nav">
                                    <li>
                                        <a href="#">Desktop</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">Laptop</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">Máy tính bảng</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">Smart phone</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">Camera</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">Điện tử</a>
                                        <div class="wrap-sub-menu column2">
                                            <div class="sub-menu">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <h3>hãng</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">canon</a></li>
                                                            <li><a href="#">samsung</a></li>
                                                            <li><a href="#">nikon</a></li>
                                                            <li><a href="#">apple</a></li>
                                                            <li><a href="#">toshiba</a></li>
                                                            <li><a href="#">dell</a></li>
                                                            <li><a href="#">hp</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-6 has-sep">
                                                        <h3>phụ kiện</h3>
                                                        <ul class="nav">
                                                            <li><a href="#">màn hình</a></li>
                                                            <li><a href="#">case</a></li>
                                                            <li><a href="#">ram</a></li>
                                                            <li><a href="#">chuột</a></li>
                                                            <li><a href="#">bàn phím</a></li>
                                                            <li><a href="#">card màn hình</a></li>
                                                            <li><a href="#">khác</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="more">
                                        <a href="">Phụ kiện</a>
                                    </li>
                                    <li class="view-more">
                                        <a href="">Xem thêm</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-9">
                    <ul class="menu clearfix">
                        <li><a href="/BoEC-Shop/">Trang chủ</a></li>
                        <li><a href="listproduct">Sản phẩm</a></li>
                        <li><a href="#">Khuyến mại</a></li>
                        <li><a href="#">Trả góp</a></li>
                        <li><a href="#">Dịch vụ</a></li>
                        <li><a href="news">Tin tức</a></li>
                            <c:if test='${user.getRole().getName().equals("ADMIN")}'>
                            <li><a href="indexadmin">Quản lí</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div> <!--End Header Bottom-->
</div>
