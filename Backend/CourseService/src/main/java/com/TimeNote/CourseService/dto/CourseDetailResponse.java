package com.TimeNote.CourseService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetailResponse {
    private Long courseDetailId;
    private String courseCode;
    private String courseName;
}
