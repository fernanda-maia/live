package one.digitalinnovation.live.controller;

import one.digitalinnovation.live.model.dto.WorkloadDTO;
import one.digitalinnovation.live.service.WorkloadService;
import one.digitalinnovation.live.exception.NotFoundException;

import org.springframework.http.MediaType;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WorkloadDTO createWorkload(@RequestBody @Valid WorkloadDTO workloadDTO) {
        return workloadService.save(workloadDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WorkloadDTO> listAll() {
        return  workloadService.listAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WorkloadDTO findById(@PathVariable Long id)
            throws NotFoundException {

        return workloadService.findById(id);
    }

    @PutMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public WorkloadDTO updateWorkload(@RequestBody @Valid WorkloadDTO workloadDTO,
                                   @PathVariable Long id)
            throws NotFoundException {

        return workloadService.update(workloadDTO, id);
    }

    @DeleteMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public WorkloadDTO  deleteById(@PathVariable Long id)
            throws NotFoundException {

        return workloadService.delete(id);
    }
}
