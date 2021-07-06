package one.digitalinnovation.live.service;

import lombok.AllArgsConstructor;

import one.digitalinnovation.live.util.MessageUtils;
import one.digitalinnovation.live.mapper.WorkloadMapper;
import one.digitalinnovation.live.model.entity.Workload;
import one.digitalinnovation.live.model.dto.WorkloadDTO;
import one.digitalinnovation.live.repository.WorkloadRepository;

import one.digitalinnovation.live.exception.BusinessException;
import one.digitalinnovation.live.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class WorkloadService {

    @Autowired
    private WorkloadRepository workloadRepository;
    private final WorkloadMapper workloadMapper = WorkloadMapper.INSTANCE;

    @Transactional
    public WorkloadDTO save(WorkloadDTO workloadDTO) {
        verifyIfAlreadyRegistered(workloadDTO.getDescription());

        Workload workloadToSave = workloadMapper.toModel(workloadDTO);
        Workload savedWorkload = workloadRepository.save(workloadToSave);

        return workloadMapper.toDTO(savedWorkload);
    }

    @Transactional(readOnly = true)
    public List<WorkloadDTO> listAll() {
        return workloadMapper
                .toDTO(workloadRepository.findAll());
    }

    @Transactional(readOnly = true)
    public WorkloadDTO findById(Long id) throws NotFoundException {
        Workload foundWorkload = verifyIfExists(id);

        return workloadMapper.toDTO(foundWorkload);
    }

    @Transactional
    public WorkloadDTO delete(Long id) {
        WorkloadDTO deletedWorkload = findById(id);
        workloadRepository.deleteById(deletedWorkload.getId());

        return deletedWorkload;
    }

    @Transactional
    public WorkloadDTO update(WorkloadDTO workloadDTO, Long id) {

        verifyIfExists(id);
        verifyIfAlreadyRegistered(workloadDTO.getDescription());

        Workload workloadToBeSaved = workloadMapper.toModel(workloadDTO);
        Workload savedWorkload= workloadRepository.save(workloadToBeSaved);

        return workloadMapper.toDTO(savedWorkload);
    }


    private Workload verifyIfExists(Long id) {
        Optional<Workload> foundWorkload = workloadRepository.findById(id);

        if(foundWorkload.isEmpty()) {
            throw new NotFoundException(MessageUtils.WORKLOAD_NOT_FOUND);
        }

        return foundWorkload.get();
    }

    private void verifyIfAlreadyRegistered(String description) {
        Optional<Workload> optionalWorkload = workloadRepository
                .findByDescription(description);

        if(optionalWorkload.isPresent()) {
            throw new BusinessException(MessageUtils.WORKLOAD_ALREADY_REGISTERED);
        }
    }
}
