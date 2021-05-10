package enhancedLibrary.web;

import enhancedLibrary.domain.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {
    private final BooksRepository booksRepository;

    public void temp(){
    }
}
