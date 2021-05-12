package enhancedLibrary.web;

import enhancedLibrary.service.BooksService.BooksService;
import enhancedLibrary.service.IssuesService.IssuesService;
import enhancedLibrary.web.dto.BooksResponseDto;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {
    private final BooksService booksService;
    private final IssuesService issuesService;
    private final Postprocessor postprocessor;
    private final Archiver archiver;

    @GetMapping("/")
    public List<BooksResponseDto> get(String queryRequest){
        List<BooksResponseDto> bookList = new ArrayList<>(booksService.findAll());
        List<BooksResponseDto> processed = postprocessor.process(bookList, "");
        return processed;
    }

    @PostMapping("")
    public Long save(String IssueRequest){
        Long saveResult;
        IssueSaveRequestDto issueData=archiver.generateIssue(IssueRequest);
        saveResult=issuesService.save(issueData);
        return saveResult;
    }
}
