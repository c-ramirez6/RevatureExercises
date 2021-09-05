//Exporting module
export default class User{
    constructor(
        public firstName: string,
        public lastName: string
    ){}

    getFullName()   {
        console.log(`${this.firstName} ${this.lastName}`);
    }
}

let user = new User('Mark', 'Smith');
user.getFullName();

//You can have multiple classes in a module and export all of them

export class A{

}
export class B{
    
}
class C{
    
}