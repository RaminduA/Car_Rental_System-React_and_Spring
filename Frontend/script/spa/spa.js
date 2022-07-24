let common_logo_link = $("#common-logo-link");
let common_home_link = $("#common-home-link");
let common_services_link = $("#common-services-link");
let common_cars_link = $("#common-cars-link");
let common_contact_link = $("#common-contact-link");

let customer_logo_link = $("#customer-logo-link");
let customer_home_link = $("#customer-home-link");
let customer_booking_link = $("#customer-booking-link");
let customer_cars_link = $("#customer-cars-link");
let customer_history_link = $("#customer-history-link");
let customer_notifications_link = $("#customer-notifications-link");
let customer_profile_link = $("#customer-profile-link");
let customer_contact_link = $("#customer-contact-link");

let customer_home_page = $("#customer-home-page");
let customer_booking_page = $("#customer-booking-page");
let customer_cars_page = $("#customer-cars-page");

$(document).ready(function() {
    focusActiveLink(common_home_link);
    //displayActivePage(common_home_page);
});

common_logo_link.click(function (){
    focusActiveLink(common_home_link);
    //displayActivePage(customer_home_page);
});

common_home_link.click(function (){
    focusActiveLink(common_home_link);
    //displayActivePage(customer_home_page);
});

common_services_link.click(function (){
    focusActiveLink(common_services_link);
    //displayActivePage(customer_home_page);
});

common_cars_link.click(function (){
    focusActiveLink(common_cars_link);
    //displayActivePage(customer_home_page);
});

common_contact_link.click(function (){
    focusActiveLink(common_contact_link);
    //displayActivePage(customer_home_page);
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
});

customer_contact_link.click(function (){
    focusActiveLink(customer_contact_link);
});

function focusActiveLink(active_link) {
    common_home_link.removeClass("active");
    common_services_link.removeClass("active");
    common_cars_link.removeClass("active");
    common_contact_link.removeClass("active");

    customer_home_link.removeClass("active");
    customer_booking_link.removeClass("active");
    customer_cars_link.removeClass("active");
    customer_history_link.removeClass("active");
    customer_notifications_link.removeClass("active");
    customer_profile_link.removeClass("active");
    customer_contact_link.removeClass("active");

    active_link.addClass("active");
}

function displayActivePage(active_page) {
    customer_home_page.css("display","none");
    customer_booking_page.css("display","none");
    customer_cars_page.css("display","none");
    active_page.css("display","block");
}