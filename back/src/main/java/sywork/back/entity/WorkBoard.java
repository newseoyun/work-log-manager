package sywork.back.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private int id;
    private String endDate;
    private String dueDate;
    private String ticketNum;
    private double md;
    private String title;
    private String memo;

    public WorkBoard(String endDate, String dueDate, String ticketNum, double md, String title, String memo) {
        this.endDate = endDate;
        this.dueDate = dueDate;
        this.ticketNum = ticketNum;
        this.md = md;
        this.title = title;
        this.memo = memo;
    }
}
