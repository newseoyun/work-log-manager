package sywork.back.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sywork.back.entity.WorkBoard;

@Getter @Setter @Builder
public class JobForm {

    private String category;
    private String categorySub;
    private String jobType;
    private int jobCount;
    private String memo;

}
