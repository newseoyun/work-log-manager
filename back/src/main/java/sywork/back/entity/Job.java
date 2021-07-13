package sywork.back.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name="JOB_SEQ_GENERATOR",
        sequenceName = "JOB_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Job extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_SEQ_GENERATOR")
    private Long jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_board_id")
    private WorkBoard workBoard;
    private String category;
    private String categorySub;
    private String jobType;
    private int jobCount;
    private String memo;

    public Job(WorkBoard workBoard, String category) {
        this.workBoard = workBoard;
        this.category = category;
    }
}
