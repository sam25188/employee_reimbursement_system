let user;

window.onload = async function(){
    
    let response = await fetch("http://localhost:9001/session");

    let responseBody = await response.json();
    
    if(!responseBody.success){
        window.location="../";
    }


    user = responseBody.data;
    console.log(user)


    getAllLists();
}
async function getAllLists(){

    /* let listContainerElem = document.getElementById("list-container");
    listContainerElem.innerHTML = "";  */
    
    let response = await fetch(`http://localhost:9001/reimbursement/`);

    let responseBody = await response.json();

    console.log(responseBody)

    let lists = responseBody.data;


    lists.forEach(list => {
        showList(list)
        showListTwo(list)
    });


}
function showList(list){


    let listContainerElem = document.getElementById("list-container");

    let listCardElem = document.createElement("li");
    listCardElem.className = "list-item"

    listCardElem.innerHTML = 
    `${list.id} , ${list.amount}, ${list.userId},${list.statusId}`


    listContainerElem.appendChild(listCardElem);
}

function showListTwo(list){


    let listContainerElem = document.getElementById("selectboxtwo");

    let listCardElem = document.createElement("option");
    listCardElem.className = "list-item-two"
    listCardElem.value = `${list.id}`

    listCardElem.innerHTML = 
    `${list.id} , ${list.amount}, ${list.userId},${list.statusId}`


    listContainerElem.appendChild(listCardElem);


}

async function approveOrDeny(){
    //stops form from reloading
    //event.preventDefault();

    //retrieve from DOM 
    let reimbursementIdInputElem = document.getElementById("selectboxtwo");
    let statusIdInputElem = document.getElementById("select-box");
    //getting values from input elems and putting them into objects 
    let request = {
        id: reimbursementIdInputElem.value,
        resolverId: user.id,
        statusId: statusIdInputElem.value,

        

    }
    console.log(request)
    //sending the http request
     let response = await fetch(`http://localhost:9001/reimbursement/${request.id}/${request.resolverId}/${request.statusId}`, {
         method: "PATCH",
         body: JSON.stringify(request)
    })


    //retrieve response body 
     let responseBody = await response.json();

     console.log(responseBody)
    
     }


