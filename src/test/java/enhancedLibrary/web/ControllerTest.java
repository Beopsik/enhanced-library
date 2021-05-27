package enhancedLibrary.web;

import enhancedLibrary.domain.Books;
import enhancedLibrary.domain.BooksRepository;
import enhancedLibrary.domain.Issues;
import enhancedLibrary.domain.IssuesRepository;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IssuesRepository issuesRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Test
    public void save(){
        String guestId="1";
        int bookId=1;
        String startDate="2017/07/07";
        String dueDate="2017/07/23";
        Boolean overdueState=false;
        int calculatedFine=0;

        IssueSaveRequestDto issueSaveRequestDto=IssueSaveRequestDto.builder()
                .guestId(guestId)
                .bookId(bookId)
                .startDate(startDate)
                .dueDate(dueDate)
                .overdueState(overdueState)
                .calculatedFine(calculatedFine)
                .build();

        String url="http://localhost:"+port+"/issues";

        ResponseEntity<String> responseEntity=restTemplate.
                postForEntity(url, issueSaveRequestDto, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Issues> all=issuesRepository.findAll();
        assertThat(all.get(0).getGuestId()).isEqualTo(guestId);
        assertThat(all.get(0).getBookId()).isEqualTo(bookId);
        assertThat(all.get(0).getStartDate()).isEqualTo(startDate);
        assertThat(all.get(0).getDueDate()).isEqualTo(dueDate);
        assertThat(all.get(0).getOverdueState()).isEqualTo(overdueState);
        assertThat(all.get(0).getCalculatedFine()).isEqualTo(calculatedFine);
    }

    @Test
    public void getIssueInfo() {
        for(int i=1; i<=2; i++) {
            String guestId = "1";
            int bookId=i;
            String startDate="2017/07/07";
            String dueDate="2017/07/23";
            Boolean overdueState=false;
            int calculatedFine=0;

            IssueSaveRequestDto issueSaveRequestDto = IssueSaveRequestDto.builder()
                    .guestId(guestId)
                    .bookId(bookId)
                    .startDate(startDate)
                    .dueDate(dueDate)
                    .overdueState(overdueState)
                    .calculatedFine(calculatedFine)
                    .build();

            String url="http://localhost:"+port+"/issues";

            ResponseEntity<String> responseEntity = restTemplate.
                    postForEntity(url, issueSaveRequestDto, String.class);

            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        List<Issues> list=issuesRepository.findAllByGuestId("1");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getGuestId());
            System.out.println(list.get(i).getBookId());
            System.out.println(list.get(i).getStartDate());
            System.out.println(list.get(i).getDueDate());
            System.out.println(list.get(i).getOverdueState());
            System.out.println(list.get(i).getCalculatedFine());
        }
    }

    @Test
    public void getBookContent() {
        int bookId=0;
        String title = "title";
        String author = "author";
        String image_path="image_path";
        String description="description";
        int price=0;
        int quantity=1;
        String location="location";
        String ebookFile_path="ebookFile_path";
        String bookType="paper";

        Books books=new Books(bookId, null, title, author, image_path, description, price, quantity, location, ebookFile_path, bookType);
        booksRepository.save(books);

        Optional<Books> result=booksRepository.findById(0);
        assertThat(result.get().getBookId()).isEqualTo(bookId);
        assertThat(result.get().getTitle()).isEqualTo(title);
        assertThat(result.get().getAuthor()).isEqualTo(author);
        assertThat(result.get().getImage_path()).isEqualTo(image_path);
        assertThat(result.get().getDescription()).isEqualTo(description);
        assertThat(result.get().getPrice()).isEqualTo(price);
        assertThat(result.get().getQuantity()).isEqualTo(quantity);
        assertThat(result.get().getLocation()).isEqualTo(location);
        assertThat(result.get().getEbookFile_path()).isEqualTo(ebookFile_path);
    }
}