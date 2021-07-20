package sywork.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sywork.back.controller.JobForm;
import sywork.back.entity.Job;
import sywork.back.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobService {

    private final JobRepository jobRepository;

    // 잡 수정
    public void update(JobForm jobForm) {
        Optional<Job> job = jobRepository.findById(jobForm.getJobId());

        job.get().setJobType(jobForm.getJobType());
        job.get().setCategory(jobForm.getCategory());
        job.get().setCategorySub(jobForm.getCategorySub());
        job.get().setJobCount(jobForm.getJobCount());
        job.get().setMemo(jobForm.getMemo());
        job.get().setOrd(jobForm.getOrd());
    }

    public List<Job> getList() {
        return jobRepository.findAll();
    }

    public void delete(JobForm jobForm) {
        try {
            jobRepository.deleteById(jobForm.getJobId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 잡 삭제


}
