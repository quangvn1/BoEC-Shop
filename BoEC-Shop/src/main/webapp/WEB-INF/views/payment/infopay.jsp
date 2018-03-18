<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Thanh toán</title>
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
        <jsp:include page="layouts/_header.jsp"></jsp:include> <!--End Header-->

            <div class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9-offset-3">
                            <form action="pay" method="POST">
                                <div class="row">
                                    <br><br>
                                    <div class="col-md-5">
                                        <div class="add-title">
                                            <div>Tên khách hàng:</div>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <input type="text" name="fullname" value="${user.fullName}" class="input-text add-product" readonly>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="add-title">
                                            <div>Email:</div>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <input type="text" name="email" value="${user.email}" class="input-text add-product" readonly>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="add-title">
                                            <div>Số điện thoại:</div>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <input type="text" name="tel" value="${user.tel}" class="input-text add-product" readonly>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="add-title">
                                            <div>Khung giờ nhận hàng:</div>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <select class="input-text add-product" name="time">
                                            <option value="1">Trong giờ hành chính</option>
                                            <option value="0">Ngoài giờ hành chính</option>
                                        </select>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="add-title">
                                            <div>Địa chỉ nhận hàng: </div>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <input type="text" name="address" class="input-text add-product">
                                    </div>
                                    <div class="col-md-7 col-offset-5">
                                        <input type="submit" value="Xác nhận" class="btn add-btn">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div> <!--End Content-->

        <jsp:include page="layouts/_footer.jsp"></jsp:include><!--Footer bot-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </body>
</html>
