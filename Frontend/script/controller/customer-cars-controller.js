let owl = $('.owl-carousel');

owl.owlCarousel({
    loop:true,
    margin:10,
    dots:false,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:1
        }
    }
});


// With optional speed parameter
// Parameters has to be in square bracket '[]'

$('.car-list-next').click(function() {
    owl.trigger('next.owl.carousel', [600]);
})

$('.car-list-prev').click(function() {
    owl.trigger('prev.owl.carousel', [600]);
})