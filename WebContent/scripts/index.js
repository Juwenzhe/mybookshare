$(function() {
	var items = $('#countrySelection-items').width();
	var itemSelected = document.getElementsByClassName('countrySelection-item');
	var backgroundColours = ["rgb(133, 105, 156)", "rgb(175, 140, 115)","rgb(151, 167, 109)","rgb(171, 100, 122)","rgb(105, 134, 156)","rgb(152, 189, 169)"]
	countriesPointerScroll($(itemSelected));
	newBackgroundColour(backgroundColours);
		
	$("#countrySelection-items").scrollLeft(200).delay(200).animate({
		scrollLeft: "-=200"
	}, 2000, "easeOutQuad");

	$('.countrySelection-paddle-right').click(function () {
		$("#countrySelection-items").animate({
			scrollLeft: '+='+items
		});
	});
	$('.countrySelection-paddle-left').click(function () {
		$( "#countrySelection-items" ).animate({
			scrollLeft: "-="+items
		});
	});

	if(!/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
		var scrolling = false;

		$(".countrySelection-paddle-right").bind("mouseover", function(event) {
			scrolling = true;
			scrollContent("right");
		}).bind("mouseout", function(event) {
			scrolling = false;
		});

		$(".countrySelection-paddle-left").bind("mouseover", function(event) {
			scrolling = true;
			scrollContent("left");
		}).bind("mouseout", function(event) {
			scrolling = false;
		});
	}
	function scrollContent(direction) {
		var amount = (direction === "left" ? "-=3px" : "+=3px");
		$("#countrySelection-items").animate({
			scrollLeft: amount
		}, 1, function() {
			if (scrolling) {
				scrollContent(direction);
			}
		});
	}


	$('.countrySelection-item').click(function () {
		$('#countrySelection').find('.active').removeClass("active");
		$(this).addClass("active");
		countriesPointerScroll($(this));
		
	});
	
	$("#titlebookshare").click(function() {
		location.href="/BookShare/welcome";
	});
	
});

var newBackgroundColour = function(backgroundColours){
	var newBackground = backgroundColours[Math.floor(Math.random()*backgroundColours.length)];
	if(newBackground != $("html").css("background-color")){
		$("html").css("background",newBackground);
	}else{
		newBackgroundColour(backgroundColours);
	}
}
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 

function countriesPointerScroll(ele) {
	/*var jwzid=getQueryString("jwzid");
	if(jwzid=="wel"){jwzoffset=0;}else
		if(jwzid=="sea"){jwzoffset=135.125;}else
			if(jwzid=="sha"){jwzoffset=251.375;}else
				if(jwzid=="boo"){jwzoffset=369.4375;}else
					if(jwzid=="ide"){jwzoffset=482;}else
						if(jwzid=="sel"){jwzoffset=600.5;}else
							if(jwzid=="ord"){jwzoffset=715.35;}else	
								if(jwzid=="mon"){jwzoffset=835.6;}else
									if(jwzid=="intro"){jwzoffset=950.4;}else
										if(jwzid=="callus"){jwzoffset=1109.7;}else
										if(jwzid=="goo"){jwzoffset=1180.36;}else{jwzoffset=135.125;}*/

	var parentScroll = $("#countrySelection-items").scrollLeft()-500;
	var offset = ($(ele).offset().left - $('#countrySelection-items').offset().left);
	var totalelement = offset + $(ele).outerWidth()/2;
	var rt = (($(ele).offset().left) - ($('#countrySelection-wrapper').offset().left) + ($(ele).outerWidth())/2);
	$('#countrySelector').animate({
		left: totalelement + parentScroll
	})
}