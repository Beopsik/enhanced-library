package enhancedLibrary.web;

import enhancedLibrary.web.dto.BooksResponseDto;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Postprocessor {

    public List<BooksResponseDto> process(List<BooksResponseDto> bookList, String params){
        return bookList;
    }
}
