package sywork.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import sywork.back.entity.TestItem;

import java.util.List;

public interface TestItemRepository extends JpaRepository<TestItem, Long> {

    List<TestItem> findByName(@Param("name") String name);

}
