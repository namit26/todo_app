function submit() {

    var user = {
        "username" : document.getElementsByName("username"),
        "password" : document.getElementsByName("password"),
        "emailId" : document.getElementsByName("emailId"),
        "phone" : document.getElementsByName("phone")
    }
    var myJSON = JSON.stringify(user)
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "/signup", true);
    xhttp.send(myJSON);
}

function test() {
    console.log("hello!1");
}

document.getElementById("test").addEventListener('click', function () {
    submit();
})