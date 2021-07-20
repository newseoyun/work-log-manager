package sywork.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sywork.back.controller.JobForm;
import sywork.back.controller.WorkBoardForm;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.JobRepository;
import sywork.back.repository.WorkBoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkBoardService {

    private final WorkBoardRepository workBoardRepository;
    private final JobRepository jobRepository;

    @Transactional
    public Long post(WorkBoardForm workBoardForm) {
        WorkBoard workBoard = WorkBoard.builder()
                .acceptType(workBoardForm.getAcceptType())
                .ticketNum(workBoardForm.getTicketNum())
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
                    .ord(jobForm.getOrd())
                    .build();

            jobRepository.save(job);
        }

        return savedWork.getId();
    }

    public List<WorkBoard> getList() {
        return workBoardRepository.findAll();
    }

    public Optional<WorkBoard> getOne(Long boardId) {
        return workBoardRepository.findById(boardId);
    }

    public void updateBoard(WorkBoardForm workBoardForm) {
        Optional<WorkBoard> board = workBoardRepository.findById(workBoardForm.getWorkBoardId());

        board.get().setAcceptType(workBoardForm.getAcceptType());
        board.get().setTicketNum(workBoardForm.getTicketNum());
        board.get().setTitle(workBoardForm.getTitle());
        board.get().setEndDate(workBoardForm.getEndDate());
        board.get().setDueDate(workBoardForm.getDueDate());
        board.get().setMd(workBoardForm.getMd());
        board.get().setMemo(workBoardForm.getMemo());

    }

}
