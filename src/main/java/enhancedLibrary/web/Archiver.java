package enhancedLibrary.web;

import enhancedLibrary.web.dto.IssueSaveRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Archiver {
    public IssueSaveRequestDto generateIssue(IssueSaveRequestDto issueRequest){
        IssueSaveRequestDto issueData=new IssueSaveRequestDto();
        issueData.setGuestId(issueRequest.getGuestId());
        issueData.setBookId(issueRequest.getBookId());
        issueData.setStartDate(issueRequest.getStartDate());
        issueData.setDueDate(issueRequest.getDueDate());
        issueData.setOverdueState(issueRequest.isOverdueState());
        issueData.setCalculatedFine(issueRequest.getCalculatedFine());
        return  issueData;
    }
}
