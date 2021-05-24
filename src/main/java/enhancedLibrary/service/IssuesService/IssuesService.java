package enhancedLibrary.service.IssuesService;

import enhancedLibrary.domain.IssuesRepository;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import enhancedLibrary.web.dto.IssuesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IssuesService {
    private final IssuesRepository issuesRepository;

    @Transactional
    public Long save(IssueSaveRequestDto issueData){
        return issuesRepository.save(issueData.toEntity()).getGuestId();
    }

    @Transactional
    public List<IssuesResponseDto> findAllByGuestId(Long guestId){
        return issuesRepository.findAllByGuestId(guestId).stream()
                .map(IssuesResponseDto::new)
                .collect(Collectors.toList());
    }
}
