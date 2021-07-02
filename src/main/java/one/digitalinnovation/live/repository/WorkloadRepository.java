package one.digitalinnovation.live.repository;

import one.digitalinnovation.live.model.Workload;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkloadRepository extends JpaRepository<Workload, Long> {
}
