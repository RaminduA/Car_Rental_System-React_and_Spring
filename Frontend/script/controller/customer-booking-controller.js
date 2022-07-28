const customer_booking_base_url = 'http://localhost:8080/Easy-Car-Rental/api/customer-booking/';


let select_car_button = $("#select-car-button");

select_car_button.click(function(){
    customer_cars_link.click();
});


function requestBooking() {

    let request = {id: '', pickupVenue: '', pickupDate: '', dropOffVenue: '',
        dropOffDate: '', rentalType: '', ldwSlip: '', status: '',
        customer: {},
        car: {},
        driver: {}
    };

    $.ajax({
        url: customer_booking_base_url,
        method: "POST",
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