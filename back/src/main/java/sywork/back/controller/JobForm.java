package sywork.back.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class JobForm {

    private Long jobId;
    private String category;
    private String categorySub;
    private String jobType;
    private Integer jobCount;
    private String memo;
    private Integer ord;

}
