package sywork.back.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sywork.back.controller.JobForm;
import sywork.back.entity.Job;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JobServiceTest {

    @Autowired
    JobService jobService;

    @Test
    void 잡수정테스트() {

        JobForm jobForm = JobForm.builder()
                .jobId(1L)
                .jobType("5")
                .jobCount(5)
                .category("카테고리")
                .memo("메모222")
                .build();

        System.out.println("jobForm category = " + jobForm.getCategory());

        jobService.update(jobForm);

        List<Job> jobList = jobService.getList();

        for (Job job : jobList) {
            System.out.println("job = " + job.toString());
        }
    }

    @Test
    void 잡삭제테스트() {

        JobForm jobForm = JobForm.builder()
                .jobId(1L)
                .build();

        jobService.delete(jobForm);
    }

}