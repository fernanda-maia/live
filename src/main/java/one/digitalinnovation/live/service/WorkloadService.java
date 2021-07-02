package one.digitalinnovation.live.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.live.exception.WorkloadNotFound;
import one.digitalinnovation.live.model.Workload;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.live.repository.WorkloadRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class WorkloadService {

    @Autowired
    private WorkloadRepository workloadRepository;

    public Workload save(Workload workload) {
        return workloadRepository.save(workload);
    }

    public List<Workload> listAll() {
        return workloadRepository.findAll();
    }

    public Workload findById(Long id) throws WorkloadNotFound {
        Optional<Workload> foundWorkload = this.workloadRepository.findById(id);

        if(foundWorkload.isEmpty()) {
            throw new WorkloadNotFound(id);
        }

        return foundWorkload.get();
    }

    public Workload delete(Long id) throws WorkloadNotFound {
        Workload deletedWorkload = findById(id);
        workloadRepository.deleteById(id);

        return deletedWorkload;
    }

    public Workload update(Workload workload, Long id)
            throws WorkloadNotFound {

        findById(id);
        return workloadRepository.save(workload);
    }
}
