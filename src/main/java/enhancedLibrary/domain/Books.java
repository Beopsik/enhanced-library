package enhancedLibrary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(length = 50, nullable = false)
    private String image_path;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(length = 50, nullable = false)
    private String ebookFile_path;

    @Builder
    public Books(String title, String author, String image_path,
                 String description, Integer price, Integer quantity,
                 String location, String ebookFile_path){
        this.title=title;
        this.author=author;
        this.image_path=image_path;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
        this.location=location;
        this.ebookFile_path=ebookFile_path;
    }
}
