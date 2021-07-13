package sywork.back.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sywork.back.entity.Job;

import java.util.List;

@Getter @Setter @Builder
public class WorkBoardForm {

    private String acceptType;
    private String ticketNum;
    private String title;
    private String endDate;
    private String dueDate;
    private double md;
    private String memo;
    public List<Job> jobs;

}
