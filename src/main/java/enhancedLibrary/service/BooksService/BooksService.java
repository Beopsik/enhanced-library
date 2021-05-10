package enhancedLibrary.service.BooksService;

import enhancedLibrary.domain.Books;
import enhancedLibrary.domain.BooksRepository;
import enhancedLibrary.web.dto.BooksResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Transactional(readOnly = true)
    public List<BooksResponseDto> findAll(){
        return booksRepository.findAll().stream()
                .map(BooksResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public BooksResponseDto findById(Long id){
        Books entity=booksRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("No book"));

        return new BooksResponseDto(entity);
    }
}
