package one.digitalinnovation.live.controller;

import one.digitalinnovation.live.exception.WorkloadNotFound;
import one.digitalinnovation.live.model.Workload;
import one.digitalinnovation.live.service.WorkloadService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/workload")
@AllArgsConstructor
public class WorkloadController {

    @Autowired
    private WorkloadService workloadService;

    @PostMapping
    public Workload createWorkload(@RequestBody @Valid Workload workload) {
        return workloadService.save(workload);
    }

    @GetMapping
    public List<Workload> listAll() {
        return  workloadService.listAll();
    }

    @GetMapping(path = "/{id}")
    public Workload findById(@PathVariable Long id)
            throws WorkloadNotFound {

        return workloadService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public Workload updateWorkload(@RequestBody @Valid Workload workload,
                                   @PathVariable Long id)
            throws WorkloadNotFound {

        return workloadService.update(workload, id);
    }

    @DeleteMapping(path = "/{id}")
    public Workload  deleteById(@PathVariable Long id)
            throws WorkloadNotFound {

        return workloadService.delete(id);
    }
}
