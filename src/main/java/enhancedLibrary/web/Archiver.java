package enhancedLibrary.web;

import enhancedLibrary.web.dto.IssueSaveRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Archiver {
    Long i=0L;
    public IssueSaveRequestDto generateIssue(IssueSaveRequestDto issueRequest){
        IssueSaveRequestDto issueData=new IssueSaveRequestDto();
        issueData.setGuestId(i++);
        issueData.setTitle(issueRequest.getTitle());
        issueData.setAuthor(issueRequest.getAuthor());
        issueData.setLocation("");
        issueData.setIssuePeriod(14);
        issueData.setOverdueStatus(false);
        issueData.setCalculatedFine(0);
        return  issueData;
    }
}
