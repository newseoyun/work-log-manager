package sywork.back.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name="WORK_BOARD_SEQ_GENERATOR",
        sequenceName = "WORK_BOARD_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"jobs"})
public class WorkBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORK_BOARD_SEQ_GENERATOR")
    private Long id;
    private String acceptType;
    private String ticketNum;
    private String title;
    private String endDate;
    private String dueDate;
    private double md;
    private String memo;
    @ColumnDefault("'N'")
    private String delYn;

    @OneToMany(mappedBy = "workBoard")
    private List<Job> jobs = new ArrayList<>();


    public WorkBoard(String endDate, String dueDate, String ticketNum, double md, String title, String memo) {
        this.endDate = endDate;
        this.dueDate = dueDate;
        this.ticketNum = ticketNum;
        this.md = md;
        this.title = title;
        this.memo = memo;
    }

}
