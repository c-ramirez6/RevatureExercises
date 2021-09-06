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
    <div class="container-sm" style="width: 50%; margin-top: 15px;">
        <div class="card">
            <div class="card-body" style="margin: 0 auto;">
                <h1>Admin Page</h1>
                <form action="adminservlet" method="get" style="padding: 10px;">
                    <input type="submit" value="Work with reimbursements" class="btn btn-primary">
                </form>
    
                <form action="logoutservlet" method="post"  style="padding: 10px;">
                    <input type="submit" value="LogOut" class="btn btn-outline-danger">
                </form>
            </div>
        </div>
    </div>

</body>

</html>