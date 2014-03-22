var Script = function () {

    $().ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 20
                }
            },
            messages: {
                email: {
                    required: "Please enter a valid email address"
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 6 characters long",
                    maxlength: "Your password must be at most 20 characters long"
                }
            }
        });

        $("#signupForm").validate({
            rules: {
                firstname: "required",
                lastname: "required",
                nickname: {
                    required: true,
                    minlength: 4
                },
                password: {
                    required: true,
                    minlength: 6
                },
                email: {
                    required: true,
                    email: true
                },
            },
            messages: {
                firstname: "Please enter your firstname",
                lastname: "Please enter your lastname",
                email: "Please enter a valid email address",
                nickname: {
                    required: "Please enter a nickname",
                    minlength: "Your nickname must consist of at least 4 characters"
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 6 characters long"
                }
            }
        });

        // propose nickname by combining last and firstname
        $("#nickname").focus(function() {
            var firstname = $("#firstname").val();
            var lastname = $("#lastname").val();
            if(firstname && lastname && !this.value) {
                this.value = lastname + firstname;
            }
        });
    });
}();