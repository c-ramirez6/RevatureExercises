var Book = /** @class */ (function () {
    function Book(title, author, price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    Book.prototype.getBookInfo = function () {
        console.log("Book: Title=" + this.title + ", Author=" + this.author + ", Price=" + this.price);
    };
    return Book;
}());
var book1 = new Book('Title 1', 'Mark', 20);
// console.log('Book: Title=' + book1.title + ', Author=' + book1.author + ', Price=' + book1.price);
book1.getBookInfo();
var book2 = new Book('Title 2', 'Paul', 30);
// console.log('Book: Title=' + book2.title + ', Author=' + book2.author + ', Price=' + book2.price);
book2.getBookInfo();
