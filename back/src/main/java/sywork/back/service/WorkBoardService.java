package sywork.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sywork.back.controller.JobForm;
import sywork.back.controller.WorkBoardForm;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.WorkBoardRepository;

@Service
@RequiredArgsConstructor
public class WorkBoardService {

    private final WorkBoardRepository workBoardRepository;

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



        return workBoard.getId();
    }

}
