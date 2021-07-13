package sywork.back.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
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
