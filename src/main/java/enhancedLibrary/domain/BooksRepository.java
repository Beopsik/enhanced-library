package enhancedLibrary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Query("SELECT '*' FROM Books")
    List<Books> findAll();

    List<Books> findByBookId(Integer bookId);

    List<Books> findAllByTitle(String title);

    List<Books> findAllByAuthor(String author);
}
