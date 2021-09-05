class Employee{
    public empId: number;
    public firstName: string;
    public lastName: string;
    public email: string;

    public getFullName(){
        console.log(`First name ${this.firstName} Last Name ${this.lastName}`);
    }

}

class FullTimeEmployee extends Employee{
    public annual: number;
}

class PartTimeEmployee extends Employee{
    public hourly: number;
}

let fte = new FullTimeEmployee();
fte.firstName = 'Mark';
fte.lastName = 'Smith';

let pte = new PartTimeEmployee();
pte.firstName = 'Paul';
pte.lastName = 'Watson';

fte.getFullName();
pte.getFullName();
console.log(fte.Id());
