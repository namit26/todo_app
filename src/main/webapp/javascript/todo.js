

function createtodo() {
    var title = document.getElementById("title").value;
    var desc = document.getElementById("description").value;
    var params = "title=" + title + "&description=" + desc;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert("Todo Created");

            updateEverything();
        }
    };
    document.getElementById('CreateModal').style.display='none';
    xhttp.open("POST","createTodo",true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(params);
}

function unAssignEdit(todoId) {
    var params = "todoId=" + todoId;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            if(this.getResponseHeader("content-type").split(";")[0] == "application/json"){
                var todoContent = JSON.parse(this.responseText);
                document.getElementById("AssignId").innerHTML = todoContent[1][0];
                document.getElementById("AssignTitle").innerHTML = todoContent[1][1];
                document.getElementById("AssignDescription").innerHTML =  todoContent[1][2];
                document.getElementById('AssignModal').style.display='block';
            } else{
                alert(this.responseText);
                updateEverything();
            }
        }
    }
    xhttp.open("POST","assignTodo",true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(params);
}

function assignEdit(todoId) {
    var params = "todoId=" + todoId;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            if(this.getResponseHeader("content-type").split(";")[0] == "application/json"){
                var todoContent = JSON.parse(this.responseText);
                document.getElementById("CompleteId").innerHTML = todoContent[1][0];
                document.getElementById("CompleteTitle").innerHTML = todoContent[1][1];
                document.getElementById("CompleteDescription").innerHTML =  todoContent[1][2];
                document.getElementById("CompletedBy").innerHTML =  todoContent[1][3];
                document.getElementById('CompleteModal').style.display='block';
            } else{
                alert(this.responseText);
                updateEverything();
            }
        }
    }
    xhttp.open("POST","completeTodo",true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(params);
}

function assignment() {
    var todoId = document.getElementById("AssignId").innerHTML;
    var assignTo = document.getElementById("AssignTodoForm").elements[0].value;
    var params = "todoId=" + todoId + "&assignTo=" + assignTo;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState ==4 && this.status == 200){
            if(this.getResponseHeader("content-type").split(";")[0] == "application/json"){
                alert("Todo is assigned");
                updateEverything();
            } else{
                alert(this.responseText);
                updateEverything();
            }
        }
    }
    document.getElementById('AssignModal').style.display='none';
    xhttp.open("POST","assignment",true);
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhttp.send(params);
}

function completion() {
    var todoId = document.getElementById("CompleteId").innerHTML;
    var params = "todoId=" + todoId;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState ==4 && this.status == 200){
            if(this.getResponseHeader("content-type").split(";")[0] == "application/json") {
                alert("Todo is Completed");
                updateEverything();
            }
            else{
                alert(this.responseText);
                updateEverything();
            }
        }
    }
    document.getElementById('CompleteModal').style.display = 'none';
    xhttp.open("POST","completion",true);
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhttp.send(params);
}

function hide(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

function dumpUnAssignedTasks(task) {
    var unAssignedTable = document.getElementById("Un-AssignedTodos");
    var row = unAssignedTable.insertRow();
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    cell1.innerHTML = task[1];
    cell2.innerHTML = task[2];
    cell3.innerHTML = task[3];
    cell4.innerHTML = task[4];
    cell5.innerHTML = "<button onclick=\'unAssignEdit(" +  task[1] + ")\'>Edit</button>";
}
function dumpAssignedTasks(task) {

    var unAssignedTable = document.getElementById("Un-AssignedTodos");
    var rowToDelete = null;
    for (var i = 1, row; row = unAssignedTable.rows[i]; i++) {
        if(row.cells[0].innerHTML == task[1]){
            rowToDelete = i;
            break;
        }
    }
    unAssignedTable.deleteRow(rowToDelete);

    var assignedTable = document.getElementById("AssignedTodos");
    var row = assignedTable.insertRow();
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    cell1.innerHTML = task[1];
    cell2.innerHTML = task[2];
    cell3.innerHTML = task[3];
    cell4.innerHTML = task[4];
    cell5.innerHTML = task[5]
    cell6.innerHTML = "<button onclick=\'assignEdit("+ task[1] +")'>Completed</button>";
}
function dumpCompletedTasks(task) {
    var assignedTable = document.getElementById("AssignedTodos");
    var rowToDelete = null;
    for (var i = 1, row; row = assignedTable.rows[i]; i++) {
        if(row.cells[0].innerHTML == task[1]){
            rowToDelete = i;
            break;
        }
    }
    console.log(rowToDelete);
    if(rowToDelete != null) {
        assignedTable.deleteRow(rowToDelete);
    }

    var completedTable = document.getElementById("CompletedTodos");
    var row = completedTable.insertRow();
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    cell1.innerHTML = task[1];
    cell2.innerHTML = task[2];
    cell3.innerHTML = task[3];
    cell4.innerHTML = task[4];
    cell5.innerHTML = task[5];
}

function updateEverything(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            if(this.getResponseHeader("content-type").split(";")[0] == "application/json") {
                var tasks = JSON.parse(this.responseText);
                for (var key in tasks) {
                    if (tasks.hasOwnProperty(key)) {
                        if (tasks[key][0] == "UnAssigned") {
                            dumpUnAssignedTasks(tasks[key]);
                        }
                        else if (tasks[key][0] == "Assigned") {
                            dumpAssignedTasks(tasks[key]);
                        }
                        else if (tasks[key][0] == "Completed") {
                            dumpCompletedTasks(tasks[key]);
                        }
                    }
                }
            }
            else{
                alert("Not Logged In. Go Back");
            }
        }
    }
    xhttp.open("GET","updateEverything",true);
    xhttp.send();
}
updateEverything();
setInterval(updateEverything,10000);


