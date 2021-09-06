<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reimbursement System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>
    <div class="container-sm" style="width: 30%; margin-top: 15px;">
        <div class="card">
            <img src="photo.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h1>Reimbursement Login</h1>
                <form action="loginservlet" method="post">
                    <div class="mb-3">
                        <label for="">Username</label>
                        <input type="text" name="username" class="form-control" aria-describedby="usernameHelp">
                        <div class="form-text" id="usernameHelp">Please enter your company issued username</div>
                    </div>
                    <div class="mb-3">
                        <label for="">Password</label>
                        <input type="password" name="password" class="form-control">
                    </div>
                    <div class="mb-3">
                        <input type="submit" value="Login" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>