package enhancedLibrary.web.dto;

import enhancedLibrary.domain.Books;

public class BooksResponseDto {
    private Long id;
    private String title;
    private String author;
    private String image_path;
    private String description;
    private int price;
    private int quantity;
    private String location;
    private String ebookFile_path;

    public BooksResponseDto(Books entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.author=entity.getAuthor();
        this.image_path=entity.getImage_path();
        this.description=entity.getDescription();
        this.price=entity.getPrice();
        this.quantity=entity.getQuantity();
        this.location=entity.getLocation();
        this.ebookFile_path=entity.getEbookFile_path();
    }
}