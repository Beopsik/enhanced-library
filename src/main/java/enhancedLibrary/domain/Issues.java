package enhancedLibrary.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueIndex;

    @Column(length = 45, nullable = false)
    private String guestId;

    @Column(nullable = false)
    private Integer bookId;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String dueDate;

    @Column(nullable = false)
    private Boolean overdueState;

    @Column(nullable = false)
    private Integer calculatedFine;

    @Builder
    public  Issues(String guestId, int bookId, String startDate, String dueDate,
                                boolean overdueState, int calculatedFine){
        this.guestId=guestId;
        this.bookId=bookId;
        this.startDate=startDate;
        this.dueDate=dueDate;
        this.overdueState=overdueState;
        this.calculatedFine=calculatedFine;
    }
}
