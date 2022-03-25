//runs once the page loads 
document.getElementById("register-form").addEventListener("submit",async function(event){
    //stops form from reloading
    event.preventDefault();

    //retrieve from DOM 
    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");
    let firstNameInputElem = document.getElementById("firstname");
    let lastNameInputElem = document.getElementById("lastname");
    let emailInputElem = document.getElementById("email");
    let roleIdInputElem = document.getElementById("roleId");
    //getting values from input elems and putting them into objects 
    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value,
        firstName: firstNameInputElem.value,
        lastName: lastNameInputElem.value,
        email: emailInputElem.value,
        roleId: roleIdInputElem.value
    }
    //sending the http request
    let response = await fetch("http://localhost:9001/user", {
        method: "POST",
        body: JSON.stringify(user)
    })
    //retrieve response body 
    let responseBody = await response.json();

    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        window.location = `../`
        //redirect page to login page on successful registration 
       
    }

})