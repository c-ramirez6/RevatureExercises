//Every file or class or module are limited to that module.  User is defined in demo7
// let user = new User('Mark', 'Smith');
// user.getFullName();
//We have to import the class from the module
import{A, B} from './demo6';
import User from './demo6';
let user = new User('Mark', 'Smith');
user.getFullName();