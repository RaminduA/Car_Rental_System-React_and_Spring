let login_flip_button = $('#login-flip-button');
let register_flip_button = $('#register-flip-button');



login_flip_button.click(function(){
    document.querySelector('#login-register-flipper').classList.toggle("flip");
    focusActiveLink(common_register_button);
});

register_flip_button.click(function(){
    document.querySelector('#login-register-flipper').classList.toggle("flip");
    focusActiveLink(common_login_button);
});