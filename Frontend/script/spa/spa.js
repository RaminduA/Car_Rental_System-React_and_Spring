let logo_link = $("#logo-link");
let home_link = $("#home-link");
let booking_link = $("#booking-link");
let cars_link = $("#cars-link");
let history_link = $("#history-link");
let notifications_link = $("#notifications-link");
let profile_link = $("#profile-link");
let contact_link = $("#contact-link");

let customer_home_page = $("#customer-home-page");
let customer_booking_page = $("#customer-booking-page");

$(document).ready(function() {
    focusActiveLink(home_link);
    displayActivePage(customer_home_page);
});

logo_link.click(function (){
    focusActiveLink(home_link);
    displayActivePage(customer_home_page);
});

home_link.click(function (){
    focusActiveLink(home_link);
    displayActivePage(customer_home_page);
});

booking_link.click(function (){
    focusActiveLink(booking_link);
    displayActivePage(customer_booking_page);
});

cars_link.click(function (){
    focusActiveLink(cars_link);
});

history_link.click(function (){
    focusActiveLink(history_link);
});

notifications_link.click(function (){
    focusActiveLink(notifications_link);
});

profile_link.click(function (){
    focusActiveLink(profile_link);
});

contact_link.click(function (){
    focusActiveLink(contact_link);
});

function focusActiveLink(active_link) {
    home_link.removeClass("active");
    booking_link.removeClass("active");
    cars_link.removeClass("active");
    history_link.removeClass("active");
    notifications_link.removeClass("active");
    profile_link.removeClass("active");
    contact_link.removeClass("active");
    active_link.addClass("active");
}

function displayActivePage(active_page) {
    customer_home_page.css("display","none");
    customer_booking_page.css("display","none");
    active_page.css("display","block");
}