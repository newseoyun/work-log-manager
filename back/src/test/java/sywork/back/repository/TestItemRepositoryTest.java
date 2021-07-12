package sywork.back.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sywork.back.entity.TestItem;

import java.util.List;

@SpringBootTest
@Transactional
class TestItemRepositoryTest {

    @Autowired
    TestItemRepository testItemRepository;

    @Test
    public void saveAndGet() {

        TestItem testItem = new TestItem("test222");
        testItemRepository.save(testItem);

        List<TestItem> itemList = testItemRepository.findByName("test222");

        Assertions.assertThat(itemList.size()).isEqualTo(1);
    }

}