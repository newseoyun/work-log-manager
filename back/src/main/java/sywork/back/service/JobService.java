package sywork.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sywork.back.repository.JobRepository;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;




}
