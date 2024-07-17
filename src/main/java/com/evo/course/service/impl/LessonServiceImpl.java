package com.evo.course.service.impl;

import com.evo.course.dto.CreateLessonDto;
import com.evo.course.dto.LessonDto;
import com.evo.course.dto.UpdateActiveLessonDto;
import com.evo.course.dto.UpdateLessonDto;
import com.evo.course.entity.LessonEntity;
import com.evo.course.exception.LessonNotFoundException;
import com.evo.course.mapper.LessonMapper;
import com.evo.course.repository.LessonRepository;
import com.evo.course.service.LessonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    @Override
    public LessonDto createLesson(CreateLessonDto createLessonDto) {
        if (createLessonDto.getIsActive() ==null){
             createLessonDto.setIsActive(true);
        }



        LessonEntity lessonEntity =
                lessonMapper.toLessonEntity(createLessonDto);
        LessonEntity lessonEntityDb = lessonRepository.save(lessonEntity);
        LessonDto lessonDto = lessonMapper.toLessonDto(lessonEntityDb);
        return lessonDto;
    }

    @Override
    public LessonDto updateLesson(Long id, UpdateLessonDto updateLessonDto) {
        if (updateLessonDto.getIsActive() ==null){
            updateLessonDto.setIsActive(true);
        }

        LessonEntity entity = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(
                        "lesson id =" + id + " not found"));

        LessonEntity lessonEntity = lessonMapper.toLessonEntity(updateLessonDto,entity);
        LessonEntity saveLessonDb = lessonRepository.save(lessonEntity);
        return lessonMapper.toLessonDto(saveLessonDb);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);


    }

    @Override
    public LessonDto updateActiveLesson(Long id,
                                         UpdateActiveLessonDto updateActiveLessonDto) {
        if (updateActiveLessonDto.getIsActive() ==null){
            updateActiveLessonDto.setIsActive(true);
        }
        LessonEntity lessonEntity = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(
                        "lesson id = " + id + " not found"));

        LessonEntity lessonEntity2 = lessonMapper.toLessonEntity(updateActiveLessonDto,lessonEntity);
        LessonEntity activeLessondb = lessonRepository.save(lessonEntity2);
        return lessonMapper.toLessonDto(activeLessondb);
    }

    @Override
    public List<LessonDto> getAllLesson() {
        return  lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toLessonDto)
                .toList();
    }
}
