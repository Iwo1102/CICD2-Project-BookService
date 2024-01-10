package ie.atu.bookservice;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBook/{title}")
    Book getBook(@PathVariable String title) {
        Book book = bookService.getBookByTitle(title);

        return book;
    }

    @PostMapping("/saveBook")
    public String addBookToRepo(@RequestBody Book book) {
        if (book == null) {
            return "No book found";
        }
        bookService.addBook(book);
        return "Added book " + book.getBookTitle();
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookFromRepo(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted";
    }

    @PutMapping("/updateBook/{title}")
    String editBookInRepo(@PathVariable String title, @RequestBody Book book){
        bookService.updateBook(title, book);
        return "Book updated";
    }

}
