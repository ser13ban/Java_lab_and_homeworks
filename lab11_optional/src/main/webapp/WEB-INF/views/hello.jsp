<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Facebook Login JavaScript Example</title>
    <meta charset="UTF-8">
</head>
<body>
<div id="fb-root"></div>
<!--
<script async defer crossorigin="anonymous"
        src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v10.0&appId=910278569813888&autoLogAppEvents=1"
        nonce="KLXoHO9F">
</script>
-->

<script>
    let token = "";
    function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
        console.log('statusChangeCallback');
        console.log(response);                   // The current login status of the person.
        if (response.status === 'connected') {   // Logged into your webpage and Facebook.
            //I have to send the token to the java
            token = response.authResponse.accessToken;
            console.log(token);


        } else {                                 // Not logged into your webpage or we are unable to tell.
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this webpage.';
        }

        return token;
    }


    function checkLoginState() {               // Called when a person is finished with the Login Button.
        FB.getLoginStatus(function (response) {   // See the onlogin handler
            statusChangeCallback(response);
        });
    }


    window.fbAsyncInit = function () {
        FB.init({
            appId: '910278569813888',
            cookie: true,                     // Enable cookies to allow the server to access the session.
            xfbml: true,                     // Parse social plugins on this webpage.
            version: 'v10.0'           // Use this Graph API version for this call.
        });


        FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
            statusChangeCallback(response);        // Returns the login status.
        });
    };

    function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function (response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                'Thanks for logging in, ' + response.name + '!';
        });
    }


    function getTokenClick(){
        document.getElementById("link2").href = "/firstAPIcall?token=" + token;
    }
    function formHandler() {
        let fLink = document.getElementById("fLink").value;
        console.log(fLink);
        //document.getElementById("link2").href = "/firstAPIcall?token=" + token + "?link="+fLink;
        document.getElementById("link2").href = "/firstAPIcall/" + token + "/"+fLink;
    }
</script>


<!-- The JS SDK Login Button -->
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>
<!--
<div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-layout="default"
     data-auto-logout-link="false" data-use-continue-as="false"></div>
-->

<div id="status">
</div>

<form action="javascript:void(0);" onsubmit="return formHandler()">
    <input type="text" id="fLink" size="20" name="mail"><br><br>
    <input type="submit" value="Submit">
</form>


<br><br>
<a id="link" onclick="getTokenClick()"> Give me a link</a>
<br>
<a id="link2"> press this after you got the token</a>

<!-- Load the JS SDK asynchronously -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
</body>
</html>



