package sywork.back.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class WorkBoardDto {

    private int id;
    private String endDate;
    private String dueDate;
    private String ticketNum;
    private float md;
    private String title;
    private String memo;

}
