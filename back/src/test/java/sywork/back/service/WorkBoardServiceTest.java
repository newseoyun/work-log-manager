package sywork.back.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import sywork.back.controller.JobForm;
import sywork.back.controller.WorkBoardForm;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.JobRepository;
import sywork.back.repository.WorkBoardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class WorkBoardServiceTest {

    @Autowired
    WorkBoardRepository workBoardRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    WorkBoardService workBoardService;

    @Test
    void 등록하기() {

        WorkBoardForm workBoardForm = WorkBoardForm.builder()
                .acceptType("티켓")
                .build();

        WorkBoard workBoard = WorkBoard.builder()
                .acceptType(workBoardForm.getAcceptType())
                .build();

        WorkBoard savedWork = workBoardRepository.save(workBoard);

        System.out.println("savedWork = " + savedWork.getId());

        JobForm jobForm = JobForm.builder()
                .jobType("빌링통계")
                .build();
        Job job1 = Job.builder().jobType(jobForm.getJobType()).workBoard(savedWork).build();
        Job job2 = Job.builder().jobType(jobForm.getJobType()).workBoard(savedWork).build();
        Job job3 = Job.builder().jobType(jobForm.getJobType()).workBoard(savedWork).build();

        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        List<Job> savedJobs = jobRepository.saveAll(jobs);

        for (Job job : savedJobs) {
            System.out.println("saved job id = " + job.getJobId());
            System.out.println("saved job workBoardId = " + job.getWorkBoard().getId());
        }
    }

    @Test
    void postTest() {

        JobForm jobForm1 = JobForm.builder().jobType("빌링통계").build();
        JobForm jobForm2 = JobForm.builder().jobType("빌링통계").build();
        JobForm jobForm3 = JobForm.builder().jobType("빌링통계").build();

        List<JobForm> jobForms = new ArrayList<>();
        jobForms.add(jobForm1);
        jobForms.add(jobForm2);
        jobForms.add(jobForm3);

        WorkBoardForm workBoardForm = WorkBoardForm.builder()
                .title("테스트")
                .jobs(jobForms)
                .build();

        Long boardId = workBoardService.post(workBoardForm);
        System.out.println("boardId = " + boardId);

    }


}