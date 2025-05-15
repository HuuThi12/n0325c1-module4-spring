package com.techzen.academy_n0325c1.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    private int id;
    private String name;
    private double score;
    private String adress;
    String clazzName;
}
