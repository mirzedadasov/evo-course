package com.evo.course.controller;

import com.evo.course.dto.CreateLessonDto;
import com.evo.course.dto.LessonDto;
import com.evo.course.dto.UpdateActiveLessonDto;
import com.evo.course.dto.UpdateLessonDto;
import com.evo.course.service.LessonService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@Valid @RequestBody
                                                      CreateLessonDto createLessonDto) {
        return ResponseEntity.ok(lessonService.createLesson(createLessonDto));

    }

    @PatchMapping
    public ResponseEntity<LessonDto> updateLesson(@RequestParam  Long id, @Valid @RequestBody
    UpdateLessonDto updateLessonDto) {
        return ResponseEntity.ok(lessonService.updateLesson(id, updateLessonDto));

    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable  Long id) {
        lessonService.deleteLesson(id);
    }

    @PatchMapping("/deactive/{id}")
    public ResponseEntity<LessonDto> updateActiveLesson(@PathVariable Long id,
                                                        @Valid
                                                        @RequestBody
                                                        UpdateActiveLessonDto
                                                                updateActiveLessonDto) {
        return ResponseEntity.ok(lessonService.updateActiveLesson(id, updateActiveLessonDto));
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> getLessonDtoResponseEntity() {
        return ResponseEntity.ok(lessonService.getAllLesson());
        
    }


}
