class Employee   {
    id;
    firstName;
    lastName;
    email;
    phone;

    getFullName()   {
        console.log(`${this.firstName} ${this.lastName}`);
    }
}

class fullTimeEmployee extends Employee {
    annualSalary;
}

class partTimeEmployee extends Employee {
    hourSalary;
}

let fte = new fullTimeEmployee();
fte.firstName = 'Mark';
fte.lastName = 'Smith';

let pte = new partTimeEmployee();
pte.firstName = 'Paul';
pte.lastName = 'Watson';

fte.getFullName();
pte.getFullName();