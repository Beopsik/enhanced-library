package enhancedLibrary.web;

import enhancedLibrary.domain.Issues;
import enhancedLibrary.domain.IssuesRepository;
import enhancedLibrary.service.IssuesService.IssuesService;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import enhancedLibrary.web.dto.IssuesResponseDto;
import lombok.Builder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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
    private IssuesService issuesService;

    private MockMvc mvc;

    @Test
    public void save() throws Exception{
        Long guestId=1L;
        String title="title";
        String author="author";

        IssueSaveRequestDto issueSaveRequestDto=IssueSaveRequestDto.builder()
                .guestId(guestId)
                .title(title)
                .author(author)
                .build();

        String url="http://localhost:"+port+"/issues";

        ResponseEntity<Long> responseEntity=restTemplate.
                postForEntity(url, issueSaveRequestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Issues> all=issuesRepository.findAll();
        assertThat(all.get(0).getGuestId()).isEqualTo(guestId);
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    public void getIssueInfo() {
        for(int i=1; i<=2; i++) {
            Long guestId = 1L;
            String title = "title"+i;
            String author = "author"+i;

            IssueSaveRequestDto issueSaveRequestDto = IssueSaveRequestDto.builder()
                    .guestId(guestId)
                    .title(title)
                    .author(author)
                    .build();

            String url="http://localhost:"+port+"/issues";

            ResponseEntity<Long> responseEntity = restTemplate.
                    postForEntity(url, issueSaveRequestDto, Long.class);

            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(responseEntity.getBody()).isGreaterThan(0L);
        }

        String url="http://localhost:"+port+"/issues/"+1L;

        HttpEntity<Long> requestEntity=new HttpEntity<>(1L);

        ResponseEntity<List> responseEntity=restTemplate.
                getForEntity(url, List.class);
        //List<IssuesResponseDto> list=restTemplate.getForObject(url,List.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Issues> list=issuesRepository.findAllByGuestId(1L);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getGuestId());
            System.out.println(list.get(i).getTitle());
            System.out.println(list.get(i).getAuthor());
            System.out.println(list.get(i).getIssuePeriod());
            System.out.println(list.get(i).getCalculatedFine());
        }
    }

    @Test
    public void getBookContent() {
    }
}