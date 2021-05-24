package enhancedLibrary.web.dto;

import enhancedLibrary.domain.Issues;
import lombok.Getter;

@Getter
public class IssuesResponseDto {
    private Long guestId;
    private String title;
    private String author;
    private String location;
    private int issuePeriod;
    private boolean overdueStatus;
    private int calculatedFine;

    public IssuesResponseDto(Issues entity){
        this.guestId=entity.getGuestId();
        this.title=entity.getTitle();
        this.author= entity.getAuthor();
        this.location=entity.getLocation();
        this.issuePeriod=entity.getIssuePeriod();
        this.overdueStatus=entity.getOverdueStatus();
        this.calculatedFine=entity.getCalculatedFine();
    }
}
