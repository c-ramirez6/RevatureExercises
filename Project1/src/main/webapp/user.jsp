<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="listservlet" method="get">
        <input type="submit" value="Get Reimbursements">
    </form>
    <form action="addservlet" method="POST">

        <h2>Add Reimbursement</h2>
        <input type="number" name="amount" step="0.01" placeholder="amount in $">
        <select name="type" id="">
            <option value="lodging">Lodging</option>
            <option value="food">Food</option>
            <option value="travel">Travel</option>
            <option value="other">Other</option>
        </select>
        <input type="text" name="description" id="" placeholder="description of expense">
        <label for="">When was the expense</label>
        <input type="date" name="date" id="">
        <input type="submit" value="Submit Reimbursement">
    </form>
</body>
</html>