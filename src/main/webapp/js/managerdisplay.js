document.addEventListener("DOMContentLoaded", function(e) {
  createOnStartup();
});

let uUrl = "http://localhost:8080/Project1/viewemployees.json";
let rUrl = "http://localhost:8080/Project1/allreimbs.json";
// let updateUrl = "http://localhost:8080/Project1/update.go"

const createOnStartup = () => {
  sendAjaxGet(uUrl, display);
  sendAjaxGet(rUrl, displayReimbTable);
  // sendAJaxGet(updateUrl, displayReimbTable);
};

let sendAjaxGet = (url, func) => {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      func(this);
    }
  };
  xhr.open("GET", url, true);
  xhr.send();
};

let display = (xhr) => {
  let reqArr = JSON.parse(xhr.responseText)["list"];
  let table = document.getElementById("eTable");

  let body = document.createElement("tbody");

  table.appendChild(body);

  for (let req of reqArr) {
    console.log(req);

    let row = document.createElement("tr");

    row.innerHTML = `<td>${req.firstName +
      " " +
      req.lastName}</td>
				<td>${req.username}</td>
				<td>${req.userId}</td> 
				`;
    table.appendChild(row);
  }
};

let displayReimbTable = (xhr) => {
  let reqArr = JSON.parse(xhr.responseText)["list"];
  let table = document.getElementById("rTable");
  let selector = document.getElementById("reimburseselect");
  let body = document.createElement("tbody");

  table.appendChild(body);

  for (let req of reqArr) {
    console.log(req);

    let row = document.createElement("tr");
    let newOp = document.createElement("option");
    let resStatus;

    console.log(req.statusId);
    
    switch(req.statusId) {
        case 1:
            resStatus = "PENDING";
            // break;
        case 2:
            resStatus = "APPROVED";
            break;
        case 3: 
            resStatus = "PENDING";
            break;
        default : 
            console.log("Status Error.");
    }

    if (req.statusId != 1) {
        
    

    row.innerHTML = 
        `<td>${req.author}</td>
        <td>${req.statusId}</td> 
        <td>${req.description}</td>
        <td>$${req.amount}</td> 
        <td>${req.resolver}</td>
				`;
    table.appendChild(row);
  } else {
      newOp.value = req.reimbId;
      newOp.text = `Author: ${req.author}, Amount: $${req.amount},  Description: ${req.description}`;
      
      selector.appendChild(newOp);
  }
  }
};
