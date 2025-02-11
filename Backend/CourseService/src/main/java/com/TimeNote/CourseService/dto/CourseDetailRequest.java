package com.TimeNote.CourseService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetailRequest {
    private String courseCode;
    private String classCode;
    private List<String> timeStarts; // format: 2 7:30
    private List<String> studentCodes;
    private List<String> lectureCodes;
}
