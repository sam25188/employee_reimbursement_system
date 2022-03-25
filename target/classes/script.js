//runs once the page loads 
document.getElementById("login-form").addEventListener("submit",async function(event){
    //stops form from reloading
    event.preventDefault();

    //retrieve from DOM 
    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");
    
    //getting values from input elems and putting them into objects 
    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }
    //sending the http request
    let response = await fetch("http://localhost:9001/login", {
        method: "POST",
        body: JSON.stringify(user)
    })
    //retrieve response body 
    let responseBody = await response.json();

    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        if(responseBody.data.roleId == 1){
            window.location = `./managerdashboard?userId=${responseBody.data.id}`
        }else{
            window.location = `./employeedashboard?userId=${responseBody.data.id}`
        }
        

        //redirect page to dashboard on successful login
        //window.location = "./dashboard?userId=" + responseBody.data.id
        //template literal below 
        
        

    }

})

