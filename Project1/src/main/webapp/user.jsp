<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>
    <div class="container" style="width: 50%; margin-top: 15px;">
        <div class="card">
            <div class="card-body">
                <h1>User Page</h1>
                <form action="addservlet" method="POST">
                    <h2>Add Reimbursement</h2>
                    <div class="mb-3">
                        <label for="">Amount Spent</label>
                        <input type="number" name="amount" step="0.01" placeholder="amount in $" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="">Type of expense</label>
                        <select name="type" id="" class="form-control">
                            <option value="lodging">Lodging</option>
                            <option value="food">Food</option>
                            <option value="travel">Travel</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="">Description of the expense</label>
                        <input type="text" name="description" id="" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="">When was the expense</label>
                        <input type="date" name="date" id="" class="form-control">
                    </div>
                    <div class="mb-3">
                        <input type="submit" value="Submit Reimbursement" class="btn btn-success">
                    </div>
                </form>
            </div>
        </div>
        <form action="listservlet" method="get" style="margin: 5px;">
            <input type="submit" value="Get Reimbursements" class="btn btn-primary">
        </form>
        <form action="logoutservlet" method="post" style="margin: 5px;">
            <input type="submit" value="LogOut" class="btn btn-outline-danger">
        </form>
    </div>
</body>

</html>