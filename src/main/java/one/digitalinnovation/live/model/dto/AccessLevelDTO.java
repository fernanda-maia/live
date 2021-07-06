package one.digitalinnovation.live.model.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessLevelDTO {

    private Long id;

    @NotEmpty
    private String description;
}
