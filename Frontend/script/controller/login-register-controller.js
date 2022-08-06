const login_register_base_url = 'http://localhost:8080/Easy-Car-Rental/api/login-register/';


let middle_login_button = $('#middle-login-button');
let middle_register_button = $('#middle-register-button');

let login_flip_button = $('#login-flip-button');
let register_flip_button = $('#register-flip-button');
let login_register_flipper = $('#login-register-flipper');

let login_username = $('#login-username');


middle_login_button.click(function(){
    if(login_username.val()==='customer1'){
        displayActiveHeaderArea(customer_header_area);
        focusActiveLink(customer_home_link);
        displayActivePage(customer_home_page);
    }else if(login_username.val()==='admin1'){
        displayActiveHeaderArea(admin_header_area);
        focusActiveLink(admin_home_link);
        displayActivePage(admin_home_page);
    }

});


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

    let username = $('#login-username');
    let password = $('#login-password');

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
        method: "GET",
        contentType: "application/json",
        success: function (jsonResp) {
            if(jsonResp.status===200){


                let id = jsonResp.data;
                let name = $('#register-name');
                let email = $('#register-email');
                let address = $('#register-address');
                let contact = $('#register-contact');
                let username = $('#register-username');
                let password = $('#register-password');
                let password_confirm = $('#register-confirm-password');


                let jsonReq = { id: id, name: name, email: email, address: address, contact: contact,
                            account: { id: "", username: username, password: password, email: email}};

                if(password === password_confirm){

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

                }else{
                    alert("Passwords you entered doesn't match");
                }


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