            function openLogin() {
                var x = document.getElementById("login-box");

                x.open = true;

                var y = document.getElementById("login");
                y.style.display = "block";
            }
            function openRegister() {
                var x = document.getElementById("register-box");

                x.open = true;

                var y = document.getElementById("register");
                y.style.display = "block";
            }
            function closeLogin() {
                var x = document.getElementById("login-box");

                x.open = false;

                var y = document.getElementById("login");
                y.style.display = "none";
            }
            function closeRegister() {
                var x = document.getElementById("register-box");

                x.open = false;

                var y = document.getElementById("register");
                y.style.display = "none";
            }