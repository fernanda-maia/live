package one.digitalinnovation.live.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import one.digitalinnovation.live.model.dto.WorkloadDTO;
import one.digitalinnovation.live.model.entity.Workload;

import java.util.List;


@Mapper
public interface WorkloadMapper {

    WorkloadMapper INSTANCE = Mappers.getMapper(WorkloadMapper.class);

    Workload toModel(WorkloadDTO workloadDTO);
    WorkloadDTO toDTO(Workload workload);
    List<WorkloadDTO> toDTO(List<Workload> workloads);
}
