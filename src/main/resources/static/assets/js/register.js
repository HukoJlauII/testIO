function registerUser() {
    var form = document.querySelector('#register')
    var roleRadios = document.querySelectorAll('.form-check-input')
    var role = roleRadios[0].checked ? roleRadios[0].value : roleRadios[1].value
    var name = document.querySelector('#yourName').value
    var surname = document.querySelector('#yourSurname').value
    var username = document.querySelector('#yourUsername').value
    var email = document.querySelector('#yourEmail').value
    var passwordConfirm = document.querySelector('#yourPasswordConfirm').value
    var settings = {
        "url": baseUrl + users,
        "method": "POST",
        "timeout": 0,
    }
    $.ajax(settings).done(function (response) {
        console.log(response)
    });
}