package sywork.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sywork.back.controller.JobForm;
import sywork.back.controller.WorkBoardForm;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.JobRepository;
import sywork.back.repository.WorkBoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkBoardService {

    private final WorkBoardRepository workBoardRepository;
    private final JobRepository jobRepository;

    public Long post(WorkBoardForm workBoardForm) {
        WorkBoard workBoard = WorkBoard.builder()
                .acceptType(workBoardForm.getAcceptType())
                .ticketNum(workBoardForm.getTicketNumber())
                .title(workBoardForm.getTitle())
                .endDate(workBoardForm.getEndDate())
                .dueDate(workBoardForm.getDueDate())
                .md(workBoardForm.getMd())
                .memo(workBoardForm.getMemo())
                .build();

        WorkBoard savedWork = workBoardRepository.save(workBoard);

        List<JobForm> jobForms = workBoardForm.getJobs();

        for (JobForm jobForm : jobForms) {
            Job job = Job.builder()
                    .workBoard(savedWork)
                    .jobType(jobForm.getJobType())
                    .category(jobForm.getCategory())
                    .categorySub(jobForm.getCategorySub())
                    .jobCount(jobForm.getJobCount())
                    .memo(jobForm.getMemo())
                    .ord(jobForm.getOrder())
                    .build();

            jobRepository.save(job);
        }


        return savedWork.getId();
    }

}
