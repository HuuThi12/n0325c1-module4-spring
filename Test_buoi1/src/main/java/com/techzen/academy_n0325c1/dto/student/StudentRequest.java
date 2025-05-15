package com.techzen.academy_n0325c1.dto.student;

import com.techzen.academy_n0325c1.dto.clazz.ClazzRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    private String name;
    private double score;
    private String adress;
    ClazzRequest clazz;
}
