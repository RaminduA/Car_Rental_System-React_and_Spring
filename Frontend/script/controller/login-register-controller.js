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