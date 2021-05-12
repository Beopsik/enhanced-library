package enhancedLibrary.web.dto;

import enhancedLibrary.domain.Issues;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IssueSaveRequestDto{
    private Long guestId;
    private String title;
    private String author;
    private String location;
    private int issuePeriod;
    private boolean overdueStatus;
    private int calculatedFine;

    @Builder
    public  IssueSaveRequestDto(Long guestId, String title, String author,
                                String location, int issuePeriod,
                                boolean overdueStatus, int calculatedFine){
        this.guestId=guestId;
        this.title=title;
        this.author=author;
        this.location=location;
        this.issuePeriod=issuePeriod;
        this.overdueStatus=overdueStatus;
        this.calculatedFine=calculatedFine;
    }

    public Issues toEntity(){
        return Issues.builder()
                .guestId(guestId)
                .title(title)
                .author(author)
                .location(location)
                .issuePeriod(issuePeriod)
                .overdueStatus(overdueStatus)
                .calculatedFine(calculatedFine)
                .build();
    }

}
