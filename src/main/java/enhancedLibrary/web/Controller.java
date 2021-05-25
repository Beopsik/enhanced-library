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

    @PostMapping("/issues")
    public Long save(@RequestBody IssueSaveRequestDto IssueRequest) {
        Long saveResult;
        IssueSaveRequestDto issueData = archiver.generateIssue(IssueRequest);
        saveResult = issuesService.save(issueData);
        return saveResult;
    }

    @GetMapping("/issues/{id}")
    public List<IssuesResponseDto> getIssueInfo(@PathVariable Long id) {
        List<IssuesResponseDto> issueInfo = new ArrayList<>(issuesService.findAllByGuestId(id));
        return issueInfo;
    }

    @GetMapping("/books/{id}")
    public BooksResponseDto getBookContent(@PathVariable Long id, String queryRequest) {
        BooksResponseDto EbookContent = booksService.findById(id);
        return EbookContent;
    }
}
