<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Enrollment Form</title>
    <style type="text/css">
      input {
        width: 45%;
        margin-bottom: 20px;
        margin-top: 7px;
        background: transparent;
        border: none;
        color: black;
        border-bottom: 2px solid lightgreen;
      }

      input:hover {
        transition: 0.2s;
        border-bottom: 2px solid black;
      }

      button {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
      }

      input[type="submit"] {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
      }

      input[type="date"]::-webkit-inner-spin-button,
      input[type="number"]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
      }

      input[type="submit"]:hover {
        background-color: green;
        transition: 0.2s;
      }

      input[type="radio"] {
        width: 5%;
      }

      select {
        width: 20%;
        padding-left: 8%;
      }

      label {
        margin-top: 9px;
        font-weight: bold;
        font-size: 22px;
        color: black;
      }

      ::placeholder {
        color: black;
        opacity: 0.6;
      }

      input:focus,
      select:focus,
      textarea:focus,
      button:focus {
        outline: none;
      }

      input[title]:hover {
        font-style: italic;
        color: red;
      }
    </style>
  </head>
  <style type="text/css">
    input {
      width: 45%;
      margin-bottom: 20px;
      margin-top: 7px;
      background: transparent;
      border: none;
      color: black;
      border-bottom: 2px solid lightgreen;
    }

    input:hover {
      transition: 0.2s;
      border-bottom: 2px solid black;
    }

    button {
      width: 20%;
      background-color: #ffb3b3;
      color: black;
      height: 30px;
      border-radius: 10px;
      border: none;
    }

    input[type="submit"] {
      width: 20%;
      background-color: #ffb3b3;
      color: black;
      height: 30px;
      border-radius: 10px;
      border: none;
    }

    input[type="date"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }

    input[type="submit"]:hover {
      background-color: green;
      transition: 0.2s;
    }

    input[type="radio"] {
      width: 5%;
    }

    select {
      width: 20%;
      padding-left: 8%;
    }

    label {
      margin-top: 9px;
      font-weight: bold;
      font-size: 22px;
      color: black;
    }

    ::placeholder {
      color: black;
      opacity: 0.6;
    }

    input:focus,
    select:focus,
    textarea:focus,
    button:focus {
      outline: none;
    }
  </style>

  <body style="background-image: url(./Source_Code/assets/bg4.jpg); background-size: cover">
    <h2 style="color: black; font-size: 50px" align="center">
      Enter Your Details !
    </h2>
    <h3 style="color:red" align="center">Invalid User Credentials !</h3>
    <div style="margin-left: 25%; width: 50%">
      <form method="GET" action="Login">
        <div style="border: 2px solid black; padding: 20px">
          <label for="uname">Phone : </label><br />
          <input
            maxlength="20"
            ondblclick="return newfunc(this);"
            autocomplete="off"
            placeholder="Phone *"
            type="text"
            id="uname"
            name="uname"
          /><br />

          <label for="password">Password : </label><br />
          <input
            maxlength="15"
            ondblclick="return newfunc(this);"
            autocomplete="off"
            placeholder="Enter password *"
            type="password"
            id="pass"
            name="pass"
          /><br />
        </div>

        <button
          class="prevbtn"
          style="margin-top: 20px"
          id="submitbtn"
          type="submit"
          name="submit"
        >
          Submit
        </button>
      </form>
    </div>

    <script>
    document.getElementById("submitbtn").onclick = function () {
        if (document.getElementById("uname").value == "") {
         alert("Please insert phone !");
      
         return false;
       } else if (document.getElementById("pass").value == "") {
         alert("Please insert password !");
         return false;
       }
    };

      document.getElementById("pass").onkeyup = function () {
        var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$/;

        if (reg.test(this.value) == false) {
          this.style.borderBottom = "2px solid red";
          //playAudio();
          return false;
        }
        this.style.borderBottom = "2px solid lightgreen";

        return true;
      };

      document.getElementById("uname").onkeyup = function () {
        var reg = /^\d{10}$/;

        if (reg.test(this.value) == false) {
          this.style.borderBottom = "2px solid red";
          //playAudio();
          return false;
        }
        this.style.borderBottom = "2px solid lightgreen";
        return true;
      };




    </script>
  </body>
</html>
