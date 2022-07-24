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

window.onload = function() {
    loadAllCommonCars();
};

let common_owl = $('#common-car-list');

common_owl.owlCarousel({
    loop:true,
    margin:10,
    autoplay:false,
    autoplayTimeout:4000,
    autoplaySpeed:600,
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
    for (let c of customer_cars) {
        let car = $('<div class="item car"></div>');

        let car_tag = $('<div class="car-tag"><h3>'+c.car_tag.h3+'</h3><div class="subtitle">'+c.car_tag.subtitle+'</div><div class="car-price"><strong>'+c.car_tag.car_price.strong+'</strong><span>'+c.car_tag.car_price.span+'</span></div><a href="#" class="btn"><i class="fa fa-calendar-alt" aria-hidden="true"></i>Reserve Now</a></div>');
        let car_image = $('<div class="car-image"><img src="assets/images/cars/'+c.car_image+'" alt=""></div>');
        let car_info = $('<div class="car-info"><ul><li>Doors: <strong>'+c.car_info.doors+'</strong></li><li>Passengers: <strong>'+c.car_info.passengers+'</strong></li><li>Luggage: <strong>'+c.car_info.luggage+'</strong></li><li>Transmission: <strong>'+c.car_info.transmission+'</strong></li><li>Air conditioning: <strong>'+c.car_info.air_conditioning+'</strong></li><li>Minimum age: <strong>'+c.car_info.minimum_age+'</strong></li></ul></div>');

        car.append(car_tag);
        car.append(car_image);
        car.append(car_info);

        common_owl.trigger('add.owl.carousel', [car]).trigger('refresh.owl.carousel');
    }
}
