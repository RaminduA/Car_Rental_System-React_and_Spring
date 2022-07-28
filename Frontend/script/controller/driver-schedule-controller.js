const driver_schedule_base_url = 'http://localhost:8080/Easy-Car-Rental/api/driver-schedule/';


function getScheduleForTheWeek() {

    let id = 'id';

    $.ajax({
        url: driver_schedule_base_url + 'weekly-schedule/' + id,
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


function getScheduleForTheMonth() {

    let id = 'id';

    $.ajax({
        url: driver_schedule_base_url + 'monthly-schedule/' + id,
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