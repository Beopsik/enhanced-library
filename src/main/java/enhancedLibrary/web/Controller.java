package enhancedLibrary.web;

import enhancedLibrary.service.BooksService.BooksService;
import enhancedLibrary.service.IssuesService.IssuesService;
import enhancedLibrary.web.dto.BooksResponseDto;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import enhancedLibrary.web.dto.IssuesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller{
    private final BooksService booksService;
    private final IssuesService issuesService;
    private final Archiver archiver;

    @GetMapping("/books")
    public List<BooksResponseDto> getBooks(){
        return booksService.findAll();
    }

    @GetMapping("books/titles/{title}")
    public List<BooksResponseDto> getBooksByTitle(@PathVariable String title){
        return booksService.findAllByTitle(title);
    }
    @GetMapping("books/authors/{author}")
    public List<BooksResponseDto> getBooksByAuthor(@PathVariable String author){
        return booksService.findAllByAuthor(author);
    }

    @PostMapping("/issues")
    public String save(@RequestBody IssueSaveRequestDto IssueRequest) {
        String saveResult;
        IssueSaveRequestDto issueData = archiver.generateIssue(IssueRequest);
        saveResult = issuesService.save(issueData);
        return saveResult;
    }

    @GetMapping("/issues/{guestId}")
    public List<IssuesResponseDto> getIssueInfo(@PathVariable String guestId) {
        List<IssuesResponseDto> issueInfo = new ArrayList<>(issuesService.findAllByGuestId(guestId));
        return issueInfo;
    }

    @GetMapping("/books/{bookId}")
    public BooksResponseDto getBookContent(@PathVariable int bookId, String queryRequest) {
        BooksResponseDto EbookContent = booksService.findByBookId(bookId);
        return EbookContent;
    }
}
