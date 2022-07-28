const login_register_base_url = 'http://localhost:8080/Easy-Car-Rental/api/login-register/';


let login_flip_button = $('#login-flip-button');
let register_flip_button = $('#register-flip-button');
let login_register_flipper = $('#login-register-flipper');


login_flip_button.click(function(){
    document.querySelector('#login-register-flipper').classList.toggle("flip");
    login_register_flipper.removeClass('face-register');
    login_register_flipper.addClass('face-login');
    focusActiveLink(common_register_button);
});

register_flip_button.click(function(){
    document.querySelector('#login-register-flipper').classList.toggle("flip");
    login_register_flipper.removeClass('face-login');
    login_register_flipper.addClass('face-register');
    focusActiveLink(common_login_button);
});


function loginUser() {

    let username = 'username';
    let password = 'password';

    $.ajax({
        url: login_register_base_url + '?username=' + username + '&password=' +password,
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


function getCustomerId() {

    $.ajax({
        url: login_register_base_url + 'get-customer-id',
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


function registerUser() {

    $.ajax({
        url: login_register_base_url + 'get-customer-id',
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