let user;

 window.onload = async function getEmpList(){
    
    let response = await fetch("http://localhost:9001/session");

    let responseBody = await response.json();
    
    if(!responseBody.success){
        window.location="../";
    }


    user = responseBody.data;
    console.log(user)


   
}
async function getReimbursementListsForEmployee(){

    /* let listContainerElem = document.getElementById("list-container");
    listContainerElem.innerHTML = "";  */
    
    let response = await fetch(`http://localhost:9001/reimbursement/${user.id}/list`);

    let responseBody = await response.json();

    console.log(responseBody)

    let lists = responseBody.data;


    lists.forEach(list => {
        showList(list)
    });


}
function showList(list){


    let listContainerElem = document.getElementById("list-container");

    let listCardElem = document.createElement("li");
    listCardElem.className = "list-item"

    listCardElem.innerHTML = 
    `${list.id} , ${list.amount}, ${list.userId}`


    listContainerElem.appendChild(listCardElem);
}

async function createReimbRequest(event){
    //stops form from reloading
    event.preventDefault();

    //retrieve from DOM 
    let amountInputElem = document.getElementById("amount");
    let userInputElem = document.getElementById("user");
    let typeIdInputElem = document.getElementById("select-box");
    //getting values from input elems and putting them into objects 
    let request = {
        amount: amountInputElem.value,
        userId: user.id,
        typeId: typeIdInputElem.value,

        

    }
    console.log(request)
    //sending the http request
     let response = await fetch(`http://localhost:9001/reimbursement/${user.id}/reimbursement`, {
         method: "POST",
         body: JSON.stringify(request)
    })


    //retrieve response body 
     let responseBody = await response.json();

     console.log(responseBody)
       
     }