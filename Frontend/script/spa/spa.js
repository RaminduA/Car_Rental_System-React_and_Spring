let common_header_area = $("#common-header-area");
let customer_header_area = $("#customer-header-area");
let driver_header_area = $("#driver-header-area");
let admin_header_area = $("#admin-header-area");

let common_logo_link = $("#common-logo-link");
let common_home_link = $("#common-home-link");
let common_services_link = $("#common-services-link");
let common_cars_link = $("#common-cars-link");
let common_contact_link = $("#common-contact-link");
let common_login_button = $("#common-login-button");
let common_register_button = $("#common-register-button");

let customer_logo_link = $("#customer-logo-link");
let customer_home_link = $("#customer-home-link");
let customer_booking_link = $("#customer-booking-link");
let customer_cars_link = $("#customer-cars-link");
let customer_history_link = $("#customer-history-link");
let customer_notifications_link = $("#customer-notifications-link");
let customer_profile_link = $("#customer-profile-link");
let customer_contact_link = $("#customer-contact-link");

let driver_logo_link = $("#driver-logo-link");
let driver_home_link = $("#driver-home-link");
let driver_services_link = $("#driver-services-link");
let driver_schedule_link = $("#driver-schedule-link");
let driver_contact_link = $("#driver-contact-link");

let admin_logo_link = $("#admin-logo-link");
let admin_home_link = $("#admin-home-link");
let admin_booking_link = $("#admin-booking-link");
let admin_cars_link = $("#admin-cars-link");
let admin_customers_link = $("#admin-customers-link");
let admin_drivers_link = $("#admin-drivers-link");

let common_home_page = $("#common-home-page");
let common_cars_page = $("#common-cars-page");
let login_register_page = $("#login-register-page");

let customer_home_page = $("#customer-home-page");
let customer_booking_page = $("#customer-booking-page");
let customer_cars_page = $("#customer-cars-page");
let customer_profile_page = $("#customer-profile-page");

$(document).ready(function() {
    displayActiveHeaderArea(customer_header_area);
    focusActiveLink(customer_home_link);
    displayActivePage(customer_home_page);
});

common_logo_link.click(function (){
    focusActiveLink(common_home_link);
    displayActivePage(common_home_page);
});

common_home_link.click(function (){
    focusActiveLink(common_home_link);
    displayActivePage(common_home_page);
});

common_services_link.click(function (){
    focusActiveLink(common_services_link);
    //displayActivePage(customer_home_page);
});

common_cars_link.click(function (){
    focusActiveLink(common_cars_link);
    displayActivePage(common_cars_page);
});

common_contact_link.click(function (){
    focusActiveLink(common_contact_link);
    //displayActivePage(customer_home_page);
});

common_login_button.click(function (){
    displayActivePage(login_register_page);
    if(login_register_flipper.hasClass('face-register')){
        document.querySelector('#login-register-flipper').classList.toggle("flip");
        login_register_flipper.removeClass('face-register');
        login_register_flipper.addClass('face-login');
    }
    focusActiveLink(common_login_button);
});

common_register_button.click(function (){
    displayActivePage(login_register_page);
    if(login_register_flipper.hasClass('face-login')){
        document.querySelector('#login-register-flipper').classList.toggle("flip");
        login_register_flipper.removeClass('face-login');
        login_register_flipper.addClass('face-register');
    }
    focusActiveLink(common_register_button);
});

customer_logo_link.click(function (){
    focusActiveLink(customer_home_link);
    displayActivePage(customer_home_page);
});

customer_home_link.click(function (){
    focusActiveLink(customer_home_link);
    displayActivePage(customer_home_page);
});

customer_booking_link.click(function (){
    focusActiveLink(customer_booking_link);
    displayActivePage(customer_booking_page);
});

customer_cars_link.click(function (){
    focusActiveLink(customer_cars_link);
    displayActivePage(customer_cars_page);
});

customer_history_link.click(function (){
    focusActiveLink(customer_history_link);
});

customer_notifications_link.click(function (){
    focusActiveLink(customer_notifications_link);
});

customer_profile_link.click(function (){
    focusActiveLink(customer_profile_link);
    displayActivePage(customer_profile_page);
});

customer_contact_link.click(function (){
    focusActiveLink(customer_contact_link);
});

function focusActiveLink(active_link) {
    common_home_link.removeClass("active");
    common_services_link.removeClass("active");
    common_cars_link.removeClass("active");
    common_contact_link.removeClass("active");
    common_login_button.removeClass("active");
    common_register_button.removeClass("active");

    customer_home_link.removeClass("active");
    customer_booking_link.removeClass("active");
    customer_cars_link.removeClass("active");
    customer_history_link.removeClass("active");
    customer_notifications_link.removeClass("active");
    customer_profile_link.removeClass("active");
    customer_contact_link.removeClass("active");

    driver_home_link.removeClass("active");
    driver_services_link.removeClass("active");
    driver_schedule_link.removeClass("active");
    driver_contact_link.removeClass("active");

    admin_home_link.removeClass("active");
    admin_booking_link.removeClass("active");
    admin_cars_link.removeClass("active");
    admin_customers_link.removeClass("active");
    admin_drivers_link.removeClass("active");

    active_link.addClass("active");
}

function displayActiveHeaderArea(active_header_area) {
    common_header_area.css("display","none");
    customer_header_area.css("display","none");
    driver_header_area.css("display","none");
    admin_header_area.css("display","none");
    active_header_area.css("display","flex");
}

function displayActivePage(active_page) {
    common_home_page.css("display","none");
    common_cars_page.css("display","none");
    login_register_page.css("display","none");

    customer_home_page.css("display","none");
    customer_booking_page.css("display","none");
    customer_cars_page.css("display","none");
    customer_profile_page.css("display","none");

    active_page.css("display","block");
}