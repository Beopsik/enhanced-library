package enhancedLibrary.web.dto;

import enhancedLibrary.domain.Issues;
import lombok.Getter;

@Getter
public class IssuesResponseDto {
    private String guestId;
    private int bookId;
    private String startDate;
    private String dueDate;
    private boolean overdueState;
    private int calculatedFine;

    public IssuesResponseDto(Issues entity){
        this.guestId=entity.getGuestId();
        this.bookId=entity.getBookId();
        this.startDate=entity.getStartDate();
        this.dueDate=entity.getDueDate();
        this.overdueState=entity.getOverdueState();
        this.calculatedFine=entity.getCalculatedFine();
    }
}
