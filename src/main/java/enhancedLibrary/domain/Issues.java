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
    private Long guestId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer issuePeriod;

    @Column(nullable = false)
    private boolean overdueStatus;

    @Column(nullable = false)
    private Integer calculatedFine;

    @Builder
    public  Issues(Long guestId, String title, String author,
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


}
