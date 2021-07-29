package sywork.back.dto;

import lombok.*;

@Getter @Builder
@AllArgsConstructor
public class WorkBoardDto {

    private Long id;
    private String acceptType;
    private String ticketNum;
    private String title;
    private String endDate;
    private String dueDate;
    private double md;

}
