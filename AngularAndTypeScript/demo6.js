var User = /** @class */ (function () {
    function User(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    User.prototype.getFullName = function () {
        console.log(this.firstName + " " + this.lastName);
    };
    return User;
}());
var user = new User('Mark', 'Smith');
user.getFullName();
