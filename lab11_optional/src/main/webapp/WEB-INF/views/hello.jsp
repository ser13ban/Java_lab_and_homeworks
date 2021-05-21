<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Facebook Login JavaScript Example</title>
    <meta charset="UTF-8">
    <style>
        body{
            background-image: url('background.jpg');
        }
        input {
            width: 200px;
            height: 70px;
            background: linear-gradient(to left top, #c32c71 50%, #b33771 50%);
            border-style: none;
            color: #fff;
            font-size: 23px;
            letter-spacing: 3px;
            font-family: 'Lato';
            font-weight: 600;
            outline: none;
            cursor: pointer;
            position: relative;
            padding: 0px;
            overflow: hidden;
            transition: all .5s;
            box-shadow: 0px 1px 2px rgba(0, 0, 0, .2);
        }

        input span {
            position: absolute;
            display: block;
        }

        input span:nth-child(1) {
            height: 3px;
            width: 200px;
            top: 0px;
            left: -200px;
            background: linear-gradient(to right, rgba(0, 0, 0, 0), #f6e58d);
            border-top-right-radius: 1px;
            border-bottom-right-radius: 1px;
            animation: span1 2s linear infinite;
            animation-delay: 1s;
        }

        @keyframes span1 {
            0% {
                left: -200px
            }
            100% {
                left: 200px;
            }
        }

        input span:nth-child(2) {
            height: 70px;
            width: 3px;
            top: -70px;
            right: 0px;
            background: linear-gradient(to bottom, rgba(0, 0, 0, 0), #f6e58d);
            border-bottom-left-radius: 1px;
            border-bottom-right-radius: 1px;
            animation: span2 2s linear infinite;
            animation-delay: 2s;
        }

        @keyframes span2 {
            0% {
                top: -70px;
            }
            100% {
                top: 70px;
            }
        }

        input span:nth-child(3) {
            height: 3px;
            width: 200px;
            right: -200px;
            bottom: 0px;
            background: linear-gradient(to left, rgba(0, 0, 0, 0), #f6e58d);
            border-top-left-radius: 1px;
            border-bottom-left-radius: 1px;
            animation: span3 2s linear infinite;
            animation-delay: 3s;
        }

        @keyframes span3 {
            0% {
                right: -200px;
            }
            100% {
                right: 200px;
            }
        }

        input span:nth-child(4) {
            height: 70px;
            width: 3px;
            bottom: -70px;
            left: 0px;
            background: linear-gradient(to top, rgba(0, 0, 0, 0), #f6e58d);
            border-top-right-radius: 1px;
            border-top-left-radius: 1px;
            animation: span4 2s linear infinite;
            animation-delay: 4s;
        }

        @keyframes span4 {
            0% {
                bottom: -70px;
            }
            100% {
                bottom: 70px;
            }
        }

        input:hover {
            transition: all .5s;
            transform: rotate(-3deg) scale(1.1);
            box-shadow: 0px 3px 5px rgba(0, 0, 0, .4);
        }

        input:hover span {
            animation-play-state: paused;
        }
        .wrapper{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100vw;
            height: 100vh;
        }
        .spacer{
            margin-bottom: 5%;
        }
    </style>
</head>
<body>
<div id="fb-root"></div>

<script>
    let token = "";

    function getRidOfLogInButton() {
        document.getElementById("loginButton").remove();
    }

    function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
        console.log('statusChangeCallback');
        console.log(response);                   // The current login status of the person.
        if (response.status === 'connected') {   // Logged into your webpage and Facebook.
            //I have to send the token to the java
            getRidOfLogInButton();
            token = response.authResponse.accessToken;
            //add it to the session

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

    function setTokenOnSession() {
        return token;
    }

    function getTokenClick() {
        document.getElementById("link2").href = "/firstAPIcall?token=" + token;
    }

    function formHandlerQA() {
        //document.getElementById("link2").href = "/firstAPIcall?token=" + token + "?link="+fLink;
        window.location.href = "/qa/" + token;
    }

    function formHandlerGiveAway() {
        //document.getElementById("link2").href = "/firstAPIcall?token=" + token + "?link="+fLink;
        window.location.href = "/giveaway/" + token;
    }
</script>


<!-- The JS SDK Login Button -->
<div id="loginButton">
    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
    </fb:login-button>
</div>

<!--
<div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-layout="default"
     data-auto-logout-link="false" data-use-continue-as="false"></div>
-->

<div id="status">
</div>
<div class="wrapper">


<form class="spacer" action="javascript:void(0);" onsubmit="return formHandlerQA() ">
    <input type="submit" value="Q&A"></form>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
</form>
<form action="javascript:void(0);" onsubmit="return formHandlerGiveAway()">
    <input type="submit" value="Give away">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
</form>
</div>
<!-- Load the JS SDK asynchronously -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></SCRIPT>
</body>
</html>



