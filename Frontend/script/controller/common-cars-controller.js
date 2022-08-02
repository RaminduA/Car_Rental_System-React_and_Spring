const common_cars_base_url = 'http://localhost:8080/Easy-Car-Rental/api/common-cars/';


let common_cars = [
    {
        car_tag: {
            brand: 'BMW',
            model: '3-SERIES',
            car_type: 'ModernLine',
            car_price: {
                daily_rate: {strong: '$99', span: '/Day'},
                monthly_rate: {strong: '$2499', span: '/Month'}
            },
            status: 'Available'
        },
        car_image: '01.png',
        car_info: {
            passengers: 5,
            transmission: 'Automatic',
            distance_par_day: '100km',
            distance_par_month: '4000km',
            price_per_extra_km: '$2'
        }
    },
    {
        car_tag: {
            brand: 'Subaru',
            model: 'Impreza',
            car_type: 'Premium',
            car_price: {
                daily_rate: {strong: '$125', span: '/Day'},
                monthly_rate: {strong: '$3699', span: '/Month'}
            },
            status: 'Available'
        },
        car_image: '02.png',
        car_info: {
            passengers: 5,
            transmission: 'Automatic',
            distance_par_day: '100km',
            distance_par_month: '4000km',
            price_per_extra_km: '$2'
        }
    },
    {
        car_tag: {
            brand: 'Hyundai',
            model: 'Santa Fe XL',
            car_type: 'Streetsville H',
            car_price: {
                daily_rate: {strong: '$199', span: '/Day'},
                monthly_rate: {strong: '$5599', span: '/Month'}
            },
            status: 'Available'
        },
        car_image: '03.png',
        car_info: {
            passengers: 5,
            transmission: 'Automatic',
            distance_par_day: '100km',
            distance_par_month: '4000km',
            price_per_extra_km: '$2'
        }
    },
    {
        car_tag: {
            brand: 'Honda',
            model: 'Vezel',
            car_type: 'Streetsville H',
            car_price: {
                daily_rate: {strong: '$215', span: '/Day'},
                monthly_rate: {strong: '$6199', span: '/Month'}
            },
            status: 'Available'
        },
        car_image: '04.png',
        car_info: {
            passengers: 5,
            transmission: 'Automatic',
            distance_par_day: '100km',
            distance_par_month: '4000km',
            price_per_extra_km: '$2'
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

        let common_car_tag = $('<div class="car-tag"><h3>'+common_c.car_tag.brand+' '+common_c.car_tag.model+'</h3><div class="subtitle">'+common_c.car_tag.car_type+'</div><div class="car-price"><strong>'+common_c.car_tag.car_price.daily_rate.strong+'</strong><span>'+common_c.car_tag.car_price.daily_rate.span+'</span></div><div class="car-price"><strong>'+common_c.car_tag.car_price.monthly_rate.strong+'</strong><span>'+common_c.car_tag.car_price.monthly_rate.span+'</span></div></div>');
        let common_car_image = $('<div class="car-image"><img src="assets/images/cars/'+common_c.car_image+'" alt=""></div>');
        let common_car_info = $('<div class="car-info"><ul><li>Passengers: <strong>'+common_c.car_info.passengers+'</strong></li><li>Transmission: <strong>'+common_c.car_info.transmission+'</strong></li><li>Per Day: <strong>'+common_c.car_info.distance_par_day+'</strong></li><li>Per Month: <strong>'+common_c.car_info.distance_par_month+'</strong></li><li>Extra KM: <strong>'+common_c.car_info.price_per_extra_km+'</strong></li></ul></div>');

        common_car.append(common_car_tag);
        common_car.append(common_car_image);
        common_car.append(common_car_info);

        common_owl.trigger('add.owl.carousel', [common_car]).trigger('refresh.owl.carousel');
    }
}


function getAllCommonCars() {

    $.ajax({
        url: common_cars_base_url,
        method: "GET",
        contentType: "application/json",
        success: function (jsonResp) {
            if(jsonResp.status===200){
                console.log(jsonResp.data);
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error: function(ob) {
            alert(ob.responseJSON.message);
        }
    });

}


function getAllCommonCarsSortedByCriteria() {

    let criteria = '???';

    $.ajax({
        url: common_cars_base_url + criteria,
        method: "GET",
        contentType: "application/json",
        success: function (jsonResp) {
            if(jsonResp.status===200){
                console.log(jsonResp.data);
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error: function(ob) {
            alert(ob.responseJSON.message);
        }
    });

}
