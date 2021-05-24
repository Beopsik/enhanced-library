package enhancedLibrary.web;

import enhancedLibrary.service.BooksService.BooksService;
import enhancedLibrary.service.IssuesService.IssuesService;
import enhancedLibrary.web.dto.BooksResponseDto;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import enhancedLibrary.web.dto.IssuesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class controller {
    private final BooksService booksService;
    private final IssuesService issuesService;
    private final Archiver archiver;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("EbookList", booksService.findAll());
        return "index";
    }
    @GetMapping("/issue/save")
    public String IssueSave(){
        return "issue-save";
    }
    @GetMapping("/issue/show")
    public String IssueShow(Model model){
        return "issue-show";
    }
    @GetMapping("/issue/show/{id}")
    public String IssueShowById(@PathVariable Long id, Model model){
        model.addAttribute("IssueList", issuesService.findAllByGuestId(id));
        return "issue-show";
    }

    @PostMapping("/issue")
    public @ResponseBody Long save(@RequestBody IssueSaveRequestDto IssueRequest){
        Long saveResult;
        IssueSaveRequestDto issueData=archiver.generateIssue(IssueRequest);
        saveResult=issuesService.save(issueData);
        return saveResult;
    }

   @GetMapping("/issues/{id}")
    public List<IssuesResponseDto> getIssueInfo(@PathVariable Long id, String queryRequest){
        List<IssuesResponseDto> issueInfo=new ArrayList<>(issuesService.findAllByGuestId(id));
        return issueInfo;
    }

    @GetMapping("/books/{id}")
    public BooksResponseDto getBookContent(@PathVariable Long id, String queryRequest){
        BooksResponseDto EbookContent= booksService.findById(id);
        return EbookContent;
    }
}
