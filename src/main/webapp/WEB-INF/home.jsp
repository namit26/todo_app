
<!DOCTYPE html>

<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="/todoapp/w3css/w3css.css">

    <link rel="stylesheet" href="/todoapp/w3css/mycss.css">
    <style>
        /* Center the loader */
        #loader {
            position: absolute;
            left: 50%;
            top: 50%;
            z-index: 1;
            width: 150px;
            height: 150px;
            margin: -75px 0 0 -75px;
            border: 16px solid #f3f3f3;
            border-radius: 50%;
            border-top: 16px solid #3498db;
            width: 120px;
            height: 120px;
            -webkit-animation: spin 2s linear infinite;
            animation: spin 2s linear infinite;
        }

        @-webkit-keyframes spin {
            0% { -webkit-transform: rotate(0deg); }
            100% { -webkit-transform: rotate(360deg); }
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        /* Add animation to "page content" */
        .animate-bottom {
            position: relative;
            -webkit-animation-name: animatebottom;
            -webkit-animation-duration: 1s;
            animation-name: animatebottom;
            animation-duration: 1s
        }

        @-webkit-keyframes animatebottom {
            from { bottom:-100px; opacity:0 }
            to { bottom:0px; opacity:1 }
        }

        @keyframes animatebottom {
            from{ bottom:-100px; opacity:0 }
            to{ bottom:0; opacity:1 }
        }

        #myDiv {
            display: none;
            text-align: center;
        }
    </style>

</head>

<body>



<div class="w3-bar w3-left w3-dark-grey" style="width:100%;overflow:hidden">

    <span class="w3-bar-item w3-teal" >Todo App</span>
    <form action="logout">
        <input class="w3-button w3-right w3-bar-item  w3-green w3-hover-red " type="submit" value="Log Out"/>
    </form>

    <button onclick="document.getElementById('CreateModal').style.display='block'" class="w3-button w3-hover-green w3-btn w3-gray" >Create Todo</button>
</div>

    <div id="CreateModal" class="w3-modal">
        <div class="w3-modal-content">
            <div class="w3-container">
                <span onclick="document.getElementById('CreateModal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <form class="w3-container" id="createTodoform" >
                    <div class="w3-section">
                        <label>Title</label>
                        <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Title" id="title" required>
                        <label>Description</label>
                        <textarea class="w3-input w3-border w3-margin-bottom" id="description" rows="10" cols="80" placeholder="Description" ></textarea>
                    </div>

                </form>
                <button class="w3-input w3-animate-input w3-padding-8" onclick="createtodo()">Submit</button>
            </div>
        </div>
    </div>

<div class="w3-cell-row">
<div class="w3-cell">
    <button onclick="hide('Un-AssignedTodos')" class="w3-btn w3-block w3-green w3-border w3-mobile"><h3>Un-Assigned Todos</h3></button>
    <table class="w3-table-all w3-block w3-border w3-hide" id="Un-AssignedTodos" >
        <thead>
        <tr class="w3-light-grey">
            <th>Todo Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Time</th>
            <th>Assign</th>
        </tr>
        </thead>
    </table>
    <div id="AssignModal" class="w3-modal">
        <div class="w3-modal-content">
            <div class="w3-container">
                <span onclick="document.getElementById('AssignModal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <form class="w3-container" id="AssignTodoForm" >
                    <div class="w3-section">
                        <label>Id</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="AssignId" rows="10" cols="80" ></h5>
                        <label>Title</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="AssignTitle" rows="10" cols="80" ></h5>
                        <label>Description</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="AssignDescription" rows="10" cols="80" ></h5>
                        <label>Assign to</label>
                        <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Assign to " id="AssignTo" required>
                    </div>
                </form>
                <button class="w3-input w3-animate-input w3-padding-8" onclick="assignment()" value = "Submit">Submit</button>
            </div>
        </div>
    </div>
</div>


<div class="w3-cell">
    <button onclick="hide('AssignedTodos')" class="w3-btn w3-block w3-green w3-border w3-mobile"><h3>Assigned Todos</h3></button>
    <table class="w3-table-all w3-border w3-hide" id="AssignedTodos" >
        <thead>
        <tr class="w3-light-grey">
            <th>Todo Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Time</th>
            <th>Assigned To</th>
            <th>Complete</th>
        </tr>
        </thead>
    </table>
    <div id="CompleteModal" class="w3-modal">
        <div class="w3-modal-content">
            <div class="w3-container">
                <span onclick="document.getElementById('CompleteModal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <form class="w3-container" id="CompleteTodoForm" >
                    <div class="w3-section">
                        <label>Id</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="CompleteId" rows="10" cols="80" ></h5>
                        <label>Title</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="CompleteTitle" rows="10" cols="80" ></h5>
                        <label>Description</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="CompleteDescription" rows="10" cols="80" ></h5>
                        <label>Assign to</label>
                        <h5 class="w3-input w3-border w3-margin-bottom" id="CompletedBy" rows="10" cols="80" ></h5>
                    </div>
                </form>
                <button class="w3-input w3-animate-input w3-padding-8" onclick="completion()" value = "Submit">Submit</button>
            </div>
        </div>
    </div>
</div>

<div class="w3-cell">
    <button onclick="hide('CompletedTodos')" class="w3-btn w3-block w3-green w3-border w3-mobile"><h3>Completed Todos</h3></button>
    <table class="w3-table-all w3-border w3-hide" id="CompletedTodos">
        <thead>
        <tr class="w3-light-grey">
            <th>Todo Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Time</th>
            <th>Completed By</th>
        </tr>
        </thead>
    </table>
</div>
</div>

<script type="application/javascript" src="/todoapp/javascript/todo.js"></script>
</body>


</html>
