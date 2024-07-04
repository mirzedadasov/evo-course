package com.evo.course.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLessonDto {

    @NotBlank(message = "title can not be null or empty")
    private String title;

    private Boolean isActive;

}
