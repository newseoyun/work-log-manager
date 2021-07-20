package sywork.back.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;
import sywork.back.dto.WorkBoardDto;
import sywork.back.entity.Job;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.WorkBoardRepository;
import sywork.back.service.WorkBoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkBoardController {

    private final WorkBoardService workBoardService;
/*
    @GetMapping("/list/{page}")
    @ResponseBody
    public List<WorkBoard> list(@PathVariable int page) {
        return workBoardService.getList(page); // dto, 페이징 처리 할 것
    }
*/

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


}
