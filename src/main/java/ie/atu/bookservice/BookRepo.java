package ie.atu.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {

    Book findBookByBookTitle(String title);
}
