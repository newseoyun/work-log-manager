package sywork.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sywork.back.entity.WorkBoard;
import sywork.back.repository.WorkBoardRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkBoardController {

    private final WorkBoardRepository workBoardRepository;

    @GetMapping("/list")
    @ResponseBody
    public List<WorkBoard> list() {
        return workBoardRepository.findAll();
    }


}
