package sywork.back.controller;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkBoardForm {

    private Long workBoardId;
    private String acceptType;
    private String ticketNum;
    private String title;
    private String endDate;
    private String dueDate;
    private double md;
    private String memo;
    @Nullable
    private List<JobForm> jobs;

}
