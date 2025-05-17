package com.techzen.academy_n0325c1.Bai9.dto.derpartment;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentSearchRequest {
    String name = "";
}
