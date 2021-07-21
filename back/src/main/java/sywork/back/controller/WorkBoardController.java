package sywork.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sywork.back.dto.WorkBoardDto;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.WorkBoardRepository;
import sywork.back.service.WorkBoardService;

@Controller
@RequiredArgsConstructor
public class WorkBoardController {

    private final WorkBoardService workBoardService;
    private final WorkBoardRepository workBoardRepository;

    @GetMapping("/list")
    @ResponseBody
    public Page<WorkBoardDto> list(@PageableDefault Pageable pageable) {
        return workBoardRepository.findAll(pageable)
                .map(m -> new WorkBoardDto(
                        m.getId(),
                        m.getAcceptType(),
                        m.getTicketNum(),
                        m.getTitle(),
                        m.getEndDate(),
                        m.getDueDate(),
                        m.getMd()
                        ));
    }

    @GetMapping("/work/{workId}")
    @ResponseBody
    public WorkBoard getWork(@PathVariable Long workId) {
        return workBoardService.getOne(workId).get();
    }

    @PostMapping("/add")
    @ResponseBody
    public Long add(@RequestBody WorkBoardForm workBoardForm) {
        return workBoardService.post(workBoardForm);
    }

    @PostMapping("/edit/{workId}")
    public String edit(@PathVariable Long workId, @RequestBody WorkBoardForm workBoardForm) {
        workBoardService.updateBoard(workId, workBoardForm);
        return "redirect:/work/{workId}";
    }

}
