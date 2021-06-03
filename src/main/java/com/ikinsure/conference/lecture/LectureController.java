package com.ikinsure.conference.lecture;

import com.ikinsure.conference.user.dto.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService service;

    @Autowired
    public LectureController(LectureService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Lecture> getAll() {
        return service.getAll();
    }

    @PostMapping("/reserve/{lectureId}")
    public void reserveLecture(@PathVariable UUID lectureId, @RequestBody @Valid UserCommand userCommand) {
        service.reserveLecture(userCommand, lectureId);
    }


}
