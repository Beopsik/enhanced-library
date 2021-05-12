package enhancedLibrary.service.IssuesService;

import enhancedLibrary.domain.IssuesRepository;
import enhancedLibrary.web.dto.IssueSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class IssuesService {
    private final IssuesRepository issuesRepository;

    @Transactional
    public Long save(IssueSaveRequestDto issueData){
        return issuesRepository.save(issueData.toEntity()).getGuestId();
    }
}
