package com.techzen.academy_n0325c1.dto.student;

import com.techzen.academy_n0325c1.constraint.DobConstraint;
import com.techzen.academy_n0325c1.dto.clazz.ClazzRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "[a-zA-ZÀ-ỹ ]+", message = "Tên không được chứa ký tự đặc biệt")
    @Length(min = 3, message = "Tên phải lớn hơn 3 ký tự")
    String name;

    @NotNull(message = "Điểm không được để trống")
    @Min(value = 0, message = "Điểm phải lớn hơn 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn 10")
    Double score;

    @NotBlank(message = "Địa chỉ không được để trống")
    String adress;

    @Valid
    @NotNull(message = "Bắt buộc chọn lớp cho sinh viên")
    ClazzRequest clazz;

    @NotNull(message = "Ngày sinh là bắt buộc")
    @DobConstraint(min = 18, message = "Bạn chưa đủ tuổi")
    LocalDate dateOfBirth;
}
