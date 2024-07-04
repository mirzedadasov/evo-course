package com.evo.course.service;

import com.evo.course.dto.CreateLessonDto;
import com.evo.course.dto.LessonDto;
import com.evo.course.dto.UpdateActiveLessonDto;
import com.evo.course.dto.UpdateLessonDto;

public interface LessonService {
    LessonDto createLesson(CreateLessonDto createLessonDto);

    LessonDto updateLesson(Long id, UpdateLessonDto updateLessonDto);

    void deleteLesson(Long id);

    LessonDto updateActiveLesson(Long id, UpdateActiveLessonDto updateActiveLessonDto);
}
