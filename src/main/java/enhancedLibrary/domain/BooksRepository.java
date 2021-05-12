package enhancedLibrary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query("SELECT '*' FROM Books")
    List<Books> findAll();

    List<Books> findAllByTitle(String title);

    List<Books> findAllByAuthor(String author);
}
