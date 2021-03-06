package sywork.back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
class WorkBoardJobRepositoryTest {

    @Autowired
    JobRepository jobRepository;
    @Autowired
    WorkBoardRepository workBoardRepository;

    @Test
    void boardInsertTest() {
        WorkBoard workBoard = new WorkBoard("20210101", "20210101", "a1", 0.2, "test", "test");
        workBoardRepository.save(workBoard);

        Job job = new Job(workBoard, "계정관리");
        jobRepository.save(job);
    }

}