package sywork.back.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @Builder
public class WorkBoardForm {

    private String acceptType;
    private String ticketNumber;
    private String title;
    private String endDate;
    private String dueDate;
    private double md;
    private String memo;
    public List<JobForm> jobs;

}
