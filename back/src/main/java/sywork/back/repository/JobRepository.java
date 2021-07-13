package sywork.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sywork.back.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
