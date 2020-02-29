document.addEventListener("DOMContentLoaded", function (e) {
  createOnStartup();
})

let uUrl = "http://localhost:8080/Project1/employee.json"
let rUrl = "http://localhost:8080/Project1/reimb.json"


const createOnStartup = () => {
  sendAjaxGet(uUrl, display);
  sendAjaxGet(rUrl, displayReimbTable);
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
  let reqArr1 = JSON.parse(xhr.responseText)['list'];
  let table1 = document.getElementById("tEmp");

  console.log(reqArr1);

  let body1 = document.createElement("tbody");

  table1.appendChild(body1);

  
  // for (let req1 of reqArr1) {
    // console.log(req1);
    
    let row1 = document.createElement("tr");
    // console.log(req1);
    
    row1.innerHTML =
    `<td>${reqArr1.userId}</td>
    <td>${reqArr1.firstName}</td>
    <td>${reqArr1.lastName}</td> 
    <td>${reqArr1.username}</td> 
    `;
  table1.appendChild(row1);
  // }
};

let displayReimbTable = (xhr) => {
  
  //let reqArr = JSON.parse(xhr.responseText)['list'];
  let reqArr = JSON.parse(xhr.responseText);
  console.log(reqArr);
  let table = document.getElementById("tReimb");

  let body = document.createElement("tbody");

  table.appendChild(body);

  for (let req of reqArr) {
    console.log(req);
    let row = document.createElement("tr");

      row.innerHTML =
       `<td>${req.reimbId}</td>
        <td>$${req.amount}</td> 
        <td>${req.resolver}</td> 
        <td>${req.description}</td>
        <td>${req.typeId}</td> 
        <td>${req.submitted}</td>
        <td>${req.resolved}</td>
		    <td>${req.statusId}</td>
				`;
      table.appendChild(row);
    }
};

document.getElementById("displayReimbTable").style.display = "none";

// reimbView is linked to the button with reimbView id
document.getElementById("reimbView").onclick = function() {
  document.getElementById("displayReimbTable").style.display = "block";
  sendAjaxGet("", displayReimbTable);
};

// reimbCreate is linked to the button with reimbCreate id
document.getElementById("submit").onclick = function() {
  document.getElementById("submitoccured").innerHTML = "Request submitted!";
};

let time = (arr[i])['submitTime'];
        let minute = time.minute;
        let pad = '';
        if(minute < 10) pad = '0';
        let subt = `${time.monthValue}/${time.dayOfMonth}/${time.year} ${time.hour}:${pad}${minute}`;
