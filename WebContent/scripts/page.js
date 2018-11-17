$(window).load(function() {
	$(".mobile-inner-header-icon").click(function() {
		$(this)
		.toggleClass(
				"mobile-inner-header-icon-click mobile-inner-header-icon-out");
		$(".mobile-inner-nav")
		.slideToggle(250);
	});

	$("titlebookshare").click(function() {
		window.location="/BookShare/welcome";
	});

	$(".mobile-inner-nav a").each(function(index) {
		$(this).css({
			'animation-delay' : (index / 10) + 's'
		});
	});
});
