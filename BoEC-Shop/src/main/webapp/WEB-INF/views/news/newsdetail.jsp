<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Tin tức</title>
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
                            <span>Tin tức</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="sort-choice">
                            <div class="sort-by-type">
                                <h3>Danh mục</h3>
                                <ul class="list-choice">
                                    <li><a href="#">Desktop</a></li>
                                    <li><a href="#">Laptop</a></li>
                                    <li><a href="#">Máy tính bảng</a></li>
                                    <li><a href="#">Camera</a></li>
                                    <li><a href="#">Điện tử</a></li>
                                    <li><a href="#">Phụ kiện khác</a></li>
                                </ul>
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

                        <div class="news-container">
                            <div class="title-group">
                                <h2>Tin mới</h2>
                            </div>
                            <div id="news-upload" class="owl-container">
                                <div class="owl">
                                    <div class="news-item item">
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-01.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">công nghệ bảo mật bằng vân tay</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-02.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">phụ kiện kết nối</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-03.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">mẹo vặt cho smart phone</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-04.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">bản update mới nhất cho windows phone</a></h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="news-item item">
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-01.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">công nghệ bảo mật bằng vân tay</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-02.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">phụ kiện kết nối</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-03.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">mẹo vặt cho smart phone</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-04.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">bản update mới nhất cho windows phone</a></h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="news-item item">
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-01.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">công nghệ bảo mật bằng vân tay</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-02.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">phụ kiện kết nối</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-03.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">mẹo vặt cho smart phone</a></h2>
                                            </div>
                                        </div>
                                        <div class="item-inner first">
                                            <div class="image-container">
                                                <a href="#" class="news-image">
                                                    <img src="images/news/blog-sm-04.jpg">
                                                </a>
                                            </div>
                                            <div class="des-container">
                                                <h2 class="news-name"><a href="#">bản update mới nhất cho windows phone</a></h2>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tag-container">
                            <div class="title-group">
                                <h2>Tags</h2>
                            </div>
                            <div class="tag-list">
                                <ul>
                                    <li><a href="#">Mẹo vặt</a></li>
                                    <li><a href="#" class="active">Công nghệ</a></li>
                                    <li><a href="#">Sale</a></li>
                                    <li><a href="#">Máy ảnh</a></li>
                                    <li><a href="#">Điện tử</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9">
                        <div class="news-detail">
                            <div class="news-detail-image">
                                <img src="images/news/blog-10.jpg" alt="" class="img-responsive">
                            </div>
                            <div class="item">
                                <div class="item-inner">
                                    <h2 class="product-name"><a href="">Apple sẽ phát hành Ipad 9.7 inch giá rẻ hơn vào năm sau</a></h2>
                                    <div class="blog-attr">
                                        <span>Đăng bởi: <a href="#">Admin</a></span>
                                        <span class="separator">|</span>
                                        <span>05 Tháng 9, 2017</span>
                                    </div>
                                    <div class="desc">
                                        <p>Vào tháng 3 năm nay, lần đầu tiên Apple trình làng mẫu iPad 9.7 inch với giá chỉ 329 USD. Song Digitimes mới đây còn cho biết, Táo khuyết đang lên kế hoạch tung ra một iPad 9.7 inch giá chỉ 259 USD vào năm sau.</p>
                                        <p>Trang 9to5mac dẫn lại báo cáo của Digitimes rằng: Apple muốn đưa máy tính bảng giá rẻ của mình về các thị trường đang phát triển hoặc các công ty, doanh nghiệp. Bởi hiện tại, doanh số iPad của Apple đã phải đối mặt với sự sụt giảm mạnh.</p>
                                        <p>Trong 3 năm gần đây, doanh số bán hàng của iPad đã giảm sụt mạnh sau khi đạt mức cao kỷ lục vào năm 2013-2014. Tạm thời thì năm 2017 này, doanh thu iPad đã có sự hồi phục nhờ Apple tung ra iPad 329 USD và một bản nâng cấp cho iPad Pro.</p>
                                        <p>Hiện chưa rõ iPad 259 USD mới sẽ ra mắt cùng với phiên bản 329 USD hay nó sẽ thay thế hoàn toàn phiên bản cũ. Nhiều khả năng thông số kỹ thuật của iPad giá rẻ 2018 sẽ giống như các model iPad hiện tại.</p>
                                        <p>Báo cáo còn cho rằng, iPad giá rẻ sẽ được sản xuất bởi Compal Electronics và có thể đến quý 2/2018 nó mới trình làng.</p>
                                        <p>Không chỉ có cấu hình mạnh mẽ, iPad Pro 9.7 inch còn sở hữu độ dày chỉ 6.1 mm, mỏng hơn cả iPhone 7. Hiện mẫu máy tính bảng này đang được giảm giá khá tốt tại Thế Giới Di Động.</p>
                                        <p>Cụ thể hơn, nếu bây giờ bạn đặt mua online iPad Pro 9.7 inch Wifi 32GB sẽ chỉ phải trả số tiền là 13.690.000 đồng, thay vì giá thường 14.490.000 đồng mua trực tiếp tại siêu thị. Tuy nhiên, chương trình giá rẻ online có hạn (đến hết 31/8/2017).</p>
                                        <p>Về cấu hình, iPad Pro 9.7 inch Wifi 32GB có màn hình 2K, dùng chip Apple A9X, kết hợp với RAM 2GB và được hỗ trợ nâng cấp lên iOS 11. Máy có camera trước 5MP, camera sau 12MP quay phim 4K, tích hợp cảm biến vân tay trên phím Home và dung lượng pin 7.350 mAh.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
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
