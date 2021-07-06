package one.digitalinnovation.live.repository;

import one.digitalinnovation.live.model.entity.Workload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WorkloadRepository extends JpaRepository<Workload, Long> {
    Optional<Workload> findByDescription(String description);
}
