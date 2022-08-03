$(document).ready(function () {
    customer_notifications_link.click(function () {
        $("#customer-notifications-page").fadeToggle(300);
        $(".notification-count").fadeOut("slow");
        return false;
    });

    $("#customer-notifications-page").hide();

    //Document Click hiding the popup
    $(document).click(function () {
        $("#customer-notifications-page").hide();
    });

    //Popup on click
    $(".notification-container").click(function () {
        return false;
    });

    $('#AddNew').on('click', function(){
        $('.notifications-list').append('<li><div class="notification" >New Message</div></li>');
    });

});