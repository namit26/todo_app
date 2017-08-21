
<!DOCTYPE html>

<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="w3css/w3css.css">

    <link rel="stylesheet" href="w3css/mycss.css">


</head>

<body>

<div class="w3-container w3-dark-grey w3-center">

    <h1>Todo App</h1>

</div>

<div id="login1" class="w3-container ">


    <h2 class="w3-text-teal w3-center" >Log In</h2>


    <form action="login" method="POST" style="width: 50%; margin-left: 25%;">

        <input class="w3-input w3-animate-input w3-padding-8 " type="text" style="width:33%" name="username" required>
        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">ID</label>

        <input class="w3-input w3-animate-input w3-padding-8" type="password" style="width:33%" name="password" required>
        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">Password</label>
        <input class="w3-input w3-animate-input w3-padding-8" type = "submit" value = "Submit" />

    </form>



</div>
<div id="signup1" class="w3-container ">
    <h2 class="w3-text-teal w3-center" >Register</h2>


    <form action="signup" name="signupform" id="signupformid" method="POST" style="width: 50%; margin-left: 25%;" >

        <input class="w3-input w3-animate-input w3-padding-8 " type="text" style="width:33%" name="username" required>

        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">ID</label>

        <input class="w3-input w3-animate-input w3-padding-8" type="password" style="width:33%" name="password" required>

        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">Password</label>

        <input class="w3-input w3-animate-input w3-padding-8" type="text" style="width:33%" name="emailID" required>

        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">emailId</label>

        <input class="w3-input w3-animate-input w3-padding-8" type="text" style="width:33%" name="phone" required>

        <label class="w3-label w3-validate w3-left-align w3-margin-top" style="font-size: 20px;">Phone Number</label>

        <input class="w3-input w3-animate-input w3-padding-8" id="signupsubmit" type = "submit" value = "submit" />

    </form>

</div>

</body>



</html>