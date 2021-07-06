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
    private final WorkloadRepository workloadRepository;
    private final WorkloadMapper workloadMapper = WorkloadMapper.INSTANCE;

    @Transactional
    public WorkloadDTO save(WorkloadDTO workloadDTO) {
        Optional<Workload> optionalWorkload = workloadRepository
                .findByDescription(workloadDTO.getDescription());

        if(optionalWorkload.isPresent()) {
            throw new BusinessException(MessageUtils.WORKLOAD_ALREADY_REGISTERED);
        }

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
        Optional<Workload> foundWorkload = this.workloadRepository.findById(id);

        if(foundWorkload.isEmpty()) {
            throw new NotFoundException(MessageUtils.WORKLOAD_NOT_FOUND);
        }

        return workloadMapper.toDTO(foundWorkload.get());
    }

    @Transactional
    public WorkloadDTO delete(Long id) throws NotFoundException {
        WorkloadDTO deletedWorkload = this.findById(id);
        workloadRepository.deleteById(id);

        return deletedWorkload;
    }

    @Transactional
    public WorkloadDTO update(WorkloadDTO workloadDTO, Long id)
            throws NotFoundException {

        this.findById(id);

        Workload workloadToBeSaved = workloadMapper.toModel(workloadDTO);
        Workload savedWorkload= workloadRepository.save(workloadToBeSaved);

        return workloadMapper.toDTO(savedWorkload);
    }
}
