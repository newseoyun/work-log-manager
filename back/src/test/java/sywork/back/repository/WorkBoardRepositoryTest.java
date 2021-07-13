package sywork.back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sywork.back.entity.WorkBoard;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class WorkBoardRepositoryTest {

    @Autowired
    WorkBoardRepository workBoardRepository;

    @Test
    void insertTest() {

        WorkBoard workBoard = new WorkBoard("20210101", "20210101", "a1", 0.2, "test", "test");
        workBoardRepository.save(workBoard);

    }

}