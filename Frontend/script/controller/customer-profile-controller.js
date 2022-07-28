const customer_profile_base_url = 'http://localhost:8080/Easy-Car-Rental/api/customer-profile/';


function updateDisplayPicture() {

    let id = 'customer id';

    $.ajax({
        url: customer_profile_base_url + 'update-dp/' + id,
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


function updatePersonalDetails() {

    let id = 'customer id';

    $.ajax({
        url: customer_profile_base_url + 'update-info/' + id,
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