const admin_bookings_base_url = 'http://localhost:8080/Easy-Car-Rental/api/admin-bookings/';


let admin_request_list = [
    {
        id: 'REQ-000001',
        pickup_venue: 'Galle',
        pickup_date: '2022-08-07',
        drop_off_venue: 'Matara',
        drop_off_date: '2022-08-08',
        rental_type: 'Daily',
        customer: 'CUS-0000002',
        car: 'CAR-00005',
        driver: 'DRI-00007'
    },
    {
        id: 'REQ-000002',
        pickup_venue: 'Colombo',
        pickup_date: '2022-08-10',
        drop_off_venue: 'Colombo',
        drop_off_date: '2022-10-01',
        rental_type: 'Monthly',
        customer: 'CUS-0000001',
        car: 'CAR-00004',
        driver: 'DRI-00006'
    },
    {
        id: 'REQ-000003',
        pickup_venue: 'Kandy',
        pickup_date: '2022-08-08',
        drop_off_venue: 'Jaffna',
        drop_off_date: '2022-08-21',
        rental_type: 'Daily',
        customer: 'CUS-0000004',
        car: 'CAR-00008',
        driver: 'DRI-00001'
    },
    {
        id: 'REQ-000004',
        pickup_venue: 'Kegalle',
        pickup_date: '2022-08-09',
        drop_off_venue: 'Mannar',
        drop_off_date: '2022-09-10',
        rental_type: 'Monthly',
        customer: 'CUS-0000006',
        car: 'CAR-00002',
        driver: 'DRI-00003'
    },
    {
        id: 'REQ-000005',
        pickup_venue: 'Matara',
        pickup_date: '2022-08-07',
        drop_off_venue: 'Matara',
        drop_off_date: '2022-08-07',
        rental_type: 'Daily',
        customer: 'CUS-0000008',
        car: 'CAR-00001',
        driver: 'DRI-00005'
    },
    {
        id: 'REQ-000006',
        pickup_venue: 'colombo',
        pickup_date: '2022-08-13',
        drop_off_venue: 'Galle',
        drop_off_date: '2022-08-15',
        rental_type: 'Daily',
        customer: 'CUS-0000007',
        car: 'CAR-00009',
        driver: 'DRI-00002'
    }
];



window.onload = function() {
    loadAllAdminBookings();
};

let admin_bookings_owl = $('.owl-admin-bookings');

admin_bookings_owl.owlCarousel({
    loop:true,
    margin:10,
    autoHeight:false,
    autoplay:false,
    autoplayTimeout:4000,
    autoplaySpeed:600,
    autoplayHoverPause:true,
    nav:false,
    dots:false,
    responsive:{
        0:{items:3},
        600:{items:3},
        1000:{items:3}
    }
});

$('#admin-bookings-list-next').click(function() {
    admin_bookings_owl.trigger('next.owl.carousel', [600]);
});

$('#admin-bookings-list-prev').click(function() {
    admin_bookings_owl.trigger('prev.owl.carousel', [600]);
});

let image_list = ['cars-bg','common-bg','home-bg','login-bg','profile-bg','profile-cover'];

