$(function(){
	$('.mega-menu-title').click(function(){
		if($('.mega-menu').is(':visible')){
			$('.mega-menu').slideUp();
		} else {
			$('.mega-menu').slideDown();
		}
	})
    $('.mega-menu .nav > li').hover(function(){
    	$(this).addClass("active");
		$(this).find('.sub-menu').stop(true,true).fadeIn('slow');
    },function(){
        $(this).removeClass("active");
		$(this).find('.sub-menu').stop(true,true).fadeOut('slow');
    })
	$('.mega-menu .nav > li.view-more').click(function(e){
		if($('.mega-menu .nav > li.more').is(':visible')){
			$('.mega-menu .nav > li.more').stop().slideUp();
			$(this).find('a').text('Nhiều hơn');
		} else { 
			$('.mega-menu .nav > li.more').stop().slideDown();
			$(this).find('a').text('Đóng');
		}
		e.preventDefault();
	})

	$('#ma-slider').nivoSlider({
		effect: 'random',
		animSpeed: 1000,
		controlNav: false,
		directionNav: true,
		pauseTime: 6000
	});

	$("#hotproducts .owl").owlCarousel({
        autoPlay : false,
        items : 4,
        slideSpeed : 3000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });

    $("#saleproduct .owl").owlCarousel({
        autoPlay : false,
        items : 4,
        slideSpeed : 3000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });

    $("#newproduct .owl").owlCarousel({
        autoPlay : false,
        items : 4,
        slideSpeed : 3000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });

    $("#offer .owl").owlCarousel({
        autoPlay : false,
        items : 1,
        slideSpeed : 2000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });

    $("#special-product .owl").owlCarousel({
        autoPlay : false,
        items : 1,
        slideSpeed : 2000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });
    $("#news-upload .owl").owlCarousel({
        autoPlay : false,
        items : 1,
        slideSpeed : 2000,
        directionNav: true,
        paginationSpeed : 3000,
        rewindSpeed : 3000,
        navigation : true,
        stopOnHover : true,
        pagination : false,
        scrollPerPage:true,
    });
});
