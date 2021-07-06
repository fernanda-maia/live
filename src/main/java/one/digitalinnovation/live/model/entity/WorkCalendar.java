package one.digitalinnovation.live.model.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import one.digitalinnovation.live.model.entity.DataType;

import javax.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DataType dataType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime specialDate;

}
