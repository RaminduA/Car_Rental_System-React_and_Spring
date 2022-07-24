let common_cars = [
    {
        car_tag: {
            h3: 'BMW 3-SERIES',
            subtitle: 'ModernLine',
            car_price: {strong: '$99', span: '/Day'}
        },
        car_image: '01.png',
        car_info: {
            doors: 4,
            passengers: 5,
            luggage: '2 Bags',
            transmission: 'Automatic',
            air_conditioning: 'Dual Zone',
            minimum_age: '35 years'
        }
    },
    {
        car_tag: {
            h3: 'Subaru Impreza',
            subtitle: 'Premium',
            car_price: {strong: '$125', span: '/Day'}
        },
        car_image: '02.png',
        car_info: {
            doors: 4,
            passengers: 5,
            luggage: '2 Bags',
            transmission: 'Automatic',
            air_conditioning: 'Dual Zone',
            minimum_age: '35 years'
        }
    },
    {
        car_tag: {
            h3: 'Hyundai Santa Fe XL',
            subtitle: 'Streetsville H',
            car_price: {strong: '$199', span: '/Day'}
        },
        car_image: '03.png',
        car_info: {
            doors: 4,
            passengers: 5,
            luggage: '2 Bags',
            transmission: 'Automatic',
            air_conditioning: 'Dual Zone',
            minimum_age: '35 years'
        }
    },
    {
        car_tag: {
            h3: 'Honda Vezel',
            subtitle: 'Streetsville H',
            car_price: {strong: '$215', span: '/Day'}
        },
        car_image: '04.png',
        car_info: {
            doors: 4,
            passengers: 5,
            luggage: '2 Bags',
            transmission: 'Automatic',
            air_conditioning: 'Dual Zone',
            minimum_age: '35 years'
        }
    }
];

$(document).ready(function() {
    loadAllCommonCars();
});

let common_owl = $('.owl-common-cars');

common_owl.owlCarousel({
    loop:true,
    margin:10,
    autoHeight:true,
    autoplay:true,
    autoplayTimeout:4000,
    autoplaySpeed:600,
    autoplayHoverPause:true,
    nav:false,
    dots:false,
    responsive:{
        0:{items:1},
        600:{items:1},
        1000:{items:1}
    }
});


// With optional speed parameter
// Parameters has to be in square bracket '[]'

$('#common-car-list-next').click(function() {
    common_owl.trigger('next.owl.carousel', [600]);
});

$('#common-car-list-prev').click(function() {
    common_owl.trigger('prev.owl.carousel', [600]);
});


function loadAllCommonCars(){
    for (let common_c of common_cars) {
        let common_car = $('<div class="item car"></div>');

        let common_car_tag = $('<div class="car-tag"><h3>'+common_c.car_tag.h3+'</h3><div class="subtitle">'+common_c.car_tag.subtitle+'</div><div class="car-price"><strong>'+common_c.car_tag.car_price.strong+'</strong><span>'+common_c.car_tag.car_price.span+'</span></div></div>');
        let common_car_image = $('<div class="car-image"><img src="assets/images/cars/'+common_c.car_image+'" alt=""></div>');
        let common_car_info = $('<div class="car-info"><ul><li>Doors: <strong>'+common_c.car_info.doors+'</strong></li><li>Passengers: <strong>'+common_c.car_info.passengers+'</strong></li><li>Luggage: <strong>'+common_c.car_info.luggage+'</strong></li><li>Transmission: <strong>'+common_c.car_info.transmission+'</strong></li><li>Air conditioning: <strong>'+common_c.car_info.air_conditioning+'</strong></li><li>Minimum age: <strong>'+common_c.car_info.minimum_age+'</strong></li></ul></div>');

        common_car.append(common_car_tag);
        common_car.append(common_car_image);
        common_car.append(common_car_info);

        common_owl.trigger('add.owl.carousel', [common_car]).trigger('refresh.owl.carousel');
    }
}
