package ie.atu.bookservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book getBookByTitle(String title) {
        return bookRepo.findBookByBookTitle(title);
    }
}
