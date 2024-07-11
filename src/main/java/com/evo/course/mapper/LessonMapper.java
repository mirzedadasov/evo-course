package com.evo.course.mapper;

import com.evo.course.dto.CreateLessonDto;
import com.evo.course.dto.LessonDto;
import com.evo.course.dto.UpdateActiveLessonDto;
import com.evo.course.dto.UpdateLessonDto;
import com.evo.course.entity.LessonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface LessonMapper {

    LessonDto toLessonDto(LessonEntity lessonEntity);


    LessonEntity toLessonEntity(CreateLessonDto createLessonDto);

    LessonEntity toLessonEntity(UpdateLessonDto updateLessonDto, @MappingTarget LessonEntity entity);

    LessonEntity toLessonEntity(UpdateActiveLessonDto updateActiveLessonDto, @MappingTarget LessonEntity lessonEntity);
}
