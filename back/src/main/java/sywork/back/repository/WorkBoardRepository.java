package sywork.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sywork.back.entity.WorkBoard;

public interface WorkBoardRepository extends JpaRepository<WorkBoard, Integer> {


}