function loadAllAdminBookings(){
    for (let req of admin_request_list) {
        let admin_booking = $('<div class="item booking"></div>');

        let request_title = $('<h3 class="request-title">'+req.id+'</h3>');
        let request_info = $(' <div class="request-info"> <ul><li>Pickup Venue: <strong>'+req.pickup_venue+'</strong></li> <li>Pickup Date: <strong>'+req.pickup_date+'</strong></li> <li>Drop Off Venue: <strong>'+req.drop_off_venue+'</strong></li> <li>Drop Off Date: <strong>'+req.pickup_date+'</strong></li> <li>Rental Type: <strong>'+req.rental_type+'</strong></li> <li>Customer: <strong>'+req.customer+'</strong></li> <li>Car: <strong>'+req.car+'</strong></li> <li>Driver: <strong class="request-driver-id">'+req.driver+'</strong></li> </ul> </div>');

        let option_buttons = $('<div class="request-option-buttons"></div>');

        let deny_button = $('<button class="request-option-button request-deny-button"> <i class="fa fa-times" aria-hidden="true"></i> </button>');
        let accept_button = $('<button class="request-option-button request-accept-button"><i class="fa fa-check" aria-hidden="true"></i></button>');

        const request_page_swal = Swal.mixin({
                                        width: 600,
                                        padding: '3em',
                                        color: '#FFF',
                                        background: '#333',
                                        backdrop: `rgba(0,0,0,0.4)`/*,
                                        confirmButtonColor: '#066c35',
                                        denyButtonColor: '#d33',
                                        cancelButtonColor: '#3085d6'*/
                                    });



        deny_button.click(function() {
            request_page_swal.fire({
                title: 'Do you really want to deny this request?',
                showDenyButton: false,
                showCancelButton: true,
                confirmButtonText: 'Deny',
                confirmButtonColor: '#066c35',
                cancelButtonColor: '#3085d6'
            }).then((result) => {
                if (result.isConfirmed) {
                    request_page_swal.fire({
                        title: 'Enter your message to the customer',
                        input: 'text',
                        inputAttributes: {
                            autocapitalize: 'off'
                        },
                        showCancelButton: true,
                        confirmButtonText: 'Deny',
                        confirmButtonColor: '#066c35',
                        cancelButtonColor: '#3085d6',
                        showLoaderOnConfirm: true,
                        preConfirm: (driver_id) => {
                            return driver_id;
                        }
                    }).then((result) => {
                        if (result.isConfirmed) {
                            request_page_swal.fire({
                                icon: 'success',
                                title: 'Request Denied!',
                                text: '\"' + result.value + '\" will be sent to customer.',
                                showCancelButton: false,
                                confirmButtonText: 'Okay',
                                confirmButtonColor: '#066c35'
                            });
                        }else{
                            request_page_swal.fire({
                                icon: 'info',
                                title: 'Request Wasn\'t Accepted!',
                                text: '',
                                showCancelButton: false,
                                confirmButtonText: 'Okay',
                                confirmButtonColor: '#066c35'
                            });
                        }
                    });
                }else{
                    request_page_swal.fire({
                        icon: 'info',
                        title: 'Request Wasn\'t Denied!',
                        text: '',
                        showCancelButton: false,
                        confirmButtonText: 'Okay',
                        confirmButtonColor: '#066c35'
                    });
                }
            });
        });


        accept_button.click(function() {
            //title: 'Request ' + request_title.text() + ' accepted with Driver ' + request_info.contents().find('.request-driver-id').text() + '!',


            request_page_swal.fire({
                title: 'Do you really want to accept this request?',
                showDenyButton: true,
                showCancelButton: true,
                confirmButtonText: 'Accept',
                denyButtonText: 'Change Driver',
                confirmButtonColor: '#066c35',
                denyButtonColor: '#f9c200',
                cancelButtonColor: '#3085d6'
            }).then((result) => {
                if (result.isConfirmed) {
                    request_page_swal.fire({
                        icon: 'success',
                        title: 'Request Accepted!',
                        text: 'Driver remains the same',
                        showCancelButton: false,
                        confirmButtonText: 'Okay',
                        confirmButtonColor: '#066c35'
                    });
                }else if (result.isDenied) {
                    request_page_swal.fire({
                        title: 'Enter Driver ID',
                        input: 'text',
                        inputAttributes: {
                            autocapitalize: 'off'
                        },
                        showCancelButton: true,
                        confirmButtonText: 'Accept',
                        confirmButtonColor: '#066c35',
                        cancelButtonColor: '#3085d6',
                        showLoaderOnConfirm: true,
                        preConfirm: (driver_id) => {
                            return driver_id;
                        }
                    }).then((result) => {
                        if (result.isConfirmed) {
                            request_page_swal.fire({
                                icon: 'success',
                                title: 'Request Accepted!',
                                text: 'Driver changed to '+result.value,
                                showCancelButton: false,
                                confirmButtonText: 'Okay',
                                confirmButtonColor: '#066c35'
                            });
                        }else{
                            request_page_swal.fire({
                                icon: 'info',
                                title: 'Request Wasn\'t Accepted!',
                                text: '',
                                showCancelButton: false,
                                confirmButtonText: 'Okay',
                                confirmButtonColor: '#066c35'
                            });
                        }
                    });
                }else{
                    request_page_swal.fire({
                        icon: 'info',
                        title: 'Request Wasn\'t Accepted!',
                        text: '',
                        showCancelButton: false,
                        confirmButtonText: 'Okay',
                        confirmButtonColor: '#066c35'
                    });
                }
            });


            /*Swal.fire({
                title: 'Request ' + request_title.text() + ' accepted with Driver ' + request_info.contents().find('.request-driver-id').text() + '!',
                width: 600,
                padding: '3em',
                color: '#FFF',
                background: '#333',
                backdrop: `rgba(0,0,0,0.4)`
            });*/
        });

        option_buttons.append(deny_button);
        option_buttons.append(accept_button);

        admin_booking.append(request_title);
        admin_booking.append(request_info);
        admin_booking.append(option_buttons);

        admin_bookings_owl.trigger('add.owl.carousel', [admin_booking]).trigger('refresh.owl.carousel');

    }
}