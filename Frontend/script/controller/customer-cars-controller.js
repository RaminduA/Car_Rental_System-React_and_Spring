let customer_cars = [
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
    loadAllCustomerCars();
};

let customer_owl = $('.owl-customer-cars');

customer_owl.owlCarousel({
    loop:true,
    margin:10,
    autoHeight:true,
    autoplay:false,
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

$('#customer-car-list-next').click(function() {
    customer_owl.trigger('next.owl.carousel', [600]);
});

$('#customer-car-list-prev').click(function() {
    customer_owl.trigger('prev.owl.carousel', [600]);
});

function loadAllCustomerCars(){
    for (let customer_c of customer_cars) {
        let customer_car = $('<div class="item car"></div>');

        let customer_car_tag = $('<div class="car-tag"><h3>'+customer_c.car_tag.h3+'</h3><div class="subtitle">'+customer_c.car_tag.subtitle+'</div><div class="car-price"><strong>'+customer_c.car_tag.car_price.strong+'</strong><span>'+customer_c.car_tag.car_price.span+'</span></div><a href="#" class="btn"><i class="fa fa-calendar-alt" aria-hidden="true"></i>Reserve Now</a></div>');
        let customer_car_image = $('<div class="car-image"><img src="assets/images/cars/'+customer_c.car_image+'" alt=""></div>');
        let customer_car_info = $('<div class="car-info"><ul><li>Doors: <strong>'+customer_c.car_info.doors+'</strong></li><li>Passengers: <strong>'+customer_c.car_info.passengers+'</strong></li><li>Luggage: <strong>'+customer_c.car_info.luggage+'</strong></li><li>Transmission: <strong>'+customer_c.car_info.transmission+'</strong></li><li>Air conditioning: <strong>'+customer_c.car_info.air_conditioning+'</strong></li><li>Minimum age: <strong>'+customer_c.car_info.minimum_age+'</strong></li></ul></div>');

        customer_car.append(customer_car_tag);
        customer_car.append(customer_car_image);
        customer_car.append(customer_car_info);

        customer_owl.trigger('add.owl.carousel', [customer_car]).trigger('refresh.owl.carousel');
    }
}
